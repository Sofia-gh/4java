package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.*;
import com.zhiyou100.gym.service.IClassOrderService;
import com.zhiyou100.gym.service.ICoachClassService;
import com.zhiyou100.gym.service.ICoachOrderService;
import com.zhiyou100.gym.util.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("coach_class")
public class CoachClassController {
    @Autowired
    private ICoachClassService coachClassService;
    public static final String KEY = "教练";

    @RequestMapping("show")
    public String show(Integer coachNumber,Integer page, Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user.getRole().getName().equals(KEY)){
            coachNumber = user.getNumber();
        }
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
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        coachClass.setCoachNumber(user.getNumber());
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

    @ResponseBody
    @RequestMapping("form")
    public ResponseUtil form(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Integer> counts = coachClassService.findCount(user.getNumber());
        return ResponseUtil.success(counts);
    }
}
