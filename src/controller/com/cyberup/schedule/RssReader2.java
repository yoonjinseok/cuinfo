package com.cyberup.schedule;

import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.Document;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/*
 * 페이스북 연동을 위한 RssReader 개발중.
 * 페이스북은 html 인코딩이 되어있으므로 변환 해야함.
 * */

public class RssReader2 {

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) {
		
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
		
		Integer duplicatCnt = 0;
		// TODO Auto-generated method stub
		System.out.println("facebook() start..\n");

		try {
//			String url = "https://www.facebook.com/feeds/page.php?format=rss20&id=163689290352537";
//			String url = "https://www.facebook.com/feeds/page.php?format=rss20&id=139177689433288";
			String url = "https://173.252.120.6/feeds/page.php?format=rss20&id=139177689433288";
			
//			String url = "https://www.facebook.com/feeds/page.php?format=rss20&id=148851721869059";
			// org.w3c.dom
			Document document = null;

			URL feedUrl = new URL(url);

			SyndFeedInput input = new SyndFeedInput();
			
			SyndFeed feed = input.build(new XmlReader(feedUrl));

			List entries = feed.getEntries();

			for (int i = 0; i < entries.size(); i++) {
				
				
				SyndEntry entry = (SyndEntry) entries.get(i);
				
				System.out.println(StringEscapeUtils.unescapeHtml("getAuthor = " + entry.getAuthor()));
				System.out.println(StringEscapeUtils.unescapeHtml("getLink = " + entry.getLink()));
				System.out.println(StringEscapeUtils.unescapeHtml("getTitle = " + entry.getTitle().trim()));
				System.out.println(StringEscapeUtils.unescapeHtml("getDescription = " + entry.getDescription()));
				System.out.println(StringEscapeUtils.unescapeHtml("getPublishedDate = " + entry.getPublishedDate()));
				
				
				String fromDate = entry.getPublishedDate().toString();
				String fromDateFormat = "EEE MMM d HH:mm:ss z yyyy";
				String changeFormat = "yyyy/MM/dd HH:mm";
				
				System.out.println(changeRSSDateFormat(fromDate, fromDateFormat, changeFormat));
				
				if(i == 0)
					break;
			}
			
		} catch (Exception e) {
			System.out.println("facebook() error..");
			e.printStackTrace();
			// TODO: handle exception
		}
		
		System.out.println("facebook() end..");

	}
	
	public static String changeRSSDateFormat(String fromDate,String fromDateFormat, String changeFormat) {
		String resultDate = "";
		SimpleDateFormat transFormat = new SimpleDateFormat(fromDateFormat ,Locale.ENGLISH);
		
		System.out.println("fromDate = " + fromDate);
		
		try {
			Date toDate = transFormat.parse(fromDate);
			transFormat = new SimpleDateFormat(changeFormat ,Locale.KOREAN);
			resultDate = transFormat.format(toDate);
			
		} catch (ParseException e) {
			e.printStackTrace(); 
		}
		return resultDate;
	}
	

	public static String stripTags(String text, String title) {

		if (text != null) {
			text = text.replaceAll("\\<.*?>", "").trim();

			// 제목을 제외한 내용이 되로록 수정.
			int end_idx = text.indexOf("...") + 3;
			title = title.replaceAll(" ", "");

			int title_idx = title.indexOf("-");
			title = title.substring(title_idx + 1);

			int title_len = title.length();
			int desc_idx = text.indexOf(title);

			// System.out.println(desc_idx + ":" + end_idx);

			/*
			 * 2012.02.14. [LJH] substring 에 들어간 인자에 따른 예외처리.
			 */
			if (desc_idx >= end_idx)
				end_idx = text.length();

			if (desc_idx == 0)
				return text;

			text = text.substring(desc_idx + title_len, end_idx);

			return text;
		} else {
			return "";
		}
	}

}
