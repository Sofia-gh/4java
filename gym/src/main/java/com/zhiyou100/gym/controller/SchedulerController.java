package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Scheduler;
import com.zhiyou100.gym.pojo.Staff;
import com.zhiyou100.gym.service.ISchedulerService;
import com.zhiyou100.gym.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("scheduler")
public class SchedulerController {
    @Autowired
    private ISchedulerService schedulerService;

    @RequestMapping("show")
    public String show(Integer page,Model model){
        int currentPage = schedulerService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("schedulers",schedulerService.findByPage(currentPage));
        model.addAttribute("mPage",schedulerService.findMaxPage());
        return "scheduler/show";
    }

    @RequestMapping("add")
    public String add(Model model){
        return "scheduler/add";
    }

    @RequestMapping("insert")
    public String insert(Scheduler scheduler){
        schedulerService.insert(scheduler);
        return "redirect:show";
    }

    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        model.addAttribute("scheduler",schedulerService.findById(id));
        return "scheduler/edit";
    }

    @RequestMapping("update")
    public String update(Scheduler scheduler){
        schedulerService.update(scheduler);
        return "redirect:show";
    }

    @RequestMapping("delete")
    public String delete(Scheduler scheduler){
        schedulerService.delete(scheduler);
        return "redirect:show";
    }
}
