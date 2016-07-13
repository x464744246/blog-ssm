package rocks.chendidi.ssm.interceptor;

/**
 * Created by lenov0 on 2016/7/13.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import rocks.chendidi.ssm.pojo.User;

/**
 * 身份认证拦截器 *@author 王旭 *@time 2015-9-6 上午9:51:27
 */
public class LoginInteceptor implements HandlerInterceptor {
    /**
     * 进行身份认证，在handler执行之前执行
     */

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("u");
        //判断是否为公开地址
        String url = request.getRequestURL().toString();
        if (url.contains("register")||url.contains("login_check")||url.contains("token")) {
            return true;//是公开地址则放行
        } //判断用户是否登录
        else if (user != null) {
            return true;
        } else {//不是公开地址则重定向到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return false;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
