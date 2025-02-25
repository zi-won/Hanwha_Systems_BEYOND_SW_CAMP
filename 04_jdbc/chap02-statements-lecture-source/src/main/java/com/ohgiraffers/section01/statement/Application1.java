package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {

        /* 설명. Connection 객체 생성 */
        Connection con = getConnection();

        System.out.println("con = " + con);

        Statement stmt = null;

        /* 설명. 실행될 쿼리가 조회일 경우 */
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT * FROM EMPLOYEE");

            /* 설명. 다중행 결과는 반복문 활용 */
            while(rset.next()) {

                /* 설명. 반복문 안에서의 rset은 단일행으로 해석 */
                System.out.println(rset.getString("EMP_NAME") + ", "
                        + rset.getInt("SALARY"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}