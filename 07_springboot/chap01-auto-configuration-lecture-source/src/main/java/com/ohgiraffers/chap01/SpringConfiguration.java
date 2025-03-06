package com.ohgiraffers.chap01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Value("${test.value}")
    public String testValue;

    @Value("${test.age}")
    public int testAge;

    /* 설명. @Value는 시스템 환경변수도 불러올 수 있다. */
    @Value("${user}")
    public String user;

    @Bean
    public Object propertReadTest() {
        System.out.println("testValue: " + testValue);
        System.out.println("age: " + testAge);
        System.out.println("username: " + user);

        return new Object();
    }
}
