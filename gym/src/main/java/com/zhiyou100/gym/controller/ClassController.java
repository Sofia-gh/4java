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
@RequestMapping("class")
public class ClassController {
    @Autowired
    private IClassService classService;
    @Autowired
    private IClassOrderService classOrderService;

    @RequestMapping("show")
    public String show(Integer page, Model model){
        int currentPage = classService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("classes",classService.findByPage(currentPage));
        model.addAttribute("mPage",classService.findMaxPage());
        return "class/show";
    }

    @RequestMapping("add")
    public String add(){
        return "class/add";
    }

    @RequestMapping("insert")
    public String insert(Class c){
        classService.insert(c);
        return "redirect:show";
    }

    @RequestMapping("start")
    public String start(Class c){
        classService.start(c);
        return "redirect:show";
    }

    @RequestMapping("end")
    public String end(Class c){
        classService.end(c);
        return "redirect:show";
    }

    @RequestMapping("order")
    public String order(ClassOrder classOrder, Integer page, Model model){
        int currentPage = classOrderService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("classNumber",classOrder.getClassNumber());
        model.addAttribute("orders",classOrderService.findByPage(currentPage,classOrder));
        model.addAttribute("mPage",classOrderService.findMaxPage(classOrder));
        return "class/order";
    }
}
