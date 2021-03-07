package cn.ling.medicalview.mapper;

import cn.ling.medicalview.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户模块
 */
//@Repository   //用户模块使用mybatis plus
public interface UserMapper extends BaseMapper<User> {

}
