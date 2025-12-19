package com.tom.dao;

import lombok.Data;

// 重点：@Data加在User类上，自动生成getId()/getName()等方法
@Data
public class User {
    // 必须声明所有用到的属性，Lombok才会生成对应的getter/setter
    private long id;
    private String name;
    private int age;
    private double height;
    private double weight;

    // 可选：无参构造（Spring/集合操作需要，@Data默认生成，可省略）
    public User() {}

    // 可选：全参构造（方便创建对象）
    public User(long id, String name, int age, double height, double weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}