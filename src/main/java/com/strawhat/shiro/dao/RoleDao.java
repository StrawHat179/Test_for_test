package com.strawhat.shiro.dao;

import com.strawhat.shiro.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/1 17:33
 */
public interface RoleDao {
    /**
     * Query role by user list.
     *根据用户账号查询相应角色
     * @param userAccount the user account
     * @return the list
     */
    List<Role> queryRoleByUser(String userAccount);
}
