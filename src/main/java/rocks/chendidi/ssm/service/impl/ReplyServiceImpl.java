package rocks.chendidi.ssm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.chendidi.ssm.mapper.ReplyMapper;
import rocks.chendidi.ssm.model.Page;
import rocks.chendidi.ssm.pojo.Reply;
import rocks.chendidi.ssm.pojo.ReplyExample;
import rocks.chendidi.ssm.service.ReplyService;
import rocks.chendidi.ssm.util.PublicValue;

import java.util.List;

/**
 * Created by lenov0 on 2016/7/9.
 */
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;


    public List<Reply> getByPage(int page, int size, String articleid) {
        ReplyExample replyExample = new ReplyExample();
        ReplyExample.Criteria criteria = replyExample.createCriteria();
        criteria.andArticleidEqualTo(articleid);
        if (page == 0)
            page = (replyMapper.countByExample(replyExample) / PublicValue.PAGESIZE) + 1;
        if (page == -1)
            page = 1;
        int currentRow = (page - 1) * size;
        return replyMapper.selectByPage(currentRow, size, articleid);
    }

    public Page getPage(int page, String articleid) {

        ReplyExample replyExample = new ReplyExample();
        ReplyExample.Criteria criteria = replyExample.createCriteria();
        criteria.andArticleidEqualTo(articleid);
        Page p = new Page();
        if (page == 0) {
            page = (replyMapper.countByExample(replyExample) / PublicValue.PAGESIZE) + 1;
            p.setCurrent(page);
        } else if (page == -1) {
            page = 1;
            p.setCurrent(page);
        } else
            p.setCurrent(page);
        p.setTotlePage((replyMapper.countByExample(replyExample) / PublicValue.PAGESIZE) + 1);
        p.setPerPage();
        return p;

    }

    public int addReply(Reply reply) {
        return replyMapper.insert(reply);
    }
}
