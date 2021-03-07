package cn.ling.medicalview.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping({"*/",""})
public class PortalSkipController {
    /**
     * 进入加盟信息填写
     * @return
     */
    @RequestMapping("portal/tojoin")
    public String portaltojoin() {
        return "portal/contact";
    }

    /**
     * 加盟商注册
     * @return
     */
    @RequestMapping("portal/medicalMain")
    public String portalmedicalMain(){
        System.out.println("portal/medicalMain");
        return "hos_index";
    }
    /**
     * 跳转主页面
     * @return
     */
    @RequestMapping("proindex.html")
    public String skipIndex(){
        return "index";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/medicalAdmin")
    public String portalmedicalAdmin(){
        return "hospital/index";
    }
}
