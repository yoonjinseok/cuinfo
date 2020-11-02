package com.cyberup.model.univ;

import java.util.Date;

import com.cyberup.framework.model.PagingModel;

//페이지 처리를 위해 PagingModel 을 상속한다.
public class Univ extends PagingModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2556243698664510451L;
	
	
	private String videoUpfilePath = "";

	private Integer upfileId0 = 0;
	private Integer entermodel = 0;
	
	public Integer getEntermodel() {
		return entermodel;
	}
	
	public void setEntermodel(Integer entermodel) {
		if(entermodel != null)
			this.entermodel = entermodel;
	}
	
	public Integer getUpfileId0() {
		return upfileId0;
	}
	public void setUpfileId0(Integer upfileId0) {
		if(upfileId0 != null)
			this.upfileId0 = upfileId0;
	}

	
	
	private Integer cnt = 0;
	
	private Integer classifyId = 0;
	private String 	selectYear = "";
	private String 	classifyName = "";
	private String univdeptId = "0";
	private String 	univdeptName = "";
	private Integer deptId = 0;
	private String  deptName = "";
	private String  univName = "";
	
	private String  successLink = "";
	
	private String popularYn="";
	private String recommendYn="";
	
	private String chairman="";
	private String principal="";
	private String supOpen="";
	private String sameCorp="";
	
	private String univgradname="";
	
	
	private String  univSampleLink = "";
	
	private String  gubn1 = "";
	private String  gubn2 = "";
	
	
	
	
	public String getGubn1() {
		return gubn1;
	}

	public void setGubn1(String gubn1) {
		this.gubn1 = gubn1;
	}

	public String getGubn2() {
		return gubn2;
	}

	public void setGubn2(String gubn2) {
		this.gubn2 = gubn2;
	}

	public String getUnivSampleLink() {
		return univSampleLink;
	}

	public void setUnivSampleLink(String univSampleLink) {
		this.univSampleLink = univSampleLink;
	}

	public String getUnivgradname() {
		return univgradname;
	}

	public void setUnivgradname(String univgradname) {
		this.univgradname = univgradname;
	}

	public String getChairman() {
		return chairman;
	}

	public void setChairman(String chairman) {
		this.chairman = chairman;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getSupOpen() {
		return supOpen;
	}

	public void setSupOpen(String supOpen) {
		this.supOpen = supOpen;
	}

	public String getSameCorp() {
		return sameCorp;
	}

	public void setSameCorp(String sameCorp) {
		this.sameCorp = sameCorp;
	}

	public String getSuccessLink() {
		return successLink;
	}
	public void setSuccessLink(String successLink) {
		this.successLink = successLink;
	}
	public String getUnivName() {
		return univName;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}

	private String  successStory = "";
	
	public String getSuccessStory() {
		return successStory;
	}
	public void setSuccessStory(String successStory) {
		this.successStory = successStory;
	}

	private Integer previewGubn = 0;
	
	private Integer location_img_upfileid = 0;
	
	public String getVideoUpfilePath() {
		return videoUpfilePath;
	}
	public void setVideoUpfilePath(String videoUpfilePath) {
		this.videoUpfilePath = videoUpfilePath;
	}


	public Integer getLocation_img_upfileid() {
		return location_img_upfileid;
	}
	public void setLocation_img_upfileid(Integer location_img_upfileid) {
		if(location_img_upfileid != null)
		this.location_img_upfileid = location_img_upfileid;
	}
	public Integer getPreviewGubn() {
		return previewGubn;
	}
	public void setPreviewGubn(Integer previewGubn) {
		if(previewGubn != null)
			this.previewGubn = previewGubn;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	private Integer viewGubn = 0;
	private Integer univ_id = 0;
	private String 	originalFilename_0 = "";
	private String 	srcName_0 = ""; 			
	private Long fileSize_0 = 0L; 		
	private String 	originalFilename_1 = "";
	private String 	srcName_1 = ""; 			
	private Long fileSize_1 = 0L; 		
	private String 	originalFilename_2 = "";
	private String 	srcName_2 = ""; 			
	private Long fileSize_2 = 0L;  		
	private String 	originalFilename_3 = "";
	private String 	srcName_3 = ""; 			
	private Long fileSize_3 = 0L;   	
	private String 	originalFilename_4 = "";
	private String 	srcName_4 = ""; 			
	private Long fileSize_4 = 0L;  	
	private Integer university_id = 0;
	private String  univ_name = "";
	private Integer gubun_id = 0;
	private String  core_slogan = "";
	private String univ_zipcode = "";
	private String  univ_address = "";
	private String  univ_email = "";
	private String  univ_homepage = "";
	private String  univ_phone = "";
	private String  univ_enter_phone = "";
	private String  univ_fax = "";
	private Integer logo_upfile_gid = 0;
	private String  logo_upfile_path = "";
	private Integer video_img_upfile_gid = 0;
	private Integer video_upfile_gid = 0;
	private String  academy_id = "";
	private String  use_yn = "";
	private String  register = "";
	private Date	regDate;
	private String  modifier = "";
	private Date    modDate;
	private Integer local_id = 0;
	private Integer greeting_type_id = 0;
	private String  greeting_content = "";
	private Integer greeting_img_upfile_id = 0;
	private Integer vision_type_id = 0;
	private String  vision_content = "";
	private Integer vision_img_upfile_id = 0;
	private Integer location_type_id = 0;
	private String  location_content = "";
	private Integer location_img_upfile_id = 0;
	private Integer public_type_id = 0;
	private String  public_content = "";
	private Integer public_img_upfile_id = 0;
	private String  show_yn = "";
	private String 	basic_type = "";
	private String 	total_type = "";
	private String 	greeting_type = "";
	private String 	vision_type = "";
	private String 	public_type = "";
	private String 	location_type = "";
	private Integer	linkcnt = 0;
	private String 	dlcnt = "";
	private Integer link_id = 0;
	private Integer link_gubun_id = 0;
	private String 	link_name = "";
	private String 	link_url = "";
	private Integer link_order = 0;
	private String 	deadlink_err_code = "";
	private String 	link_gubun_nm = "";
	private String 	gubunId = "";
	private String 	radio = "";
	private String 	text = "";
	private Integer universityId =0;
	private Integer area_id = 0;
	private String 	university_name = "";
	private String univEmail="";
	
	
	public String getSelectYear() {
		return selectYear;
	}

	public void setSelectYear(String selectYear) {
		this.selectYear = selectYear;
	}

	public Long getFileSize_0() {
		return fileSize_0;
	}

	public void setFileSize_0(Long fileSize_0) {
		if(fileSize_0 != null)
			this.fileSize_0 = fileSize_0;
	}

	public Long getFileSize_1() {
		return fileSize_1;
	}

	public void setFileSize_1(Long fileSize_1) {
		if(fileSize_1 != null)
			this.fileSize_1 = fileSize_1;
	}

	public Long getFileSize_2() {
		return fileSize_2;
	}

	public void setFileSize_2(Long fileSize_2) {
		if(fileSize_2 != null)
			this.fileSize_2 = fileSize_2;
	}

	public Long getFileSize_3() {
		return fileSize_3;
	}

	public void setFileSize_3(Long fileSize_3) {
		if(fileSize_3 != null)
			this.fileSize_3 = fileSize_3;
	}

	public Long getFileSize_4() {
		return fileSize_4;
	}

	public void setFileSize_4(Long fileSize_4) {
		if(fileSize_4 != null)
			this.fileSize_4 = fileSize_4;
	}



	//파일 처리를 위한 변수
	private Integer rn1 = 1;
	private Integer rn2 = 1;
	
	
	
	public Integer getRn2() {
		return rn2;
	}
	public void setRn2(Integer rn2) {
		if(rn2 != null)
			this.rn2 = rn2;
	}
	public Integer getRn1() {
		return rn1;
	}
	public void setRn1(Integer rn1) {
		if(rn1 != null)
			this.rn1 = rn1;
	}


	private Integer upfileGid = 0;
	private String srcFileName = "";
	private String orgFileName = "";
	private String filePath ="";
	private String fileSize = "";
	
	private Integer public_vod_upfile_id2 = 0;
	private Integer img_type_id = 0;
	private Integer img_upfile_gid1 = 0;
	private String img_map_tag1 = "";
	private Integer img_upfile_gid2 = 0;
	private String img_map_tag2 = "";
	private Integer img_upfile_gid3 = 0;
	private String img_map_tag3 = "";
	private Integer img_upfile_gid4 = 0;
	private String img_map_tag4 = "";
	
	private String location_img_upfile_path = "";
	private String public_img_upfile_path = "";
	private String vision_img_upfile_path = "";
	private String greeting_img_upfile_path = "";
	
	private Integer greetingType = 0;
	private Integer visionType = 0;
	private Integer locationType = 0;
	private Integer publicType = 0;
	
	private String[] upfileSrc;
	
	public String[] getUpfileSrc() {
		return upfileSrc;
	}
	public void setUpfileSrc(String[] upfileSrc) {
		this.upfileSrc = upfileSrc;
	}
	
	public Integer getGreetingType() {
		return greetingType;
	}
	public void setGreetingType(Integer greetingType) {
		if(greetingType!=null)
			this.greetingType = greetingType;
	}
	public Integer getVisionType() {
		return visionType;
	}
	public void setVisionType(Integer visionType) {
		if(visionType!=null)
			this.visionType = visionType;
	}
	public Integer getLocationType() {
		return locationType;
	}
	public void setLocationType(Integer locationType) {
		if(locationType!=null)
			this.locationType = locationType;
	}
	public Integer getPublicType() {
		return publicType;
	}
	public void setPublicType(Integer publicType) {
		if(publicType!=null)
			this.publicType = publicType;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		if(deptId != null)
			this.deptId = deptId;
	}
	
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		if(cnt != null)
			this.cnt = cnt;
	}
	public Integer getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(Integer classifyId) {
		if(classifyId != null)
			this.classifyId = classifyId;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	public String getUnivdeptId() {
		return univdeptId;
	}
	public void setUnivdeptId(String univdeptId) {
		if(univdeptId != null)
			this.univdeptId = univdeptId;
	}
	public String getUnivdeptName() {
		return univdeptName;
	}
	public void setUnivdeptName(String univdeptName) {
		this.univdeptName = univdeptName;
	}
	public String getLocation_img_upfile_path() {
		return location_img_upfile_path;
	}
	public void setLocation_img_upfile_path(String location_img_upfile_path) {
		this.location_img_upfile_path = location_img_upfile_path;
	}
	public String getPublic_img_upfile_path() {
		return public_img_upfile_path;
	}
	public void setPublic_img_upfile_path(String public_img_upfile_path) {
		this.public_img_upfile_path = public_img_upfile_path;
	}
	public String getVision_img_upfile_path() {
		return vision_img_upfile_path;
	}
	public void setVision_img_upfile_path(String vision_img_upfile_path) {
		this.vision_img_upfile_path = vision_img_upfile_path;
	}
	public String getGreeting_img_upfile_path() {
		return greeting_img_upfile_path;
	}
	public void setGreeting_img_upfile_path(String greeting_img_upfile_path) {
		this.greeting_img_upfile_path = greeting_img_upfile_path;
	}
	public String getLogo_upfile_path() {
		return logo_upfile_path;
	}
	public void setLogo_upfile_path(String logo_upfile_path) {
		this.logo_upfile_path = logo_upfile_path;
	}
	public Integer getPublic_vod_upfile_id2() {
		return public_vod_upfile_id2;
	}
	public void setPublic_vod_upfile_id2(Integer public_vod_upfile_id2) {
		if(public_vod_upfile_id2!=null)
			this.public_vod_upfile_id2 = public_vod_upfile_id2;
	}
	public Integer getImg_type_id() {
		return img_type_id;
	}
	public void setImg_type_id(Integer img_type_id) {
		if(img_type_id!=null)
			this.img_type_id = img_type_id;
	}
	public Integer getImg_upfile_gid1() {
		return img_upfile_gid1;
	}
	public void setImg_upfile_gid1(Integer img_upfile_gid1) {
		if(img_upfile_gid1!=null)
			this.img_upfile_gid1 = img_upfile_gid1;
	}
	public String getImg_map_tag1() {
		return img_map_tag1;
	}
	public void setImg_map_tag1(String img_map_tag1) {
		this.img_map_tag1 = img_map_tag1;
	}
	public Integer getImg_upfile_gid2() {
		return img_upfile_gid2;
	}
	public void setImg_upfile_gid2(Integer img_upfile_gid2) {
		if(img_upfile_gid2!=null)
			this.img_upfile_gid2 = img_upfile_gid2;
	}
	public String getImg_map_tag2() {
		return img_map_tag2;
	}
	public void setImg_map_tag2(String img_map_tag2) {
		this.img_map_tag2 = img_map_tag2;
	}
	public Integer getImg_upfile_gid3() {
		return img_upfile_gid3;
	}
	public void setImg_upfile_gid3(Integer img_upfile_gid3) {
		if(img_upfile_gid3!=null)
			this.img_upfile_gid3 = img_upfile_gid3;
	}
	public String getImg_map_tag3() {
		return img_map_tag3;
	}
	public void setImg_map_tag3(String img_map_tag3) {
		this.img_map_tag3 = img_map_tag3;
	}
	public Integer getImg_upfile_gid4() {
		return img_upfile_gid4;
	}
	public void setImg_upfile_gid4(Integer img_upfile_gid4) {
		if(img_upfile_gid4!=null)
			this.img_upfile_gid4 = img_upfile_gid4;
	}
	public String getImg_map_tag4() {
		return img_map_tag4;
	}
	public void setImg_map_tag4(String img_map_tag4) {
		this.img_map_tag4 = img_map_tag4;
	}
	public Integer getViewGubn() {
		return viewGubn;
	}
	public void setViewGubn(Integer viewGubn) {
		if(viewGubn != null)
			this.viewGubn = viewGubn;
	}
	
	public Integer getUniv_id() {
		return univ_id;
	}
	public void setUniv_id(Integer univ_id) {
		if(univ_id != null)
			this.univ_id = univ_id;
	}
	
	public String getOriginalFilename_0() {
		return originalFilename_0;
	}
	public void setOriginalFilename_0(String originalFilename_0) {
		this.originalFilename_0 = originalFilename_0;
	}
	public String getSrcName_0() {
		return srcName_0;
	}
	public void setSrcName_0(String srcName_0) {
		this.srcName_0 = srcName_0;
	}
	public String getOriginalFilename_1() {
		return originalFilename_1;
	}
	public void setOriginalFilename_1(String originalFilename_1) {
		this.originalFilename_1 = originalFilename_1;
	}
	public String getSrcName_1() {
		return srcName_1;
	}
	public void setSrcName_1(String srcName_1) {
		this.srcName_1 = srcName_1;
	}
	public String getOriginalFilename_2() {
		return originalFilename_2;
	}
	public void setOriginalFilename_2(String originalFilename_2) {
		this.originalFilename_2 = originalFilename_2;
	}
	public String getSrcName_2() {
		return srcName_2;
	}
	public void setSrcName_2(String srcName_2) {
		this.srcName_2 = srcName_2;
	}
	public String getOriginalFilename_3() {
		return originalFilename_3;
	}
	public void setOriginalFilename_3(String originalFilename_3) {
		this.originalFilename_3 = originalFilename_3;
	}
	public String getSrcName_3() {
		return srcName_3;
	}
	public void setSrcName_3(String srcName_3) {
		this.srcName_3 = srcName_3;
	}
	public String getOriginalFilename_4() {
		return originalFilename_4;
	}
	public void setOriginalFilename_4(String originalFilename_4) {
		this.originalFilename_4 = originalFilename_4;
	}
	public String getSrcName_4() {
		return srcName_4;
	}
	public void setSrcName_4(String srcName_4) {
		this.srcName_4 = srcName_4;
	}
	
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	/* 오성애과장님이 String 으로 구현하여 String 으로 선언함.
	private Integer fileSize = 0;
	
	public Integer getFileSize() {
		return fileSize;
	}
	public void setFileSize(Integer fileSize) {
		if(fileSize != null)
			this.fileSize = fileSize;
	}
	*/
	
	public Integer getUpfileGid() {
		return upfileGid;
	}
	public void setUpfileGid(Integer upfileGid) {
		if(upfileGid != null)
			this.upfileGid = upfileGid;
	}
	public String getSrcFileName() {
		return srcFileName;
	}
	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getUniversity_name() {
		return university_name;
	}
	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}
	public Integer getUniversity_id() {
		return university_id;
	}
	public void setUniversity_id(Integer university_id) {
		if(university_id != null)
			this.university_id = university_id;
	}
	public Integer getGubun_id() {
		return gubun_id;
	}
	public void setGubun_id(Integer gubun_id) {
		if(gubun_id != null)
			this.gubun_id = gubun_id;
	}
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		if(area_id != null)
			this.area_id = area_id;
	}
	public Integer getLocal_id() {
		return local_id;
	}
	public void setLocal_id(Integer local_id) {
		if(local_id != null)
			this.local_id = local_id;
	}
//	public Integer getUniv_zipcode() {
//		return univ_zipcode;
//	}
//	public void setUniv_zipcode(Integer univ_zipcode) {
//		if(univ_zipcode != null)
//			this.univ_zipcode = univ_zipcode;
//	}
	
	public String getCore_slogan() {
		return core_slogan;
	}
	public String getUniv_zipcode() {
		return univ_zipcode;
	}
	public void setUniv_zipcode(String univ_zipcode) {
		this.univ_zipcode = univ_zipcode;
	}
	public void setCore_slogan(String core_slogan) {
		this.core_slogan = core_slogan;
	}
	public String getUniv_address() {
		return univ_address;
	}
	public Integer getVideo_img_upfile_gid() {
		return video_img_upfile_gid;
	}
	public Integer getVideo_upfile_gid() {
		return video_upfile_gid;
	}
	public void setUniv_address(String univ_address) {
		this.univ_address = univ_address;
	}
	public String getUniv_email() {
		return univ_email;
	}
	public void setUniv_email(String univ_email) {
		this.univ_email = univ_email;
	}
	public String getUniv_homepage() {
		return univ_homepage;
	}
	public void setUniv_homepage(String univ_homepage) {
		this.univ_homepage = univ_homepage;
	}
	public String getUniv_phone() {
		return univ_phone;
	}
	public void setUniv_phone(String univ_phone) {
		this.univ_phone = univ_phone;
	}
	public String getUniv_fax() {
		return univ_fax;
	}
	public void setUniv_fax(String univ_fax) {
		this.univ_fax = univ_fax;
	}
	public String getUniv_enter_phone() {
		return univ_enter_phone;
	}
	public void setUniv_enter_phone(String univ_enter_phone) {
		this.univ_enter_phone = univ_enter_phone;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getUniversityId() {
		return universityId;
	}
	public void setUniversityId(Integer universityId) {
			this.universityId = universityId;
	}
	public String getGubunId() {
		return gubunId;
	}
	public void setGubunId(String gubunId) {
		this.gubunId = gubunId;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String getLink_gubun_nm() {
		return link_gubun_nm;
	}

	public void setLink_gubun_nm(String link_gubun_nm) {
		this.link_gubun_nm = link_gubun_nm;
	}

	public String getDlcnt() {
		return dlcnt;
	}

	public Integer getLink_id() {
		return link_id;
	}

	public void setLink_id(Integer link_id) {
		if(link_id != null)
			this.link_id = link_id;
	}

	public Integer getLink_gubun_id() {
		return link_gubun_id;
	}

	public void setLink_gubun_id(Integer link_gubun_id) {
		if(link_gubun_id != null)
			this.link_gubun_id = link_gubun_id;
	}

	public String getLink_name() {
		return link_name;
	}

	public void setLink_name(String link_name) {
		this.link_name = link_name;
	}

	public String getLink_url() {
		return link_url;
	}

	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}

	public Integer getLink_order() {
		return link_order;
	}

	public void setLink_order(Integer link_order) {
		if(link_order != null)
			this.link_order = link_order;
	}

	public String getDeadlink_err_code() {
		return deadlink_err_code;
	}

	public void setDeadlink_err_code(String deadlink_err_code) {
		this.deadlink_err_code = deadlink_err_code;
	}

	public void setDlcnt(String dlcnt) {
		this.dlcnt = dlcnt;
	}

	public Integer getLinkcnt() {
		return linkcnt;
	}

	public void setLinkcnt(Integer linkcnt) {
		this.linkcnt = linkcnt;
	}

	public String getBasic_type() {
		return basic_type;
	}

	public void setBasic_type(String basic_type) {
		this.basic_type = basic_type;
	}

	public String getTotal_type() {
		return total_type;
	}

	public void setTotal_type(String total_type) {
		this.total_type = total_type;
	}

	public String getGreeting_type() {
		return greeting_type;
	}

	public void setGreeting_type(String greeting_type) {
		this.greeting_type = greeting_type;
	}

	public String getVision_type() {
		return vision_type;
	}

	public void setVision_type(String vision_type) {
		this.vision_type = vision_type;
	}

	public String getPublic_type() {
		return public_type;
	}

	public void setPublic_type(String public_type) {
		this.public_type = public_type;
	}

	public String getLocation_type() {
		return location_type;
	}

	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}

	public Integer getGreeting_type_id() {
		return greeting_type_id;
	}

	public void setGreeting_type_id(Integer greeting_type_id) {
		if(greeting_type_id != null)
			this.greeting_type_id = greeting_type_id;
	}

	public String getGreeting_content() {
		return greeting_content;
	}

	public void setGreeting_content(String greeting_content) {
		this.greeting_content = greeting_content;
	}

	public Integer getGreeting_img_upfile_id() {
		return greeting_img_upfile_id;
	}

	public void setGreeting_img_upfile_id(Integer greeting_img_upfile_id) {
		if(greeting_img_upfile_id != null)
			this.greeting_img_upfile_id = greeting_img_upfile_id;
	}

	public Integer getVision_type_id() {
		return vision_type_id;
	}

	public void setVision_type_id(Integer vision_type_id) {
		if(vision_type_id != null)
			this.vision_type_id = vision_type_id;
	}

	public String getVision_content() {
		return vision_content;
	}

	public void setVision_content(String vision_content) {
		this.vision_content = vision_content;
	}

	public Integer getVision_img_upfile_id() {
		return vision_img_upfile_id;
	}

	public void setVision_img_upfile_id(Integer vision_img_upfile_id) {
		if(vision_img_upfile_id != null)
			this.vision_img_upfile_id = vision_img_upfile_id;
	}

	public Integer getLocation_type_id() {
		return location_type_id;
	}

	public void setLocation_type_id(Integer location_type_id) {
		if(location_type_id != null)
			this.location_type_id = location_type_id;
	}

	public String getLocation_content() {
		return location_content;
	}

	public void setLocation_content(String location_content) {
		this.location_content = location_content;
	}

	public Integer getLocation_img_upfile_id() {
		return location_img_upfile_id;
	}

	public void setLocation_img_upfile_id(Integer location_img_upfile_id) {
		if(location_img_upfile_id != null)
			this.location_img_upfile_id = location_img_upfile_id;
	}

	public Integer getPublic_type_id() {
		return public_type_id;
	}

	public void setPublic_type_id(Integer public_type_id) {
		if(public_type_id != null)
			this.public_type_id = public_type_id;
	}

	public String getPublic_content() {
		return public_content;
	}

	public void setPublic_content(String public_content) {
		this.public_content = public_content;
	}

	public Integer getPublic_img_upfile_id() {
		return public_img_upfile_id;
	}

	public void setPublic_img_upfile_id(Integer public_img_upfile_id) {
		if(public_img_upfile_id != null)
			this.public_img_upfile_id = public_img_upfile_id;
	}

	public String getShow_yn() {
		return show_yn;
	}

	public void setShow_yn(String show_yn) {
		this.show_yn = show_yn;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public String getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserDegree() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUniv_name() {
		return univ_name;
	}

	public void setUniv_name(String univ_name) {
		this.univ_name = univ_name;
	}


	public Integer getLogo_upfile_gid() {
		return logo_upfile_gid;
	}

	public void setLogo_upfile_gid(Integer logo_upfile_gid) {
		if(logo_upfile_gid != null)
			this.logo_upfile_gid = logo_upfile_gid;
	}

	public void setVideo_img_upfile_gid(Integer video_img_upfile_gid) {
		if(video_img_upfile_gid != null)
			this.video_img_upfile_gid = video_img_upfile_gid;
	}

	public void setVideo_upfile_gid(Integer video_upfile_gid) {
		if(video_upfile_gid != null)
			this.video_upfile_gid = video_upfile_gid;
	}

	public String getAcademy_id() {
		return academy_id;
	}

	public void setAcademy_id(String academy_id) {
		this.academy_id = academy_id;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	
	//-----------------------------------------------------------------
	// UNIV_OVERALL
	//-----------------------------------------------------------------
	private Integer publicVodUpfileId2 = 0;
	private Integer imgTypeId = 0;
	private String content = "";
	private Integer imgUpfileGid0 = 0;
	private String imgMapTag0 = "";
	private Integer imgUpfileGid1 = 0;
	private String imgMapTag1 = "";
	private Integer imgUpfileGid2 = 0;
	private String imgMapTag2 = "";
	private Integer imgUpfileGid3 = 0;
	private String imgMapTag3 = "";
	private Integer imgUpfileGid4 = 0;
	private String imgMapTag4 = "";
	
	private String showYn = "";

	public Integer getPublicVodUpfileId2() {
		return publicVodUpfileId2;
	}
	public void setPublicVodUpfileId2(Integer publicVodUpfileId2) {
		if(publicVodUpfileId2 != null)
			this.publicVodUpfileId2 = publicVodUpfileId2;
	}
	public Integer getImgTypeId() {
		return imgTypeId;
	}
	public void setImgTypeId(Integer imgTypeId) {
		if(imgTypeId != null)
			this.imgTypeId = imgTypeId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getImgUpfileGid0() {
		return imgUpfileGid0;
	}
	public void setImgUpfileGid0(Integer imgUpfileGid0) {
		if(imgUpfileGid0 != null)
			this.imgUpfileGid0 = imgUpfileGid0;
	}
	public String getImgMapTag0() {
		return imgMapTag0;
	}
	public void setImgMapTag0(String imgMapTag0) {
		this.imgMapTag0 = imgMapTag0;
	}
	public Integer getImgUpfileGid1() {
		return imgUpfileGid1;
	}
	public void setImgUpfileGid1(Integer imgUpfileGid1) {
		if(imgUpfileGid1 != null)
			this.imgUpfileGid1 = imgUpfileGid1;
	}
	public String getImgMapTag1() {
		return imgMapTag1;
	}
	public void setImgMapTag1(String imgMapTag1) {
		this.imgMapTag1 = imgMapTag1;
	}
	public Integer getImgUpfileGid2() {
		return imgUpfileGid2;
	}
	public void setImgUpfileGid2(Integer imgUpfileGid2) {
		if(imgUpfileGid2 != null)
			this.imgUpfileGid2 = imgUpfileGid2;
	}
	public String getImgMapTag2() {
		return imgMapTag2;
	}
	public void setImgMapTag2(String imgMapTag2) {
		this.imgMapTag2 = imgMapTag2;
	}
	public Integer getImgUpfileGid3() {
		return imgUpfileGid3;
	}
	public void setImgUpfileGid3(Integer imgUpfileGid3) {
		if(imgUpfileGid3 != null)
			this.imgUpfileGid3 = imgUpfileGid3;
	}
	public String getImgMapTag3() {
		return imgMapTag3;
	}
	public void setImgMapTag3(String imgMapTag3) {
		this.imgMapTag3 = imgMapTag3;
	}
	
	public Integer getImgUpfileGid4() {
		return imgUpfileGid4;
	}
	public void setImgUpfileGid4(Integer imgUpfileGid4) {
		if(imgUpfileGid4 != null)
			this.imgUpfileGid4 = imgUpfileGid4;
	}
	public String getImgMapTag4() {
		return imgMapTag4;
	}
	public void setImgMapTag4(String imgMapTag4) {
		if(imgMapTag4 != null)
			this.imgMapTag4 = imgMapTag4;
	}
	public String getShowYn() {
		return showYn;
	}
	public void setShowYn(String showYn) {
		this.showYn = showYn;
	}
	
	//==============================
	/*2011-11 김현철
	모집요강 추가
	*/
	private String newcome;	//신입학
	private String transfer;		//편입학
	private String timecome; 	//시간제등록

	public String getNewcome() {
		return newcome;
	}
	public void setNewcome(String newcome) {
		this.newcome = newcome;
	}
	public String getTransfer() {
		return transfer;
	}
	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}
	public String getTimecome() {
		return timecome;
	}
	public void setTimecome(String timecome) {
		this.timecome = timecome;
	}
	
	//==========================
	
	// 대학특징 추가
	private String univFeature = "";

	public String getUnivFeature() {
		return univFeature;
	}
	public void setUnivFeature(String univFeature) {
		this.univFeature = univFeature;
	}
	
	private String localName = "";
	private String gubunName = "";

	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getGubunName() {
		return gubunName;
	}
	public void setGubunName(String gubunName) {
		this.gubunName = gubunName;
	}
	public String getPopularYn() {
		return popularYn;
	}
	public void setPopularYn(String popularYn) {
		this.popularYn = popularYn;
	}
	public String getRecommendYn() {
		return recommendYn;
	}
	public void setRecommendYn(String recommendYn) {
		this.recommendYn = recommendYn;
	}
	public String getUnivEmail() {
		return univEmail;
	}
	public void setUnivEmail(String univEmail) {
		this.univEmail = univEmail;
	}
	
}
