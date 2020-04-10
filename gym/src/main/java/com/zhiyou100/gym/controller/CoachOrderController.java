package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.CoachOrder;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.ICoachOrderService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("coach_order")
public class CoachOrderController {

    @Autowired
    private ICoachOrderService coachOrderService;

    @RequestMapping("show")
    public String order(CoachOrder coachOrder,Integer page, Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer memberNumber = user.getNumber();
        coachOrder.setMemberNumber(memberNumber);
        int currentPage = coachOrderService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("orders",coachOrderService.findByMemberNumber(currentPage,memberNumber));
        model.addAttribute("mPage",coachOrderService.findMaxPage(coachOrder));
        return "coach_order/show";
    }

    @RequestMapping("order")
    public String order(CoachOrder coachOrder){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        coachOrder.setMemberNumber(user.getNumber());
        coachOrderService.insert(coachOrder);
        return "redirect:/coach/find";
    }

    @RequestMapping("delete")
    public String delete(CoachOrder coachOrder){
        coachOrderService.delete(coachOrder);
        return "redirect:show";
    }
}
