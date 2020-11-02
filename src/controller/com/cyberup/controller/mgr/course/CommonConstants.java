/*
 * Created on 2005. 8. 19.
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.cyberup.controller.mgr.course;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CommonConstants {

	/* License 변수 */
	public static final String LIC_TYPE 		= "CreativeCommons";
	public static final String LIC_VERSION 		= "2.0";
	public static final String LIC_JRUISDICTION = "kr";

	public static final String LIC_ATTRIBUTION 		= "by";
    public static final String LIC_NONCOMMERCIAL 	= "nc";
    public static final String LIC_NO_DERIVATIVE 	="nd";
    public static final String LIC_SHARE_ALIKE 		= "sa";

    public static final String ORDER_BY_ASC 	= "ASC";
    public static final String ORDER_BY_DESC 	= "DESC";

    //  검색연산자 상수
    public final static String OPERATOR_AND = "AND";
    public final static String OPERATOR_OR 	= "OR";
    public final static String OPERATOR_NOT = "NOT";

    // 검색 날짜 제한자 타입
    public final static String SEARCH_AWARDED_DATE	= "awarded"; //학위수여년
    public final static String SEARCH_ISSUED_DATE	= "issued"; //발행년

    //비동의논문 정산가
    public final static int AGREE_NO_NORMAL_PRICE = 100;

    // 루씬 카테고리
    public final static String LUCENE_CATEGORY_ITEM		= "item";
    public final static String LUCENE_CATEGORY_SERIES 	= "series";

    //원문보기 리턴 상태 값
    public final static String VIEW_OK 				= "0"; 		//원문보기
    public final static String VIEW_RESTRICT 		= "1";		//제한적 원문 보기
    public final static String VIEW_NO_SERVICE 		= "2";      //비동의논문공동활용 비참여 기관
    public final static String VIEW_NO_INNER_VIEW 	= "4";    	//관내보기 불허
    public final static String VIEW_KERIS_AUTH_FAIL = "5";  	//KERIS인증 실패
    public final static String VIEW_FILE_ERROR 		= "6";      //원문 파일 에러
    public final static String VIEW_PACKAGING_ERROR	= "7";      //원문 파일 에러

    //검색 통계
    public static final String TYPE_GENERAL 	= "1"; 			//일반검색
    public static final String TYPE_DETAIL 		= "2";  		//고급검색
    public static final String TYPE_DEPARTMENT 	= "3";			//학과별 학위논문
    public static final String TYPE_SERIES 		= "4";			//학술논문
    public static final String TYPE_PROCEEDING 	= "5";			//프로시딩/논문집
    public static final String TYPE_OTHER 		= "6";		    //보고서 및 기타

    //데몬관제
    public static final String DAEMON_STARTED = "1";  //데몬 시작
    public static final String DAEMON_STOPED  = "0";  //데몬 중지

    public static final String DAEMON_IMPORTER  = "importer";
    public static final String DAEMON_EXPORTER  = "exporter";
    public static final String DAEMON_MAILER  = "mailer";
    public static final String DAEMON_INDEXER  = "indexer";

}
