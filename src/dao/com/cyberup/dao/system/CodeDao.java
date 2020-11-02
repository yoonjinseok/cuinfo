package com.cyberup.dao.system;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.system.Code;

@Repository
public class CodeDao extends BaseDAO {
	public int deleteInfo(Integer codeId)
	{
		return delete("CodeDao.deleteInfo", codeId);
	}

	public List<Code> selectViewList(Integer showCnt, Integer currPage, Integer codeId, String codeName, String codeGroup, String codeGroupName, String useYn)
	{
		Map param = new HashMap();
		param.put("showCnt", showCnt);
		param.put("currPage", currPage);
		param.put("codeId", codeId);
		param.put("codeName", codeName);
		param.put("codeGroup", codeGroup);
		param.put("codeGroupName", codeGroupName);
		param.put("useYn", useYn);
		
		return queryForList("CodeDao.selectViewList", param);
	}
	
	public List<Code> selectList(Integer codeGroup, String useYn)
	{
		Map param = new HashMap();
		param.put("codeGroup", codeGroup);
		param.put("useYn", useYn);
		
		return queryForList("CodeDao.selectList", param);
	}

	public List<Code> selectGroupList(String useYn)
	{
		Map param = new HashMap();
		param.put("useYn", useYn);
		
		return queryForList("CodeDao.selectGroupList", param);
	}

	public int updateInfo(Code code)
	{
		return update("CodeDao.updateInfo", code);
	}

	public Code selectInfo(Integer codeId)
	{
		return (Code)queryForObject("CodeDao.selectInfo", codeId);
	}

	public Integer insertInfo(Code code)
	{
		Integer codeId = (Integer)insert("CodeDao.insertInfo", code);
		code.setCodeId(codeId);
		return codeId;
	}
	
	
	/**row 데이터 추출 기능
	 * 20140918 김재현
	 * @param model
	 * @param query
	 * @return
	 */
	public List selectTableData(String query) {
		return queryForList("CodeDao.selectTableData", query);
	}
	
	public String insertTableData(String insertquery) {
		//return queryForList("CodeDao.insertTableData", query);
		return (String) insert("CodeDao.insertTableData", insertquery);
	}
	
	public int updateTableData(String updatequery) {
		//return queryForList("CodeDao.insertTableData", query);
		return update("CodeDao.updateTableData", updatequery);
	}
	
	public int deleteTableData(String deletequery) {
		//return queryForList("CodeDao.insertTableData", query);
		return delete("CodeDao.deleteTableData", deletequery);
	}

	
	public String makeFileTableData(List list) {
		String result = "";
		//String filepath = "/data/data2/wwwjeus/cuinfo/mgr/";
		String filepath = "d:/";
		String filename = "tableDataTxt.txt";

		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter = null;
		System.out.println("파일 = " + filepath + filename);

		try {

			File checkFile = new File(filepath + filename);
			
			if(checkFile.exists())
				checkFile.delete();
			
			// 파일생성
			if (list != null || list.size() > 0) {
				try {

					System.out.println("list.size = " + list.size());
					
					File f = new File(filepath);

					if (!f.isDirectory())
						f.mkdirs();

					fileWriter = new FileWriter(filepath + filename);
					bufferedWriter = new BufferedWriter(fileWriter);

					HashMap headerMap = (HashMap)list.get(0);
					Iterator header = headerMap.keySet().iterator();
					
					List headerList = new ArrayList(); 
					
					while(header.hasNext()){
						headerList.add(header.next().toString());
					}
					
					System.out.println("headerList.size() = " + headerList.size());
					
					//제목 입력
					for (int i = 0; i < headerList.size(); i++) {
						bufferedWriter.write(headerList.get(i) + "");	
						bufferedWriter.write("\t");	
						System.out.print(headerList.get(i));	
					}
					
					bufferedWriter.newLine();
					
					//내용 입력
					for (int i = 0; i < list.size(); i++) {
						HashMap rmap = (HashMap) list.get(i);
						for (int j = 0; j < headerList.size(); j++) {
							bufferedWriter.write(rmap.get(headerList.get(j)) + "");	
							bufferedWriter.write("\t");	
						}
						bufferedWriter.newLine();
					}

					result = "filePath=" + filepath + ",fileName=" + filename;

				} catch (Exception e) {
					result = "";
					e.printStackTrace();
				} finally {
					try {
						if (bufferedWriter != null)
							bufferedWriter.close();
						if (fileWriter != null)
							fileWriter.close();
					} catch (Exception e2) {
						result = "";
						e2.printStackTrace();
					}
				}
			}

		} catch (Exception e) {
			result = e.getMessage();
			e.printStackTrace();
		}

		return result;
	}
}
