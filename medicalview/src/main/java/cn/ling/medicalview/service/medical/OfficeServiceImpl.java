package cn.ling.medicalview.service.medical;

import cn.ling.medicalview.mapper.OfficeMapper;
import cn.ling.medicalview.pojo.Office;

import javax.annotation.Resource;

public class OfficeServiceImpl implements OfficeService {
    @Resource
    private OfficeMapper officeMapper;

    @Override
    public Office queryOfficeByName(String offName) {
        return officeMapper.queryOfficeByName(offName);
    }
}
