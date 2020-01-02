package com.spectred.dream.router;

import com.spectred.dream.domain.UserInfo;
import com.spectred.dream.handler.UserInfoHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoHandler userInfoHandler;

    @GetMapping("/get/{id}")
    public Mono<UserInfo> getUserById(@PathVariable Long id) {
        return userInfoHandler.getUserById(id);
    }

    @GetMapping("/getUsers")
    public Flux<UserInfo> getUsers() {
        return userInfoHandler.getUsers();
    }
}
