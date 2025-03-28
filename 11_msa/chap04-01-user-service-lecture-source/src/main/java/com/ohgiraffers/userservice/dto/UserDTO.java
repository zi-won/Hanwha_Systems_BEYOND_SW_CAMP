package com.ohgiraffers.userservice.dto;

import com.ohgiraffers.userservice.vo.ResponseOrder;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String email;
    private String name;
    private String pwd;

    /* 설명. 회원가입 진행하며 추가됨 */
    private String userId;

    /* 설명. FeignClient 이후(회원이 주문한 내역도 담기) */
    private List<ResponseOrder> orders;
}
