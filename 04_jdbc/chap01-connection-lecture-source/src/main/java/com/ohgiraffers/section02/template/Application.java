package com.ohgiraffers.section02.template;

import java.sql.Connection;

/* 설명. 다른 클래스의 static 메소드를 클래스명을 쓰지 않고 메소드만 호출하려면 import static을 한다. */
import static com.ohgiraffers.section02.template.JDBCTemplate.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {
//        Connection con = JDBCTemplate.getConnection();
        Connection con = getConnection();

        /* 설명. 비즈니스 로직(트랜잭션 관련) 실행 */
        System.out.println("con = " + con);
        System.out.println("Connection 객체를 활용해 DB와 SQL로 소통");

        close(con);
    }
}
