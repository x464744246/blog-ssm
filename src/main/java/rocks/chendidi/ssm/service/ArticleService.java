package rocks.chendidi.ssm.service;

import rocks.chendidi.ssm.model.Page;
import rocks.chendidi.ssm.pojo.Article;

import java.util.List;

/**
 * Created by lenov0 on 2016/7/7.
 */
public interface ArticleService {

    List<Article> getByPage(int page , int size);
    Page getPage(int page);
}
