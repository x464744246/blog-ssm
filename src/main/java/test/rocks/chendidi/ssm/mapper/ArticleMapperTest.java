package test.rocks.chendidi.ssm.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rocks.chendidi.ssm.mapper.ArticleMapper;
import rocks.chendidi.ssm.pojo.Article;

import java.util.List;

/**
 * Created by lenov0 on 2016/7/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/config/spring/applicationContext-*.xml", "classpath*:/config/spring/springmvc.xml"})
public class ArticleMapperTest {
    @Autowired
    private ArticleMapper articleMapper;
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
      /*  List<Article> list = articleMapper.selectByPage(2,1);

        //List<Article> list = articleMapper.selectByExample(null);
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i).getArticleid());
        }*/
    }

    @Test
    public void testInsert() throws Exception {
//TODO: Test goes here...
        Article article = new Article();
        article.setUsername("qqqq");
        article.setUserid("qqqq");
        article.setArticle("qqqq");
        article.setTitle("qqqq");
        articleMapper.insert(article);


    }
}
