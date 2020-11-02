package com.cyberup.framework.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
public class SessionUploadProgress extends BaseObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 881336765482783111L;
	private Long totalSize = 0L;
	private Long currentSize = 0L;
	private Integer percent = 0;
	private Integer item = -1;
	public Long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getPercent() {
		return percent;
	}
	public void setPercent(Integer percent) {
		this.percent = percent;
	}
	public Long getCurrentSize() {
		return currentSize;
	}
	public void setCurrentSize(Long currentSize) {
		this.currentSize = currentSize;
	}
	public Integer getItem() {
		return item;
	}
	public void setItem(Integer item) {
		this.item = item;
	}
}
