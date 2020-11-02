package com.cyberup.controller.home.intro;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyberup.framework.conf.SiteConfiguration;
import com.cyberup.framework.controller.MailSender;
import com.cyberup.framework.model.LoginInfo;
import com.cyberup.framework.model.PagingModel;
import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.model.refer.ServiceGuide;
import com.cyberup.model.univ.SendMail;
import com.cyberup.model.univ.Univ;
import com.cyberup.service.refer.ServiceGuideService;
import com.cyberup.service.univ.UnivService;
import com.ibm.icu.text.SimpleDateFormat;



@Controller
@RequestMapping("/home/intro")
public class ServiceGuideController {
	@Autowired
	private SiteConfiguration siteConfiguration;
	@Autowired
	private ServiceGuideService serviceGuideService;
	@Autowired
	private UnivService univService;
	@Autowired
	private MailSender mailSender;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;
	@Inject
	private Provider<SessionUploadConfig> sessionUploadConfig;
	
	@RequestMapping("/serviceGuide")
	public String serviceGuide(ServiceGuide serviceGuide, ModelMap modelMap) {
		modelMap.addAttribute("param",serviceGuide);
		List<ServiceGuide> questionList=serviceGuideService.selectQuestionInfo(serviceGuide);
		modelMap.addAttribute("questionList", questionList);
		
		return null;
	}
	
	@RequestMapping("/serviceGuide2")
	public String serviceGuide2(ServiceGuide serviceGuide, ModelMap modelMap) {
		modelMap.addAttribute("param",serviceGuide);
		
		List<ServiceGuide> answerList=serviceGuideService.selectAnswerGuideList(serviceGuide.getGuideNo());
		modelMap.addAttribute("answerList", answerList);
		return null;
	}
	
	@RequestMapping("/serviceGuideEnd")
	public String serviceGuideEnd(ServiceGuide serviceGuide,ModelMap model) {
		model.addAttribute("param",serviceGuide);
		
		model.addAttribute("selectStep1",serviceGuide.getSelectStep1());
		model.addAttribute("answer",serviceGuideService.selectQuestionEnd(serviceGuide));
		
		return null;
	}
	
	
	
	
	
	
	@RequestMapping("/serviceQuestion")
	public String overall(Univ univ,ModelMap model) {
		univ.setShowCnt(999);
		model.addAttribute("univList",univService.selectUnivInfoList(univ));
		
		if(univ.getUniversity_id() != 0)
			model.addAttribute("university_id",univ.getUniversity_id());
		/*
		 * KERIS 담당자 이메일 가져오기
		 */
		model.addAttribute("kerisEmail",univService.selectKerisEmail());
		
		return null;
	}
	
	@RequestMapping("/serviceQuestion_List")
	public String overallUnivList(Univ univ,ModelMap model) {
		univ.setShowCnt(999);
		model.addAttribute("univList",univService.selectUnivInfoList(univ));
		
		return null;
	}
	
	@RequestMapping("/serviceQuestion_sendMail")
	public String sendMail(String kerisEmail, SendMail sendParam, ModelMap model) {
		String univEmail=sendParam.getUnivEmail()+","+kerisEmail;
		String[] toAddr = StringUtils.split(univEmail, ",");
		
		System.out.println("toAddr11: "+toAddr);
		System.out.println("toAddr11: "+toAddr);
		//toAddr=null;
		System.out.println("toAddr22: "+toAddr);
		System.out.println("toAddr22: "+toAddr);
		//SiteConfig.xml - managerEmail(KERIS 담당자 이메일)
		
		//testTo=testTo.replaceAll(",", ";");
		//InternetAddress[] To={new InternetAddress(testTo)};
		
		Logger logger = Logger.getLogger(this.getClass());
		
		//MimeMessage message=mailSender.createMimeMessage();
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper=new MimeMessageHelper(mimeMessage,true,"euc-kr");
			msgHelper.setSubject(sendParam.getTitle()); //제목
   			//String htmlContent="<h2 style='color:red;'>메.일.발.송.테.스.트</h2>";
			msgHelper.setText(sendParam.getContent(), true);//true-->html //내용
			msgHelper.setFrom(sendParam.getFromAddr(),sendParam.getWriter()); //보내는 사람
			msgHelper.setTo(toAddr); //받는 사람
			//mimeMessage.setRecipients(MimeMessage.RecipientType.TO, testTo);
			
			//message.setSubject("메.일.발.송.테.스.트", "euc-kr"); //제목
			//String htmlContent="<h2 style='color:red;'>메.일.발.송.테.스.트</h2>";
			//message.setText(htmlContent, "euc-kr", "html");//true-->html //내용
			//message.setFrom(new InternetAddress("1234567890@abc.com","테스터"));
			//message.addRecipients(RecipientType.TO, testTo);
			
			
   			logger.debug(mailSender);
   			logger.debug(mailSender.getJavaMailSender());

   			mailSender.getJavaMailSender().send(mimeMessage);
   			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		System.out.println("제목"+sendParam.getTitle());
		System.out.println("작성자"+sendParam.getWriter());
		System.out.println("내용"+sendParam.getContent());
		System.out.println("보내는 사람"+sendParam.getFromAddr());
		System.out.println("받는 사람1"+univEmail);
		System.out.println("받는 사람2"+toAddr);

		/*String univEmail="ksa120721@naver.com"+","+"ksa1207@kotech.co.kr";
		String[] toAddr = StringUtils.split(univEmail, ",");

		//System.out.println("toAddr11: "+toAddr);
		//System.out.println("toAddr11: "+toAddr);
		//toAddr=null;
		//System.out.println("toAddr22: "+toAddr);
		//System.out.println("toAddr22: "+toAddr);
		//SiteConfig.xml - managerEmail(KERIS 담당자 이메일)

		//testTo=testTo.replaceAll(",", ";");
		//InternetAddress[] To={new InternetAddress(testTo)};

		Logger logger = Logger.getLogger(this.getClass());

		//MimeMessage message=mailSender.createMimeMessage();
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper=new MimeMessageHelper(mimeMessage,true,"euc-kr");
			msgHelper.setSubject(sendParam.getTitle()); //제목
			//String htmlContent="<h2 style='color:red;'>메.일.발.송.테.스.트</h2>";
			msgHelper.setText(sendParam.getContent(), true);//true-->html //내용
			msgHelper.setFrom(sendParam.getFromAddr(),sendParam.getWriter()); //보내는 사람
			msgHelper.setTo(toAddr); //받는 사람
			//mimeMessage.setRecipients(MimeMessage.RecipientType.TO, testTo);

			//message.setSubject("메.일.발.송.테.스.트", "euc-kr"); //제목
			//String htmlContent="<h2 style='color:red;'>메.일.발.송.테.스.트</h2>";
			//message.setText(htmlContent, "euc-kr", "html");//true-->html //내용
			//message.setFrom(new InternetAddress("1234567890@abc.com","테스터"));
			//message.addRecipients(RecipientType.TO, testTo);


			logger.debug(mailSender);
			logger.debug(mailSender.getJavaMailSender());

			mailSender.getJavaMailSender().send(mimeMessage);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		System.out.println("제목"+sendParam.getTitle());
		System.out.println("작성자"+sendParam.getWriter());
		System.out.println("내용"+sendParam.getContent());
		System.out.println("보내는 사람"+sendParam.getFromAddr());
		System.out.println("받는 사람1"+univEmail);
		System.out.println("받는 사람2"+toAddr);*/
		
		return null;
	}

	@RequestMapping("/serviceQuestion_sendMail2")
	public String serviceQuestion_sendMail2(String kerisEmail, SendMail sendParam, ModelMap model) {
		//String univEmail=sendParam.getUnivEmail()+","+kerisEmail;
		String toAddr = "exrt1@hanmail.net";

		//toAddr=null;

		//SiteConfig.xml - managerEmail(KERIS 담당자 이메일)

		//testTo=testTo.replaceAll(",", ";");
		//InternetAddress[] To={new InternetAddress(testTo)};

		Logger logger = Logger.getLogger(this.getClass());

		//MimeMessage message=mailSender.createMimeMessage();
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper=new MimeMessageHelper(mimeMessage,true,"euc-kr");
			msgHelper.setSubject(sendParam.getTitle()); //제목
			//String htmlContent="<h2 style='color:red;'>메.일.발.송.테.스.트</h2>";
			msgHelper.setText(sendParam.getContent(), true);//true-->html //내용
			msgHelper.setFrom(sendParam.getFromAddr(),sendParam.getWriter()); //보내는 사람
			msgHelper.setTo(toAddr); //받는 사람
			//mimeMessage.setRecipients(MimeMessage.RecipientType.TO, testTo);

			//message.setSubject("메.일.발.송.테.스.트", "euc-kr"); //제목
			//String htmlContent="<h2 style='color:red;'>메.일.발.송.테.스.트</h2>";
			//message.setText(htmlContent, "euc-kr", "html");//true-->html //내용
			//message.setFrom(new InternetAddress("1234567890@abc.com","테스터"));
			//message.addRecipients(RecipientType.TO, testTo);


			logger.debug(mailSender);
			logger.debug(mailSender.getJavaMailSender());

			mailSender.getJavaMailSender().send(mimeMessage);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		System.out.println("제목"+sendParam.getTitle());
		System.out.println("작성자"+sendParam.getWriter());
		System.out.println("내용"+sendParam.getContent());
		System.out.println("보내는 사람"+sendParam.getFromAddr());
		//System.out.println("받는 사람1"+univEmail);
		System.out.println("받는 사람2"+toAddr);

		return null;
	}

	
}