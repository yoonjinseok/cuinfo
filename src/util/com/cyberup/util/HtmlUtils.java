package com.cyberup.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtils {
	public static String lineChange(String str){

		if(str == null)
			return "";
		
		if(str.equals(""))
			return "";
		
		String contentBr = str;
		contentBr  = contentBr.replaceAll("\r\n","<br>");
		contentBr  = contentBr.replaceAll("\r","<br>");
		contentBr  = contentBr.replaceAll("\n","<br>");

		return contentBr;
	} 
	
	public static String substring(String src, int max, String pad)
	{
		if(src != null)
		{
			if(src.length() > max)
			{
				return src.substring(0, max) + pad;
			}
			else 
				return src;
		}
		else
			return null;
	}
	
	public static String substringByByte(String src, int maxByte, String pad)
	{
		if(src != null)
		{
			if(src.getBytes().length > maxByte)
			{
				String temp = null;
				for(int i = 0; i < src.length(); i++)
				{
					temp = src.substring(0, i+1);
					if(temp.getBytes().length > maxByte)
						return temp.substring(0, temp.length()-1) + pad;
				}
				
				return src;
			}
			else 
				return src;
		}
		else
			return null;
	}
	
	public static void main(String[] args) {
		System.out.println(substringByByte("6주차 공동소유 및용익물권-6주차 학습하기", 57, "..."));
	}
	
	//입력 박스 html 태그 제한.  잘못된 태그를 넣었을 경우  false 반환
	public static boolean isValidHtmlTag(String Content) {
		
		//제한 html 문자
		String htmlTag = "<html,</html,<meta, <link,<head,</head,<body,</body,<form,</form,<script,</script,<style,</style,script:,cookie,document.";
		String [] tag = htmlTag.split(",");

		boolean retValue = true;	
		int i = 0 ;
		
		String strContent = Content.toLowerCase();

		for(i=0;i<tag.length;i++){
			if(strContent.indexOf(tag[i].trim())> -1){				
				retValue = false;
				break;
			}			
		}
		return retValue;
	}
	
	public static boolean containKorean(String val)
	{
		Pattern pattern = Pattern.compile(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*");
		Matcher matcher = pattern.matcher(val);
		return matcher.matches();
	}
	
}
