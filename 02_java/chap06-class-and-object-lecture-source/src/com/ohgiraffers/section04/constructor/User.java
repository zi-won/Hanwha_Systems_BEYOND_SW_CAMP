package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class User {     // 필드 선언
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    /* 설명. 기본 생성자(매개변수가 없는)를 활용한 객체 생성
      * (없어도 자동으로 만들어지지만 자동으로 안 만들어지는 경우가 있으므로 반드시 명시적으로 쓰자!)
      * */
    public User() {
        System.out.println("기본 생성자 호출");
    }

    /* 설명. 원하는 필드를 초기화하기 위한 매개변수 있는 생성자를 활용해 객체를 생성할 수 있다. */
    public User(String id, String pwd, String name) {
        System.out.println("매개변수 있는 생성자 호출");

        /* 설명. 생성자 안에서의 this.은 이 생성자로 만들어질 객체에 접근하는 것이다. */
        this.id = name;
        this.pwd = pwd;
        this.name = id;
    }

    public User(String id, String pwd, String name, java.util.Date enrollDate) {
//        this.id = id;
//        this.pwd = pwd;
//        this.name = name;

        /* 설명. this()를 통해 다른 생성자를 활용하여 코드의 줄 수를 줄일 수 있다. */
        /* 설명. 참고로 this()는 항상 첫 줄에 작성되어야 하며 2개 이상 작성할 수 있다. */
        this(id, pwd, name);        // 18번째 줄에 있는 User를 참고함.(19번째 줄도 같이 출력)
        this.enrollDate = enrollDate;   // 선언을 해준적이 없기 때문에 따로 선언해줌.
    }

    public String information() {
        return "id: " + this.id + ", pwd: " + this.pwd + ", name: " + this.name + ", enrollDate: " + this.enrollDate;
    }
}
