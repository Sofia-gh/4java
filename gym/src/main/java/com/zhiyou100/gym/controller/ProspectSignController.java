package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.ProspectSign;
import com.zhiyou100.gym.service.IProspectSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("prospect_sign")
public class ProspectSignController {
    @Autowired
    private IProspectSignService prospectSignService;

    @RequestMapping("show")
    public String show(Integer page, Model model){
        int currentPage = prospectSignService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("prospects",prospectSignService.findByPage(currentPage));
        model.addAttribute("mPage",prospectSignService.findMaxPage());
        return "prospect_sign/show";
    }

    @RequestMapping("sign")
    public String sign(){
        return "prospect_sign/sign";
    }

    @RequestMapping("insert")
    public String insert(ProspectSign prospectSign){
        prospectSignService.insert(prospectSign);
        return "redirect:show";
    }
}
