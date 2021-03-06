package cn.ling.medicalview.Listener;

import cn.ling.medicalview.dto.ExcelDoctorMode;
import cn.ling.medicalview.service.medical.DoctorService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ModelDoctorExcelListener extends AnalysisEventListener<ExcelDoctorMode> {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    //创建空对象
    private DoctorService doctorService;
    /**
     * 自定义构造方法 注入 doctorService
     * @param doctorService
     */
    public ModelDoctorExcelListener(DoctorService doctorService){
        this.doctorService=doctorService;
    }

    /**
     * 批处理阈值
     */
    private static final int BATCH_COUNT = 5;
    List<ExcelDoctorMode> list = new ArrayList<ExcelDoctorMode>(BATCH_COUNT);

    @Override
    public void invoke(ExcelDoctorMode user, AnalysisContext analysisContext) {
        logger.info("解析到一条数据:{}", JSON.toJSONString(user));
        list.add(user);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        logger.info("所有数据解析完成！");
    }

    private void saveData(){
        try {
            doctorService.insertDoctor(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("{}条数据，开始存储数据库！", list.size());
        logger.info("存储数据库成功！");
    }
}
