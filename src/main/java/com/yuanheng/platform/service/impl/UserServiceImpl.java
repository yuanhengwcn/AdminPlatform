package com.yuanheng.platform.service.impl;

import com.yuanheng.platform.domain.AdminUser;
import com.yuanheng.platform.mapper.UserMapper;
import com.yuanheng.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: openAdminPlatform
 * @BelongsPackage: com.yuanheng.platform.service.impl
 * @Author: yuanhengwcn@gmail.com
 * @CreateTime: 2020-10-26 20:40
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public AdminUser getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    public List<String> selectRolesByUid(Integer id) {

        return userMapper.selectRolesByUid(id);

    }

    @Override
    public List<String> selectPermissionsByUid(Integer id) {
        return userMapper.selectPermissionsByUid(id);
    }
}
