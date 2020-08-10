package cn.ling.medicalview.controller;

import cn.ling.medicalview.pojo.User;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

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
    /**
     * 跳转未授权页面
     * @return
     */
    @RequestMapping("noAuth")
    public String noAuth(){
        return "noAuth";
    }

    /**
     * 根据用户类型 进入不同的页面
     * @param userInfo
     * @return
     */
    @RequestMapping("choiceinto/{userInfo}")
    public String choiceinto(@PathVariable("userInfo")Integer userInfo){
        if(userInfo==0){
            //此用户为管理员
            return "admin/index";
        }else if(userInfo==1){
            //此用户为普通用户
            return "usercenter/index";
        }else if(userInfo==2){
            //此用户为加盟商医院
            return "hospital/index";
        }
        return "error";
    }

    @RequestMapping("blog/intomain")
    public String blogintomain(){
        return "usercenter/blogshow/index";
    }
}
