package cn.ling.medicalview.controller.user;

import cn.ling.medicalview.pojo.User;
import cn.ling.medicalview.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    /**
     * 我的主页管理
     *
     * @return PathVariable  用于解析Restful  只可get请求
     */
    @RequestMapping("/myintegral/{uid}")
    public String usermyintegral(@PathVariable("uid") Integer uid, Model model) {
        User user = userService.queryuserById(uid);
        model.addAttribute("userInfo", user);
        logger.info(user.getUsercode() + ";余额：" + user.getBalance() + ";积分：" + user.getIntegral());
        return "usercenter/pageshow/platformindex";
    }

    /**
     * 进入转盘活动
     * @return
     */
    @RequestMapping("intoTurntable/{uid}")
    public String intoTurntable(@PathVariable("uid")Integer uid, Model model){
        model.addAttribute("uid",uid);
        return "usercenter/pageshow/integralindex";
    }

    /**
     * ajax请求
     * @param num
     * @return
     */
    @RequestMapping("numberCalculate/ajax/{uid}/{num}")
    @ResponseBody //以json格式响应
    public Map<String, String> numberCalculate(@PathVariable("uid") Integer uid, @PathVariable("num") String num) {
       return null;//userService.numberCalculate(uid,num);
    }
}
