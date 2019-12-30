package com.spectred.mysql.service;

import com.spectred.mysql.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * UserInfoService
 *
 * @author SWD
 */
public interface UserInfoService {
    /**
     * 根据主键查询UserInfo
     *
     * @param id 主键
     * @return 根据主键查询UserInfo
     */
    UserInfo get(Long id);

    /**
     * 获取所有UserInfo
     *
     * @return 所有UserInfo
     */
    List<UserInfo> getAll();

    /**
     * 增加
     *
     * @param userInfo userInfo
     * @return userInfo
     */
    UserInfo save(UserInfo userInfo);


    List<UserInfo> findX(UserInfo userInfo);

    int update(UserInfo userInfo);

    long count();

    void deleteById(Long id);
}
