package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Class;
import com.zhiyou100.gym.pojo.ClassOrder;
import com.zhiyou100.gym.service.IClassOrderService;
import com.zhiyou100.gym.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("class_order")
public class ClassOrderController {
    @Autowired
    private IClassService classService;
    @Autowired
    private IClassOrderService classOrderService;

    @RequestMapping("order")
    public String show(Integer page, Model model){
        int currentPage = classService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("classes",classService.findByPage(currentPage));
        model.addAttribute("mPage",classService.findMaxPage());
        return "class_order/order";
    }

    @RequestMapping("insert")
    public String insert(ClassOrder classOrder){
        classOrderService.insert(classOrder);
        return "redirect:show";
    }

    @RequestMapping("show")
    public String order(ClassOrder classOrder, Integer page, Model model){
        // todo
        Integer memberNumber = 202003001;
        classOrder.setMemberNumber(memberNumber);
        int currentPage = classOrderService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("orders",classOrderService.findByMemberNumber(currentPage,memberNumber));
        model.addAttribute("mPage",classOrderService.findMaxPage(classOrder));
        return "class_order/show";
    }

    @RequestMapping("delete")
    public String delete(ClassOrder classOrder){
        classOrderService.delete(classOrder);
        return "redirect:show";
    }
}
