package com.lxh.myboot.controller;

import com.lxh.myboot.bean.ShoppingUser;
import com.lxh.myboot.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/shoppingUser")
public class ShoppingUserController {
    @Resource
    private UserService userService;

    @RequestMapping("/save")
    public String save(int age,String name){
        ShoppingUser shoppingUser = new ShoppingUser();
        shoppingUser.setUserAge(age);
        shoppingUser.setUserName(name);
        userService.save(shoppingUser);
        return "save ok";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        userService.delete(Integer.valueOf(id));
        return "delete ok";
    }

    @RequestMapping("/getAll")
    public Iterable<ShoppingUser> getAll(){
        return userService.getAll();
    }

    @RequestMapping("/findByName")
    public ShoppingUser findByUserName(String userName){
       return userService.findByUserName(userName);
    }

    @RequestMapping("/getByName")
    public ShoppingUser getByName(String name){
        return userService.getByName(name);
    }

    @RequestMapping("/getSortAll")
    public Iterable<ShoppingUser> getSortAll(){
        //Order idOrder = new Order(Direction.DESC, "userAge");
        Order nameOrder = new Order(Direction.DESC,"userName");
        Sort sort = new Sort(nameOrder);
        return userService.getSortAll(sort);
    }

    @RequestMapping("/getPageAll")
    public Page<ShoppingUser> getPageAll(int currentPage, int pageSize){
        //Order idOrder = new Order(Direction.DESC, "userAge");
        Order nameOrder = new Order(Direction.DESC,"userName");
        Sort sort = new Sort(nameOrder);
        PageRequest pageRequest  = new PageRequest(currentPage, pageSize, sort);
        return userService.getPageAll(pageRequest);
    }
}
