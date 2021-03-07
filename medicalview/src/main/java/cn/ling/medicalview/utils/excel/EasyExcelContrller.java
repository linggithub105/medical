package cn.ling.medicalview.utils.excel;

import cn.ling.medicalview.Listener.ModelDoctorExcelListener;
import cn.ling.medicalview.dto.ExcelDoctorMode;
import cn.ling.medicalview.service.medical.DoctorService;
import com.alibaba.excel.EasyExcel;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *   EasyExcel
 */
@Controller
@RequestMapping("excel")
public class EasyExcelContrller {
    /**
     * spring ioc 只可通过Controller 拿去Service的值
     */
    @Resource
    private DoctorService doctorService;
    /**
     * 文件上传
     * <p>1. 创建excel对应的实体对象 参照{@link ExcelDoctorMode}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link ExcelDoctorMode}
     * <p>3. 直接读即可
     */
    @PostMapping("uploadModelDoctorExcel")
    @ResponseBody
    public Map upload(MultipartFile file) throws IOException {
        Map map=new HashMap();
        EasyExcel.read(file.getInputStream(), ExcelDoctorMode.class, new ModelDoctorExcelListener(doctorService)).sheet().doRead();
        map.put("key","success");
        return map;
    }

}
