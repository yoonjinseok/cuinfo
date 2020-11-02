package com.cyberup.framework.interceptor;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.cyberup.framework.model.SessionUploadConfig;
import com.cyberup.framework.model.SessionUploadProgress;
@Component
public class AjaxProgressListener implements ProgressListener {
	@Inject
	private Provider<SessionUploadProgress> sessionUploadProgress;
	
	public void update(long pBytesRead, long pContentLength, int pItems){
		//Logger.getLogger(this.getClass()).debug("update : " + pBytesRead + ", " + pContentLength + ", " + pItems);
		
		int percent = (int)(((float)pBytesRead/pContentLength)*100);
		sessionUploadProgress.get().setPercent(percent);
		
		sessionUploadProgress.get().setTotalSize(pContentLength);
		sessionUploadProgress.get().setCurrentSize(pBytesRead);
		sessionUploadProgress.get().setItem(pItems);
		//Logger.getLogger(this.getClass()).debug("percent : " + percent);
		
		if (pBytesRead == pContentLength){
			Logger.getLogger(this.getClass()).debug("upload success.");
		}
	}
	
	public static void main(String[] args) {
		System.out.println((int)(((float)152066/152066)*100));
	}
}
