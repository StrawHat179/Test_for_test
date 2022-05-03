package com.strawhat.shiro.controller;

import com.strawhat.shiro.pojo.Position;
import com.strawhat.shiro.pojo.User;
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
@RequestMapping("/position")
public class PositionController {
    @Autowired
    PositionService positionService;

    /**
     * Instantiates a new Query all position.
     */
    @RequestMapping("/queryPosition")
    public String queryAllPosition(Model model){
        List<Position> positionList=positionService.findAllPosition();
        model.addAttribute("positionList",positionList);
        return "position_list";
    }
    @RequestMapping("/queryPositionByNO/{positionNo}")
    public String queryPositionByNO(@PathVariable("positionNo")String positionNo, Model model){
        Position position =positionService.findOne(positionNo);
        model.addAttribute("position",position);
        return "position_edit";
    }
    @RequestMapping("/editPosition")
    @ResponseBody
    public boolean editPosition(Position position){
        boolean rel1=positionService.modifyPosition(position);
        return rel1;
    }
    @RequestMapping("/deletePosition")
    @ResponseBody
    public boolean removePosition(String positionNo){
        boolean rel=positionService.removePosition(positionNo);
        return rel;
    }
    @RequestMapping("/addPositionView")
    public String addPositionView(){
        return "position_add";
    }

    @RequestMapping("/addPosition")
    @ResponseBody
    public boolean addPosition(Position position){
        boolean rel;
        if (position.getPositionNo() == null || "".equals(position.getPositionNo())) {
            rel = false;
            return rel;
        } else {
            rel=positionService.addPosition(position);
            return rel;
        }
    }

}
