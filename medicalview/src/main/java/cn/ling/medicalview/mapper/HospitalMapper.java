package cn.ling.medicalview.mapper;

import cn.ling.medicalview.pojo.Hospital;
import org.apache.ibatis.annotations.Param;

public interface HospitalMapper {
    /**
     * 通过医院名称查询医院对象
     * @return
     */
    Hospital queryHospitalByName(@Param("hospName") String hospName);
}
