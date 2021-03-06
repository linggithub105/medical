package cn.ling.medicalview.service.medical;

import cn.ling.medicalview.pojo.Office;
import org.apache.ibatis.annotations.Param;

public interface OfficeService {
    /**
     * 通过名称获取科室对象
     * @param offName
     * @return
     */
    Office queryOfficeByName(String offName);
}
