package org.jlhh.mes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangyong on 2017/10/26.
 */
@Controller
public class AIndexController {
    @RequestMapping(value = "/")
    public String toHomePage(HttpServletRequest request) {
        return "redirect:/mes_a_login.html";
    }

}
