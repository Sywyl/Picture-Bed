package io.ymq.fm.web;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述: 首页
 *
 * @author yanpenglei
 * @create 2017-09-05 16:01
 **/

public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "forward:/index.html";
    }

}
