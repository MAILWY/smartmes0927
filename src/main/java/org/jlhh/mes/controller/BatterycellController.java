package org.jlhh.mes.controller;

import org.jlhh.mes.model.Batterycell;
import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.service.BatterycellService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyong on 2017/9/27.
 */
@RestController
public class BatterycellController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private BatterycellService batterycellService;

    @RequestMapping(value = "/batterycell/update")
    public Object updateBatterycell(Batterycell batterycell) {
        RetModel retModel = new RetModel();
        try {
            this.batterycellService.getBatterycellRepository().update(batterycell);
            retModel.success().setRetObj(batterycell);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("updateBatterycell begining......");
        return retModel;
    }

    @RequestMapping(value = "/batterycell/update_sl_mes")
    public Object updateBatterycell_sl_mes(Batterycell batterycell) {
        RetModel retModel = new RetModel();
        try {
            this.batterycellService.getBatterycellRepository().update_sl_mes(batterycell);
            retModel.success().setRetObj(batterycell);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("updateBatterycell begining......");
        return retModel;
    }


    @RequestMapping(value = "/batterycell/updateCellid")
    public Object updateCellid(String OldCellid, String NewCellid) {
        RetModel retModel = new RetModel();
        try {
            this.batterycellService.getBatterycellRepository().updateCellid(OldCellid, NewCellid);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("updateBatterycell begining......");
        return retModel;
    }

}
