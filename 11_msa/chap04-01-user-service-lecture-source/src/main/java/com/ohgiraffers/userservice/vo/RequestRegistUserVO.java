package com.ohgiraffers.userservice.vo;

import lombok.Data;

@Data
public class RequestRegistUserVO {      // 요청 값을 받는 것
    private String email;
    private String name;
    private String pwd;
}