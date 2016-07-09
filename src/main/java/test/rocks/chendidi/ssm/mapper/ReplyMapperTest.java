package test.rocks.chendidi.ssm.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rocks.chendidi.ssm.mapper.ArticleMapper;
import rocks.chendidi.ssm.mapper.ReplyMapper;
import rocks.chendidi.ssm.pojo.Article;
import rocks.chendidi.ssm.pojo.Reply;
import rocks.chendidi.ssm.pojo.ReplyExample;

import java.util.List;

/**
 * Created by lenov0 on 2016/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/config/spring/applicationContext-*.xml", "classpath*:/config/spring/springmvc.xml"})
public class ReplyMapperTest {

    @Autowired
    private ReplyMapper replyMapper;

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
    public void testSelectByPage() throws Exception {
//TODO: Test goes here...
      /*  List<Reply> list = replyMapper.selectByPage(0,4,"1");
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i).getArticleid());
        }*/
    }

    @Test
    public void testCountByExample() throws Exception {
      /*  ReplyExample replyExample = new ReplyExample();
        ReplyExample.Criteria criteria = replyExample.createCriteria();
        criteria.andArticleidEqualTo("1");
        System.out.println(replyMapper.countByExample(replyExample));*/
    }
    @Test
    public  void  testInsert() throws Exception{
        Reply reply = new Reply();
        reply.setArticleid("test");
        reply.setReply("test");
        reply.setUserid("test");
        reply.setUsername("test");
        System.out.println(replyMapper.insert(reply));

    }
}
