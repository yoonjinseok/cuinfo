package com.cyberup.framework.model;

import org.springframework.ui.ModelMap;

public class PagingModel extends BaseObject {
	public final static String CURRENT_PAGE = "currPage";
	public final static String SHOW_CNT = "showCnt";
	public final static String TOTAL_PAGE = "totalPage";
	public final static String TOTAL_CNT = "totalCnt";
	
	private Integer recNum = 0;
	private Integer totalCnt = 0;
	private Integer showCnt = 10;
	private Integer currPage = 1;
	private Integer sorting = 0;
	private Integer ascending = 0;
	
	public static void mappPages(ModelMap modelMap, Integer currPage, Integer showCnt, PagingModel pagingModel)
	{
		modelMap.addAttribute(CURRENT_PAGE, currPage);
		modelMap.addAttribute(SHOW_CNT, showCnt);
		modelMap.addAttribute(TOTAL_PAGE, pagingModel.getTotalCnt() / showCnt + 1);
		modelMap.addAttribute(TOTAL_CNT, pagingModel.getTotalCnt());
	}
	
	public Integer getRecNum() {
		return recNum;
	}
	public void setRecNum(Integer recNum) {
		this.recNum = recNum;
	}
	public Integer getRowNum()
	{
		return this.totalCnt - this.recNum + 1;
	}
	public Integer getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(Integer totalCnt) {
		this.totalCnt = totalCnt;
	}
	public Integer getShowCnt() {
		return showCnt;
	}
	public void setShowCnt(Integer showCnt) {
		this.showCnt = showCnt;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getSorting() {
		return sorting;
	}

	public void setSorting(Integer sorting) {
		if(sorting != null)
			this.sorting = sorting;
	}

	public Integer getAscending() {
		return ascending;
	}

	public void setAscending(Integer ascending) {
		if(ascending != null)
			this.ascending = ascending;
	}
	
}
