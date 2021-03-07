package cn.ling.medicalview.mapper;

import cn.ling.medicalview.pojo.Doctor;
import cn.ling.medicalview.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 医生模块
 *
 */
//@Repository
public interface DoctorMapper {
    /**
     * 插入信息对象
     * @param doctor
     * @return
     */
    int insertDoctor(Doctor doctor);

    /**
     * 获取某家医院的某科室-医生信息
     * @param hid
     * @param officeName
     * @return
     */
    List<Doctor> getDoctorInfoList(@Param("hid") Integer hid, @Param("officeName") String officeName);
}
