package com.strawhat.shiro.service;

import com.strawhat.shiro.pojo.Dept;
import com.strawhat.shiro.pojo.Position;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/2 16:34
 */
public interface DeptService {
    List<Dept> findAllDept();
    boolean addDept(Dept dept);
    boolean removeDept(String deptno);
    boolean modifyDept(Dept dept);
    Dept findOneDept(String deptno);
}
