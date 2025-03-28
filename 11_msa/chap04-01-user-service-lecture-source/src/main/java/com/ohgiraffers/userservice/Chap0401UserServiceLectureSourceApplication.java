package com.ohgiraffers.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients			// 나중에 OpenFeign 추가 시 반드시 등록할 것!
public class Chap0401UserServiceLectureSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chap0401UserServiceLectureSourceApplication.class, args);
	}

}
