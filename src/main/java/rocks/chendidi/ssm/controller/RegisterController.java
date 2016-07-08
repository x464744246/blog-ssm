package rocks.chendidi.ssm.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rocks.chendidi.ssm.pojo.User;
import rocks.chendidi.ssm.service.RegisterService;
import rocks.chendidi.ssm.util.MD5Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenov0 on 2016/7/7.
 */
@Controller
@RequestMapping("/register")
@Configuration
@ComponentScan("rocks.chendidi.ssm.service")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @Autowired(required = false)
    User user;

    int num = 0;

    @RequestMapping(value = "/register", produces = "text/plain;charset=UTF-8")
    public String register() {
        return "regist";
    }

    @RequestMapping(value = "/check_id", method = RequestMethod.POST)
    public String checkUserName(HttpServletRequest request, HttpServletResponse response, User u) throws Exception {
        String userid = u.getUserid();

        System.out.println(userid);
        //检验用户名是否存在
     /*   UserExample userExample=new UserExample();
        UserExample.Criteria conditionCri = userExample.createCriteria();
        conditionCri.andUserNameEqualTo(userName);
        int num=registerService.countByExample(userExample);*/
        num = registerService.checkUserId(userid);


        //用户名是否存在的标志
        boolean flag = false;
        if (num > 0) {
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

    @RequestMapping(value = "/check_register", method = RequestMethod.POST)
    public String registerCheck(User u) throws Exception {
        System.out.println(u.getUserid());
        System.out.println(u.getPassword());
        System.out.println(u.getUsername());
        if (u.equals(null)) {
            return "regist_fail";
        } else {
            u.setLevel("user");
            u.setPassword(MD5Util.string2MD5(u.getPassword()));

            if (registerService.addUser(u) > 0)
                return "regist_success";
            else
                return "regist_fail";
           /* InputStream is = new FileInputStream(image);
            if (is != null) {
                OutputStream os = new java.io.FileOutputStream(
                        "D:/study/ReadyFoJavaee/Base1/WebContent/image/" + user.getId() + ".jpg");
                byte buffer[] = new byte[8192];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    os.write(buffer, 0, count);
                }
                os.close();
                is.close();
            }*/

        }


    }
}
