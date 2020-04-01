package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.MemberSign;
import com.zhiyou100.gym.pojo.MemberTrain;
import com.zhiyou100.gym.service.IMemberSignService;
import com.zhiyou100.gym.service.IMemberTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("member_train")
public class MemberTrainController {
    @Autowired
    private IMemberTrainService memberTrainService;

    @RequestMapping("show")
    public String show(Integer page, Model model){
        int currentPage = memberTrainService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("trains",memberTrainService.findByPage(currentPage));
        model.addAttribute("mPage",memberTrainService.findMaxPage());
        return "member_train/show";
    }

    @RequestMapping("start")
    public String start(){
        return "member_train/start";
    }

    @RequestMapping("insert")
    public String insert(MemberTrain memberTrain,Model model){
        model.addAttribute("id",memberTrainService.insert(memberTrain));
        return "member_train/end";
    }

    @RequestMapping("end")
    public String end(MemberTrain memberTrain){
        memberTrainService.update(memberTrain);
        // todo 返回会员首页
        return "redirect:show";
    }
}
