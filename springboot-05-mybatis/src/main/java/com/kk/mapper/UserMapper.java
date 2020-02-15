package com.kk.mapper;

/*
@author kzj
@date 2019/12/19 - 0:25
*/

import com.kk.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//表示这是一个Mybatis的mapper类
@Mapper
@Repository//dao层
public abstract interface UserMapper {

    public static final int age = 18;

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
