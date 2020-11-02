package com.cyberup.schedule;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.net.ssl.*;

import org.apache.commons.lang.StringEscapeUtils;
import org.jdom.*;
import org.jdom.input.*;
import org.xml.sax.InputSource;

public class RssReader3 {

	/**
	 * @param args
	 */
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

		InputStreamReader isr = null;
		StringBuffer sb = new StringBuffer();
		// Now you can access an https URL without having the certificate in the
		// truststore
		try {
			URL url = new URL("https://173.252.120.6/feeds/page.php?format=rss20&id=139177689433288");
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			isr = new InputStreamReader(con.getInputStream(), "utf-8");

			int c;
			while ((c = isr.read()) != -1) {
				sb.append((char) c);
			}

			System.out.println(sb.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				isr.close();
			} catch (Exception e) {

			}
		}

	}
}
