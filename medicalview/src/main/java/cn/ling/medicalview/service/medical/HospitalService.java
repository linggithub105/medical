package cn.ling.medicalview.service.medical;

import cn.ling.medicalview.pojo.Hospital;
import org.apache.ibatis.annotations.Param;

public interface HospitalService {
    /**
     * 通过医院名称查询医院对象
     * @return
     */
    Hospital queryHospitalByName(String hospName);
}
