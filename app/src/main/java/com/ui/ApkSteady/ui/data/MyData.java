package com.ui.ApkSteady.ui.data;

public class MyData {
    String text;
    int image;
    //标志消息的类型
    int type;
    public MyData(String text,int image,int type){
        this.text=text;
        this.image=image;
        this.type=type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
