package cn.ling.medicalview.service.medical;

import cn.ling.medicalview.dto.ExcelDoctorMode;
import cn.ling.medicalview.pojo.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DoctorService {
    /**
     * 插入信息对象
     * @param
     * @return
     */
    int insertDoctor(List<ExcelDoctorMode> list) throws Exception;
}
