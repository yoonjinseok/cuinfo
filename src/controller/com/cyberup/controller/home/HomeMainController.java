package com.cyberup.controller.home;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;

import com.cyberup.util.HtmlUtils;
import com.cyberup.model.common.HomeMain;
import com.cyberup.model.home.Poup;
import com.cyberup.service.common.HomeMainService;
import com.cyberup.service.univ.UnivService;
import com.cyberup.service.home.PoupService;
import com.cyberup.service.home.PoupSkinService;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;


@Controller
@RequestMapping("/home")
public class HomeMainController {
	
	@Autowired
	private HomeMainService homeMainService;
	@Autowired
	private PoupService poupService;
	@Autowired
	private PoupSkinService poupSkinService;
	
	@RequestMapping("/index")
	public String main(ModelMap model) {

		//mysql 접속 및 쿼리 테스트
		model.addAttribute("adminList", homeMainService.adminList());

		//사이버대학뉴스
		model.addAttribute("newsList",homeMainService.newsList());
		model.addAttribute("noticeList",homeMainService.noticeList());
		model.addAttribute("publicCoureList",homeMainService.publicCoureList());
		
		/*
		//학교소개, 대학별강의, 맛보기강의
		model.addAttribute("univCourseList",homeMainService.univCourseList());
		//학교홍보관
		model.addAttribute("univPublicList",homeMainService.univPublicList());
		
		model.addAttribute("univCourseList_tmp",homeMainService.univCourseList_tmp());
		model.addAttribute("univCourseList_tmp2",homeMainService.univCourseList_tmp2());
		 * */
		
		// 팝업
		poup(model);	
		
		
//		model.addAllAttributes(attributeValues)
		return null;
	}
	
	@RequestMapping("/index2")
	public String main2(ModelMap model) {
		
		//사이버대학뉴스
		model.addAttribute("newsList",homeMainService.newsList());
		model.addAttribute("noticeList",homeMainService.noticeList());
		//model.addAttribute("publicCoureList",homeMainService.publicCoureList());
		model.addAttribute("sampleList",homeMainService.sampleList());
		/*
		//학교소개, 대학별강의, 맛보기강의
		model.addAttribute("univCourseList",homeMainService.univCourseList());
		//학교홍보관
		model.addAttribute("univPublicList",homeMainService.univPublicList());
		
		model.addAttribute("univCourseList_tmp",homeMainService.univCourseList_tmp());
		model.addAttribute("univCourseList_tmp2",homeMainService.univCourseList_tmp2());
		 * */
		
		// 팝업
		poup(model);	
		
		
//		model.addAllAttributes(attributeValues)
		return null;
	}
	
	@RequestMapping("/indexSearch")
	public String indexSearch(HomeMain homeMain,ModelMap model)
	{
		Integer gubn = homeMain.getGubn();
		
		System.out.println("HomeMainController.gubn = " + gubn);
		
		switch (gubn) {
		case 1:
			model.addAttribute("newsList",homeMainService.newsList());
			break;
		case 2:
			model.addAttribute("eventList",homeMainService.eventList());
			break;
		case 3:
			model.addAttribute("conferenceList",homeMainService.conferenceList());
			break;
		case 4:
			model.addAttribute("noticeList",homeMainService.noticeList());
			break;
		default:
			break;
		}
		
		return "/home/common/mainList.vm";
	}
	
	// 팝업
	private String poup(ModelMap model){

		List<Poup> poupList = poupService.selectPoupShowList();
		
		
		for(int i = 0; i< poupList.size(); i++){
			
			try {
				poupList.get(i).setSkinText(poupSkinService.fileString(poupList.get(i).getSkinName()));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				Logger.getLogger(this.getClass()).debug(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				Logger.getLogger(this.getClass()).debug(e.getMessage());
			}
			if(poupList.get(i).getContentTypeId() == 19){
				
				Logger.getLogger(this.getClass()).debug("팝업이미지시작");
				String sbuff = "";
				
				String arrImgUpfileId[] = poupList.get(i).getImgUpfileId().split(",");
				
				Logger.getLogger(this.getClass()).debug("팝업이미지 : " + poupList.get(i).getImgUpfileId());
				
				if(poupList.get(i).getTargetLink() == null)
					poupList.get(i).setTargetLink("");
				
				sbuff = "<a href=\"" + poupList.get(i).getTargetLink() + "\">";
				
				Logger.getLogger(this.getClass()).debug("팝업이미지 : " + arrImgUpfileId.length);
				
				for(int j = 0; j <	arrImgUpfileId.length; j++){
					
					sbuff = sbuff + "<img src=\"/home/refer/board_File_download.json?fileGid="+ poupList.get(i).getImgUpfileGid() +"&fileID="+ arrImgUpfileId[j] +"\" alt=\"poup"+ j +"\" />";
				}
				sbuff = sbuff + "</a>";
				Logger.getLogger(this.getClass()).debug("팝업이미지 : " + sbuff);
				poupList.get(i).setSkinText(poupList.get(i).getSkinText().replace("@TEXT@", sbuff));
				
				Logger.getLogger(this.getClass()).debug("팝업이미지끝");
				
			} else if(poupList.get(i).getContentTypeId() == 20){
				Logger.getLogger(this.getClass()).debug("팝업 텍스트");
				poupList.get(i).setSkinText(poupList.get(i).getSkinText().replace("@TEXT@", HtmlUtils.lineChange(poupList.get(i).getContent())));
			} else {
				Logger.getLogger(this.getClass()).debug("팝업 HTML");
				poupList.get(i).setSkinText(poupList.get(i).getSkinText().replace("@TEXT@", poupList.get(i).getContent()));
			}
			String sbuff = "";
			if(poupList.get(i).getAttachUpfileGid() != 0){
				Logger.getLogger(this.getClass()).debug("팝업 첨부파일 시작 : poupList.get(i).getAttachUpfileId() = " + poupList.get(i).getAttachUpfileId());
				
				
				
				String arrAttachUpfileId[] = poupList.get(i).getAttachUpfileId().split(",");
				String arrAttachUpfileName[] = poupList.get(i).getAttachUpfileName().split(",");
				
				Logger.getLogger(this.getClass()).debug("팝업이미지 id: " + poupList.get(i).getAttachUpfileId());
				Logger.getLogger(this.getClass()).debug("팝업이미지 name: " + poupList.get(i).getAttachUpfileName());
				
				sbuff = "<span class=\"bold\" style=\"vertical-align:bottom;\">첨부파일</span> : ";
				
				
				int startNo = 1;
				for(int j = 0; j <	arrAttachUpfileId.length; j++){

					Logger.getLogger(this.getClass()).debug("arrAttachUpfileId[j] : " + "["+arrAttachUpfileId.length+"]"+arrAttachUpfileId[j]);
					Logger.getLogger(this.getClass()).debug("arrAttachUpfileName[j] : " + "["+arrAttachUpfileName.length+"]"+arrAttachUpfileName[j]);
					
					if(arrAttachUpfileId[j] == null || arrAttachUpfileId[j].equals("")){
						Logger.getLogger(this.getClass()).debug("arrAttachUpfileId[j] is null , j = ["+j+"] continue");
						continue;
					}
					
//					sbuff = sbuff + "<a href=\"/home/refer/board_File_download.json?fileGid="+ poupList.get(i).getAttachUpfileGid() +"&fileID="+ arrAttachUpfileId[j] +"\" alt=\"poup"+ j +"\">" + arrAttachUpfileName[j] + "</a>";
//					sbuff = sbuff + startNo++ + ". <a href='/mgr/common/file_download_id.json?upfileId=" + arrAttachUpfileId[j] + "' alt=\"poup"+ j +"\">" + arrAttachUpfileName[j] + "</a>&nbsp;&nbsp;";
					sbuff = sbuff + "[&nbsp;<a href='/mgr/common/file_download_id.json?upfileId=" + arrAttachUpfileId[j] + "' alt=\"poup"+ j +"\">" + arrAttachUpfileName[j] + "</a>&nbsp;]&nbsp;&nbsp;";
					
				}
			}
			Logger.getLogger(this.getClass()).debug("팝업이미지 : " + sbuff);
			poupList.get(i).setSkinText(poupList.get(i).getSkinText().replace("@ATTACHMENT@", sbuff));
			
			Logger.getLogger(this.getClass()).debug("팝업 첨부파일 끝");
			
			poupList.get(i).setSkinText(poupList.get(i).getSkinText().replace("@poupNum@", Integer.toString(poupList.get(i).getPoupNum())));
			poupList.get(i).setSkinText(poupList.get(i).getSkinText().replace("@title@", poupList.get(i).getTitle()));
		}
		
		model.addAttribute("poupList", poupList);
		
		return null;
	}
	
	@RequestMapping("/etc/location")
	public String location(ModelMap model) {
		return null;
	}
	
	@RequestMapping("/recommendLink")
	public String recommendLink(ModelMap model, String menuId){
		System.out.println("start");
		List list=homeMainService.getRecommendLink(menuId);
		
		System.out.println("list.size = "+list.size());
		
		//추천링크정보 없을경우 표시 되지 않도록 변경
		if(list.size() > 0)
			model.addAttribute("recommendLink", list);
		
		return null;
	}
	
	/**페이스북 RSS 연동
	 * 기존 RssReader 클래스와 별도로 html디코딩을 해야해서 함수 생성
	 * 20150402 LeeJh.
	 * @param model
	 * @param facebookRssUrl
	 * @exception xml 에서 지원하지 않는 unicode 가 포함된 경우가 있음.
	 * 				facebook 에서 rss용 xml 생성시 오류가 있는것으로 판단
	 * 				참고 : 1.http://www.w3.org/TR/2004/REC-xml-20040204/#NT-Char
	 * 					 2.http://insidesearch.tistory.com/6
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/facebookRss")
	@ResponseBody
	public HashMap facebookRss(ModelMap model, Integer universityId) {
		
		HashMap rmap = new HashMap();
		String facebookUrl 	= "";
		String facebookRssUrl = "";
		String logoUpfileGid = "";
		
		try {
			
//			HashMap hmap = homeMainService.getFacebookInfo(universityId);
			HashMap hmap = new HashMap();
			
			if(hmap == null)
				throw new Exception("facebookRss rss is null");
			else
				System.out.println("hmap = " + hmap);
			
			facebookUrl = hmap.get("FACEBOOKURL") == null ? "" : hmap.get("FACEBOOKURL").toString();
			facebookRssUrl = hmap.get("FACEBOOKRSSURL") == null ? "" : hmap.get("FACEBOOKRSSURL").toString();
			logoUpfileGid = hmap.get("LOGOUPFILEGID") == null ? "0" : hmap.get("LOGOUPFILEGID").toString();

			if(facebookUrl.equals("") || facebookRssUrl.equals("") || logoUpfileGid.equals(""))
				throw new Exception("facebookRss result is null");
			
			URL feedUrl = new URL(facebookRssUrl);

			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedUrl));

			List entries = feed.getEntries();

			for (int i = 0; i < entries.size(); i++) {
//				System.out.println("i ==> " + i + " : entries.size() ==> " + entries.size());
				SyndEntry entry = (SyndEntry) entries.get(i);
				
				String fromDate = entry.getPublishedDate().toString();
				String fromDateFormat = "EEE MMM d HH:mm:ss z yyyy";
				String changeFormat = "yyyy/MM/dd HH:mm";
				
				if("Facebook 신디케이션 오류".equals(StringEscapeUtils.unescapeHtml(entry.getTitle()))){
					System.out.println("Facebook 신디케이션 오류...");
					continue;
				}
				
				rmap.put("url", facebookUrl);
				rmap.put("logo", logoUpfileGid);
				rmap.put("title", StringEscapeUtils.unescapeHtml(entry.getTitle()).trim());
				rmap.put("regDt", changeRSSDateFormat(fromDate, fromDateFormat, changeFormat));
				
				if(i >= 0)
					break;
			}
			
		} catch (Exception e) {
			System.out.println("facebook Rss() error..");
			e.printStackTrace();

			rmap.put("url", "");
			rmap.put("logo", "");
			rmap.put("title", "");
			rmap.put("regDt", "");
			
			return rmap;
		}
		
		System.out.println("facebook Rss() end..");
		return rmap;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/facebookRssAll")
	@ResponseBody
	public List facebookRssAll(ModelMap model) {
		List list = null;
		try {
			list = homeMainService.getFacebookInfo();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList();
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/facebookRssInfo")
	@ResponseBody
	public HashMap facebookRssInfo(ModelMap model, String facebookRssUrl) {
		
		//ssl 인증서 만료기간 무시
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };
		
		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
						public boolean verify(String paramString,
								SSLSession paramSSLSession) {
							return true;
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		System.out.println("facebookRssUrl = " + facebookRssUrl);
		
		HashMap rmap = new HashMap();
		try {
			URL feedUrl = new URL(facebookRssUrl);

			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedUrl));

			List entries = feed.getEntries();

			for (int i = 0; i < entries.size(); i++) {
				SyndEntry entry = (SyndEntry) entries.get(i);
				
				String fromDate = entry.getPublishedDate().toString();
				String fromDateFormat = "EEE MMM d HH:mm:ss z yyyy";
				String changeFormat = "yyyy/MM/dd HH:mm";
				
				if("Facebook 신디케이션 오류".equals(StringEscapeUtils.unescapeHtml(entry.getTitle()))){
					System.out.println("Facebook 신디케이션 오류");
					continue;
				}
				
				if(StringEscapeUtils.unescapeHtml(entry.getTitle()) == null || StringEscapeUtils.unescapeHtml(entry.getTitle()).trim().equals("")){
					System.out.println("Facebook null or empty");
					continue;
				}
				
				rmap.put("title", StringEscapeUtils.unescapeHtml(entry.getTitle()).trim());
				rmap.put("regDt", changeRSSDateFormat(fromDate, fromDateFormat, changeFormat));
				
//				System.out.println("SUCC = " + facebookRssUrl);
//				System.out.println("StringEscapeUtils.unescapeHtml(entry.getTitle()) = \n" + StringEscapeUtils.unescapeHtml(entry.getTitle()));
//				System.out.println("StringEscapeUtils.unescapeHtml(entry.getTitle()).trim() = \n" + StringEscapeUtils.unescapeHtml(entry.getTitle()).trim());
				
				if(i >= 0)
					break;
			}
			
		} catch (Exception e) {
			System.out.println("facebookRssUrl ERROR = " + facebookRssUrl);
			e.printStackTrace();
			rmap.put("title", "");
			rmap.put("regDt", "");
			return rmap;
		}
		return rmap;
	}
	
	//페이스북 등록일 변환 함수
	public String changeRSSDateFormat(String fromDate,String fromDateFormat, String changeFormat) {
		String resultDate = "";
		SimpleDateFormat transFormat = new SimpleDateFormat(fromDateFormat ,Locale.ENGLISH);
		
//		System.out.println("fromDate = " + fromDate);
		
		try {
			Date toDate = transFormat.parse(fromDate);
			transFormat = new SimpleDateFormat(changeFormat ,Locale.KOREAN);
			resultDate = transFormat.format(toDate);
			
		} catch (ParseException e) {
			e.printStackTrace(); 
		}
		return resultDate;
	}
	
}
