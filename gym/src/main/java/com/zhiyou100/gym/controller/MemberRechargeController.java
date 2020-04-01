package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.MemberRecharge;
import com.zhiyou100.gym.service.IMemberRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("member_recharge")
public class MemberRechargeController {
    @Autowired
    private IMemberRechargeService memberRechargeService;

    @RequestMapping("show")
    public String show(Integer page, Model model){
        int currentPage = memberRechargeService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("recharges",memberRechargeService.findByPage(currentPage));
        model.addAttribute("mPage",memberRechargeService.findMaxPage());
        return "member_recharge/show";
    }

    @RequestMapping("recharge")
    public String sign(){
        return "member_recharge/recharge";
    }

    @RequestMapping("insert")
    public String insert(MemberRecharge memberRecharge){
        memberRechargeService.insert(memberRecharge);
        return "redirect:show";
    }
}
