package rocks.chendidi.ssm.controller;

import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;
import org.json.JSONObject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenov0 on 2016/7/12.
 */
@Controller
@RequestMapping("/token")
@Configuration
@ComponentScan("rocks.chendidi.ssm.service")
public class TokenController {

    /*返回七牛提交的token*/
    @RequestMapping(value = "/gettoken", produces = "text/plain;charset=UTF-8")
    public String token(HttpServletResponse response) throws Exception {
        Config.ACCESS_KEY = "Z8wombdh9buqzFIPyiEcfws79BOyQurVDpbltkJg";
        Config.SECRET_KEY = "HokbRUvvDkBxxA08yMqJcwX6RHsQXQ0TPIEFtVit";
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        String bucketName = "blog";
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = putPolicy.token(mac);

        //将数据转换成json
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token",uptoken);
        String json = JSONObject.valueToString(map).toString();
        //将数据返回
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
        return null;
    }
    /*测试方法*/
    @RequestMapping(value = "/token", produces = "text/plain;charset=UTF-8")
    public String test(HttpServletResponse response) throws Exception {

        return "test";
    }
}
