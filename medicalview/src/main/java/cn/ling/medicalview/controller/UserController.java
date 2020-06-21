package cn.ling.medicalview.controller;

import cn.ling.medicalbeans.pojo.User;
import cn.ling.medicalview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//@Controller
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/queryUser/{uid}")
    public User queryUser(@PathVariable Integer uid){
        System.out.println(1111111);
        return userService.queryuserById(uid);
    }
}
