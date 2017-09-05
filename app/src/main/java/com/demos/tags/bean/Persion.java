package com.demos.tags.bean;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class Persion {
    private int _id;
    private String name;
    private int age;

    public Persion() {
    }

    public Persion(int _id, String name, int age) {
        this._id = _id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
