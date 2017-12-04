package com.lxh.myboot.repository;

import com.lxh.myboot.bean.ShoppingUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ShoppingUser,Integer> {
}
