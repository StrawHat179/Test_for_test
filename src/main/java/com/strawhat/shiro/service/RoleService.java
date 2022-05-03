package com.strawhat.shiro.service;

import com.strawhat.shiro.pojo.Role;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/1 18:02
 */
public interface RoleService {
    List<Role> findRoleByUser(String userAccount);
}
