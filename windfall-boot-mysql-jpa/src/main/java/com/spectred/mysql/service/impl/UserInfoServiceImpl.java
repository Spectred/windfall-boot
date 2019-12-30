package com.spectred.mysql.service.impl;

import com.spectred.mysql.dao.jpa.UserInfoRepository;
import com.spectred.mysql.entity.UserInfo;
import com.spectred.mysql.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository repository;

    @Override
    public UserInfo get(Long id) {
        Optional<UserInfo> userInfoOptional = repository.findById(id);
        return userInfoOptional.orElse(null);
    }

    @Override
    public List<UserInfo> getAll() {
        Sort id = Sort.by(Sort.Order.desc("id"));
        return repository.findAll(id);
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        UserInfo save = repository.save(userInfo);
        return save;
    }

    @Override
    public List<UserInfo> findX(UserInfo userInfo) {
        List<UserInfo> allByAge = repository.findAllByAge(userInfo.getAge());
        log.info("findAllByAge. {} => {}", userInfo.getAge(), allByAge);

        UserInfo byName = repository.findByName(userInfo.getName());
        log.info("findByName. {} => {}", userInfo.getName(), byName);

        UserInfo byNameLikeWith = repository.findByNameLikeWith(userInfo.getName());
        log.info("findByNameLikeWith. {} => {}", userInfo.getName(), byNameLikeWith);

        UserInfo byNameAndAge = repository.findByNameAndAge(userInfo.getName(), userInfo.getAge());
        log.info("findByNameAndAge. {},{} => {}", userInfo.getName(), userInfo.getAge(), byNameAndAge);
        return null;
    }


    @Override
    public int update(UserInfo userInfo) {
        return repository.update(userInfo.getName(), userInfo.getId());
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
