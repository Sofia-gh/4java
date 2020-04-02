package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Coach;
import com.zhiyou100.gym.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("coach")
public class CoachController {
    @Autowired
    private ICoachService coachService;

    @RequestMapping("show")
    public String show(Integer page, Model model){
        int currentPage = coachService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("coaches",coachService.findByPage(currentPage));
        model.addAttribute("mPage",coachService.findMaxPage());
        return "coach/show";
    }

    @RequestMapping("add")
    public String add(){
        return "coach/add";
    }

    @RequestMapping("insert")
    public String insert(Coach coach, @RequestParam("file")MultipartFile file){
        coachService.insert(coach,file);
        return "redirect:show";
    }

    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        model.addAttribute("coach",coachService.findById(id));
        return "coach/edit";
    }

    @RequestMapping("update")
    public String update(Coach coach,@RequestParam("file")MultipartFile file){
        coachService.update(coach,file);
        return "redirect:show";
    }

}
