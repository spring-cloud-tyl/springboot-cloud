package com.example.demo.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author tangyulin
 * @description
 * @createdate 12/11/2018
 */
public class Student {

    private String id;

    private String name;

    private int age;

    private String sex;

    private String startDate;

    /*private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    @JsonBackReference
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }*/

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    private School school;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
