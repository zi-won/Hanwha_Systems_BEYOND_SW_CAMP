package com.ohgiraffers.section06.statickeyword;

public class StaticTest {
    private int nonStaticCount;     // stack 영역에 저장
    private static int staticCount; // static 영역에 저장

    public StaticTest(){
    }

    public int getNonStaticCount() {
        return nonStaticCount;
    }

    public static int getStaticCount() {
        return staticCount;
    }

    public void increasesNonStaticCount() {
        this.nonStaticCount++;
    }

    public static void increaseStaticCount() {
        StaticTest.staticCount++;
    }
}
