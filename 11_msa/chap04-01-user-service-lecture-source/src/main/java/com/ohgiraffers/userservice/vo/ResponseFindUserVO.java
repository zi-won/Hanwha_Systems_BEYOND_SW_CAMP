package com.ohgiraffers.userservice.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResponseFindUserVO {
    private String email;
    private String name;
    private String userId;

    /* 설명. FeignClient 이후(주문내역도 담기) */
    private List<ResponseOrder> orders;
}
