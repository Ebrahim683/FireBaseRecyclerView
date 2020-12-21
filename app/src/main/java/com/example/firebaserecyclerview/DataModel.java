package com.example.firebaserecyclerview;

public class DataModel {

    private String description;
    private String pic;
    private String title;

    public DataModel() {
    }

    public DataModel(String description, String pic, String title) {
        this.description = description;
        this.pic = pic;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
