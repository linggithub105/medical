package cn.ling.medical2.service;


import cn.ling.medical2.pojo.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "userCache")
public interface UserService {
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
    @CachePut(value = "user",key = "'queryuserById_'+#user.id")
    User updateUser(User user);

    /**
     * 删除用户
     * @param uid
     * @return
     */
    //你缓存的Key名字是：xxxx，你要去删：bbbb，能删掉？
    @CacheEvict(value = "user",key = "'queryuserById_'+#uid")
    int deleteUserById(Integer uid);
    /**
     * 通过id 查询用户
     * @param uid
     * @return
     */
    //自定义指定键  那么配置文件中的自定义无效了
    @Cacheable(value = "user",key = "'queryuserById_'+#uid")
    User queryuserById(Integer uid);
    /**
     * 修改用户密码
     * @param userCode
     * @param newPwd
     * @return
     */
    int upodatePwd(String userCode, String newPwd, String oldPwd);
}
