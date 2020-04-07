package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Staff;
import com.zhiyou100.gym.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private IStaffService staffService;

    @RequestMapping("show")
    public String show(Integer page,Model model){
        int currentPage = staffService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("staffs",staffService.findByPage(currentPage));
        model.addAttribute("mPage",staffService.findMaxPage());
        return "staff/show";
    }

    @RequestMapping("add")
    public String add(Model model){
        return "staff/add";
    }

    @RequestMapping("insert")
    public String insert(Staff staff){
        staffService.insert(staff);
        return "redirect:show";
    }

    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        model.addAttribute("staff",staffService.findById(id));
        return "staff/edit";
    }

    @RequestMapping("update")
    public String update(Staff staff){
        staffService.update(staff);
        return "redirect:show";
    }

    @RequestMapping("delete")
    public String delete(Staff staff){
        staffService.delete(staff);
        return "redirect:show";
    }
}
