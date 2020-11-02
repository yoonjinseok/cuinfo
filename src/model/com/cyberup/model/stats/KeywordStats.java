package com.cyberup.model.stats;

import com.cyberup.framework.model.PagingModel;

public class KeywordStats extends PagingModel {

	private static final long serialVersionUID = -8387702460199547249L;
	
	private int serviceRank=0;
	private String keyword = "";
	private int hitsCnt = 0;
	private int hitsTotalCnt = 0;	
	private double hitsRate = 0;
	
	private String searchSDT = "";
	private String searchEDT = "";
	private String searchKeyword = "";
	private String sortString = "";
	
	public int getServiceRank() {
		return serviceRank;
	}
	public void setServiceRank(int serviceRank) {
		this.serviceRank = serviceRank;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getHitsCnt() {
		return hitsCnt;
	}
	public void setHitsCnt(int hitsCnt) {
		this.hitsCnt = hitsCnt;
	}
	public int getHitsTotalCnt() {
		return hitsTotalCnt;
	}
	public void setHitsTotalCnt(int hitsTotalCnt) {
		this.hitsTotalCnt = hitsTotalCnt;
	}
	public double getHitsRate() {
		return hitsRate;
	}
	public void setHitsRate(double hitsRate) {
		this.hitsRate = hitsRate;
	}
	public String getSearchSDT() {
		return searchSDT;
	}
	public void setSearchSDT(String searchSDT) {
		this.searchSDT = searchSDT;
	}
	public String getSearchEDT() {
		return searchEDT;
	}
	public void setSearchEDT(String searchEDT) {
		this.searchEDT = searchEDT;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public String getSortString() {
		return sortString;
	}
	public void setSortString(String sortString) {
		this.sortString = sortString;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	
}
