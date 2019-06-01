package com.qaxxia.qaxxia.Models;

public class ProductModel {
    private String product_imageurl;
    private String product_name;
    private String product_price;

    public ProductModel(String product_imageurl, String product_name, String product_price) {
        this.product_imageurl = product_imageurl;
        this.product_name = product_name;
        this.product_price = product_price;
    }

    public void setProduct_imageurl(String product_imageurl) {
        this.product_imageurl = product_imageurl;
    }

    public String getProduct_imageurl() {
        return product_imageurl;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_price() {
        return product_price;
    }
}
