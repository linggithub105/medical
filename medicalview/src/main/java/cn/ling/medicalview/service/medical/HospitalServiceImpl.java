package cn.ling.medicalview.service.medical;

import cn.ling.medicalview.mapper.HospitalMapper;
import cn.ling.medicalview.pojo.Hospital;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("hospitalServiceImpl")
public class HospitalServiceImpl implements HospitalService {
    @Resource
    private HospitalMapper hospitalMapper;

    @Override
    public Hospital queryHospitalByName(String hospName) {
        return hospitalMapper.queryHospitalByName(hospName);
    }
}
