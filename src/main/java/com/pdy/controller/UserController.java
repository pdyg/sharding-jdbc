package com.pdy.controller;

import com.pdy.entity.Address;
import com.pdy.entity.User;
import com.pdy.serivce.AddressServiceImpl;
import com.pdy.serivce.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private AddressServiceImpl addressServiceImpl;

    //默认使用雪花算法（snowflake）生成64bit的长整型数据。
    @RequestMapping("/user/save")
    @ResponseBody
    public String save() {
        List<User> userList=new ArrayList<User>();
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++){
                User user=new User();
                user.setName("test"+i);
                user.setCityId(i);
                user.setCreateTime(new Date());
                user.setSex(j);
                user.setPhone("11111111"+i);
                user.setEmail("xxxxx");
                user.setCreateTime(new Date());
                user.setPassword("eeeeeeeeeeee");
                userList.add(user);
            }


        }
        for (User user : userList) {
            userServiceImpl.save(user);

        }

        return "success";
    }
    @RequestMapping("/user/save/address")
    @ResponseBody
    public String saveAddress() {
        for (int i = 0; i <10 ; i++) {
            Address address=new Address();
            address.setCode("code"+i); ;
            address.setName("test"+i);
            address.setPid("1112344444"+i);
            address.setType(i%2);
            address.setLit(i);
            addressServiceImpl.save(address);
        }

        return "success";
    }

    @RequestMapping("/user/get/{id}")
    @ResponseBody
    public User get(@PathVariable Long id) {
        User user =  userServiceImpl.get(id);
        System.out.println(user.getId());
        return user;
    }
}
