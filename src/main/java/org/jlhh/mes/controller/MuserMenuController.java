package org.jlhh.mes.controller;

import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.model.UserMenu;
import org.jlhh.mes.service.UserMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyong on 2017/9/27.
 */
@RestController
public class MuserMenuController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserMenuService userMenuService;

    @RequestMapping(value = "/usermenu/select")
    public Object selectUserByUserid(String userId) {
        RetModel retModel = new RetModel();
        List<UserMenu> UserMenuList = new ArrayList<UserMenu>();
        try {
            UserMenuList = this.userMenuService.getUserMenuRepository().selectUserByUserid(userId);
            logger.trace("用户表记录" + UserMenuList.size());
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/usermenu/select......");
        return UserMenuList;
    }

    @RequestMapping(value = "/usermenu/delete")
    public Object deleteUserMenu(String userId, String menuId) {
        RetModel retModel = new RetModel();
        try {
            this.userMenuService.getUserMenuRepository().deleteUserMenu(userId, menuId);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/usermenu/delete......");
        return retModel;
    }


    @RequestMapping(value = "/usermenu/insert")
    public Object insertUserMenu(UserMenu userMenu) {
        RetModel retModel = new RetModel();
        try {
            this.userMenuService.getUserMenuRepository().insert(userMenu);
            retModel.success().setRetObj(userMenu);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/usermenu/insert begining......");
        return retModel;
    }
}
