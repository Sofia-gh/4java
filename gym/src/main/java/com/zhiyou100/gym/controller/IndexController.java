package com.zhiyou100.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
