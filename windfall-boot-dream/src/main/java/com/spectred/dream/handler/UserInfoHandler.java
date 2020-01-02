package com.spectred.dream.handler;

import com.spectred.dream.domain.UserInfo;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

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
}
