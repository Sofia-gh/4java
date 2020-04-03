package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.CoachOrder;
import com.zhiyou100.gym.service.ICoachOrderService;
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
        // todo
        Integer memberNumber = 202003001;
        coachOrder.setMemberNumber(memberNumber);
        int currentPage = coachOrderService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("orders",coachOrderService.findByMemberNumber(currentPage,memberNumber));
        model.addAttribute("mPage",coachOrderService.findMaxPage(coachOrder));
        return "coach_order/show";
    }

    @RequestMapping("order")
    public String order(CoachOrder coachOrder){
        coachOrder.setMemberNumber(202003001);
        coachOrderService.insert(coachOrder);
        return "redirect:show";
    }

    @RequestMapping("delete")
    public String delete(CoachOrder coachOrder){
        coachOrderService.delete(coachOrder);
        return "redirect:show";
    }
}
