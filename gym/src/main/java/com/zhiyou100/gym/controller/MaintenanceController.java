package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Maintenance;
import com.zhiyou100.gym.service.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("maintenance")
public class MaintenanceController {
    @Autowired
    private IMaintenanceService maintenanceService;

    @RequestMapping("show")
    public String show(Integer page,Model model){
        int currentPage = maintenanceService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("maintenances",maintenanceService.findByPage(currentPage));
        model.addAttribute("mPage",maintenanceService.findMaxPage());
        return "maintenance/show";
    }

    @RequestMapping("add")
    public String add(Model model){
        return "maintenance/add";
    }

    @RequestMapping("insert")
    public String insert(Maintenance maintenance){
        maintenanceService.insert(maintenance);
        return "redirect:show";
    }

    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        model.addAttribute("maintenance",maintenanceService.findById(id));
        return "maintenance/edit";
    }

    @RequestMapping("update")
    public String update(Maintenance maintenance){
        maintenanceService.update(maintenance);
        return "redirect:show";
    }

    @RequestMapping("delete")
    public String delete(Maintenance maintenance){
        maintenanceService.delete(maintenance);
        return "redirect:show";
    }
}
