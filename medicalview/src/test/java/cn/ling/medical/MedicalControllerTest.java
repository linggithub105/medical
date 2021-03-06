package cn.ling.medical;

import cn.ling.medicalview.Listener.ModelDoctorExcelListener;
import cn.ling.medicalview.MedicalviewApplication;
import cn.ling.medicalview.dto.ExcelDoctorMode;
import cn.ling.medicalview.service.medical.DoctorService;
import com.alibaba.excel.EasyExcel;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import cn.ling.medical.MedicalviewApplicationTest;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MedicalviewApplication.class)
public class MedicalControllerTest {
    @Resource
    private DoctorService doctorService;
    /**
     * 读取Excel
     */
    @Test
    public void readExcel() {
        String fileName="E:\\Users\\workflow\\medical2\\medicalview\\src\\main\\resources\\static\\excel"+ File.separator+"DoctorModelUpdown.xlsx";
        System.out.println(11+fileName);
        EasyExcel.read(fileName,ExcelDoctorMode.class,new ModelDoctorExcelListener(doctorService)).sheet().doRead();
    }
}
