package rocks.chendidi.ssm.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import rocks.chendidi.ssm.model.Page;
import rocks.chendidi.ssm.pojo.Article;
import rocks.chendidi.ssm.pojo.Reply;
import rocks.chendidi.ssm.pojo.User;
import rocks.chendidi.ssm.service.ArticleService;
import rocks.chendidi.ssm.service.ReplyService;
import rocks.chendidi.ssm.util.PublicValue;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenov0 on 2016/7/7.
 */
@Controller
@RequestMapping("/reply")
@Configuration
@ComponentScan("rocks.chendidi.ssm.service")
public class ReplyController {
    @Autowired
    ArticleService articleService;

    @Autowired
    ReplyService replyService;


    @RequestMapping(value = "/page", produces = "text/plain;charset=UTF-8")
    public String page(HttpSession httpSession, HttpServletResponse response, int page) throws IOException {
        System.out.println(page);
        Article article = (Article) httpSession.getAttribute("a");
        List<Reply> list = replyService.getByPage(page, PublicValue.PAGESIZE, article.getArticleid());
        Page p = replyService.getPage(page,article.getArticleid());
//        System.out.println(list.get(0).getArticleid());
        boolean flag = false;
        if (list.size() > 0) {
            flag = true;
        }
        //将数据转换成json
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", flag);
        map.put("reply", list);
        map.put("page", p);
        String json = JSONObject.valueToString(map).toString();
        //将数据返回
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
        return null;
    }

    @RequestMapping(value = "/reply", produces = "text/plain;charset=UTF-8")
    public String page(HttpSession httpSession, Article article) {
        article = articleService.getById(article);
        System.out.println(article.getArticle());
        System.out.println(article.getTitle());
        System.out.println(article.getUsername());
        httpSession.setAttribute("a", article);
        return "reply";
    }


    @RequestMapping(value = "/add", produces = "text/plain;charset=UTF-8")
    public String add(HttpSession httpSession, HttpServletResponse response,Reply reply) throws IOException {
        User user = (User) httpSession.getAttribute("u");
        Article article = (Article) httpSession.getAttribute("a");
        reply.setArticleid(article.getArticleid());
        reply.setUserid(user.getUserid());
        reply.setUsername(user.getUsername());
        int row = replyService.addReply(reply);

        boolean flag = false;
        if (row > 0) {
            flag = true;
        }


        //将数据转换成json
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", flag);
        String json = JSONObject.valueToString(map).toString();
        //将数据返回
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
        return null;
    }
}
