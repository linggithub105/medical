package cn.ling.medicalview.service.medical;

import cn.ling.medicalview.dto.ExcelDoctorMode;
import cn.ling.medicalview.mapper.DoctorMapper;
import cn.ling.medicalview.mapper.HospitalMapper;
import cn.ling.medicalview.mapper.OfficeMapper;
import cn.ling.medicalview.pojo.Doctor;
import cn.ling.medicalview.pojo.Office;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.print.PrinterException;
import java.util.List;

@Service("doctorServiceImpl")
public class DoctorServiceImpl implements DoctorService {
    private Logger logger=Logger.getLogger(DoctorServiceImpl.class);
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private HospitalMapper hospitalMapper;
    @Resource
    private OfficeMapper officeMapper;

    @Override
    @Transactional(rollbackFor = Exception.class) //自定义异常事务回滚
    public int insertDoctor(List<ExcelDoctorMode> list) throws Exception {
        Doctor doctor = new Doctor();
        if (list.size() > 0) {
            try {
                for (ExcelDoctorMode excelDoctorMode : list) {
                    System.out.println("excelDoctorMode:--?" + excelDoctorMode);
                    //根据医院名 获取 医院id
                    int hospId=hospitalMapper.queryHospitalByName(excelDoctorMode.getHospitalName()).getHid();
                    //根据科室名称 获取科室id
                    int offId=officeMapper.queryOfficeByName(excelDoctorMode.getOfficeName()).getOid();

                    doctor.setHid(hospId);
                    doctor.setOid(offId);

                    doctorMapper.insertDoctor(doctor);
                }
            }catch (Exception e){
                //捕获异常，并作出弹框提示错误
                throw new Exception("批量导入出错");
            }
        }
        return 0;
    }

    @Override
    public List<Doctor> getDoctorInfoList(Integer hid, String officeName) {
        return doctorMapper.getDoctorInfoList(hid,officeName);
    }
}
