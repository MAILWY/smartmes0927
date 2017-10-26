package org.jlhh.mes.controller;

import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.model.Woald1;
import org.jlhh.mes.service.Woald1Service;
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
public class Woald1Controller {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Woald1Service woald1Service;

    @RequestMapping(value = "/woald1/insert")
    public Object insertUserMenu(Woald1 woald1) {
        RetModel retModel = new RetModel();
        try {
            this.woald1Service.getWoald1Repository().insert(woald1);
            retModel.success().setRetObj(woald1);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/woald1/insert begining......");
        return retModel;
    }

    @RequestMapping(value = "/woald1/delete")
    public Object deleteUserMenu(String woaldId) {
        RetModel retModel = new RetModel();
        try {
            this.woald1Service.getWoald1Repository().delete(woaldId);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/usermenu/select......");
        return retModel;
    }

    @RequestMapping(value = "/woald1/update")
    public Object updateWoald1(Woald1 woald1) {
        RetModel retModel = new RetModel();
        try {
            this.woald1Service.getWoald1Repository().update(woald1);
            retModel.success().setRetObj(woald1);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/woald1/update begining......");
        return retModel;
    }

    @RequestMapping(value = "/woald1/select")
    public Object selectWoald1(String date) {
        List<Woald1> Woald1List = new ArrayList<Woald1>();
        RetModel retModel = new RetModel();
        try {
            Woald1List = this.woald1Service.getWoald1Repository().selectByDate(date);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/woald1/select begining......");
        return Woald1List;
    }
}