package com.mana.spring.util;

public class Pagination {

    private static int pageSize = 25;

    protected long count;
    protected int totalPages;
    protected int currentPageNumber;

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        Pagination.pageSize = pageSize;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    private void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public void calculateAndSetTotalPages(){
        setTotalPages((int) Math.ceil((double) count / Pagination.getPageSize()));
    }
}
