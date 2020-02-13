package com.carrot.bbs.dto;

public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private int displayPagenNum = 10;

	private Criteria cri;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		System.out.println("setTotalCount~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		calcData();
	}

	private void calcData() {
		System.out.println("cri.getPage : " + cri.getPage());
		System.out.println("cri.displayPagenNum : " + (double) displayPagenNum);
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPagenNum) * displayPagenNum); // 현재 내가 있는 페이지
		startPage = (endPage - displayPagenNum) + 1;
		int tendPage = (int) (Math.ceil(totalCount) / (double) cri.getPage());
		if (endPage > tendPage)
			endPage = tendPage;
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPageNum() >= totalCount ? false : true;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPagenNum() {
		return displayPagenNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

}
