package com.ohgiraffers.section03.filterstream.dto;

import java.io.Serializable;

public class MemberDTO implements Serializable {    // 객체 입출력이 될 대상의 클래스는 Serializable을 달아줘야 한다.
    private String Id;

    /* 설명. transient 키워드가 달린 필드는 객체 입출력 시 (직렬화 시 대상이 되지 않는다.) 출력 되지 않는다. */
    private transient String pwd;       // 입출력 시 값 무시 -> null값이 들어감
    private String name;
    private String email;
    private int age;
    private char gender;

    public MemberDTO() {
    }

    public MemberDTO(String id, String pwd, String name, String email, int age, char gender) {
        Id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "Id='" + Id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
