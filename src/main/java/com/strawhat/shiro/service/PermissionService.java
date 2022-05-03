package com.strawhat.shiro.service;

import com.strawhat.shiro.pojo.Permission;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/1 18:43
 */
public interface PermissionService {
    List<Permission> findPermission(String userAccount);
}
