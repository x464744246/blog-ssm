package rocks.chendidi.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.chendidi.ssm.mapper.UserMapper;
import rocks.chendidi.ssm.pojo.User;
import rocks.chendidi.ssm.service.UserService;

import java.util.List;

/**
 * Created by lenov0 on 2016/7/6.
 */
@Service
public class UserServiceImpl implements UserService {

    //User接口
    @Autowired
    private UserMapper userMapper;

    public List<User> queryUsers() throws Exception {
        //调用mapper类中的selectByExample方法，如果传入类型为null，则表示无条件查找
        List<User> users = userMapper.selectByExample(null);

        return users;
    }


    public User findUser(User user) throws Exception {
        //调用mapper类中的selectByExample方法，如果传入类型为null，则表示无条件查找
        User u = userMapper.selectByPrimaryKey(user.getUserid());

        if (user.getPassword().equals(u.getPassword()))
            return u;
        else
            return null;
    }
}
