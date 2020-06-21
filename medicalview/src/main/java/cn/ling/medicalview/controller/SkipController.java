package cn.ling.medicalview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkipController {
    /**
     * 跳转主页面
     * @return
     */
    @RequestMapping("index.html")
    public String skipIndex(){
        return "index";
    }
    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("login.html")
    public String skipLogin(){
        return "login";
    }
}
