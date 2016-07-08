package test.rocks.chendidi.ssm.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rocks.chendidi.ssm.mapper.UserMapper;

/**
 * Created by lenov0 on 2016/7/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/config/spring/applicationContext-*.xml", "classpath*:/config/spring/springmvc.xml"})
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: checkUserId(String userid)
     */
    @Test
    public void testCheckUserId() throws Exception {
//TODO: Test goes here...
     //   System.out.println(userMapper.selectUser("123").size());
    }

}
