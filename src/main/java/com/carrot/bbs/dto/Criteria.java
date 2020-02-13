package com.carrot.bbs.dto;

public class Criteria {
	private int page;
	private int perPageNum;
	
	//생성자에 디폴트값 주기
	public Criteria() {
		this.page=1;
		this.perPageNum=10;
	}
	
	public void setPage(int page) {
		if(page<=0) {
			this.page=1;
			return;
		}
		this.page=page;
	}

	public int getPage() {
		return page;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0||perPageNum>100) {
			this.perPageNum=10;
			return;
		}
		this.perPageNum=perPageNum;
	}

	public int getPageStart() {
		return (this.page-1)*perPageNum;
		//페이지는 1 페이지부터 시작하지만 레코드는 0부터 시작되기 때문에 -1
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
}
