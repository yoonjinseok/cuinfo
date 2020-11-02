package com.cyberup.dao.educ;

import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.educ.UnivStt;
import com.cyberup.model.home.FileUpload;
import com.cyberup.util.DateFormatter;

@Repository
public class UnivSttDao extends BaseDAO {
	
	public UnivStt selectInfo(UnivStt univSttParm)
	{
		return (UnivStt)queryForObject("UnivSttDao.selectInfo", univSttParm);
	}

	public int deleteInfo(long univSttID)
	{
		return delete("UnivSttDao.deleteInfo", univSttID);
	}

	public void insertInfo(UnivStt univStt)
	{
		insert("UnivSttDao.insertInfo", univStt);
	}		

	public List<UnivStt> selectList(Integer showCnt, Integer currPage,String termState, String sttName, Date sttRegDate, String putState,Integer universityID)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("termState", termState);
		param.put("sttName", sttName);
		param.put("sttRegDate", new DateFormatter("yyyy-MM-dd").print(sttRegDate, Locale.getDefault()));
		param.put("putState", putState);
		param.put("universityID", universityID + "");

		return queryForList("UnivSttDao.selectList", param);
	}
	
	public int selectSttFileCnt(Integer universityID)
	{
		return (Integer)queryForObject("UnivSttDao.selectSttFileCnt", universityID);
	}

	public int updateInfo(UnivStt univStt)
	{
		return update("UnivSttDao.updateInfo", univStt);
	}
	
	public int updateFailInfo(UnivStt univStt)
	{
		return update("UnivSttDao.updateFailInfo", univStt);
	}
	
	public int upUploadSt(long sttUnivID)
	{
		return update("UnivSttDao.upUploadSt", sttUnivID);
	}
	
	public int initFileBoard(Integer fileGid)
	{
		return update("UnivSttDao.initFileBoard", fileGid);
	}
	
	public List<UnivStt> selectUnivList(Integer gubunId, long sttID)
	{
		Map param = new HashMap();
		param.put("gubunId", gubunId + "");
		param.put("sttID", sttID  + "");

		return queryForList("UnivSttDao.univList", param);
	}
	
	public int upPutState(String sstUnivIDs) {
		return update("UnivSttDao.upPutState", sstUnivIDs);
	}
	
	public List<FileUpload> selUnivDown(String sstUnivIDs, String sttID) 
	{
		Map param = new HashMap();
		param.put("sstUnivIDs", sstUnivIDs);
		param.put("sttID", sttID);
		return queryForList("UnivSttDao.selUnivDown", param);
	}
	
	public List<FileUpload> selSttFileDown(String fileGid)
	{
		Map param = new HashMap();
		param.put("fileGid", fileGid);
		return queryForList("UnivSttDao.selSttFileDown", param);
	}
	
	
	/*
	 * 파일 데이터 입력 처리  
	 */
	public int selectSEQ_STT_UNIVERSITY()
	{
		return (Integer) queryForObject("UnivSttDao.selectSEQ_STT_UNIVERSITY");
	}	

	public int updateSttGatherStateY(String sttID) {
		return update("UnivSttDao.updateSttGatherStateY", sttID);
	}
	
	private FormulaEvaluator evaluator;
	private CellValue cellValue;
	private int k = 0;
	private int r = 0;
	private int c = 0;
	private String str 	= "";
	private String sheetName = "";
	private int updateCnt = 0;
	
	public String excelUpload(String fileUrl, long sttUnivID, ModelMap modelMap, String forNum) {
		r = 0;	//행
		c = 0;	//열
		str 	= "";	//애로 정보
		sheetName = "";	
		updateCnt = 0;
		try 
		{
			System.out.println("========================================================\n\n fileName="+fileUrl+"\n");
			
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(fileUrl));
			HSSFWorkbook workbook = new HSSFWorkbook(fs);
		    int sheetNum = workbook.getNumberOfSheets();
		    evaluator = workbook.getCreationHelper().createFormulaEvaluator(); 
		    
		    // 쉬트 for
		    for ( k = 0; k < sheetNum; k++) {			
	            //시트 이름과 시트번호를 추출
		    	System.out.println( " Sheet Number = " + k + "\n");  
		    	System.out.println( " Sheet Name = " + workbook.getSheetName(k) + "\n" ) ;
	
		    	sheetName = workbook.getSheetName(k);
	            HSSFSheet sheet = workbook.getSheetAt(k);
	            
	            
	            // 대학별 현황표(일반현황) (CU_STT_UNIV_DATA)
	            if(sheetName.indexOf("총괄") >= 0 && forNum.equals("0")) 
            	{
	            	delete("UnivSttDao.deleteUnivData", sttUnivID);
	            	parseUnivData(sheet, sttUnivID);
	            	updateCnt++;
	            	break;
            	}	              
	                        
	            
	           //재학생수 현황 (전임교원 확보 현황) (CU_STT_TEACHER_DATA)
	           if(sheetName.indexOf("기준학생수") >= 0  && forNum.equals("1")) 
	           {
	        	   delete("UnivSttDao.deleteTeacherData", sttUnivID);
	        	   parseTeacherData(sheet, sttUnivID);	
	        	   updateCnt++;
	               break;
           	   }   
	           	            
	            
	            /**
	             *  입학정원 현황, 입학 정원 대비 등록율(정원내학생등록상황)
	             * (CU_STT_REGISTER_STDT)
	             */
	            if(sheetName != null && sheetName.indexOf("정원내") >= 0 
	            		&& sheetName.indexOf("대학원") < 0 && forNum.equals("2"))
	            {
	            	delete("UnivSttDao.deleteRegisterStdt", sttUnivID);
	            	parseRegisterStdt(sheet, sttUnivID);	
	            	updateCnt++;
	            	break;
	            }//if 입학정원 현황, 입학 정원 대비 등록율(정원내학생등록상황)
	            
	            
	            /**
	             *  정원외 재학생 현황(정원외 학생)
	             * (CU_STT_READ_STDT)
	             */
	            if(sheetName != null && sheetName.indexOf("정원외") >= 0 
	            		&& sheetName.indexOf("대학원") < 0 && forNum.equals("3"))
	            {
	            	delete("UnivSttDao.deleteReadStdt", sttUnivID);
	            	parseReadStdt(sheet, sttUnivID);	
	            	updateCnt++;
	            	break;
	            }
	            
	            /**
	             *  시간제
	             * (CU_STT_PART_TIME)
	             */
	            if(sheetName != null && sheetName.indexOf("시간제") >= 0 
	            		&& sheetName.indexOf("대학원") < 0 && forNum.equals("4"))
	            {
	            	delete("UnivSttDao.deletePartTime", sttUnivID);
	            	parsePartTime(sheet, sttUnivID);	
	            	updateCnt++;
	            	break;
	            }
	            
	            /**
	             *  연령
	             * (CU_STT_AGE)
	             */
	            if(sheetName != null && sheetName.indexOf("연령") >= 0 
	            		&& sheetName.indexOf("대학원") < 0 && forNum.equals("5"))
	            {
	            	delete("UnivSttDao.deleteAge", sttUnivID);
	            	parseAge(sheet, sttUnivID);	
	            	updateCnt++;
	            	break;
	            }
	            
	            /**
	             *  입학금.수업료
	             * (CU_STT_FEE)
	             */
	            if(sheetName != null && sheetName.indexOf("입학금") >= 0 
	            		&& sheetName.indexOf("대학원") < 0 && forNum.equals("6"))
	            {
	            	delete("UnivSttDao.deleteFee", sttUnivID);
	            	parseSttFee(sheet, sttUnivID);	
	            	updateCnt++;
	            	break;
	            }
	            
	            
	            /**
	             *  학력 직업
	             * (CU_STT_JOB)
	             */
	            if(sheetName != null && sheetName.indexOf("학력") >= 0 && sheetName.indexOf("직업") >= 0 
	            		&& sheetName.indexOf("대학원") < 0 && forNum.equals("7"))
	            {
	            	delete("UnivSttDao.deleteJob", sttUnivID);
	            	parseJob(sheet, sttUnivID);	
	            	updateCnt++;
	            	break;
	            }
	            
	            /**
	             *  총 졸업생수
	             * (CU_STT_GRADUATE)
	             */
	            if(sheetName != null && sheetName.indexOf("졸업생") >= 0
	            		&& sheetName.indexOf("대학원") < 0 && forNum.equals("8"))
	            {
	            	delete("UnivSttDao.deleteGraduate", sttUnivID);
	            	parseGraduate(sheet, sttUnivID);	
	            	updateCnt++;
	            	break;
	            }
	            
	       }
		    if( updateCnt == 0) {		    	
		    	str = "sheet가 부족합니다.\r\n";
		    	throw new Exception();
		    }
		    modelMap.addAttribute("sumessage", sheetName + "(sheet) 데이터 저장을 완료하였습니다.\r\n");
		     
		} catch (Exception e) {
			e.printStackTrace();
			
			if("".equals(str))
				str += sheetName + "(sheet)에서 " + (r + 1) + "행" +  ConvertToColName(c + 1) + "열의 값이 올바르지 않습니다.(0 또는 빈값입니다.)\r\n" ;
			System.out.println("error ==> " + str);
			
			modelMap.addAttribute("exerrors", true);
			modelMap.addAttribute("exmessage", "입력 실패하였습니다. \r\n" + str);
			modelMap.addAttribute("allsucceed", false);
			return str;
		} finally {			
			
		}
		 if(forNum.equals("8")) modelMap.addAttribute("allsucceed", true);
		 else  modelMap.addAttribute("allsucceed", false);
		return str;
	}
	
	/**
     * 대학별 현황표(일반현황)
     * (CU_STT_UNIV_DATA)
     */
	private void parseUnivData(HSSFSheet sheet, long sttUnivID) throws Exception
	{
		int rows = sheet.getPhysicalNumberOfRows();	
    	int paramNM = 1;
    	Map pmap = new HashMap();    	
        pmap.put("sttUnivID", sttUnivID);  // //대학별 통계문서 아이디 저장  
        String[] title = {"대학(원)명", "편제정원", "입학정원"};
        
        //캡취할 타이털의 [cell] [row]  number
        int [][] cellRowNum = getDataCellNum(sheet, 2, 5, title);
        
        // 캡취 타이털 행번호 아래항부터 시작
        for (r = cellRowNum[1][0] + 2 ; r < rows ; r++) 
        {         	
        	// 시트에 대한 행을 하나씩 추출
        	HSSFRow row   = sheet.getRow(r);
        	int cellCnt = 0;
        	if (row != null) 
            {
        		int [] cellNum = cellRowNum[0];
	        	for (int cc : cellNum)  //cell FOR문
	            {			
	            	 c = cc;
	            	 cellCnt++;
	        		// 행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
	                 HSSFCell cell  = row.getCell(c);
	                 if (cell != null) 
	                 { 
	                     // 대학원 데이타 저장 안함
	                	 if(paramNM == 1 && parseCellVal(cell, true).indexOf("대학원") >= 0) 
	                    	break;
	                	 // DB저장 컬럼 저장
	                	 String value = parseCellVal(cell, true);
	                	 
	                	 //개교년월일 수자형으로 인식되여 입력 불가.(년.월.일 로 입력) --> 1~2로 시작하고, 0~9의 숫자 3자리만 오도록 수정(지갑인)
	                	 /*if(cellCnt == 2 && value.matches("^.*\\.0+$"))  throw new Exception();*/
	                	 
	                	 pmap.put("" + (paramNM++), value);
	                     
	                     if(pmap.size() == 4) break;
	                 } 
	            } // for
	        	if(pmap.size() == 4) break;
            }
        }
        
        if(pmap.size() != 4) throw new Exception();
        else
        {
        	//insert CU_STT_UNIV_DATA
        	insert("UnivSttDao.insertSttUnivData", pmap);
        }
		
	}
	
	/**
	 * 재학생수 현황 (전임교원 확보 현황)
	 * (CU_STT_TEACHER_DATA)
	 */
	private void parseTeacherData(HSSFSheet sheet, long sttUnivID ) throws Exception
	{
		int paramNM = 1;
    	Map pmap = new HashMap();        	
    	pmap.put("sttUnivID", sttUnivID);  //대학별 통계문서 아이디 저장   
    	
    	 //캡취할 타이털의 [cell] [row]  number
    	String[] celltitle = {"정원내 학생수(a)", "정원외 학생수(b)", "시간제등록생 x 1/3(※3명=1명)(c)"};  
    	String[] rowtitle = {"합계"};  
        int [][] valCellNum = getDataCellNum(sheet, 3, 7, celltitle); // [0][] 열   [1][] 행
        int [][] valRowNum = getDataRowNum(sheet, valCellNum[0][1] + 2, 0,rowtitle); //[0][] 열   [1][] 행 ,  합계 행이기에 제목 아래로 두번째 행
        
    	// row
        r = valRowNum[1][0];		
        
        // 시트에 대한 행을 하나씩 추출
        HSSFRow row   = sheet.getRow(r);
        if (row != null) 
        { 
        	//cell FOR문
        	int [] cellNums = valCellNum[0];
        	for (int cc : cellNums)  //cell FOR문
            {			
            	 c = cc;			
            	// 행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
                 HSSFCell cell  = row.getCell(c);
                 if (cell != null) { 
                	 String value = parseCellVal(cell, true); 
                
            	  pmap.put("" + (paramNM++), value.trim());
                  
                } 
            } // for
        	insert("UnivSttDao.insertSttTeacherData", pmap);//insert CU_STT_TEACHER_DATA
        }
	}
	
	/**
     *  입학정원 현황, 입학 정원 대비 등록율(정원내학생등록상황)
     * (CU_STT_REGISTER_STDT)
     */	
	private void parseRegisterStdt(HSSFSheet sheet, long sttUnivID ) throws Exception
	{
		long registerSum = 0;
    	int rows = sheet.getPhysicalNumberOfRows();		            	
    	boolean isEndRow = false;
    	boolean isSumRow = false;
    	int paramNM = 1;
    	int insertCnt = 0;
    	Map pmap = new HashMap();  
    	
    	String[] celltitle = {"정원년도", "입학 정원", "소계 (O)= F+G+H+I+J"};  
        int [][] valCellNum = getDataCellNum(sheet, 3, 7, celltitle); // [0][] 열   [1][] 행
        
    	// row for문
        for (r = valCellNum[1][2] + 1; r < rows; r++) 
        {			
        	if(isEndRow) break; //총합계 행일시 끝남
        	isSumRow = false; //합계 컬럼 초기화 
            
            // 시트에 대한 행을 하나씩 추출
            HSSFRow row   = sheet.getRow(r);
            HSSFCell cell = row.getCell(1);
        	String value = parseCellVal(cell, false);
        	
        	if(value != null && value.indexOf("합") >= 0 && value.indexOf("계") >= 0 && value.indexOf("총") >= 0)  isEndRow = true;
        	
        	if(value != null && value.indexOf("합") >= 0 && value.indexOf("계") >= 0 && value.indexOf("총") < 0) {
        		int[] cVal = valCellNum[0];
        		
        		for (int i = 0; i < cVal.length; i++) {
        			HSSFCell innerCell = row.getCell(cVal[i]);
        			String value2 = parseCellVal(innerCell, false);
        			
        			if(value2 != null && value2.indexOf("합") >= 0 && value2.indexOf("계") >= 0) {
        				value2=value2.replaceAll("[^0-9]", "");
        			}
        			
        			value2=value2.replace(".0", "");
        			pmap.put("" + (paramNM++), value2.trim());
     			
        		}
        		isSumRow=true;
        	}
        	if(isSumRow)
	        	if(pmap.size() != 3 ) throw new Exception(); 
	       	 	else {
	       	 		pmap.put("sttUnivID", sttUnivID);  //대학별 통계문서 아이디 저장   
	       	 		insert("UnivSttDao.insertSttRegisterStdt", pmap);	 //insert CU_STT_TEACHER_DATA
	       	 		paramNM = 1;
	       	 		insertCnt++;            
	       	 		registerSum = 0;
	       	 		pmap = new HashMap();
	       	 	}
        } // for
        
        if(insertCnt == 0 ) throw new Exception(); 
	}
	
	/**
	 *  정원외 재학생 현황 (정원외학생)
	 * (CU_STT_READ_STDT)
	 */	
	private void parseReadStdt(HSSFSheet sheet, long sttUnivID ) throws Exception
	{
		int paramNM = 1;
		Map pmap = new HashMap();
		String[] celltitle = {"재학", "재학", "재학", "재학", "재학", "재학", "재학", "재학", "재학", "재학(A)"};  
        int [][] valCellNum = getDataCellNum(sheet, 3, 6, celltitle); // [0][] 열   [1][] 행
        String[] rwotitle = {"합계"};  
        int [][] valrwoNum = getDataRowNum(sheet, 7, 0, rwotitle); // [0][] 열   [1][] 행
        
		// row for문
		r = valrwoNum[1][0]; 
        
        // 시트에 대한 행을 하나씩 추출
        HSSFRow row   = sheet.getRow(r);
        if (row != null) 
        { 
        	//cell FOR문
        	int [] cellNums = valCellNum[0];
        	for (int cc : cellNums)  //cell FOR문
            {			
            	 c = cc;			
            	// 행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
                 HSSFCell cell  = row.getCell(c);
                 if (cell != null) { 
                	 String value = parseCellVal(cell, true); 
                
            	  pmap.put("" + (paramNM++), value.trim());
                  
                } 
            } // for
        	pmap.put("sttUnivID", sttUnivID);  //대학별 통계문서 아이디 저장   
        	insert("UnivSttDao.insertSttReadStdt", pmap);	 //insert CU_STT_TEACHER_DATA
        }		
	}
	
	
	/**
     *  시간제
     * (CU_STT_PART_TIME)
     */
	private void parsePartTime(HSSFSheet sheet, long sttUnivID ) throws Exception
	{
    	int paramNM = 1;
    	Map pmap = new HashMap();        
    	// row for문
    	String[] celltitle = {"모집인원", "등록자수", "등록율(%)", "학점당수업료(원)", "강좌수", "시간제등록 수강생수(b)"};  
        int [][] valCellNum = getDataCellNum(sheet, 3, 6, celltitle); // [0][] 열   [1][] 행
        String[] rwotitle = {"합계"};  
        int [][] valrwoNum = getDataRowNum(sheet, 8, 0, rwotitle); // [0][] 열   [1][] 행
        
		// row for문
		r = valrwoNum[1][0]; 
        
        // 시트에 대한 행을 하나씩 추출
        HSSFRow row   = sheet.getRow(r);
        if (row != null) 
        { 
        	//cell FOR문
        	int [] cellNums = valCellNum[0];
        	for (int cc : cellNums)  //cell FOR문
            {			
            	 c = cc;			
            	// 행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
                 HSSFCell cell  = row.getCell(c);
                 if (cell != null) { 
                	 String value = parseCellVal(cell, true); 
                	 value.replaceAll("%", "");
                	 pmap.put("" + (paramNM++), value.trim());
                } 
            } // for
        	pmap.put("sttUnivID", sttUnivID);  //대학별 통계문서 아이디 저장   
        	insert("UnivSttDao.insertPartTime", pmap);	 //insert CU_STT_TEACHER_DATA
        }	        
		
	}
	
	
	/**
     * 연령별, 성별별 통계
     * (CU_STT_AGE)
     */	
	private void parseAge(HSSFSheet sheet, long sttUnivID ) throws Exception
	{
		int paramNM = 1;
    	Map pmap = new HashMap();        
    	// row for문
    	String[] celltitle = {"등록자수(A)", "19세 이하", "20대", "30대", "40대", "50대", "60대 이상"};  
        int [][] valCellNum = getDataCellNum(sheet, 3, 7, celltitle); // [0][] 열   [1][] 행
        String[] rwotitle = {"합계"};  
        int [][] valrwoNum = getDataRowNum(sheet, 8, 2, rwotitle); // [0][] 열   [1][] 행
        
		// row for문
		r = valrwoNum[1][0]; 
		
		 for(; r < valrwoNum[1][0]+3; r++)
		 {
			 HSSFRow row   = sheet.getRow(r);
			 if (row != null) 
	        {
				 HSSFCell cell  = row.getCell(valCellNum[0][0] + 1);
				 if (cell != null) {                 	 
                	 String value = parseCellVal(cell, true); 
                	 pmap.put("" + (paramNM++), value.trim());
                } 
	        }
		 }
        
        // 시트에 대한 행을 하나씩 추출
        HSSFRow row   = sheet.getRow(r - 1);
        if (row != null) 
        { 
        	//cell FOR문
        	int [] cellNums = valCellNum[0];
        	int index = 0;
        	for (int cc : cellNums)  //cell FOR문
            {			
            	 c = cc;		
            	 if(++index == 1) continue;
            	 if(index == 3) 
            	 {
            		// 행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
                     HSSFCell cell  = row.getCell(c++);
                     if (cell != null) { 
                    	 
                    	 String value = parseCellVal(cell, true); 
                    	 pmap.put("" + (paramNM++), value.trim());
                    } 
            	 }
            	// 행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
                 HSSFCell cell  = row.getCell(c);
                 if (cell != null) { 
                	 
                	 String value = parseCellVal(cell, true); 
                	 pmap.put("" + (paramNM++), value.trim());
                } 
            } // for
        	pmap.put("sttUnivID", sttUnivID);  //대학별 통계문서 아이디 저장   
        	insert("UnivSttDao.insertSttAge", pmap);	 //insert CU_STT_TEACHER_DATA
        }	
	}
	
	
	
	/**
     *  입학금.수업료
     * (CU_STT_FEE)
     */
	private void parseSttFee(HSSFSheet sheet, long sttUnivID ) throws Exception
	{
		int paramNM = 1;
    	Map pmap = new HashMap();    
    	String[] celltitle = {"전형료ⓐ", "입학금ⓑ", "학점당 수업료©","실습비ⓓ", 
    							"기타ⓔ", "등록금(A)", "전년도 등록금(B)", "전년대비 인상률(%)"};  
        int [][] valCellNum = getDataCellNum(sheet, 3, 5, celltitle); // [0][] 열   [1][] 행
//        String[] rwotitle = {"합계"};  
//        int [][] valrwoNum = getDataRowNum(sheet, 8, rwotitle); // [0][] 열   [1][] 행
        
		// row for문
		r = valCellNum[1][0] + 1; 
        
        // 시트에 대한 행을 하나씩 추출
        HSSFRow row   = sheet.getRow(r);
        if (row != null) 
        { 
        	//cell FOR문
        	int [] cellNums = valCellNum[0];
        	for (int cc : cellNums)  //cell FOR문
            {			
            	 c = cc;			
            	// 행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
                 HSSFCell cell  = row.getCell(c);
                 if (cell != null) { 
                	 String value = parseCellVal(cell, true); 
                	 value.replaceAll("%", "");
                	 pmap.put("" + (paramNM++), value.trim());
                } 
            } // for
        	pmap.put("sttUnivID", sttUnivID);  //대학별 통계문서 아이디 저장   
        	insert("UnivSttDao.insertSttFee", pmap);	 //insert CU_STT_TEACHER_DATA
        }	 
		
	}
	
	/**
	 *  학력 직업
	 * (CU_STT_JOB)
	 */
	private void parseJob(HSSFSheet sheet, long sttUnivID ) throws Exception
	{
		int paramNM = 1;
		Map pmap = new HashMap();    
		String[] celltitle = {"관리자", "전문가 및 관련종사자", "사무 종사자","서비스종사자", 
				"판매종사자", "농림어업종사자", "기능원 및기능종사자", "장치.기계조작 및 조립종사자",
				"단순노무 종사자", "군인", "무직", "계 ©"};  
		int [][] valCellNum = getDataCellNum(sheet, 3, 6, celltitle); // [0][] 열   [1][] 행
        String[] rwotitle = {"합계"};  
        int [][] valrwoNum = getDataRowNum(sheet, 8, 2, rwotitle); // [0][] 열   [1][] 행
		
		// row for문
		r = valrwoNum[1][0] + 2; 
		
		// 시트에 대한 행을 하나씩 추출
		HSSFRow row   = sheet.getRow(r);
		if (row != null) 
		{ 
			//cell FOR문
			int [] cellNums = valCellNum[0];
			for (int cc : cellNums)  //cell FOR문
			{			
				c = cc;			
				// 행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
				HSSFCell cell  = row.getCell(c);
				if (cell != null) { 
					String value = parseCellVal(cell, true); 
					pmap.put("" + (paramNM++), value.trim());
				} 
			} // for
			pmap.put("sttUnivID", sttUnivID);  //대학별 통계문서 아이디 저장   
			insert("UnivSttDao.insertSttJob", pmap);	 //insert CU_STT_TEACHER_DATA
		}	 
		
	}
	
	/**
	 *  총 졸업생
	 * (CU_STT_GRADUATE)
	 */
	private void parseGraduate(HSSFSheet sheet, long sttUnivID ) throws Exception
	{
		int paramNM = 1;
		Map pmap = new HashMap();    
		String[] celltitle = {"졸업학년도", "합계(C=A+B)"};  
		int [][] valCellNum = getDataCellNum(sheet, 3, 7, celltitle); // [0][] 열   [1][] 행
		String[] rwotitle = {"합계"};  
		int [][] valrwoNum = getDataRowNum(sheet, 8, 2, rwotitle); // [0][] 열   [1][] 행
		
		// row for문
		for(r =valCellNum[1][1] + 2; r < valrwoNum[1][0]; r++)
		{
			// 시트에 대한 행을 하나씩 추출
			HSSFRow row   = sheet.getRow(r);
			paramNM = 1;
			pmap = new HashMap();    
			if (row != null) 
			{ 
				//cell FOR문
				int [] cellNums = valCellNum[0];
				for (int cc : cellNums)  //cell FOR문
				{			
					c = cc;			
					// 행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
					HSSFCell cell  = row.getCell(c);
					if (cell != null) {
						String value = parseCellVal(cell, true);
						value = value.replace(".0", "");
						value = value.replaceAll("[^0-9]", "");
						pmap.put("" + (paramNM++), value.trim());
					} 
				} // for
				pmap.put("sttUnivID", sttUnivID);  //대학별 통계문서 아이디 저장   
				insert("UnivSttDao.insertSttGraduate", pmap);	 //insert CU_STT_TEACHER_DATA
			}	 
		}
		
	}
	
	
	private String parseCellVal(HSSFCell cell, boolean isNotNull) throws Exception
	{
		String value = "";
		try{
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:
					value = "" + cell.getNumericCellValue(); // double
				break;
			case HSSFCell.CELL_TYPE_STRING:
				value = "" + cell.getStringCellValue(); // String
				if("-".equals(value.trim())) value = "0";
				break;
			case HSSFCell.CELL_TYPE_FORMULA :
			   cellValue = evaluator.evaluate(cell); 			                            	   
         	   value = "" + cellValue.getNumberValue();
         	   break;
			case HSSFCell.CELL_TYPE_BLANK:
				value = "";
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				value = "" + cell.getBooleanCellValue(); // boolean
				break;
			case HSSFCell.CELL_TYPE_ERROR:
				value = "" + cell.getErrorCellValue(); // byte
				break;
			default:				
		}  
		}catch (Exception e) {
			r = cell.getRowIndex();
			c = cell.getCellNum();
			throw e;
		}		
		
		//캡취 컬럼이 빈 값일시 애로 호출
		if(isNotNull && "".equals(value.trim())) throw new Exception();
		
		return value.trim();
	}	
	
	// 캡취할 열을 초기화  [0][] 열   [1][] 행
	private int[][] getDataCellNum(HSSFSheet sheet, int startRow, int endRow, String[] title) throws Exception
	{
		int [][]cellRowNum = new int[2][title.length];
		int rows = sheet.getPhysicalNumberOfRows();
		int titleNum = 0;
		String titles = "";
		
		for (int rn = startRow; rn <= endRow && rn < rows; rn++) 
        {
			HSSFRow row   = sheet.getRow(rn);
//			int cells = row.getPhysicalNumberOfCells(); 
			int cells = row.getLastCellNum();
		
			for (int cc = 0; cc < cells; cc++)  //cell FOR문
            {
				// 행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
                HSSFCell cell  = row.getCell(cc);
                if (cell != null) 
                { 
                	String value = parseCellVal(cell, false); 
                	if("".equals(value)) continue;
                	String titleName = title[titleNum].replaceAll("[\\(\\)\\<\\>\\{\\}\\\\\\/\\,\\.\\+\\=\\s\\d\\\"\\\']", "");
                	value = value.replaceAll("[\\(\\)\\<\\>\\{\\}\\\\\\/\\,\\.\\+\\=\\s\\d\\\"\\\']", "");
                	if(!titleName.equals(value)) continue;
					for(int tl = 0; tl < titleName.length(); tl++)
					{
						value = value.replaceAll(titleName.substring(tl, tl + 1), "");
					}
					if("".equals(value.trim()))
            		{
            			cellRowNum[0][titleNum] = cc;
            			cellRowNum[1][titleNum] = rn;
            			titles += title[titleNum] + ",";
            			titleNum++;
            		}
            		if(titleNum == title.length)
            			break;
                	//}
                	
                }
            }
			if(titleNum == title.length)
    			break;
        }
	
		if(titleNum != title.length) {
			str = sheetName + "(sheet)에 "+title[titleNum]+" 컬럼명이 부족합니다.\r\n";
			throw new Exception();
		}
        
		return cellRowNum;
	}
	
	// 캡취할 열을 초기화
	private int[][] getDataRowNum(HSSFSheet sheet, int startRow, int endCell, String[] title) throws Exception
	{
		int [][]cellRowNum = new int[2][title.length];
		int rows = sheet.getPhysicalNumberOfRows();
		int titleNum = 0;
		String titles = "";
		
		for (int rn = startRow; rn < rows; rn++) 
		{
			HSSFRow row   = sheet.getRow(rn);
			int cells = 0;
			if(endCell != 0) cells = endCell;
			else cells = row.getLastCellNum();//cells = row.getPhysicalNumberOfCells(); 
			for (int cc = 0; cc < cells; cc++)  //cell FOR문
			{
				// 행에대한 셀을 하나씩 추출하여 셀 타입에 따라 처리
				HSSFCell cell  = row.getCell(cc);
				if (cell != null) 
				{ 
					String value = parseCellVal(cell, false); 
					if("".equals(value)) continue;
					String titleName = title[titleNum].replaceAll("[\\(\\)\\<\\>\\{\\}\\\\\\/\\,\\.\\+\\=\\s\\d\\\"\\\']", "");
                	value = value.replaceAll("[\\(\\)\\<\\>\\{\\}\\\\\\/\\,\\.\\+\\=\\s\\d\\\"\\\']", "");
                	if(!titleName.equals(value)) continue;
					for(int tl = 0; tl < titleName.length(); tl++)
					{
						value = value.replaceAll(titleName.substring(tl, tl + 1), "");
					}
					if("".equals(value.trim()))
					{
						cellRowNum[0][titleNum] = cc;
						cellRowNum[1][titleNum] = rn;
						titles += title[titleNum] + ",";
						titleNum++;
					}
					if(titleNum == title.length)
						break;
					//}
				}
			}
			if(titleNum == title.length)
				break;
		}
		
		if(titleNum != title.length) {
			str = sheetName + "(sheet)에  "+title[titleNum]+" 컬럼명이 부족합니다.\r\n";
			throw new Exception();
		}
		
		return cellRowNum;
	}
	
	public String ConvertToColName(int colIndex)

	{
		String strRtn = "";
		int numMod = 0;
		int numTemp = colIndex;
		char ch = 'A';
		
		if (colIndex <= 0)
			return "";
		
		do
		{
			numMod = numTemp % 26;
			numTemp = numTemp / 26;
			if (numMod == 0)
			{
				ch = 'Z';
				numTemp--;
			}
			else
				ch = (char) ('A' + numMod - 1);
			strRtn = ch + strRtn;
		}
		while (numTemp > 0);
		
		return strRtn;
	}


}
