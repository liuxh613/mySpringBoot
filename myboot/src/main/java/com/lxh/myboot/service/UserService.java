package com.lxh.myboot.service;

import com.lxh.myboot.bean.ShoppingUser;
import com.lxh.myboot.repository.User2Repository;
import com.lxh.myboot.repository.User3Repository;
import com.lxh.myboot.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private User2Repository user2Repository;

    @Resource
    private User3Repository user3Repository;

    @Transactional
    public void save(ShoppingUser user){
        userRepository.save(user);
    }

    @Transactional
    public void delete(int id){
        userRepository.delete(id);
    }

    @Transactional
    public Iterable<ShoppingUser> getAll(){
        return userRepository.findAll();
    }

    public ShoppingUser findByUserName(String userName){
        return user2Repository.findByUserName(userName);
    }

    public ShoppingUser getByName(String name){
        return  user2Repository.getByName(name);
    }

    public Iterable<ShoppingUser> getSortAll(Sort sort){
        return user3Repository.findAll(sort);
    }
}
