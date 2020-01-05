package com.spectred.creep.controller;

import com.spectred.creep.common.CommonResponse;
import com.spectred.creep.domain.User;
import com.spectred.creep.exception.BusinessException;
import com.spectred.creep.exception.TempException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Demo Controller
 *
 * @author SWD
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = "/getUser")
    public User getUser() {
        User user = new User();
        user.setName("Jack");
        user.setAge(24);
        user.setGender(true);
        return user;
    }

    @GetMapping(value = "/getUser2")
    public CommonResponse<User> getUser2() {
        User user = new User();
        user.setName("Lisa");
        user.setAge(9);
        user.setGender(false);
        return new CommonResponse<>(user);
    }

    @GetMapping(value = "/getUserList")
    public List<User> getUserList() {
        return List.of(User.builder().name("Java").age(24).gender(false).build(),
                User.builder().name("Lisa").age(19).gender(true).build());
    }

    @PostMapping(value = "/postUser")
    public User postUser(@Valid @RequestBody User user) {
        return user;
    }

    @GetMapping(value = "/testException")
    public User testException() {
        if (true) {
            throw new BusinessException("100", "testExceptionMsg");
        }
        return null;
    }

    @GetMapping(value = "/testTempException")
    public User testTempException() {
        if (true) {
            throw new TempException("200", "testTempExceptionMsg");
        }
        return null;
    }

}
