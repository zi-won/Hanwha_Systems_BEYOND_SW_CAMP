package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor      // 기본 생성자 자동 생성
@AllArgsConstructor     // 모든 필드를 초기화하는 생성자 자동 생성
@Setter                 // 모든 필드의 Setter 메서드 자동 생성
@Getter                 // 모든 필드의 Getter 메서드 자동 생성
@ToString               // 객체의 정보를 문자열로 반환하는 toString() 메서드 자동 생성
public class MemberDTO {
    private int sequence;
    private String id;
    private String pwd;
    private String name;
}