package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Achievement;
import com.zhiyou100.gym.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("achievement")
public class AchievementController {
    @Autowired
    private IAchievementService achievementService;

    @RequestMapping("show")
    public String show(Integer page,Model model){
        int currentPage = achievementService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("achievements",achievementService.findByPage(currentPage));
        model.addAttribute("mPage",achievementService.findMaxPage());
        return "achievement/show";
    }

    @RequestMapping("add")
    public String add(Model model){
        return "achievement/add";
    }

    @RequestMapping("insert")
    public String insert(Achievement achievement){
        achievementService.insert(achievement);
        return "redirect:show";
    }

    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        model.addAttribute("achievement",achievementService.findById(id));
        return "achievement/edit";
    }

    @RequestMapping("update")
    public String update(Achievement achievement){
        achievementService.update(achievement);
        return "redirect:show";
    }

    @RequestMapping("delete")
    public String delete(Achievement achievement){
        achievementService.delete(achievement);
        return "redirect:show";
    }
}
