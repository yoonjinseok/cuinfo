package com.cyberup.schedule;

import com.cyberup.model.home.NewsFeedModel;
import com.cyberup.service.home.NewsFeedService;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;

public class RssReader
{

  @Autowired
  private NewsFeedService newsFeedService;

  public void main(String[] args)
    throws IllegalArgumentException, FeedException, IOException
  {
    System.out.println("execute2() start..\n");
    try
    {
      //String url = "https://news.google.co.kr/news/feeds?pz=1&cf=all&ned=ko&hl=ko&q=%EC%82%AC%EC%9D%B4%EB%B2%84%EB%8C%80+OR+%EB%94%94%EC%A7%80%ED%84%B8%EB%8C%80+OR+%EC%82%AC%EC%9D%B4%EB%B2%84%ED%95%9C%EA%B5%AD%EC%99%B8%EB%8C%80+OR+%EC%82%AC%EC%9D%B4%EB%B2%84%EB%8C%80%ED%95%99+OR+%EB%94%94%EC%A7%80%ED%84%B8%EB%8C%80%ED%95%99+OR+%EC%82%AC%EC%9D%B4%EB%B2%84%ED%95%9C%EA%B5%AD%EC%99%B8%EB%8C%80%ED%95%99+OR+%EC%82%AC%EC%9D%B4%EB%B2%84%EB%8C%80%ED%95%99%EA%B5%90+OR+%EB%94%94%EC%A7%80%ED%84%B8%EB%8C%80%ED%95%99%EA%B5%90+OR+%EC%82%AC%EC%9D%B4%EB%B2%84%ED%95%9C%EA%B5%AD%EC%99%B8%EA%B5%AD%EC%96%B4%EB%8C%80%ED%95%99%EA%B5%90&output=rss";
      String url = "http://newssearch.naver.com/search.naver?where=rss&query=%EC%82%AC%EC%9D%B4%EB%B2%84%EB%8C%80%ED%95%99&field=1&nx_search_query=&nx_and_query=&nx_sub_query=&nx_search_hlquery=";
      ////String url = "http://news.search.naver.com/search.naver?ie=utf8&where=news&query=%EC%82%AC%EC%9D%B4%EB%B2%84%EB%8C%80%20%7C%20%EB%94%94%EC%A7%80%ED%84%B8%EB%8C%80&sm=tab_pge&sort=0&photo=0=&field=1&pd=0&ds=&de=&refresh=-1&docid=";
      Document document = null;

      URL feedUrl = new URL(url);

      SyndFeedInput input = new SyndFeedInput();
      SyndFeed feed = input.build(new XmlReader(feedUrl));

      List entries = feed.getEntries();

      for (int i = 0; i < entries.size(); i++) {
        SyndEntry entry = (SyndEntry)entries.get(i);
        System.out.println(i + " : " + entry.getTitle() + " : " + entry.getPublishedDate());
      }

      for (int i = 0; i < entries.size(); i++) {
        SyndEntry entry = (SyndEntry)entries.get(i);

        NewsFeedModel nfm = new NewsFeedModel();

        nfm.setNewsTitle(entry.getTitle());
        nfm.setNewsLink(entry.getLink());
        nfm.setNewsDesc(stripTags(entry.getDescription().getValue(), entry.getTitle()));
        nfm.setNewsRegDate(entry.getPublishedDate());

        System.out.println("title : " + entry.getTitle());
        System.out.println("link  : " + entry.getLink());
        System.out.println("desc1 : " + entry.getDescription().getValue());
        System.out.println("desc2 : " + stripTags(entry.getDescription().getValue(), entry.getTitle()));
        System.out.println("date  : " + entry.getPublishedDate() + "\n");

        int duplicatCnt = this.newsFeedService.isDuplicated(nfm);
        if (duplicatCnt > 0) {
          System.out.println("중복뉴스 제외..");
        }
        else {
          System.out.println("duplicatCnt ==> " + duplicatCnt);

          this.newsFeedService.newsFeed_insert(nfm);
        }
      }
    } catch (Exception e) {
      System.out.println("execute2() error..");
      e.printStackTrace();
    }

    System.out.println("execute2() end..");
  }

  public void execute()
    throws IllegalArgumentException, FeedException, IOException
  {
    System.out.println("execute1() start..\n");
    try
    {
    	//String url = "https://news.google.co.kr/news/feeds?pz=1&cf=all&ned=ko&hl=ko&q=%EC%82%AC%EC%9D%B4%EB%B2%84%EB%8C%80+OR+%EB%94%94%EC%A7%80%ED%84%B8%EB%8C%80+OR+%EC%82%AC%EC%9D%B4%EB%B2%84%ED%95%9C%EA%B5%AD%EC%99%B8%EB%8C%80+OR+%EC%82%AC%EC%9D%B4%EB%B2%84%EB%8C%80%ED%95%99+OR+%EB%94%94%EC%A7%80%ED%84%B8%EB%8C%80%ED%95%99+OR+%EC%82%AC%EC%9D%B4%EB%B2%84%ED%95%9C%EA%B5%AD%EC%99%B8%EB%8C%80%ED%95%99+OR+%EC%82%AC%EC%9D%B4%EB%B2%84%EB%8C%80%ED%95%99%EA%B5%90+OR+%EB%94%94%EC%A7%80%ED%84%B8%EB%8C%80%ED%95%99%EA%B5%90+OR+%EC%82%AC%EC%9D%B4%EB%B2%84%ED%95%9C%EA%B5%AD%EC%99%B8%EA%B5%AD%EC%96%B4%EB%8C%80%ED%95%99%EA%B5%90&output=rss";
    	////String url = "http://newssearch.naver.com/search.naver?where=rss&query=%EC%82%AC%EC%9D%B4%EB%B2%84%EB%8C%80%ED%95%99&field=1&nx_search_query=&nx_and_query=&nx_sub_query=&nx_search_hlquery=";
    	String url = "http://newssearch.naver.com/search.naver?where=rss&query=%EC%82%AC%EC%9D%B4%EB%B2%84%EB%8C%80%ED%95%99%20%7C%20%EB%94%94%EC%A7%80%ED%84%B8%EB%8C%80%ED%95%99%20%7C%20%EC%9B%90%EA%B4%91%EB%94%94%EC%A7%80%ED%84%B8%EB%8C%80%20%7C%20%EB%B6%80%EC%82%B0%EB%94%94%EC%A7%80%ED%84%B8%EB%8C%80%20%7C%20%EC%84%9C%EC%9A%B8%EB%94%94%EC%A7%80%ED%84%B8%EB%8C%80%20%7C%20%EC%84%9C%EC%9A%B8%EB%AC%B8%ED%99%94%EC%98%88%EC%88%A0%EB%8C%80&field=1&nx_search_query=&nx_and_query=&nx_sub_query=&nx_search_hlquery=";
    	URL feedUrl = new URL(url);

      SyndFeedInput input = new SyndFeedInput();
      SyndFeed feed = input.build(new XmlReader(feedUrl));

      List entries = feed.getEntries();

      for (int i = 0; i < entries.size(); i++) {
        SyndEntry entry = (SyndEntry)entries.get(i);
        System.out.println(i + " : " + entry.getTitle());
        System.out.println(i + " : " + entry.getPublishedDate());
      }

      for (int i = 0; i < entries.size(); i++) {
        SyndEntry entry = (SyndEntry)entries.get(i);

        NewsFeedModel nfm = new NewsFeedModel();

        nfm.setNewsTitle(entry.getTitle());
        nfm.setNewsLink(entry.getLink());
        nfm.setNewsDesc(stripTags(entry.getDescription().getValue(), entry.getTitle()));
        nfm.setNewsRegDate(entry.getPublishedDate());

        System.out.println("title : " + entry.getTitle());
        System.out.println("link  : " + entry.getLink());
        System.out.println("desc1 : " + entry.getDescription().getValue());
        System.out.println("desc2 : " + stripTags(entry.getDescription().getValue(), entry.getTitle()));
        System.out.println("date  : " + entry.getPublishedDate());

        int duplicatCnt = this.newsFeedService.isDuplicated(nfm);
        if (duplicatCnt > 0) {
          System.out.println("중복뉴스 제외..");
        }
        else {
          System.out.println("duplicatCnt ==> " + duplicatCnt);

          this.newsFeedService.newsFeed_insert(nfm);
        }
      }
    } catch (Exception e) {
      System.out.println("execute1() error..");
      e.printStackTrace();
    }

    System.out.println("execute1() end..");
  }

  public String stripTags(String text, String title)
  {
    if (text != null) {
      text = text.replaceAll("\\<.*?>", "").trim();

      int end_idx = text.indexOf("...") + 3;
      title = title.replaceAll(" ", "");
      
      if(end_idx<= 10){
			end_idx = text.length();
		}
      

      int title_idx = title.indexOf("-");
      title = title.substring(title_idx + 1);

      int title_len = title.length();
      int desc_idx = text.indexOf(title);

      if (desc_idx >= end_idx) {
        end_idx = text.length();
      }
      if (desc_idx == 0) {
        return text;
      }
      text = text.substring(desc_idx + title_len, end_idx);

      return text;
    }
    return "";
  }
}