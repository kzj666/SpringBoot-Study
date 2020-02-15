package com.kk.springboot.controller;

/*
@author kzj
@date 2019/12/18 - 18:20
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    //查询数据库的所有信息
    //没有实体类，数据库中的东西，怎么获取
    @GetMapping("/user")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into mybatis.user(name,pwd) value ('赵六','123')";
        jdbcTemplate.update(sql);
        return "add-ok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Integer id){
        String sql = "update mybatis.user set name=?, pwd=? where id ="+id;
        Object[] obj = new Object[2];
        obj[0] = "小明";
        obj[1] = "111";
        jdbcTemplate.update(sql,obj);
        return "update-ok";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id =?";
        jdbcTemplate.update(sql,id);
        return "delete-ok";
    }


}
