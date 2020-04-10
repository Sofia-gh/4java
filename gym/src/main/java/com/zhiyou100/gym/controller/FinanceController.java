package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.service.IFinanceService;
import com.zhiyou100.gym.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("finance")
public class FinanceController {

    @Autowired
    private IFinanceService financeService;

    @RequestMapping("form")
    public ResponseUtil form(){
        return ResponseUtil.success(financeService.find());
    }
}
