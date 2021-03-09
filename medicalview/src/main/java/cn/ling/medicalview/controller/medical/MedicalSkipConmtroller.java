package cn.ling.medicalview.controller.medical;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping({"hospital/"})
public class MedicalSkipConmtroller {

    /**
     * 跳转医院综合管理
     * @return
     */
    @RequestMapping("Management")
    public String hospitalManagement() {
        return "hospital/child";
    }
    /**
     * 跳转医院医生添加
     * @return
     */
    @RequestMapping("YuanGong_tj")
    public String hospitalYuanGong_tj(){
        return "hospital/YuanGong_tj";
    }

}
