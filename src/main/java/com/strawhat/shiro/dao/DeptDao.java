package com.strawhat.shiro.dao;

import com.strawhat.shiro.pojo.Dept;
import com.strawhat.shiro.pojo.Position;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/2 16:24
 */
public interface DeptDao {
    List<Dept> selectAllDept();
    int insertDept(Dept dept);
    int deleteDept(String deptno);
    int updateDept(Dept dept);
    Dept selectDept(String deptno);
}
