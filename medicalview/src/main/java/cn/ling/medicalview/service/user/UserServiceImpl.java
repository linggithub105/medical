package cn.ling.medicalview.service.user;

import cn.ling.medicalview.mapper.UserMapper;
import cn.ling.medicalview.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public int deleteUserById(Integer uid) {
        return 0;
    }

    @Override
    public User queryuserById(Integer uid) {
        return null;
    }

    @Override
    public int updatePwd(String userCode, String newPwd, String oldPwd) {
        return 0;
    }

    @Override
    public User queryUserByInfo(String info) {
        //条件构造器
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        queryWrapper.eq("userPhone",info).or().eq("userEmail",info);
        List<User> userlist =list(queryWrapper);
        if(userlist.size()>0){
            return userlist.get(0);
        }
        return null;
    }
}
