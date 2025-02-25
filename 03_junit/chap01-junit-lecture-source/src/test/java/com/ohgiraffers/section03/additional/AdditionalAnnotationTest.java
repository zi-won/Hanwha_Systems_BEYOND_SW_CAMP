package com.ohgiraffers.section03.additional;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdditionalAnnotationTest {

    /* 수업목표. Junit에서 제공하는 메소드 관련 추가 어노테이션을 사용할 수 있다. */
    @Disabled
    @Test
    public void testIgnore() {}

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(900);      // Thread.sleep을 활용하면 밀리초 만큼 지연 가능
//        Thread.sleep(1001);
    }

    /* 설명. 클래스 위에 TestMethodOrder 어노테이션을 추가하면 원하는 순서로 실행할 수 있다. */
    @Test
    @Order(1)
    public void testFirst() {}

    @Test
    @Order(3)
    public void testThird() {}

    @Test
    @Order(2)
    public void testSecond() {}

}
