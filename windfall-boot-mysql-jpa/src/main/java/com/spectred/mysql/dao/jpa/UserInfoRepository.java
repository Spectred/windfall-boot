package com.spectred.mysql.dao.jpa;

import com.spectred.mysql.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    @Query(" SELECT ui FROM user_info ui WHERE ui.name = ?1 ")
    UserInfo findByName(String name);

    @Query(" SELECT ui FROM user_info  ui WHERE ui.name LIKE %?1% ")
    UserInfo findByNameLikeWith(String name);

    @Query(" SELECT ui FROM user_info ui WHERE ui.name= :name AND ui.age = :age")
    UserInfo findByNameAndAge(String name, Integer age);


    @Query(" select t from #{#entityName} t where t.age = ?1")
    List<UserInfo> findAllByAge(Integer age);

    @Modifying
    @Query("update user_info ui set ui.name = :name where ui.id = :id ")
    int update(String name, Long id);


}
