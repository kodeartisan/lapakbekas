package com.qodr.lapakbekas.entity;

import java.util.List;

/**
 * Created by kodeartisan on 24/05/17.
 */

public class ProductWrapper {

    private String status;
    private String promoDue;
    private String banner;
    private List<Product> products;
    private List<String> categories;
    private String message;
    private List<String> facets;
    private String labels;
    private String relatedKeywords;
    private List<String> recommendedProducts;
    private String productDeeplink;

    public ProductWrapper(String status, String promoDue, String banner, List<Product> products, List<String> categories, String message, List<String> facets, String labels, String relatedKeywords, List<String> recommendedProducts, String productDeeplink) {
        this.status = status;
        this.promoDue = promoDue;
        this.banner = banner;
        this.products = products;
        this.categories = categories;
        this.message = message;
        this.facets = facets;
        this.labels = labels;
        this.relatedKeywords = relatedKeywords;
        this.recommendedProducts = recommendedProducts;
        this.productDeeplink = productDeeplink;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPromoDue() {
        return promoDue;
    }

    public void setPromoDue(String promoDue) {
        this.promoDue = promoDue;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getFacets() {
        return facets;
    }

    public void setFacets(List<String> facets) {
        this.facets = facets;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getRelatedKeywords() {
        return relatedKeywords;
    }

    public void setRelatedKeywords(String relatedKeywords) {
        this.relatedKeywords = relatedKeywords;
    }

    public List<String> getRecommendedProducts() {
        return recommendedProducts;
    }

    public void setRecommendedProducts(List<String> recommendedProducts) {
        this.recommendedProducts = recommendedProducts;
    }

    public String getProductDeeplink() {
        return productDeeplink;
    }

    public void setProductDeeplink(String productDeeplink) {
        this.productDeeplink = productDeeplink;
    }
}
