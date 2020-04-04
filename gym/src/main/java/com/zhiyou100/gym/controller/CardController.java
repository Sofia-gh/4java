package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Card;
import com.zhiyou100.gym.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("card")
public class CardController {
    @Autowired
    private ICardService cardService;

    @RequestMapping("show")
    public String show(Integer page, Model model){
        int currentPage = cardService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("cards",cardService.findByPage(currentPage));
        model.addAttribute("mPage",cardService.findMaxPage());
        return "card/show";
    }

    @RequestMapping("add")
    public String add(){
        return "card/add";
    }

    @RequestMapping("insert")
    public String insert(Card card){
        cardService.insert(card);
        return "redirect:show";
    }

    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        model.addAttribute("card",cardService.findById(id));
        return "card/edit";
    }

    @RequestMapping("update")
    public String update(Card card){
        cardService.update(card);
        return "redirect:show";
    }

    @RequestMapping("delete")
    public String delete(Card card){
        cardService.delete(card);
        return "redirect:show";
    }
}
