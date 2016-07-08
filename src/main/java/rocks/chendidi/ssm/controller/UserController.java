package rocks.chendidi.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import rocks.chendidi.ssm.pojo.User;
import rocks.chendidi.ssm.service.UserService;
import rocks.chendidi.ssm.util.MD5Util;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lenov0 on 2016/7/6.
 */
@Controller
@RequestMapping("/user")
@Configuration
@ComponentScan("rocks.chendidi.ssm.service")
public class UserController {

    //service类
    @Autowired
    private UserService userService;

    @Autowired(required = false)
    User user;

    @Autowired(required = false)
    List<User> users;

    @Autowired(required = false)
    ModelAndView modelAndView;

    /**
     * user
     * 查找所用用户控制器方法
     * 测试用例
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryUsers", produces = "text/plain;charset=UTF-8")
    public ModelAndView queryUsers() throws Exception {
        modelAndView = new ModelAndView();

        //调用service方法得到用户列表
        users = userService.queryUsers();
        //将得到的用户列表内容添加到ModelAndView中
        modelAndView.addObject("users", users);
        //设置响应的jsp视图
        modelAndView.setViewName("test");
        System.out.print("11111111111111");
        return modelAndView;
    }

    /*  跳转登录页面 */
    @RequestMapping(value = "/login", produces = "text/plain;charset=UTF-8")
    public String login() throws Exception {
        return "login";
    }

    /*  登陆验证  */
    @RequestMapping(value = "/login_check", produces = "text/plain;charset=UTF-8")
    public String loginCheck(HttpSession httpSession, User u) throws Exception {

        u.setPassword(MD5Util.string2MD5(u.getPassword()));
        user = userService.findUser(u);

        if (user != null) {

            if (user.getLevel().equals("admin")) {
                httpSession.setAttribute("u", user);
                return "redirect:/article/article";
            } else if (user.getLevel().equals("user")) {
                return "user";
            } else {
                return "WrongPassword";
            }
        } else {
            return "WrongPassword";
        }

    }


 /*   @RequestMapping("/jsontest")
    @ResponseBody
    public List<User> editItemSubmit_RequestJson() throws Exception {
        users = userService.findUser();
        System.out.print("11111111111111");
        return users;

    }*/
}
