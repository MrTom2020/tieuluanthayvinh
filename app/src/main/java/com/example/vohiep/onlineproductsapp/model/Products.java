package com.example.vohiep.onlineproductsapp.model;

import java.util.List;

public class Products {

    String productid;
    String productName;
    String productQty;
    String productPrice;
    String imageUrl;
    String mausac;
    String kichthuoc;
    String chu;

    public Products(String productid, String productName, String productQty, String productPrice, String imageUrl, String mausac, String kichthuoc, String chu) {
        this.productid = productid;
        this.productName = productName;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.imageUrl = imageUrl;
        this.mausac = mausac;
        this.kichthuoc = kichthuoc;
        this.chu = chu;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getKichthuoc() {
        return kichthuoc;
    }

    public void setKichthuoc(String kichthuoc) {
        this.kichthuoc = kichthuoc;
    }

    public String getChu() {
        return chu;
    }

    public void setChu(String chu) {
        this.chu = chu;
    }
}
