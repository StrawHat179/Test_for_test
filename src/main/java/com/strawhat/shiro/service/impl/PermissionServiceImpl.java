package com.strawhat.shiro.service.impl;

import com.strawhat.shiro.dao.PermissionDao;
import com.strawhat.shiro.pojo.Permission;
import com.strawhat.shiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/1 18:44
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionDao permissionDao;
    @Override
    public List<Permission> findPermission(String userAccount) {
        return permissionDao.queryPermission(userAccount);
    }
}
