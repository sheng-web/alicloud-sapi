package com.tom.dao;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Builder
@Data
public class User {
    private long id;
    private String name;
    private int age;
    private int height;
    private int weight;
    private double gender;
    private double nationality;

}
