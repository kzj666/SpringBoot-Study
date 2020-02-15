package com.kk.pojo;

/*
@author kzj
@date 2020/1/14 - 17:41
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//该注解会提供getter、setter、equals、canEqual、hashCode、toString方法。
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;
    private String perms;
}
