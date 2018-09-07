package com.example.dsm2018.scrollview;

public class Item {
    int image;
    String imagetitle;
    String description;


    public int getImage(){
        return image;
    }

    public String getImagetitle() {
        return imagetitle;
    }

    public String getDescription() {
        return description;
    }

    public Item(int image, String imagetitle, String description){
        this.image=image;
        this.imagetitle=imagetitle;
        this.description = description;
    }
}
