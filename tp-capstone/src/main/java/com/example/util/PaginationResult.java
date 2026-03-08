package com.example.util;

import java.util.List;

public class PaginationResult<T> {

    private List<T> results;
    private int page;
    private int pageSize;
    private long totalItems;
    private int totalPages;

    public PaginationResult(List<T> results, int page, int pageSize, long totalItems) {
        this.results = results;
        this.page = page;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.totalPages = (int) Math.ceil((double) totalItems / pageSize);
    }

    public List<T> getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }
}