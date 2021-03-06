package cn.ling.medicalview.mapper;

import cn.ling.medicalview.pojo.Office;
import org.apache.ibatis.annotations.Param;

public interface OfficeMapper {
    /**
     * 通过名称获取科室对象
     * @param offName
     * @return
     */
    Office queryOfficeByName(@Param("offName") String offName);
}
