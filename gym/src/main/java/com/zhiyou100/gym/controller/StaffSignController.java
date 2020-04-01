package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.StaffSign;
import com.zhiyou100.gym.service.IStaffSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("staff_sign")
public class StaffSignController {
    @Autowired
    private IStaffSignService staffSignService;

    @RequestMapping("show")
    public String show(Integer page, Model model){
        int currentPage = staffSignService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("staffs",staffSignService.findByPage(currentPage));
        model.addAttribute("mPage",staffSignService.findMaxPage());
        return "staff_sign/show";
    }

    @RequestMapping("sign")
    public String sign(){
        return "staff_sign/sign";
    }

    @RequestMapping("insert")
    public String insert(StaffSign staffSign){
        staffSignService.insert(staffSign);
        return "redirect:show";
    }
}
