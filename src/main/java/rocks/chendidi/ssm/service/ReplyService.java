package rocks.chendidi.ssm.service;

import rocks.chendidi.ssm.model.Page;
import rocks.chendidi.ssm.pojo.Reply;

import java.util.List;

/**
 * Created by lenov0 on 2016/7/9.
 */
public interface ReplyService {

    List<Reply> getByPage(int page , int size , String articleid );

    Page getPage(int page  , String articleid );

    int addReply(Reply reply);
}
