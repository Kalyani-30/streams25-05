package com.neoteric.student.avootaCode;

import java.util.List;

public class ResponseData {
    private List<Category> categoryList;
    private List<Photo> photos;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
