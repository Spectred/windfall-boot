package com.spectred.mysql.controller;


import com.spectred.mysql.entity.UserInfo;
import com.spectred.mysql.service.UserInfoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息-简单的CRUD
 *
 * @author SWD
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService service;

    @GetMapping("/get/{id}")
    public UserInfo getById(@PathVariable("id") Long id) {
        UserInfo userInfo = service.get(id);
        return userInfo;
    }

    @GetMapping("/getAll")
    public List<UserInfo> getAll() {
        List<UserInfo> userInfos = service.getAll();
        return userInfos;
    }

    @PostMapping("/save")
    public UserInfo save(@RequestBody UserInfo userInfo) {
        return service.save(userInfo);
    }

    @PostMapping("/findX")
    public List<UserInfo> findX(@RequestBody UserInfo userInfo) {
        return service.findX(userInfo);
    }

    @PostMapping("/update")
    public int update(@RequestBody UserInfo userInfo) {
        return service.update(userInfo);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam("id") Long id) {
        service.deleteById(id);
    }


}
