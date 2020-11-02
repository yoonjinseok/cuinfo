package com.cyberup.dao.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.common.DeadLinkCheckModel;

@Repository
public class DeadLinkCheckDao extends BaseDAO {
	
	public String CONNECT_TIME_OUT	= null;
	public String READ_TIME_OUT		= null;
	
	
	public List<DeadLinkCheckModel> deadLinkCheckListForUser(Integer university_id){
		
		return queryForList("DeadLinkCheckDao.deadLinkCheckListForUser",university_id);
		
	}
	
	public List<DeadLinkCheckModel> deadLinkCheckList(){
		
		return queryForList("DeadLinkCheckDao.deadLinkCheckList");
		
	}
	
	public void updateUnivLinkInfo(int linkId,int errCode){
		
		HashMap map = new HashMap();
		
		map.put("linkId", linkId);
		map.put("errCode", errCode);
		
		update("DeadLinkCheckDao.updateUnivLinkInfo", map);
	}
	
	
	public String deadLinkCheck(String url)
	{
		return "";
	}
	
	public String encodingPath(String urlPath) {
		String[] array = urlPath.split("/");
		urlPath = "";
		for (int i = 0; i < array.length; i++) {
			try {			
				String tmpStr = URLEncoder.encode(array[i], "euc-kr");

				if(array[i].indexOf(" ") >= 0 )
					tmpStr = tmpStr.replaceAll("\\+", "%20");			
				urlPath = urlPath + tmpStr + "/";
				
			} catch (UnsupportedEncodingException  e) {
				e.printStackTrace();
			} 
		}		
		urlPath = urlPath.substring(0, urlPath.length() - 1);
		
		return urlPath;
	}
	
	public int isValid(String urlPath, String timeOut){
		
		int flg = 0; 
		
		if ( urlPath != null && urlPath.length() > 0 ){
			
			try{
				//타임아웃 설정
				setTimeOut(timeOut);
				
				System.out.println("timeOuting...");
				
				//mms = 미디어 서버는 return yes
				if ( urlPath.toLowerCase().indexOf("mms://") >= 0 )
				{
					flg = mmsConnectTest(urlPath);
				}
				else
				{
					flg = httpConnectTest(urlPath);
				}
				
			}
			catch (Exception e) {
//				flg = DeadlinkCheckHistory.VALID_NO;
			}
			finally{
				initTimeOut();
			}
		}
		
		return flg;
	}
	
	
	private int httpConnectTest(String urlPath){
		
		URL url;
		int url_ret = 0;
		
		try {
			url = new URL( addHttpString( urlPath ) );
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			
			//데드 링크 체크
			url_ret = urlConn.getResponseCode();
			
			if ( url_ret != HttpURLConnection.HTTP_OK ){
				
				// Http 접속을 종료한다.
				urlConn.disconnect();
				//URL 스트링 중 한글이 존재할 수 있으므로, 한글을 euc-kr로 인코딩한다.
				String filePath = url.getFile();
				filePath = filePath.substring(1);
				filePath = encodingPath(filePath);
				
				String hostURL;
				if(url.getPort() > 80 )
					hostURL = url.getProtocol() + "://" + url.getHost() + ":" + url.getPort();
				else
					hostURL = url.getProtocol() + "://" + url.getHost();
				
				hostURL = hostURL + "/" + filePath;
				
				url = new URL( hostURL );
				urlConn = (HttpURLConnection) url.openConnection();
				
			}
			
			// Http 접속을 종료한다.
			urlConn.disconnect();
			
		} catch (UnknownHostException e) {
			//UnknownHostException = 999
			return 999;
		} catch (MalformedURLException e) {
			//MalformedURLException = 998
			e.printStackTrace();
			return 998;
		} catch (IOException e) {
			//IOException = 997
			e.printStackTrace();
			return 997;
		}
		 
		return url_ret;
	}
	
	
	private int mmsConnectTest(String urlPath){
		return 0;//DeadlinkCheckHistory.VALID_YES;
	}
	
	
	private void setTimeOut(String timeOut){
		CONNECT_TIME_OUT	= System.getProperty("sun.net.client.defaultConnectTimeout");
		READ_TIME_OUT		= System.getProperty("sun.net.client.defaultReadTimeout");
		
		System.setProperty("sun.net.client.defaultConnectTimeout",	timeOut);
		System.setProperty("sun.net.client.defaultReadTimeout", 	timeOut);
	}
	
	
	private void initTimeOut(){
		if (CONNECT_TIME_OUT == null || CONNECT_TIME_OUT.length() ==0 )
			System.setProperty("sun.net.client.defaultConnectTimeout",	"");
		else
			System.setProperty("sun.net.client.defaultConnectTimeout",	CONNECT_TIME_OUT);
		
		if (READ_TIME_OUT == null || READ_TIME_OUT.length() ==0 )
			System.setProperty("sun.net.client.defaultReadTimeout",	"");
		else
			System.setProperty("sun.net.client.defaultReadTimeout",	READ_TIME_OUT);
	}
	
	
	private String addHttpString( String url ){
		
		if (url.length() > 0){
			if ( url.toLowerCase().indexOf("http://") != 0 ){
				url = "http://" + url;
			}
		}
		 
		return url;
	}
}
