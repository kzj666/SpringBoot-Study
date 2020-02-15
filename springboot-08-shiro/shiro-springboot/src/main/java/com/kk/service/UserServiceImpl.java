package com.kk.service;

/*
@author kzj
@date 2020/1/14 - 17:52
*/

import com.kk.mapper.UserMapper;
import com.kk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
       return userMapper.queryUserByName(name);
    }
}
