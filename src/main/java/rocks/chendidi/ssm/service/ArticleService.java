package rocks.chendidi.ssm.service;

import rocks.chendidi.ssm.model.Page;
import rocks.chendidi.ssm.pojo.Article;
import rocks.chendidi.ssm.pojo.Photo;

import java.util.List;

/**
 * Created by lenov0 on 2016/7/7.
 */
public interface ArticleService {

    Article getById(Article article);

    List<Article> getByPage(int page , int size);

    Page getPage(int page);

    int deleteArticle(Article article);

    int addArticle(Article article);

    int addPhoto(Photo photo);

    List<Photo> getPhotos(String articleid);

}
