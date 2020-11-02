<%--@ page pageEncoding = "utf-8" --%>
<%!
 /**
 *  subject: 검색엔진 설정 페이지
 */

	final static int CONNECTION_TIMEOUT = 10000;
	final static String CHARSET = "utf-8";
	final static int REALTIME_COUNT=100;
	final static int PAGE_SCALE = 10; //view page list count

	final static int CONNECTION_KEEP = 0; //recevive mode
	final static int CONNECTION_REUSE = 2;
	final static int CONNECTION_CLOSE = 3;

	final static int ASC = 0; //order
	final static int DESC = 1; //order

	final static int USE_KMA_OFFOFF = 0; //synonym, morpheme
	final static int USE_KMA_ONON = 1;
	final static int USE_KMA_ONOFF = 2;

	final static int IS_CASE_ON = 1; //case on, off
	final static int IS_CASE_OFF = 0;

	final static int HI_SUM_OFFOFF = 0; //summarizing, highlighting
	final static int HI_SUM_OFFON = 1;
	final static int HI_SUM_ONOFF = 2;
	final static int HI_SUM_ONON = 3;

	final static int INDEX_NAME = 0;
	final static int COLLECTION_NAME = 1;
	final static int PAGE_INFO = 2;
	final static int ANALYZER = 3;
	final static int SORT_FIELD = 4;
	final static int SEARCH_FIELD = 5;
	final static int RESULT_FIELD = 6;
	final static int DATE_RANGE = 7;
	final static int EXQUERY_FIELD = 8;
	final static int COLLECTION_QUERY =9;
	final static int FILTER_OPERATION = 10;
	final static int GROUP_BY = 11;
	final static int GROUP_SORT_FIELD = 12;
	final static int CATEGORY_BOOST = 13;
	final static int PROPERTY_GROUP = 14;
	final static int SEARCH_MAPPING = 15;
	final static int PREFIX_FIELD = 16;
	final static int FAST_ACCESS = 17;
	final static int COLLECTION_KOR = 18;

	final static String SEARCH_IP="210.102.99.65";
	final static int SEARCH_PORT=9204;
    // ���հ˻����� univ_lecture_year �� ���� 2012.03.14
	public String[] COLLECTIONS_NEW = new String[]{"univ_lecture","univ_bbs","univ_web"};
	public String[] COLLECTIONS = new String[]{"univ_lecture","univ_lecture_year","univ_bbs","univ_web"};
	public class WNCollection{
	public String[][] COLLECTION_INFO = null;
		WNCollection(){
			COLLECTION_INFO = new String[][]
			{
		{
			"univ_lecture", // set collection name
			"univ_lecture", // set index name
			"0,3",  // set pageinfo (start,count)
			"1,0", // set query analyzer (useKMA,isCase)
			"RANK,1",  // set sort field (field,order) multi sort '/'
			"DOCID,title,keyword,univName,contName,description",// set search field
			"DOCID,courseIdentifier,title,keyword,regDate,univName,deptName,description,contName,credit,termSemester,clicksCnt,departmentId,universityId,publicYn",// set document field
			"",// set date range
			"", // set exquery (fieldname:value...) and ' ', or '|'/, not '!'
			"", // set collection query (<fieldname:value> <fieldname,fieldname2:value> | <field3:value>...) and ' ', or '|'
			"", // set filter operation (fieldname <operator>value)
			"",// set groupby field(field, count)
			"",// set sort field group(field,order)
			"",// set categoryBoost(fieldname,matchType,boostID,boostKeyword)
			"",// set property group (fieldname,from,to)
			"",// set mapping search field
			"departmentId,universityId,publicYn", //use check exquery filed
			"", // set use check fast access field
			"univ_lecture" // collection display name
		}
         ,
	   {
			"univ_lecture_year", // set collection name
			"univ_lecture_year", // set index name
			"0,3",  // set pageinfo (start,count)
			"1,0", // set query analyzer (useKMA,isCase)
			"RANK,1",  // set sort field (field,order) multi sort '/'
			"DOCID,title,keyword,univName,contName,description",// set search field
			"DOCID,courseIdentifier,title,keyword,regDate,univName,deptName,description,contName,credit,termSemester,clicksCnt,departmentId,universityId,publicYn",// set document field
			"",// set date range
			"", // set exquery (fieldname:value...) and ' ', or '|'/, not '!'
			"", // set collection query (<fieldname:value> <fieldname,fieldname2:value> | <field3:value>...) and ' ', or '|'
			"", // set filter operation (fieldname <operator>value)
			"",// set groupby field(field, count)
			"",// set sort field group(field,order)
			"",// set categoryBoost(fieldname,matchType,boostID,boostKeyword)
			"",// set property group (fieldname,from,to)
			"",// set mapping search field
			"departmentId,universityId,publicYn", //use check exquery filed
			"", // set use check fast access field
			"univ_lecture_year" // collection display name
		}
         ,
		{
			"univ_bbs", // set collection name
			"univ_bbs", // set index name
			"0,3",  // set pageinfo (start,count)
			"1,0", // set query analyzer (useKMA,isCase)
			"RANK,1",  // set sort field (field,order) multi sort '/'
			"DOCID,title,content",// set search field
			"DOCID,gubn,title,content,regDate,hitsCnt",// set document field
			"",// set date range
			"", // set exquery (fieldname:value...) and ' ', or '|'/, not '!'
			"", // set collection query (<fieldname:value> <fieldname,fieldname2:value> | <field3:value>...) and ' ', or '|'
			"", // set filter operation (fieldname <operator>value)
			"",// set groupby field(field, count)
			"",// set sort field group(field,order)
			"",// set categoryBoost(fieldname,matchType,boostID,boostKeyword)
			"",// set property group (fieldname,from,to)
			"",// set mapping search field
			"", //use check exquery filed
			"", // set use check fast access field
			"univ_bbs" // collection display name
		}
         ,
		{
			"univ_web", // set collection name
			"univ_web", // set index name
			"0,3",  // set pageinfo (start,count)
			"1,0", // set query analyzer (useKMA,isCase)
			"RANK,1",  // set sort field (field,order) multi sort '/'
			"subject,content",// set search field
			"DOCID,subject,content,Date,writer,base_url,url,type,source,section",// set document field
			"",// set date range
			"", // set exquery (fieldname:value...) and ' ', or '|'/, not '!'
			"", // set collection query (<fieldname:value> <fieldname,fieldname2:value> | <field3:value>...) and ' ', or '|'
			"", // set filter operation (fieldname <operator>value)
			"",// set groupby field(field, count)
			"",// set sort field group(field,order)
			"",// set categoryBoost(fieldname,matchType,boostID,boostKeyword)
			"",// set property group (fieldname,from,to)
			"",// set mapping search field
			"", //use check exquery filed
			"", // set use check fast access field
			"univ_web" // collection display name
		}
			};
		}
	}
%>