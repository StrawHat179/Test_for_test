package com.strawhat.shiro.controller;

import com.strawhat.shiro.pojo.Dept;
import com.strawhat.shiro.pojo.Position;
import com.strawhat.shiro.service.DeptService;
import com.strawhat.shiro.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author :StrawHat
 * @date : 2022/5/2 15:22
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;

    /**
     * Instantiates a new Query all position.
     */
    @RequestMapping("/queryDept")
    public String queryAllDept(Model model){
        List<Dept> deptList=deptService.findAllDept();
        model.addAttribute("deptList",deptList);
        return "dept_list";
    }
    @RequestMapping("/queryDeptByNO/{deptno}")
    public String queryDeptByNO(@PathVariable("deptno")String deptno, Model model){
        Dept dept=deptService.findOneDept(deptno);
        model.addAttribute("dept",dept);
        return "dept_edit";
    }
    @RequestMapping("/editDept")
    @ResponseBody
    public boolean editDept(Dept dept){
        boolean rel1=deptService.modifyDept(dept);
        return rel1;
    }
    @RequestMapping("/deleteDept")
    @ResponseBody
    public boolean removeDept(String deptno){
        boolean rel=deptService.removeDept(deptno);
        return rel;
    }
    @RequestMapping("/addDeptView")
    public String addDeptView(){
        return "dept_add";
    }

    @RequestMapping("/addDept")
    @ResponseBody
    public boolean addDept(Dept dept){
        boolean rel;
        if (dept.getDeptno() == null || "".equals(dept.getDeptno())) {
            rel = false;
            return rel;
        } else {
            rel=deptService.addDept(dept);
            return rel;
        }
    }

}
