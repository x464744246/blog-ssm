package test.rocks.chendidi.ssm.service.impl;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rocks.chendidi.ssm.service.RegisterService;

/**
 * RegisterServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 7, 2016</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/config/spring/applicationContext-*.xml", "classpath*:/config/spring/springmvc.xml"})
public class RegisterServiceImplTest {
    @Autowired
    private RegisterService registerService;
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
        System.out.println(registerService.checkUserId("123"));
    }


} 
