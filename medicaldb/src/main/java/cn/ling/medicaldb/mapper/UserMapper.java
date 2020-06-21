package cn.ling.medicaldb.mapper;

import cn.ling.medicalbeans.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户模块
 */
@Repository
public interface UserMapper {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);
    /**
     * 删除用户
     * @param uid
     * @return
     */
    int deleteUserById(@Param("uid") Integer uid);

    /**
     * 通过id 查询用户
     * @param uid
     * @return
     */
    User queryuserById(@Param("uid") Integer uid);
}
