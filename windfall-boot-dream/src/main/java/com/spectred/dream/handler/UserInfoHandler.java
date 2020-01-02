package com.spectred.dream.handler;

import com.spectred.dream.domain.UserInfo;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 类似Service
 */
@Component
public class UserInfoHandler {


    public Mono<UserInfo> getUserById(Long id) {
        // Mock Data
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Java");
        userInfo.setAge(10);
        userInfo.setGender("1");

        return Mono.justOrEmpty(userInfo);
    }

    public Flux<UserInfo> getUsers() {
        // Mock Data
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Java");
        userInfo.setGender("1");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setName("Java2");
        userInfo2.setGender("12");
        return Flux.fromIterable(List.of(userInfo, userInfo2));
    }
}
