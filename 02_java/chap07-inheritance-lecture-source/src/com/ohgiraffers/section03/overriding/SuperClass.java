package com.ohgiraffers.section03.overriding;

/* 설명. class의 접근 제어자는 public/default 두 가지가 있다. */
public class SuperClass {

    /* 수업목표. 오버라이딩에 대해 이해할 수 있다. */

    /* 설명. 멤버(필드/메소드)들은 public/protected/default/private 네 가지가 있다. */
    public void method(int num) {}

    public Object method2(int num) {
        return null;
    }

    private void privateMethod() {}

    public final void finalMethod() {}

    protected void protectedMethod() {}

    void defaultMethod() {}     // default 접근제어자 사용 시 생략해야 작동함(default void defaultMethod X)
}
