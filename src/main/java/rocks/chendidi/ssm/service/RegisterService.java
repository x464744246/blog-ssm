package rocks.chendidi.ssm.service;

import rocks.chendidi.ssm.pojo.User;

/**
 * Created by lenov0 on 2016/7/7.
 */
public interface RegisterService {

    int checkUserId(String userid) throws Exception ;

    int addUser(User user) throws Exception;
}
