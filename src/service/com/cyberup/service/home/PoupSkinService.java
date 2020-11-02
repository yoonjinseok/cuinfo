package com.cyberup.service.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.framework.conf.SiteConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


@Service
@Transactional
public class PoupSkinService {
	@Autowired
	private SiteConfiguration siteConfiguration;
	
//	파일 스트림 읽기 
	public String fileString(String fileName) throws IOException, FileNotFoundException{
		String fileDir =siteConfiguration.getWebContentPath()+ "home/poup";
		
		FileReader readFile = null;
		String fileString = "";
		
		if(!fileName.equals("")){
			readFile = new FileReader(fileDir+"/"+fileName); //FileReader 객체를 readFile이라는 이름으로 생성하고 MyFile에 적어준 파일을 생성한 객체에 넣는다.
			
			do {
				int tempChar = readFile.read();
				
				if (tempChar == -1) //파일 끝에 도달하면 -1을 리턴하기 때문
				break;
				
				fileString = fileString + (char)tempChar;
			} while(true);
		}
		
		fileString = fileString.replace("@CHKCLOSETEXT@", "오늘하루동안 보지않기");
		fileString = fileString.replace("@RootPath@", siteConfiguration.getWebContentPath());
		return fileString;
	}
	
}
