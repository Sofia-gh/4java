package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Member;
import com.zhiyou100.gym.service.ICardService;
import com.zhiyou100.gym.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("member")
public class MemberController {
    @Autowired
    private IMemberService memberService;
    @Autowired
    private ICardService cardService;

    @RequestMapping("show")
    public String show(Integer page,String key, Model model){
        int currentPage = memberService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("key",key);
        model.addAttribute("members",memberService.findByPage(currentPage,key));
        model.addAttribute("mPage",memberService.findMaxPage(key));
        return "member/show";
    }

    @RequestMapping("add")
    public String add(Model model){
        model.addAttribute("cards",cardService.findAll());
        return "member/add";
    }

    @RequestMapping("insert")
    public String insert(Member member){
        memberService.insert(member);
        return "redirect:show";
    }

    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        model.addAttribute("member",memberService.findById(id));
        model.addAttribute("cards",cardService.findAll());
        return "member/edit";
    }

    @RequestMapping("update")
    public String update(Member member){
        memberService.update(member);
        return "redirect:show";
    }

    @RequestMapping("delete")
    public String delete(Member member){
        memberService.delete(member);
        return "redirect:show";
    }

    @RequestMapping("member")
    public String member(Model model,Integer number){
        model.addAttribute("member",memberService.findByNumber(number));
        return "member/member";
    }
}
