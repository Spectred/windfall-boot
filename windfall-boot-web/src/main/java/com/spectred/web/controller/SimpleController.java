package com.spectred.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.spectred.web.common.BusinessException;
import com.spectred.web.dto.UserDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 一个简单的Controller
 *
 * @author SWD
 */
@RestController
public class SimpleController {

    @GetMapping(value = "/sayHello/{name}")
    public UserDTO sayHello(@PathVariable("name") String name) {
        if (name.equals("11")){
            throw new BusinessException("1111","ffff");
        }

        return UserDTO.builder().age("1").name(name).build();
    }



    @PostMapping("/sayHi")
    public String sayHi(@RequestParam("name") String name) {
        return "Hi," + name;
    }

    @PostMapping("/sayHiJson")
    public String sayHiJson(@RequestBody JSONObject json) {
        return "Hi," + json.getString("name");
    }
}
