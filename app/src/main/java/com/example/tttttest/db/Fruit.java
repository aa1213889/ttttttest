package com.example.tttttest.db;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/8.
 */

public class Fruit implements Serializable {
    private String name;
    private int imageId;
     public Fruit(String name,int imageId){
         this.name = name;
         this.imageId = imageId;
     }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
