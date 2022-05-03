package com.strawhat.shiro.service.impl;

import com.strawhat.shiro.dao.RoleDao;
import com.strawhat.shiro.pojo.Role;
import com.strawhat.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/1 18:03
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public List<Role> findRoleByUser(String userAccount) {
        return roleDao.queryRoleByUser(userAccount);
    }
}
