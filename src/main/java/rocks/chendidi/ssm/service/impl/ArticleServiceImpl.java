package rocks.chendidi.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.chendidi.ssm.mapper.ArticleMapper;
import rocks.chendidi.ssm.model.Page;
import rocks.chendidi.ssm.pojo.Article;
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

    public List<Article> getByPage(int page, int size) {
        int currentRow = (page-1)*size;
        return articleMapper.selectByPage(currentRow,size);
    }

    public Page getPage(int page) {
        Page p = new Page();
        p.setCurrent(page);
        p.setTotlePage((articleMapper.countByExample(null)/ PublicValue.PAGESIZE)+1);
        p.setPerPage();
        return p;
    }
}
