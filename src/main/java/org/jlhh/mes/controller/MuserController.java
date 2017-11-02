package org.jlhh.mes.controller;

import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.model.User;
import org.jlhh.mes.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjialin on 2017/9/17.
 */
@RestController
public class MuserController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/select")
    public Object selectAllUser() {
        RetModel retModel = new RetModel();
        List<User> UserList = new ArrayList<User>();
        try {
            UserList = this.userService.getUserReposiotry().selectAll();
            logger.trace("用户表记录" + UserList.size());
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/user/selec begining......");
        return UserList;
    }

    @RequestMapping(value = "/user/selectById")
    public Object selectUserById(User loginUser) {
        RetModel retModel = new RetModel();
        User loginuser = new User();
        try {
            loginuser = this.userService.getUserReposiotry().selectUser(loginUser);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/user/selectById begining......");
        return loginuser;
    }

    @RequestMapping(value = "/user/login")
    public Object userLogin(User user) {
        RetModel retModel = new RetModel();
        User loginuser = new User();
        try {
            System.out.println(user.getUserId().toString() + "------------------");
            System.out.println(user.getUserPwd().toString() + "-------------------");
            loginuser = this.userService.getUserReposiotry().selectUser(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        if (loginuser.getUserId() == null) {
            return retModel.fail("999", "无此用户");
        }

        if (loginuser.getUserId().toString().equals(user.getUserId().toString()) && loginuser.getUserPwd().toString().equals(user.getUserPwd().toString())) {
            System.out.println(loginuser.getUserName() + "--------");
            retModel.setRetCode("000");
            retModel.setRetMsg(loginuser.getUserName());
            return retModel;
        } else return retModel.fail("999", "密码错误");
    }


    @RequestMapping(value = "/user/insert")
    public Object insertUser(User user) {
        RetModel retModel = new RetModel();
        try {
            this.userService.getUserReposiotry().insert(user);
            retModel.success().setRetObj(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("insertUser begining......");
        return retModel.success();
    }


    @RequestMapping(value = "/user/delete")
    public Object deleteUser(User user) {
        RetModel retModel = new RetModel();
        try {
            this.userService.getUserReposiotry().delete(user.getUserId());
            retModel.success().setRetObj(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("deleteUser begining......");
        return retModel;
    }

    @RequestMapping(value = "/user/updatePwd")
    public Object updatePwd(User user) {
        RetModel retModel = new RetModel();
        try {
            this.userService.getUserReposiotry().updatePwd(user);
            retModel.success().setRetObj(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("updatePwd begining......");
        return retModel;
    }
}
