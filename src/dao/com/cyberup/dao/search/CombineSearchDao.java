package com.cyberup.dao.search;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;


import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.course.CourseSearch;
import com.cyberup.model.home.CombineSearch;

@Repository
public class CombineSearchDao extends BaseDAO{

	public List selectBoards(CombineSearch combineSearch){
		return queryForList("CombineSearchDao.selectBoards",combineSearch);
		
	}
	public List selectCourses(CombineSearch combineSearch){
		return queryForList("CombineSearchDao.selectCourses",combineSearch);
		
	}
	public List selectKeywords(){
		return queryForList("CombineSearchDao.selectKeywords");
		
	}
	public List selectBestCourses(){
		return queryForList("CombineSearchDao.selectBestCourses");
		
	}
	
	
	//통합검색
//	public static void main(String[] ar){
	public List totalSearch(CombineSearch combineSearch){
		
		List<CombineSearch> list = new ArrayList<CombineSearch>();
		
		String url = "";
		
		//인자에따라 url 또는 collection 명을 변경한다.
		Integer startCount		= 0;
		Integer searchGubn	 	= 0;
		Integer currPage 		= 0;
		Integer showCnt 		= 0;
		String  headerText 		= "";
		String  collection		= "";
		
		String sort 			= "";
		String order 			= "";
		
		//사용하지 않는 변수. (와이즈넛에서 검색어를 띄어쓰기로 들어갈경우 and 검색하고 | 를 연결할경우 or 검색한다고함.)
		String  headerTextArr 	= "";
		String  headerText1		= "";
		String  headerText2		= "";
		String  headerText3		= "";
		String  sfield		= "";

		searchGubn	= combineSearch.getSearchGubn();
		currPage 	= combineSearch.getCurrPage2();
		showCnt 	= combineSearch.getShowCnt2();
		headerText 	= combineSearch.getHeaderText();
		headerText1 = combineSearch.getHeaderText1();
		headerText2 = combineSearch.getHeaderText2();
		headerText3 = combineSearch.getHeaderText3();
		sort 		= combineSearch.getSort();
		order 		= combineSearch.getOrder();
		
		//test
		//searchGubn = 3;
		//headerText = "1";
		
		//검색범위
		switch (searchGubn) {
		case 0:
			collection = "ALL";
			break;
		case 1:
			collection = "univ_lecture";
			sfield = "TITLE,DESCRIPTION";
//			sfield = "TITLE,KEYWORD,UNIVNAME,DEPARTMENT,UNIVERSITYNAME,MANAGER,DESCRIPTION";
			break;
		case 2:
			collection = "univ_bbs";
			sfield = "TITLE,CONTENT";
			break;
		case 3:
			collection = "univ_web";
			sfield = "TITLE,CONTENT";
			break;
		default:
			collection = "ALL";
			break;
		}
		
		if("".equals(sort))
			sort = "regDate";
		if("clicksCnt".equals(sort) && searchGubn == 2)
			sort = "hitsCnt";
		if("clicksCnt".equals(sort) && searchGubn == 3)
			sort = "regDate";
		
		startCount = (currPage - 1) * showCnt;
		
		// check param =>
		System.out.println("#########################################");
		System.out.println("collection = " + collection);
		System.out.println("startCount = " + startCount);
		System.out.println("headerText = " + headerText);
		System.out.println("sort = " + sort);
		System.out.println("order = " + order);
		System.out.println("#########################################");
		
		//검색시작번호(페이징처리)
		//url = "http://122.199.151.60:8088/search/search_xml.jsp?query="+headerText+"&collection="+collection+"&startCount="+startCount+"&listCount=10";
		
		try {
//			url = "http://122.199.151.60:8088/search/search_xml.jsp?query="+URLEncoder.encode(URLEncoder.encode(headerText,"UTF-8"),"UTF-8")+"&collection="+collection+"&sort="+sort+"&order="+order+"&startCount="+startCount+"&listCount=10";
//			url = "http://www.cuinfo.net/search1/search_xml.jsp?query="+URLEncoder.encode(URLEncoder.encode(headerText,"UTF-8"),"UTF-8")+"&collection="+collection+"&sort="+sort+"&order="+order+"&startCount="+startCount+"&listCount=10";
//			url = "http://61.82.137.49:7900/xml/jsp/search_xml.jsp?query="+URLEncoder.encode(URLEncoder.encode(headerText,"UTF-8"),"UTF-8")+"&collection="+collection+"&sort="+sort+"&order="+order+"&startCount="+startCount+"&listCount=5";
			url = "http://www.cuinfo.net/search_new/search_xml.jsp?query="+URLEncoder.encode(headerText,"UTF-8")+"&collection="+collection+"&sort=RANK/DESC,DATE/DESC&startCount="+startCount+"&listCount=10&sfield="+sfield;
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (Exception e2){
			e2.printStackTrace();
		}
//		url = "http://61.82.137.49:7900/xml/jsp/search_ml.jsp?collection="+collection+"&sort="+sort+"&order="+order+"&startCount="+startCount+"&listCount=10";
		
		System.out.println("url = "+url+"\n");
		
		try {
			//xml 파일을 Document 객체로 파싱하여 노드별로접근 가능토록 한다.
			DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder   		= factory.newDocumentBuilder();
			Document document     			= builder.parse(url);

			String resultName 	= "";
			String resultValue 	= "";
			String totalCnt 	= "";
			String collName 	= "";
			
//			System.out.println("\nDocumentSet ============================================================================================\n");
			
			NodeList DocumentSet = document.getElementsByTagName("DocumentSet");
			NodeList temp1 = null;

			
			/*
			 * 2단계:condition 을 확인하여 검색어와 총 검색 갯수를 확인하다.
			 * */
			for (int i = 0; i < DocumentSet.getLength(); i++) {
				temp1 = DocumentSet.item(i).getChildNodes();
				for (int j = 0; j < temp1.getLength(); j++) {
					if(temp1.item(j).getNodeName().equals("TotalCount")){
//						totalCnt += Integer.parseInt(temp1.item(j).getTextContent().trim());
						totalCnt = temp1.item(j).getTextContent().trim();
					}
				}
			}
			
			
			/*
			 * 3단계:콜렉션 명에 따라 해당하는 모델 맵핑
			 * */
			
			/*			
			NodeList result = document.getElementsByTagName("Result");
			NamedNodeMap result_nnm 	= result.item(0).getAttributes();
			
			
			for (int i = 0; i < result_nnm.getLength(); i++) {
				
				System.out.println("result = "+result_nnm.item(i).getNodeName() + " : " + result_nnm.item(i).getNodeValue());
				
				resultName 	= result_nnm.item(i).getNodeName();
				resultValue = result_nnm.item(i).getNodeValue();
				
				//총카운트
				if(resultName.equals("TotalCount"))
					totalCnt = resultValue;
				//검색대상
				if(resultName.equals("CollName"))
					collName = resultValue;
			}
			
			System.out.println("totalCnt = " + totalCnt);
			System.out.println("collName = " + collName + "\n");
			
			NodeList rows = result.item(0).getChildNodes();
			
			for (int i = 0; i < rows.getLength(); i++) {
				
				//System.out.println("rows.item(i).getNodeType() = " + rows.item(i).getNodeType());
				
				if(rows.item(i).getNodeType() == 1){
					
					CombineSearch cs = new CombineSearch();
					
					NodeList row = rows.item(i).getChildNodes();
					
					//모델에 맵핑
					Integer clicksCnt = 0;
					Integer courseId = 0;
					for (int j = 0; j < row.getLength(); j++) {
						
						if(row.item(j).getNodeType() == 1 ){
							
							System.out.println(row.item(j).getNodeName()+":"+row.item(j).getTextContent());
							
							//강의검색
							if(collName.equals("univ_lecture_year")){
								
								if(row.item(j).getNodeName().equals("DOCID"))
									cs.setCourseId(Integer.parseInt(row.item(j).getTextContent().replace("faq", "").replace("board", "").trim()));
								else if(row.item(j).getNodeName().equals("courseIdentifier"))
									cs.setCourseIdentifier(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("title")){
									cs.setTitle(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));//<em class="red"></em>
									cs.setMainTitle(row.item(j).getTextContent().trim().replace("<!HS>", "").replace("<!HE>", ""));
								}
								else if(row.item(j).getNodeName().equals("keyword"))
									cs.setKeyword(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("regDate"))
								{
									SimpleDateFormat sdfmt = new SimpleDateFormat( "yyyyMMdd" );
									String date = row.item(j).getTextContent().substring(0, 8);
									Date regdate = sdfmt.parse( date.trim() );
									cs.setRegDate(regdate);
								}
								else if(row.item(j).getNodeName().equals("univName"))
									cs.setUnivName(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("deptName"))
									cs.setDeptName(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("description"))
									cs.setDescription(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("contName"))
									cs.setContName(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("credit"))
									cs.setCredit(row.item(j).getTextContent());
								else if(row.item(j).getNodeName().equals("termSemester"))
									cs.setTermSemester(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("clicksCnt")){
									
									courseId = cs.getCourseId();
									clicksCnt = (Integer)queryForObject("CourseSearchDao.clicksCnt",courseId);
									cs.setClicksCnt(clicksCnt);
								}
								// 추가된 컬럼
								else if(row.item(j).getNodeName().equals("departmentId"))
									cs.setDepartmentId(Integer.parseInt(row.item(j).getTextContent().trim()));
								else if(row.item(j).getNodeName().equals("publicYn"))
									cs.setPublicYn(row.item(j).getTextContent().trim());
								
							//게시판검색
							}else if(collName.equals("univ_bbs")){
								
								if(row.item(j).getNodeName().equals("DOCID"))
									cs.setId(Integer.parseInt(row.item(j).getTextContent().replace("faq", "").replace("board", "").trim()));
								else if(row.item(j).getNodeName().equals("gubn"))
									cs.setGubn(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("title")){
									cs.setTitle(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
									
								}
								else if(row.item(j).getNodeName().equals("CONTENT"))
									cs.setContent(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("regDate")){
									SimpleDateFormat sdfmt = new SimpleDateFormat( "yyyyMMdd" );
									String date = row.item(j).getTextContent().substring(0, 8);
									Date regdate = sdfmt.parse( date.trim() );
									cs.setRegDate(regdate);
								}
								else if(row.item(j).getNodeName().equals("hitsCnt")){
									cs.setClicksCnt(Integer.parseInt(row.item(j).getTextContent().trim()));
								}
							//웹검색
							}else if(collName.equals("univ_web")){
								
								if(row.item(j).getNodeName().equals("subject"))
									cs.setSubject(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("content"))
									cs.setContent(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("Date")) {
									SimpleDateFormat sdfmt = new SimpleDateFormat( "yyyy.MM.dd" );
									String date = row.item(j).getTextContent().trim();
									Date regdate = sdfmt.parse( date.trim() );
									cs.setRegDate(regdate);
								}
								else if(row.item(j).getNodeName().equals("writer"))
									cs.setRegister(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("base_url"))
									cs.setBaseUrl(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("base_url"))
									cs.setBaseUrl(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("url"))
									cs.setUrl(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("type"))
									cs.setType(row.item(j).getTextContent().trim());
								if(row.item(j).getNodeName().equals("source"))
									cs.setSource(row.item(j).getTextContent().trim());
								if(row.item(j).getNodeName().equals("section"))
									cs.setSection(row.item(j).getTextContent().trim());
							}
							cs.setTotalCnt2(Integer.parseInt(totalCnt));
						}
					}
					list.add(cs);
					System.out.println();
					
				}//end if
			}//end for
			 */
			
			//Document 집합을 구한다.
			NodeList Documents = document.getElementsByTagName("Document");
			
			//Document 크기만큼 루프.
			for (int i = 0; i < Documents.getLength(); i++) {
				
				//Document 의 내용을 담는다.
				NodeList Document = Documents.item(i).getChildNodes();
				
				
				//Document 의 내용만큼 루프.
				for (int k = 0; k < Document.getLength(); k++) {
					
					//Document 의 내용중 Field 를 CourseSearch 객체에 맵핑한다.
					if(Document.item(k).getNodeName().equals("Field") && Document.item(k).getNodeType() == 1){
						CombineSearch cs = new CombineSearch();
						NodeList row = Document.item(k).getChildNodes();
						Integer clicksCnt = 0;
						Integer courseId = 0;
						
						for (int j = 0; j < row.getLength(); j++) {
							if(row.item(j).getNodeType() == 1 ){
								
//								System.out.println(i + " => " + row.item(j).getNodeName()+":"+row.item(j).getTextContent());
								
								if(searchGubn == 1 ){
									//univ_lecture_year 검색
		
									if(row.item(j).getNodeName().equals("DOCID"))
										cs.setCourseId(Integer.parseInt(row.item(j).getTextContent().trim()));
									else if(row.item(j).getNodeName().equals("COURSEIDENTIFIER"))
										cs.setCourseIdentifier(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("UNIVNAME"))
										cs.setUnivName (row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));//<em class="red"></em>
									else if(row.item(j).getNodeName().equals("CLICKSCNT")){
										courseId = cs.getCourseId();
										clicksCnt = (Integer)queryForObject("CourseSearchDao.clicksCnt",courseId);
										cs.setClicksCnt(clicksCnt);
									}
									else if(row.item(j).getNodeName().equals("DEPARTMENT"))
										cs.setDepartment(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
									else if(row.item(j).getNodeName().equals("CREDIT"))
										cs.setCredit(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("TERMSEMESTER"))
										cs.setTermSemester(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("MANAGER"))
										cs.setManager(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
									else if(row.item(j).getNodeName().equals("DESCRIPTION"))
										cs.setDescription(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
									else if(row.item(j).getNodeName().equals("TITLE")){
										cs.setMainTitle(row.item(j).getTextContent().trim().replace("<!HS>", "").replace("<!HE>", ""));
										cs.setTitle(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
									}
									else if(row.item(j).getNodeName().equals("PUBLICYN"))
										cs.setPublicYn(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("DEPARTMENTID"))
										cs.setDeptName(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("UNIVERSITYID"))
										cs.setUnivId(Integer.parseInt(row.item(j).getTextContent().trim()));
									else if(row.item(j).getNodeName().equals("KEYWORD"))
										cs.setKeyword(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
									else if(row.item(j).getNodeName().equals("REGDATE"))
									{
										SimpleDateFormat sdfmt = new SimpleDateFormat( "yyyymmdd" );
										String date = row.item(j).getTextContent().substring(0, 8);
										Date regdate = sdfmt.parse( date.trim() );
										cs.setRegDate(regdate);
									}
									else if(row.item(j).getNodeName().equals("SIP"))
										cs.setSip(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("URI"))
										cs.setUri(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("QUI"))
										cs.setQri(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("SP"))
										cs.setSp(row.item(j).getTextContent().trim());
									
								}else if (searchGubn == 2){
									// univ_bbs 검색
									
									if(row.item(j).getNodeName().equals("DOCID"))
										cs.setId(Integer.parseInt(row.item(j).getTextContent().replace("faq", "").replace("board", "").trim()));
									else if(row.item(j).getNodeName().equals("GUBN"))
										cs.setGubn(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("TITLE")){
										cs.setTitle(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
										
									}
									else if(row.item(j).getNodeName().equals("CONTENT"))
										cs.setContent(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
									else if(row.item(j).getNodeName().equals("REGDATE")){
										SimpleDateFormat sdfmt = new SimpleDateFormat( "yyyyMMdd" );
										String date = row.item(j).getTextContent().substring(0, 8);
										Date regdate = sdfmt.parse( date.trim() );
										cs.setRegDate(regdate);
									}
									else if(row.item(j).getNodeName().equals("HITSCNT")){
										cs.setClicksCnt(Integer.parseInt(row.item(j).getTextContent().trim()));
									}
									
								}else if (searchGubn == 3){
									//univ_web 검색
									
									if(row.item(j).getNodeName().equals("SUBJECT"))
										cs.setSubject(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("CONTENT")){
										
										//웹페이지검색의 내용이 길어 substring 처리
										if(row.item(j).getTextContent().trim().length() > 210)
											cs.setContent(row.item(j).getTextContent().trim().substring(0,210) + "...");
										else
											cs.setContent(row.item(j).getTextContent().trim());
									}else if(row.item(j).getNodeName().equals("DATE")) {
//										SimpleDateFormat sdfmt = new SimpleDateFormat( "yyyy.MM.dd" );
//										String date = row.item(j).getTextContent().trim();
//										Date regdate = sdfmt.parse( date.trim() );
//										cs.setRegDate(regdate);
									}
									else if(row.item(j).getNodeName().equals("WRITER"))
										cs.setRegister(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("BASE_URL"))
										cs.setBaseUrl(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("BASE_URL"))
										cs.setBaseUrl(row.item(j).getTextContent().trim());
									else if(row.item(j).getNodeName().equals("URL"))
										cs.setUrl(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
									else if(row.item(j).getNodeName().equals("TYPE"))
										cs.setType(row.item(j).getTextContent().trim());
									if(row.item(j).getNodeName().equals("SOURCE"))
										cs.setSource(row.item(j).getTextContent().trim());
									if(row.item(j).getNodeName().equals("SECTION"))
										cs.setSection(row.item(j).getTextContent().trim());
								}
							cs.setTotalCnt2(Integer.parseInt(totalCnt));
								
						}//end for j
							
						}
						list.add(cs);
					}//end if
				
				}//end for k
				
			}//end for i
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] ar){
		System.out.println("main func");
		
		String aa= "123456789";
		
		String bb = "CUinfo > 사이버대학안내 > 사이버대학이란? CUinfo main 전체메뉴 즐겨찾기 KOCW RISS 통합검색 강의검색 게시물검색 웹문서 검색 사이버대학안내 사이버대학이란? 대학소개 학과 내비게이션 전체 학과 검색 국가자격증(학위취득) 길라잡이 입학 안내 입학절차 안내 모집 요강 대학 정보현황 강의 검색 강의명 검색 학과분야별 검색 학교별 검색 정보 자료실 연구/교육 자료 사이버대학 뉴스 대학행사 안내 원격대학 협의회 동정 공지 사항 자주하는 질문답변 사이버대학안내 사이버대학이란? - 개요 및 특징 - 신입생/편입생 안내 - 시간제등록 안내 대학소개 학과 내비게이션 전체 학과 검색 국가자격증(학위취득) - 사회복지사 - 보육교사 - 평생교육사 - 건강가정사 길라잡이 입학 안내 입학절차 안내 - 신/입학 - 시간제등록 모집 요강 대학 정보현황 강의 검색 강의명 검색 학과분야별 검색 학교별 검색 정보 자료실 연구/교육 자료 사이버대학 뉴스 대학행사 안내 원격대학 협의회 동정 공지 사항 자주하는 질문답변 사이버대학안내 사이버대학이란? 개요 및 특징 신입생/편입생 안내 시간제등록 안내 대학소개 학과 내비게이션 전체 학과 검색 국가자격증(학위취득) 사회복지사 보육교사 평생교육사 건강가정사 길라잡이 Home 사이버대학안내 사이버대학이란? 졸업에 필요한 기간으로 4년제의 경우 4년(8학기), 2년제의 경우 2년(4학기)으로 되어있으며, 졸업요건을 충족하고 평점 평균이 3.5~4.0 이상(학교마다 다름)인 경우 조기졸업이 가능하다. 재학연한은 제한 두지 않는다. ※ 학교마다 졸업요건 및 조기졸업요건이 상이하기 때문에 지원하는 학교에 직접 문의해야 한다. 1학기 : 3월 초부터 8월 말까지 2학기 : 9월 초부터 다음 해 2월 말까지 수업일수 : 매 학기 15주로 구성 ※ 수업진행방법 및 평가 방법은 각 학교마다 다를 수 있으니 해당 학교 홈페이지에서 확인바랍니다.";
		
		System.out.println("bb = " + bb.length());
		System.out.println("bb = " + bb.indexOf("연구/"));
		System.out.println("bb1 = " + bb);
		System.out.println("bb2 = " + bb.substring(0,210));
		
	}
	
}
