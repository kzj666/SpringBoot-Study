package com.kk.mapper;

/*
@author kzj
@date 2020/1/14 - 17:43
*/

import com.kk.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserMapper {
    public User queryUserByName(String name);
}
