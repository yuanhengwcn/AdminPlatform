package com.yuanheng.platform.service;

import com.yuanheng.platform.domain.AdminUser;

import java.util.List;

/**
 * @BelongsProject: openAdminPlatform
 * @BelongsPackage: com.yuanheng.platform.service
 * @Author: yuanhengwcn@gmail.com
 * @CreateTime: 2020-10-26 20:40
 */
public interface UserService {
    AdminUser getUserByEmail(String email);

    List<String> selectRolesByUid(Integer id);

    List<String> selectPermissionsByUid(Integer id);
}
