package com.sunny.green.vo;




public class PaginationVo {


    private int totalRecordCount;   // 전체 데이터 수
    private int totalPageCount;     // 전체 페이지 수
    private int startPage;          // 첫 페이지 번호
    private int endPage;            // 끝 페이지 번호
    private int limitStart;         // LIMIT 시작 위치
    private boolean existPrevPage;  // 이전 페이지 존재 여부
    private boolean existNextPage;  // 다음 페이지 존재 여부

    public PaginationVo(int totalRecordCount, int totalPageCount, int startPage, int endPage, int limitStart, boolean existPrevPage, boolean existNextPage) {
        this.totalRecordCount = totalRecordCount;
        this.totalPageCount = totalPageCount;
        this.startPage = startPage;
        this.endPage = endPage;
        this.limitStart = limitStart;
        this.existPrevPage = existPrevPage;
        this.existNextPage = existNextPage;
    }

    public PaginationVo() {
    }

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart = limitStart;
    }

    public boolean isExistPrevPage() {
        return existPrevPage;
    }

    public void setExistPrevPage(boolean existPrevPage) {
        this.existPrevPage = existPrevPage;
    }

    public boolean isExistNextPage() {
        return existNextPage;
    }

    public void setExistNextPage(boolean existNextPage) {
        this.existNextPage = existNextPage;
    }
}