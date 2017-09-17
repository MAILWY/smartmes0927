package org.jlhh.mes.controller;

import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.model.User;
import org.jlhh.mes.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangjialin on 2017/9/17.
 */
@RestController
public class MenuController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/menu/insert")
    public Object insertMenu(User user) {
        logger.trace("insertMenu begining......");
        return new RetModel();
    }
}
