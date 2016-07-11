package rocks.chendidi.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.chendidi.ssm.mapper.ArticleMapper;
import rocks.chendidi.ssm.model.Page;
import rocks.chendidi.ssm.pojo.Article;
import rocks.chendidi.ssm.pojo.ArticleExample;
import rocks.chendidi.ssm.service.ArticleService;
import rocks.chendidi.ssm.util.PublicValue;

import java.util.List;

/**
 * Created by lenov0 on 2016/7/8.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public Article getById(Article article) {

        return articleMapper.selectByPrimaryKey(article.getArticleid());

    }

    public List<Article> getByPage(int page, int size) {

        if (page == 0)
            page = (articleMapper.countByExample(null) / PublicValue.PAGESIZE) + 1;
        if (page == -1)
            page = 1;
        int currentRow = (page - 1) * size;
        return articleMapper.selectByPage(currentRow, size);
    }

    public Page getPage(int page) {
        Page p = new Page();
        if (page == 0) {
            page = (articleMapper.countByExample(null) / PublicValue.PAGESIZE) + 1;
            p.setCurrent(page);
        } else if (page == -1) {
            page = 1;
            p.setCurrent(page);
        } else
            p.setCurrent(page);
        p.setTotlePage((articleMapper.countByExample(null) / PublicValue.PAGESIZE) + 1);
        p.setPerPage();
        return p;
    }

    public int deleteArticle(Article article) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleidEqualTo(article.getArticleid());
        return articleMapper.deleteByExample(articleExample);
    }

    public int addArticle(Article article) {
        return articleMapper.insert(article);
    }
}
