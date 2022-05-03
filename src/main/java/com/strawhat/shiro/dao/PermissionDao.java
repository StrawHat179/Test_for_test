package com.strawhat.shiro.dao;

import com.strawhat.shiro.pojo.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/1 18:04
 */
public interface PermissionDao {
    /**
     * Query permission list.
     *根据用户账号查询相应权限
     * @param userAccount the user account
     * @return the list
     */
    List<Permission> queryPermission(String userAccount);
}
