package cn.ling.medicalview.mapper;

import cn.ling.medicalview.pojo.log.SysLog;
import org.apache.ibatis.annotations.Insert;

public interface SysLogMapper {
    /**
     * 添加日志
     * @param syslog
     * @return
     */
    @Insert("insert into sys_log (username,operation,time,method,params,ip,createtime) values (#{userName},#{operation},#{time},#{method},#{params},#{ip},#{createTime})")
    int saveSysLog(SysLog syslog);
}
