package com.cyberup.framework.model;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.Joinpoint;
import org.apache.commons.net.nntp.Article;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.weaver.JoinPointSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.cyberup.model.course.CourseSearch;
import com.cyberup.service.home.FileUploadService;
import com.ibm.icu.text.ChineseDateFormat.Field;

public class ModelCheck {
	@Autowired
	FileUploadService fileUploadService; 
	
	public void modelCheck(JoinPoint joinPoint) throws Exception{
		/****************************************************************************
		 * 보안취약점 전체로직
		 * 1.joinPoint 로부터 호출 컨트롤러의 path 를 구한다.
		 * 2.path 에서 home(사용자), mgr(관리자)를 구분하여 보안취약점관련 파라미터 검증을 한다.
		 ****************************************************************************/
		String controllerPath = joinPoint.toString();
		String chkStr = "";
		Logger.getLogger(this.getClass()).debug("modelCheck controllerPath : " + controllerPath);
		
		if(controllerPath.indexOf("controller.home")>=0){
			
			//사용자화면의 메일발송시에는 이메일주소 및 내용에 특수문자를 사용할 경우가 있으므로 예외처리한다.
			if(joinPoint.toString().indexOf(".sendMail")>=0 || joinPoint.toString().indexOf(".facebook")>=0)
				return;
			
			Object[] args = joinPoint.getArgs();
			
			for (int i = 0; i < args.length; i++) {
				if(args[i] != null){
					/****************************************************************************
					 *파라미터가 null 이 아닐경우 type 별로 처리한다.
					 *model의 경우 \n 으로 split, = 으로 split 하여 변수값을 확인한다.
					 *String, Integer 의 경우 바로 변수값을 확인한다.
					 ****************************************************************************/
					//허용할 문자 패턴(정규표현식)
					String pattern = "^[a-zA-Z0-9ㄱ-ㅎ가-힣.]*$";
					
					//파라미터가 bean 객체일경우
					if(args[i].getClass().getName().indexOf(".model.")>=0){
						String[] params = args[i].toString().split("\n");
						
						for (int j = 0; j < params.length; j++) {
							chkStr = params[j];
							
							//자주사용되는 특수문자는 예외처리한다(제거).
							chkStr = chkStr.replace("{", "")
									.replace("}", "")
									.replace("=", "")
									.replace("[", "")
									.replace("]", "")
									.replace("_", "")
									.replace("-", "")
									.replace(",", "")
									.replace("(", "")
									.replace(")", "")
									.replace("·", "")
									.replace(" ", "").trim();
							
							if(
								chkStr == null || 
								chkStr.equals("") || 
								chkStr.indexOf(".model.")>=0 || 
								chkStr.indexOf("<null>")>=0 || 
								chkStr.indexOf("java.lang.String;")>=0 || 
								chkStr.indexOf(".validation.")>=0 || 
								chkStr.indexOf(".connector.")>=0 || 
								chkStr.indexOf(".log4j.")>=0 || 
								chkStr.indexOf("jeus")>=0 || 
								chkStr.equals("]")
							){
								System.out.println("home paramCheck1 continue");
								continue;
							}
							
							/*
							if(!chkStr.trim().matches(pattern)){
								Logger.getLogger(this.getClass()).debug("home paramError1 : " + chkStr + "["+chkStr.length()+"]");
								throw new Exception("paramError");
							}
							 */
							
							if(chkStr.indexOf("'")>=0 || chkStr.indexOf("<")>=0 || chkStr.indexOf(">")>=0){
								Logger.getLogger(this.getClass()).debug("mgr paramError1 : " + chkStr + "["+chkStr.length()+"]");
								throw new Exception("paramError");
							}
						}
					}
					//파라미터가 primitive 형일 경우
					else if(args[i].getClass().getName().indexOf("java.lang.String")>-1){
						if((!args[i].toString().matches(pattern))){
							if(fileUploadService.selectUploadCount(args[i].toString())==0){
								
								if(args[i].toString().indexOf(",")>0)
									continue;
								
								Logger.getLogger(this.getClass()).debug("home paramError2 : " + args[i].getClass() + ":" + args[i]);
								throw new Exception("paramError");
							}
						}
					}
					//그 외의 경우
					else{
//						Logger.getLogger(this.getClass()).debug("paramSkip : " + args[i].getClass() + ":" + args[i]);
						continue;
					}
					
				}
			}
		}
		//관리자
		else if(controllerPath.indexOf(".mgr")>=0){
			Object[] args = joinPoint.getArgs();
			
			for (int i = 0; i < args.length; i++) {
				if(args[i] != null){
					/****************************************************************************
					 *파라미터가 null 이 아닐경우 type 별로 처리한다.
					 *model의 경우 \n 으로 split, = 으로 split 하여 변수값을 확인한다.
					 *String, Integer 의 경우 바로 변수값을 확인한다.
					 ****************************************************************************/
					//허용할 문자 패턴(정규표현식)
					
					//파라미터가 bean 객체일경우
					if(args[i].getClass().getName().indexOf(".model.")>=0){
						String[] params = args[i].toString().split("\n");
						
						for (int j = 0; j < params.length; j++) {
							chkStr = params[j];
							
							//관리자는 특정문자에서만 예외를 발생한다.
							chkStr = chkStr.trim();
							
							//관리자에서 사용가능한 특수문자는 치환한다.
							chkStr = chkStr.replace("&nbsp;", "");
							
							if(chkStr.indexOf("'")>=0){
								Logger.getLogger(this.getClass()).debug("mgr paramError1 : " + chkStr + "["+chkStr.length()+"]");
								throw new Exception("paramError");
							}
						}
					}
					//파라미터가 primitive 형일 경우
					else if(args[i].getClass().getName().indexOf("java.lang.String") > -1){
						if(chkStr.indexOf("'")>=0){
							if(fileUploadService.selectUploadCount(args[i].toString()) == 0){
								Logger.getLogger(this.getClass()).debug("mgr paramError2 : " + chkStr.getClass() + ":" + chkStr);
								throw new Exception("paramError");
							}
						}
					}
					//그 외의 경우
					else{
						Logger.getLogger(this.getClass()).debug("mgr paramSkip : " + chkStr + ":" + chkStr);
						continue;
					}
				}
			}
		}
	}
	
	public static void main(String[] ar){
//		String pattern = "^[a-zA-Z0-9ㄱ-ㅎ가-힣.@=()<>]*$";
//		System.out.println("redukyo@naver.com<;".matches(pattern));
		try {
			System.out.println(URLDecoder.decode("%22%27%3E%3CIMG+SRC%3D%22%2FWF_XSRF.html%22%3E","utf-8"));
			System.out.println(URLDecoder.decode("152%27%3B","utf-8"));
			System.out.println(URLDecoder.decode("","utf-8"));
			System.out.println(URLDecoder.decode("","utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
