package com.kk.config;/*
@author kzj
@date 2020/1/13 - 16:18
*/

import com.kk.pojo.User;
import com.kk.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //为经过的请求加上"user:add"权限

        //拿到当前登录的用户的信息资源
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();

        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证");

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //连接真实数据库
        User user = userService.queryUserByName(userToken.getUsername());

        if(user == null){//没有此人
            return null;//UnknowAccountException
        }

        //将user放入session
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser", user);


        //可以加密：MD5  MD5盐值加密(不可逆)
        //密码认证，shiro做~
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");

    }
}
