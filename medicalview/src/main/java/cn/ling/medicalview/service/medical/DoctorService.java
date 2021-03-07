package cn.ling.medicalview.service.medical;

import cn.ling.medicalview.dto.ExcelDoctorMode;
import cn.ling.medicalview.pojo.Doctor;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 获取某家医院的某科室-医生信息
     * @param hid
     * @param officeName
     * @return
     */
    List<Doctor> getDoctorInfoList(Integer hid, String officeName);
}
