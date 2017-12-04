package com.lxh.myboot.repository;

import com.lxh.myboot.bean.ShoppingUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface User2Repository extends Repository<ShoppingUser,Integer>{

     ShoppingUser findByUserName(String userName);

    @Query("from ShoppingUser where userName=:cn")
     ShoppingUser getByName(@Param("cn") String name);

}
