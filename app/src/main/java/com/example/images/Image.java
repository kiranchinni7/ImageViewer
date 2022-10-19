package com.example.images;

public class Image {
    private  String id;
    private  String author;
    private String coverImage;
    private String downUrl;

    public Image(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public Image(String id, String author, String coverImage, String downUrl){
        this.id=id;
        this.author=author;
        this.coverImage=coverImage;
        this.downUrl=downUrl;
    }
}
