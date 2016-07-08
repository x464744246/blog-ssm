package rocks.chendidi.ssm.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import rocks.chendidi.ssm.model.Page;
import rocks.chendidi.ssm.pojo.Article;
import rocks.chendidi.ssm.service.ArticleService;
import rocks.chendidi.ssm.util.PublicValue;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenov0 on 2016/7/7.
 */
@Controller
@RequestMapping("/article")
@Configuration
@ComponentScan("rocks.chendidi.ssm.service")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/page", produces = "text/plain;charset=UTF-8")
    public String page(HttpServletResponse response, int page) throws IOException {
        System.out.println(page);

        List<Article> list = articleService.getByPage(page, PublicValue.PAGESIZE);
        Page p = articleService.getPage(page);
//        System.out.println(list.get(0).getArticleid());
        boolean flag = false;
        if (list.size() > 0) {
            flag = true;
        }
        //将数据转换成json
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", flag);
        map.put("article", list);
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

    @RequestMapping(value = "/article", produces = "text/plain;charset=UTF-8")
    public String page() {
        return "article";
    }


}
