package com.ohgiraffers.section02.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =        // 컨테이너 만들기
                new GenericXmlApplicationContext("section02/xmlconfig/spring-context.xml");

        /* 설명. 컨테이너에 들어있는 모든 bean의 이름(id)을 확인 */
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        /* 설명. 1. bean의 id를 가지고 컨테이너에서 추출 */
        /* member라는 id를 가진 bean을 가져옴(다운캐스팅 필요) */
//        MemberDTO member = (MemberDTO)context.getBean("member");

        /* 설명. 2. bean의 클래스의 메타 정보(bean의 타입)를 전달하여 추출 */
        /* MemberDTO 타입의 빈을 찾아서 반환(같은 타입의 빈이 여러개 라면 예외 발생) */
//        MemberDTO member = context.getBean(MemberDTO.class);

        /* 설명. 3. bean의 id와 클래스의 메타 정보를 전달하여 추출 */
        /* member라는 id와 MemberDTO.class 타입을 모두 검사하여 bean을 가져옴(가장 안전한 방법) */
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println("member = " + member);
    }
}