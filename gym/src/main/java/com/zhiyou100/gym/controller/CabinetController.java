package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Cabinet;
import com.zhiyou100.gym.pojo.CabinetInfo;
import com.zhiyou100.gym.service.ICabinetInfoService;
import com.zhiyou100.gym.service.ICabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("cabinet")
public class CabinetController {
    @Autowired
    private ICabinetService cabinetService;
    @Autowired
    private ICabinetInfoService cabinetInfoService;

    @RequestMapping("show")
    public String show(Integer page, Model model){
        int currentPage = cabinetService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("cabinets",cabinetService.findByPage(currentPage));
        model.addAttribute("mPage",cabinetService.findMaxPage());
        return "cabinet/show";
    }

    @RequestMapping("add")
    public String add(){
        return "cabinet/add";
    }

    @RequestMapping("insert")
    public String insert(Cabinet cabinet){
        cabinetService.insert(cabinet);
        return "redirect:show";
    }

    @RequestMapping("edit")
    public String edit(Integer number,Model model){
        model.addAttribute("cabinetNumber",number);
        return "cabinet/edit";
    }

    @RequestMapping("update")
    public String update(CabinetInfo cabinetInfo){
        cabinetInfoService.insert(cabinetInfo);
        return "redirect:show";
    }

    @RequestMapping("info")
    public String info(Integer page,Model model){
        int currentPage = cabinetInfoService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("infos",cabinetInfoService.findByPage(currentPage));
        model.addAttribute("mPage",cabinetInfoService.findMaxPage());
        return "cabinet/info";
    }

    @RequestMapping("delete")
    public String delete(CabinetInfo cabinetInfo){
        cabinetInfoService.update(cabinetInfo);
        return "redirect:info";
    }
}
