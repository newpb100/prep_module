package com.ams.models;

import java.util.ArrayList;

public class UserListRootResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private ArrayList<UserResponse> data;
    private Support support;

    public UserListRootResponse(int page, int per_page, int total, int total_pages, ArrayList<UserResponse> data, Support support) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.support = support;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setData(ArrayList<UserResponse> data) {
        this.data = data;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public ArrayList<UserResponse> getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }
}
