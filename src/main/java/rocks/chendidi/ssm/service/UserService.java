package rocks.chendidi.ssm.service;

/**
 * Created by lenov0 on 2016/7/6.
 */

import rocks.chendidi.ssm.pojo.User;

import java.util.List;

public  interface UserService {

    /**
     * 查找所有用户
     * @return
     * @throws Exception
     */
    List<User> findUser()throws Exception;
}
