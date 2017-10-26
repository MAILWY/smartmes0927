package org.jlhh.mes.controller;

import org.jlhh.mes.model.Menu;
import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.service.MenuService;
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
public class MenuController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MenuService mmenuService;

    @RequestMapping(value = "/menu/insert")
    public Object insertMenu(Menu mmenu) {
        RetModel retModel = new RetModel();
        try {
            this.mmenuService.getMenuRepository().insert(mmenu);
            retModel.success().setRetObj(mmenu);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("insertMenu begining......");
        return retModel;
    }

    @RequestMapping(value = "/menu/delete")
    public Object deleteMenu(String menuId) {
        RetModel retModel = new RetModel();
        try {
            this.mmenuService.getMenuRepository().delete(menuId);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("deleteMenu begining......");
        return retModel;
    }

    @RequestMapping(value = "/menu/select")
    public Object selectMenu() {
        List<Menu> MenuList = new ArrayList<Menu>();
        RetModel retModel = new RetModel();
        try {
            MenuList = this.mmenuService.getMenuRepository().selectAll();
            retModel.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("insertMenu begining......");
        return MenuList;
    }
}
