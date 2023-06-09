package com.hua.matchfriends;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.hua.matchfriends.mapper")
@EnableScheduling
public class MatchFriendsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatchFriendsApplication.class, args);
    }

}
