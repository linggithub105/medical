package cn.ling.medicalview.mapper;

import cn.ling.medicalview.pojo.Doctor;
import cn.ling.medicalview.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

}
