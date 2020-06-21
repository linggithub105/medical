package cn.ling.medicalview.service;

import cn.ling.medicalbeans.pojo.User;
import cn.ling.medicaldb.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    @Transactional
    /**
     * 先修改数据库
     * 在进行查询缓存
     */
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return userMapper.queryuserById(user.getId());
    }

    @Override
    //方法 设置事务
    @Transactional(rollbackFor = Exception.class)//自定义异常的处理
    public int deleteUserById(Integer uid) {
        int result = -1;
        try {
            result = userMapper.deleteUserById(uid);
            //int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            //throw new RuntimeException();
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public User queryuserById(Integer uid) {
        return userMapper.queryuserById(uid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int upodatePwd(String userCode, String newPwd, String oldPwd) {
        try {
            /*User user = this.queryUserByCode(userCode);
            if (user != null) {
                if (user.getUserPassword().equals(oldPwd)) {
                    *//*if (userMapper.upodatePwd(userCode, newPwd) == 1) {
                        //int i = 1 / 0;
                        return 1;
                    }*//*
                } else {
                    return 0;
                }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return -1;
    }
}
