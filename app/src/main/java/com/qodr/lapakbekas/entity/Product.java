package com.qodr.lapakbekas.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kodeartisan on 24/05/17.
 */

public class Product {

    private int price;

    private int category_id;

    private String category;

    private List<String> categoryStructure;

    private List<String> courier;

    private String sellerUsername;

    private String sellerName;

    private String sellerAvatar;

    private String sellerLevel;

    private String sellerLevelBadgeUrl;

    private String sellerDeliveryTime;

    private String id;

    private String url;

    private String name;

    private boolean active;

    private String city;

    private String province;

    private Integer weight;

    private List<Integer> imageIds;

    private List<String> images;

    @SerializedName("small_images")
    private List<String> smallImages;

    private String desc;

    private String condition;

    private int stock;

    public Product(int price, int category_id, String category, List<String> categoryStructure, List<String> courier, String sellerUsername, String sellerName, String sellerAvatar, String sellerLevel, String sellerLevelBadgeUrl, String sellerDeliveryTime, String id, String url, String name, boolean active, String city, String province, Integer weight, List<Integer> imageIds, List<String> images, List<String> smallImages, String desc, String condition, int stock) {
        this.price = price;
        this.category_id = category_id;
        this.category = category;
        this.categoryStructure = categoryStructure;
        this.courier = courier;
        this.sellerUsername = sellerUsername;
        this.sellerName = sellerName;
        this.sellerAvatar = sellerAvatar;
        this.sellerLevel = sellerLevel;
        this.sellerLevelBadgeUrl = sellerLevelBadgeUrl;
        this.sellerDeliveryTime = sellerDeliveryTime;
        this.id = id;
        this.url = url;
        this.name = name;
        this.active = active;
        this.city = city;
        this.province = province;
        this.weight = weight;
        this.imageIds = imageIds;
        this.images = images;
        this.smallImages = smallImages;
        this.desc = desc;
        this.condition = condition;
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getCategoryStructure() {
        return categoryStructure;
    }

    public void setCategoryStructure(List<String> categoryStructure) {
        this.categoryStructure = categoryStructure;
    }

    public List<String> getCourier() {
        return courier;
    }

    public void setCourier(List<String> courier) {
        this.courier = courier;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAvatar() {
        return sellerAvatar;
    }

    public void setSellerAvatar(String sellerAvatar) {
        this.sellerAvatar = sellerAvatar;
    }

    public String getSellerLevel() {
        return sellerLevel;
    }

    public void setSellerLevel(String sellerLevel) {
        this.sellerLevel = sellerLevel;
    }

    public String getSellerLevelBadgeUrl() {
        return sellerLevelBadgeUrl;
    }

    public void setSellerLevelBadgeUrl(String sellerLevelBadgeUrl) {
        this.sellerLevelBadgeUrl = sellerLevelBadgeUrl;
    }

    public String getSellerDeliveryTime() {
        return sellerDeliveryTime;
    }

    public void setSellerDeliveryTime(String sellerDeliveryTime) {
        this.sellerDeliveryTime = sellerDeliveryTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Integer> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(List<String> smallImages) {
        this.smallImages = smallImages;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
