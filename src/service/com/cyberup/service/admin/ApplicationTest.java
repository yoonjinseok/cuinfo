package com.cyberup.service.admin;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cyberup.framework.conf.SiteConfiguration;

public class ApplicationTest {
	
	public static void main(String[] args) {
		String webroot = "F:/iKEP4.00/workspace/IKEP/WebContent/";
		String confFolder = webroot + "WEB-INF/classes/spring/";
		String serviceFolder = webroot + "WEB-INF/classes/sqlmap/config/";
		String servlet = webroot + "WEB-INF/ikep-context-servlet.xml";
		
		PropertyConfigurator.configure(webroot + "WEB-INF/classes/spring/log4j_app.properties");
		
		Logger.getLogger(ApplicationTest.class).debug("ready.");
		
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[]{confFolder + "*.xml", servlet}
				);
		
		String[] names = ctx.getBeanDefinitionNames();
		for(int i = 0; i < names.length; i++)
		{
			System.out.println(names[i]);
		}
		
		SiteConfiguration siteConfiguration = ctx.getBean(SiteConfiguration.class);
		System.out.println(siteConfiguration.getFilePath());
		
		/*
		AopTest aopTest = (AopTest)ctx.getBean("aopTestImpl");
		aopTest.abs();
		*/
		
		/*ComCodeService comCodeService = (ComCodeService)ctx.getBean("comCodeServiceImpl");
		CodeVo codeVo = comCodeService.selectInfo(1);
		codeVo.setCodeDesc("메시지코드ㄴ");
		comCodeService.selectInfo(codeVo);*/
		
		/*
		ComCodeService comCodeService = ctx.getBean(ComCodeService.class);
		System.out.println("1 item : " + comCodeService.deleteInfo(1));
		/*
		
		/*
		Map param = new HashMap();
		param.put("id", "2");
		param.put("ids", new String[]{"2","3","4"});
		
		String sql = memberDao.getSql("MemberDAO.selectInfo", param);
		System.out.println(sql);
		*/
		
		/*
		Member member = memberDao.get(2);
		System.out.println("member : " + member);
		
		Group group = new Group();
		group.setId(5);
		group.setName("sfds");
		
		member.setLogins(10);
		member.setGroup(group);
		memberDao.update(member);
		*/
		
		/*
		Member member = memberDao.get(2);
		System.out.println("member : " + member);
		
		Group group = new Group();
		group.setId(3);
		group.setName("sfds");
		
		member.setGroup(group);
		
		memberDao.update(member);
		
		*/
		
		/*
		MemberService memberService = ctx.getBean(MemberService.class);
		memberService.deletes(member);
		*/
	}
}
