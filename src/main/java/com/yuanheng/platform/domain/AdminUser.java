package com.yuanheng.platform.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @BelongsProject: openAdminPlatform
 * @BelongsPackage: com.yuanheng.platform.domain
 * @Author: yuanhengwcn@gmail.com
 * @CreateTime: 2020-10-26 20:37
 */

@Data
@ToString
public class AdminUser implements Serializable {

    /*id*/
    private Integer id;

    /*邮箱*/
    private String email;

    /*密码*/
    private String password;

    /*真实姓名*/
    private String realName;

    /*状态*/
    private Integer status;
}
