package com.yuanheng.platform.controller;

import com.yuanheng.platform.pojo.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @BelongsProject: openAdminPlatform
 * @BelongsPackage: com.yuanheng.platform.controller
 * @Author: yuanhengwcn@gmail.com
 * @CreateTime: 2020-10-26 20:08
 */

@Controller
@RequestMapping("/platform")
public class SystemController {


    /*登录功能*/
    @ResponseBody
    @PostMapping("/login")
    public R login(String email, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(email, password);

        try {
            subject.login(token);
        }catch (AuthenticationException e){
            e.printStackTrace();
            return R.error("error");
        }

        if(subject.isAuthenticated()){
            return R.ok();
        }else {
            return R.error("error");
        }
    }




}
