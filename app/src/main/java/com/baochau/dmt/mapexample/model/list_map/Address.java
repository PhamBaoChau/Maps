package com.baochau.dmt.mapexample.model.list_map;

import com.baochau.dmt.mapexample.model.BaseModel;
import com.google.android.gms.maps.model.BitmapDescriptor;

public class Address implements BaseModel {
    private Point gps;
    private String title;
    private String address;
    private String category;
    private String img;
    private String img_big;
    private String facebook;
    private String url;
    private Double rating;

    public Point getGps() {
        return gps;
    }

    public void setGps(Point gps) {
        this.gps = gps;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg_big() {
        return img_big;
    }

    public void setImg_big(String img_big) {
        this.img_big = img_big;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Address(Point gps, String title, String address, String category, String img, String img_big, String facebook, String url,Double rating) {
        this.gps = gps;
        this.title = title;
        this.address = address;
        this.category = category;
        this.img = img;
        this.img_big = img_big;
        this.facebook = facebook;
        this.url = url;
        this.rating=rating;
    }

}
