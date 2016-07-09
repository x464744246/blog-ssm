package test.rocks.chendidi.ssm.service.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rocks.chendidi.ssm.model.Page;
import rocks.chendidi.ssm.service.ReplyService;

/** 
* ReplyServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ÆßÔÂ 9, 2016</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/config/spring/applicationContext-*.xml", "classpath*:/config/spring/springmvc.xml"})
public class ReplyServiceImplTest {
    @Autowired
    ReplyService replyService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getByPage(int page, int size, String articleid) 
* 
*/ 
@Test
public void testGetByPage() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getPage(int page, String articleid) 
* 
*/ 
@Test
public void testGetPage() throws Exception { 
//TODO: Test goes here...
    Page page = replyService.getPage(1,"1");
    System.out.println(page.getCurrent());
    System.out.println(page.getPerPage());
    System.out.println(page.getTotlePage());


} 


} 
