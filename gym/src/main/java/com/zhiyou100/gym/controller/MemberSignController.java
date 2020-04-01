package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.MemberSign;
import com.zhiyou100.gym.service.IMemberSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("member_sign")
public class MemberSignController {
    @Autowired
    private IMemberSignService memberSignService;

    @RequestMapping("show")
    public String show(Integer page, Model model){
        int currentPage = memberSignService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("members",memberSignService.findByPage(currentPage));
        model.addAttribute("mPage",memberSignService.findMaxPage());
        return "member_sign/show";
    }

    @RequestMapping("sign")
    public String sign(){
        return "member_sign/sign";
    }

    @RequestMapping("insert")
    public String insert(MemberSign memberSign){
        memberSignService.insert(memberSign);
        return "redirect:show";
    }

    @RequestMapping("out")
    public String out(MemberSign memberSign){
        memberSignService.update(memberSign);
        return "redirect:show";
    }
}
