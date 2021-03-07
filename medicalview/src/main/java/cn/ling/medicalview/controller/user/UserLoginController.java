package cn.ling.medicalview.controller.user;

import cn.ling.medicalview.pojo.User;
import cn.ling.medicalview.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserLoginController {

    @Autowired
    private UserService userService;
    //定义日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("regUserLogin")
    public String regUserLogin(@RequestParam("userInfo")String userInfo,
                               @RequestParam("userPass")String userPass,
                               Model model, HttpSession httpSession){
        /**
         * 使用shiro 进行验证
         */
        //1：获取subject
        Subject subject= SecurityUtils.getSubject();
        //2:封装用户数据
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userInfo,userPass);
        //3:执行登录方法
        try {
            subject.login(usernamePasswordToken);
            //能够获取SimpleAuthenticationInfo  的
            User user = (User)subject.getPrincipal();
            httpSession.setAttribute("session",user);
            //model.addAttribute("userInfo",user);
            return "index";
            //未发生异常，登录成功
        }catch (UnknownAccountException e){
            //账号不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            //密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
}
