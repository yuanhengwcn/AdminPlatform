package com.yuanheng.platform.shiro;

import com.yuanheng.platform.domain.AdminUser;
import com.yuanheng.platform.pojo.Contstant;
import com.yuanheng.platform.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @BelongsProject: openAdminPlatform
 * @BelongsPackage: com.yuanheng.platform.shiro
 * @Author: yuanhengwcn@gmail.com
 * @CreateTime: 2020-10-26 20:30
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String email = token.getUsername();

        /*在这里通过email拿到了用户信息*/
        AdminUser user = userService.getUserByEmail(email);
        if(user == null){
            return null;
        }
        Subject subject = SecurityUtils.getSubject();
        if(subject != null){
            subject.getSession().setAttribute(Contstant.SESSION_USER, user);
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        AdminUser user = (AdminUser)super.getAvailablePrincipal(principalCollection);

        if(user == null){
            return null;
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        /*通过上面拿到的用户信息的id值，拿其角色名*/
        List<String> roles = userService.selectRolesByUid(user.getId());

        info.addRoles(roles);

        List<String> permissions = userService.selectPermissionsByUid(user.getId());

        List<String> collect = permissions.stream().filter(Objects::nonNull).collect(Collectors.toList());

        info.addStringPermissions(collect);

        return info;
    }


}
