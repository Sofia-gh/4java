package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.MemberSign;
import com.zhiyou100.gym.pojo.MemberTrain;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.IMemberSignService;
import com.zhiyou100.gym.service.IMemberTrainService;
import com.zhiyou100.gym.util.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        int currentPage = memberTrainService.findCurrentPage(page);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("trains",memberTrainService.findByPage(currentPage,user.getNumber()));
        model.addAttribute("mPage",memberTrainService.findMaxPage(user.getNumber()));
        return "member_train/show";
    }

    @RequestMapping("start")
    public String start(){
        return "member_train/start";
    }

    @RequestMapping("insert")
    public String insert(MemberTrain memberTrain,Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        memberTrain.setMemberNumber(user.getNumber());
        model.addAttribute("id",memberTrainService.insert(memberTrain));
        return "member_train/end";
    }

    @RequestMapping("end")
    public String end(MemberTrain memberTrain){
        memberTrainService.update(memberTrain);
        return "redirect:show";
    }

    @ResponseBody
    @RequestMapping("form")
    public ResponseUtil form(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Double> list = memberTrainService.findAll(user.getNumber());
        return ResponseUtil.success(list);
    }

}
