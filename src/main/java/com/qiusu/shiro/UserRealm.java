package com.qiusu.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class UserRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return "UserRealm";
    }

    //完成身份认证（从数据库中取信息）并返回信息
    //如果失败，返回null
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户输入的用户名
        String username = (String) token.getPrincipal();
        System.out.println("用户名是" + username);
        //根据用户名从数据库中查找密码信息
        String password = "1f9011a3ad10f5ac0ffffdd8297f7f5a";//假定从数据库中获取到的密码为 1111

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes("qiusu"), this.getName());

        return info;
    }

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

}
