package rocks.chendidi.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.chendidi.ssm.mapper.UserMapper;
import rocks.chendidi.ssm.pojo.User;
import rocks.chendidi.ssm.pojo.UserExample;
import rocks.chendidi.ssm.service.RegisterService;

/**
 * Created by lenov0 on 2016/7/7.
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    //User接口
    @Autowired
    private UserMapper userMapper;

    public int checkUserId(String userid) throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        int count = userMapper.countByExample(example);

        return count;
    }

    public int addUser(User user) throws Exception {

        return userMapper.insert(user);
    }
}
