package com.strawhat.shiro.service.impl;

import com.strawhat.shiro.dao.DeptDao;
import com.strawhat.shiro.pojo.Dept;
import com.strawhat.shiro.pojo.Position;
import com.strawhat.shiro.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/2 16:35
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptDao deptDao;
    @Override
    public List<Dept> findAllDept() {
        return deptDao.selectAllDept() ;
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.insertDept(dept)>0;
    }

    @Override
    public boolean removeDept(String deptno) {
        return deptDao.deleteDept(deptno)>0;
    }

    @Override
    public boolean modifyDept(Dept dept) {
        return deptDao.updateDept(dept)>0;
    }

    @Override
    public Dept findOneDept(String deptno) {
        return deptDao.selectDept(deptno);
    }
}
