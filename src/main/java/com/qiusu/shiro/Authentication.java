package com.qiusu.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

/**
 * 完成用户认证
 */
public class Authentication {
    public static void main(String[] args){
        SimpleHash hash = new SimpleHash("md5", "1111", "qiusu", 2);
        System.out.println(hash);
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","1111");

        subject.login(token);
        if(subject.isAuthenticated()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
}
