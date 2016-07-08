package test.rocks.chendidi.ssm.service.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rocks.chendidi.ssm.service.ArticleService;

/** 
* ArticleServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ÆßÔÂ 8, 2016</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/config/spring/applicationContext-*.xml", "classpath*:/config/spring/springmvc.xml"})
public class ArticleServiceImplTest {
    @Autowired
    ArticleService articleService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getByPage(int page, int size) 
* 
*/ 
@Test
public void testGetByPage() throws Exception { 
//TODO: Test goes here...
    //articleService.getByPage(10,10)
} 


} 
