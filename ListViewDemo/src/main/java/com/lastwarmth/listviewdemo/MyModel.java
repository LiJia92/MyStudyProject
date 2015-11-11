package com.lastwarmth.listviewdemo;

/**
 * Created by Administrator on 2015/11/10.
 */
public class MyModel {

    String imageUrl;
    String groupName;
    String content;

    public MyModel(String imageUrl, String groupName, String content) {
        this.imageUrl = imageUrl;
        this.groupName = groupName;
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getContent() {
        return content;
    }

}
