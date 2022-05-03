package com.strawhat.shiro.realm;

import com.strawhat.shiro.pojo.Permission;
import com.strawhat.shiro.pojo.Role;
import com.strawhat.shiro.pojo.User;
import com.strawhat.shiro.service.PermissionService;
import com.strawhat.shiro.service.RoleService;
import com.strawhat.shiro.service.UserService;
import com.strawhat.shiro.tools.DigestsUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :StrawHat
 * @date : 2022/5/1 18:53
 */
@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * Instantiates a new My realm.
     * 自定义密码匹配方式
     */
    public MyRealm(){
        //指定密码匹配方式sha1
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher(DigestsUtil.SHA256);
        //指定密码迭代此时
        hashedCredentialsMatcher.setHashIterations(DigestsUtil.ITERATIONS);
        //使用父层方法是匹配方式生效
        setCredentialsMatcher(hashedCredentialsMatcher);
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        /**
         * 1、获取权限、角色
         * 2、封装成对象返回
         */
        String useraccount = (String) principalCollection.getPrimaryPrincipal();
        //根据账号获取角色信息
        List<Role> roleList = roleService.findRoleByUser(useraccount);
        List<Permission> permissionList = permissionService.findPermission(useraccount);
        Set<String> roleSet = new HashSet<String>();
        for(Role role :roleList){
            roleSet.add(role.getRname());
        }
        //放入角色信息进入对象
        SimpleAuthorizationInfo simpleInfo = new SimpleAuthorizationInfo(roleSet);
        for (Permission perm:permissionList){
            //将权限信息放入对象
            simpleInfo.addStringPermission(perm.getPname());
        }
        return simpleInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String useraccount = (String) authenticationToken.getPrincipal();//获取登录名
        System.out.println(useraccount);
        String salt=useraccount;//定义盐值为当前用户名
        User user = userService.findUser(useraccount);
        if (user == null){
            return null;//return null 之后会给我们报出异常
        }
        return new SimpleAuthenticationInfo(user.getAccount(),user.getPassword(), ByteSource.Util.bytes(salt),getName());
    }
}
