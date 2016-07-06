package rocks.chendidi.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import rocks.chendidi.ssm.pojo.User;
import rocks.chendidi.ssm.service.UserService;

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


    /**
     * user
     * 查找所用用户控制器方法
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/findUser",produces="text/plain;charset=UTF-8")
    public ModelAndView findUser() throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        //调用service方法得到用户列表
        List<User> users = userService.findUser();
        //将得到的用户列表内容添加到ModelAndView中
        modelAndView.addObject("users", users);
        //设置响应的jsp视图
        modelAndView.setViewName("findUser");
        System.out.print("11111111111111");
        return modelAndView;
    }


    @RequestMapping("/editItemSubmit_RequestJson")
    @ResponseBody
    public List<User> editItemSubmit_RequestJson() throws Exception {
        List<User> users = userService.findUser();
        System.out.print("11111111111111");
        return users;

    }
}
