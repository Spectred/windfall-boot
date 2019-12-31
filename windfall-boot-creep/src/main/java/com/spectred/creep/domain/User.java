package com.spectred.creep.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 用户信息
 *
 * @author SWD
 */
@Setter
@Getter
@Builder
public class User {

    /**
     * 姓名
     */
    @Email
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Boolean gender;

    public User() {
    }

    public User(@Email String name, Integer age, Boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
