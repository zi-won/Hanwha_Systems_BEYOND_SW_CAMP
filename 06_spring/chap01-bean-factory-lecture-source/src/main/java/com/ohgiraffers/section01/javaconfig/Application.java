package com.ohgiraffers.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        /* 우리의 설정으로 컨테이너가 만들어졌다는 것으로 알면 된다. */
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();  // 컨테이너에 있는 모든 빈의 이름 출력
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }
    }
}
