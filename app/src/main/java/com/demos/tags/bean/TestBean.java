package com.demos.tags.bean;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class TestBean {
    public static final int type_one=1;
    public static final int type_two=2;
    public static final int type_three=3;
    public int type;
    public String name;
    public String content;
    public int avatarColor;
    public int contentColor;

    public int getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(int avatarColor) {
        this.avatarColor = avatarColor;
    }

    public static int getType_two() {
        return type_two;
    }

    public static int getType_three() {
        return type_three;
    }

    public static int getType_one() {
        return type_one;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getContentColor() {
        return contentColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
    }
}
