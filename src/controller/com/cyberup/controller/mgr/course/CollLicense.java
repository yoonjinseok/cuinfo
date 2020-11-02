/***********************************************************
 * 프로그램 이름 : 라이선스 > 컬렉션 라이선스
 * 프로그램 fileName : CollLicense.java
 * 작성일자 : 2005.10.28.(금)
 * 작성자  : Song, kook-jong
 * 소   속 : 퓨쳐인포넷
 ***********************************************************/

package com.cyberup.controller.mgr.course;

public class CollLicense {
    public static final String COLL_LIC_LIST = "0"; // collection의 라이선스워크폼 요소 리스트
    public static final String COLL_LIC_DIC = "1"; // 해당 요소아이디의 라이선스 사전 정보
    public static final String COLL_LIC_SYMBOLS = "LS"; // 해당 요소아이디의 라이선스 사전 정보--Symbol들만
    public static final String COLL_AGREE_GUARD = "2";
    public static final String COLL_DISAGREE_GUARD = "3";
    public static final String COLL_DISAGREE_LIC = "4";
    public static final String ITEM_LIC_DISPLAY = "5";
    public static final String ITEM_LIC = "6";
    public static final String ITEM_LIC_UPDATE = "7";
    public static final String CONTTOC_SKIP_YN = "8";
    public static final String GET_COPY_AGREEDOC = "9";
    public static final String COLL_SEPARATE_GUARD = "S";
    public static final String ITEM_LIC_ADD = "13";//충돌때문에 .. (다른 상수체계를 써야하지않을까)
    public static final String ITEM_MGMT_UPDATE = "20";//제출 시인지 제출관리시 라이선스 수정인지 알기위해 추
    public static final String ITEM_SVC_UPDATE = "40"; //서비스에서 라이선스 수정
    public static final String COLL_TO_ITEM = "21";//컬렉션의 요소를 아이템에 전부 상속시킬 때
    public static final String GET_COLL_LICWF_ELE = "22";//컬렉션의 요소를 아이템에 전부 상속시킬 때

    public static final String AGREE_FROM_N_TO_Y = "A1";
    public static final String AGREE_FROM_Y_TO_N = "A2";
    public static final String AGREE_FROM_N_TO_N = "A3";
    public static final String AGREE_FROM_Y_TO_Y = "A4";

    public static final String LICENSE_Y_GUARD_Y = "B1";
    public static final String LICENSE_Y_GUARD_I = "B2";
    public static final String LICENSE_N_GUARD_Y = "B3";
    public static final String LICENSE_N_GUARD_I = "B4";

    public static final String LICENSE = "Y";
    public static final String GUARD = "N";

    private String sCollLicWFEleId = "";
    private String sCollId = "";
    private String sADefaultValue = "";
    private String sDDefaultValue = "";
    private String sSDefaultValue = "";
    private String sASystemYn = "";
    private String sDSystemYn = "";
    private String sSSystemYn = "";
    private String sElementId = "";
    private String sElement = "";
    private String sSymbol = "";
    private String sElementName = "";
    private String sElementDesc = "";
    private String sElementBrief = "";
    private String sADispYn = "";
    private String sDDispYn = "";
    private String sSDispYn = "";
    private String sAInputRule = "";
    private String sDInputRule = "";
    private String sSInputRule = "";
    private String sNameSpace = "";
    private String sRgstPerId = "";
    private String sRgstDt = "";
    private String sModPerId = "";
    private String sModDt = "";
    private String sLicenseType = "";

    private String sAOpn = "";
    private String sDOpn = "";
    private String sSOpn = "";

    private String sBaseCollId = "";

    public String getBaseCollId() {
        return sBaseCollId;
    }

    public void setBaseCollId(String baseCollId) {
        sBaseCollId = baseCollId;
    }

    public String getAOpn() {
        return sAOpn;
    }

    public void setAOpn(String opn) {
        sAOpn = opn;
    }

    public String getDOpn() {
        return sDOpn;
    }

    public void setDOpn(String opn) {
        sDOpn = opn;
    }

    public String getSOpn() {
        return sSOpn;
    }

    public void setSOpn(String opn) {
        sSOpn = opn;
    }

    public String getCollId() {
        return sCollId;
    }

    public void setCollId(String collId) {
        sCollId = collId;
    }

    public String getLicenseType() {
        return sLicenseType;
    }

    public void setLicenseType(String licenseType) {
        sLicenseType = licenseType;
    }

    public void setCollLicWFEleId(String param) {

        this.sCollLicWFEleId = param;
    }

    public String getCollLicWFEleId() {

        return this.sCollLicWFEleId;
    }

    public void setADefaultValue(String param) {

        this.sADefaultValue = param;
    }

    public String getADefaultValue() {

        return this.sADefaultValue;
    }

    public void setDDefaultValue(String param) {

        this.sDDefaultValue = param;
    }

    public String getDDefaultValue() {

        return this.sDDefaultValue;
    }

    public void setSDefaultValue(String param) {

        this.sSDefaultValue = param;
    }

    public String getSDefaultValue() {

        return this.sSDefaultValue;
    }

    public void setASystemYn(String param) {

        this.sASystemYn = param;
    }

    public String getASystemYn() {

        return this.sASystemYn;
    }

    public void setDSystemYn(String param) {

        this.sDSystemYn = param;
    }

    public String getDSystemYn() {

        return this.sDSystemYn;
    }

    public void setSSystemYn(String param) {

        this.sSSystemYn = param;
    }

    public String getSSystemYn() {

        return this.sSSystemYn;
    }

    public void setElementId(String param) {

        this.sElementId = param;
    }

    public String getElementId() {

        return this.sElementId;
    }

    public void setElement(String param) {

        this.sElement = param;
    }

    public String getElement() {

        return this.sElement;
    }

    public void setSymbol(String param) {

        this.sSymbol = param;
    }

    public String getSymbol() {

        return this.sSymbol;
    }

    public String getSSymbol() {

        return "s_" + this.sSymbol;
    }

    public String getVSSymbol() {

        return "vs_" + this.sSymbol;
    }

    public void setElementDesc(String param) {

        this.sElementDesc = param;
    }

    public void setElementBrief(String param) {

        this.sElementBrief = param;
    }

    public String getElementDesc() {

        return this.sElementDesc;
    }

    public String getElementBrief() {

        return this.sElementBrief;
    }

    public void setElementName(String param) {

        this.sElementName = param;
    }

    public String getElementName() {

        return this.sElementName;
    }

    public void setADispYn(String param) {

        this.sADispYn = param;
    }

    public String getADispYn() {

        return this.sADispYn;
    }

    public void setDDispYn(String param) {

        this.sDDispYn = param;
    }

    public String getDDispYn() {

        return this.sDDispYn;
    }

    public void setSDispYn(String param) {

        this.sSDispYn = param;
    }

    public String getSDispYn() {

        return this.sSDispYn;
    }

    public String getAInputRule() {
        return sAInputRule;
    }

    public void setAInputRule(String param) {
        sAInputRule = param;
    }

    public String getDInputRule() {
        return sDInputRule;
    }

    public void setDInputRule(String param) {
        sDInputRule = param;
    }

    public String getSInputRule() {
        return sSInputRule;
    }

    public void setSInputRule(String param) {
        sSInputRule = param;
    }

    public String getNameSpace() {
        return sNameSpace;
    }

    /**
     * @param nameSpace The sNameSpace to set.
     */
    public void setNameSpace(String param) {
        sNameSpace = param;
    }

    public String getRgstPerId() {
        return sRgstPerId;
    }

    /**
     * @param rgstPerId The sRgstPerId to set.
     */
    public void setRgstPerId(String param) {
        sRgstPerId = param;
    }

    public String getRgstDt() {
        return sRgstDt;
    }

    /**
     * @param rgstDt The sRgstDt to set.
     */
    public void setRgstDt(String param) {
        sRgstDt = param;
    }

    public String getModPerId() {
        return sModPerId;
    }

    /**
     * @param modPerId The sModPerId to set.
     */
    public void setModPerId(String param) {
        sModPerId = param;
    }

    public String getModDt() {
        return sModDt;
    }

    /**
     * @param modDt The sModDt to set.
     */
    public void setModDt(String param) {
        sModDt = param;
    }
}
