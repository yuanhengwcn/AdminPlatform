package com.yuanheng.platform.mapper;

import com.yuanheng.platform.domain.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @BelongsProject: openAdminPlatform
 * @BelongsPackage: com.yuanheng.platform.mapper
 * @Author: yuanhengwcn@gmail.com
 * @CreateTime: 2020-10-26 20:42
 */
public interface UserMapper {
    AdminUser getUserByEmail(@Param("email") String email);

    List<String> selectRolesByUid(@Param("id") Integer id);

    List<String> selectPermissionsByUid(@Param("id")Integer id);
}
