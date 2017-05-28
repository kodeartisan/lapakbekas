package com.qodr.lapakbekas.entity;

/**
 * Created by kodeartisan on 24/05/17.
 */

public class ProductRetrofitBody {

    private String keyword = null;
    private int category_id;
    private int page = 0;
    private int per_page = 20;
    private String conditions = "used";

    public ProductRetrofitBody() {

    }

    public ProductRetrofitBody(String keyword, int category_id, int page, int per_page, String conditions) {
        this.keyword = keyword;
        this.category_id = category_id;
        this.page = page;
        this.per_page = per_page;
        this.conditions = conditions;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
