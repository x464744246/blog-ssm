package test.rocks.chendidi.ssm.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rocks.chendidi.ssm.service.UserService;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 6, 2016</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/config/spring/applicationContext-*.xml", "classpath*:/config/spring/springmvc.xml"})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Before
    public void before() throws Exception {
        System.out.println("hello");
    }

    @After
    public void after() throws Exception {
        System.out.println("nice");
    }

    /**
     * Method: findUser()
     */
    @Test
    public void testFindUser() throws Exception {
//TODO: Test goes here...

        System.out.println(userService.findUser());


    }


}
