package com.example.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student {
    private int id;
    @NotBlank(message = "Tên không được để trống!")
    @Size(min = 2,max = 100,message = "Tên phải từ 2-100 ký tự")
    private String name;
    @Range(min = 1,max = 150,message = "Tuổi phải từ 1-150")
    private int age;
    public Student(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
