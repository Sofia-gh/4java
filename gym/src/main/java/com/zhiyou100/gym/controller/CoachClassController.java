package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.*;
import com.zhiyou100.gym.service.IClassOrderService;
import com.zhiyou100.gym.service.ICoachClassService;
import com.zhiyou100.gym.service.ICoachOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("coach_class")
public class CoachClassController {
    @Autowired
    private ICoachClassService coachClassService;

    @RequestMapping("show")
    public String show(Integer coachNumber,Integer page, Model model){
        // todo 判断登录
//        coachNumber = 22020001;
        int currentPage = coachClassService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("classes",coachClassService.findByPage(currentPage,coachNumber));
        model.addAttribute("mPage",coachClassService.findMaxPage(coachNumber));
        return "coach_class/show";
    }

    @RequestMapping("add")
    public String add(){
        return "coach_class/add";
    }

    @RequestMapping("insert")
    public String insert(CoachClass coachClass){
        coachClassService.insert(coachClass);
        return "redirect:show";
    }

    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        model.addAttribute("class",coachClassService.findById(id));
        return "coach_class/edit";
    }

    @RequestMapping("update")
    public String update(CoachClass coachClass){
        coachClassService.update(coachClass);
        return "redirect:show";
    }

    @RequestMapping("delete")
    public String delete(CoachClass coachClass){
        coachClassService.delete(coachClass);
        return "redirect:show";
    }

    @RequestMapping("end")
    public String start(CoachClass coachClass){
        coachClassService.end(coachClass);
        return "redirect:show";
    }

    @RequestMapping("finish")
    public String finish(CoachClass coachClass){
        coachClassService.finish(coachClass);
        return "redirect:show";
    }
}
