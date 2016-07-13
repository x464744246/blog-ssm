package rocks.chendidi.ssm.controller;

/**
 * Created by lenov0 on 2016/7/13.
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
@Configuration
@ComponentScan("rocks.chendidi.ssm.service")
public class TestController {
    @RequestMapping(value = "/test", produces = "text/plain;charset=UTF-8")
    public String page() {
        return "test";
    }
}
