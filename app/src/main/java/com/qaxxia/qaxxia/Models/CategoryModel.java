package com.qaxxia.qaxxia.Models;

public class CategoryModel {
    private String image_url;
    private String category_name;

    public CategoryModel(String image_url, String category_name) {
        this.category_name = category_name;
        this.image_url = image_url;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_url() {
        return image_url;
    }
}
