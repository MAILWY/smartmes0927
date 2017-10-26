package org.jlhh.mes.controller;

import org.jlhh.mes.model.MesChargeInfo;
import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.service.MeschargeinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyong on 2017/9/28.
 */
@RestController
public class MeschargeinfoController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MeschargeinfoService meschargeinfoService;

    @RequestMapping(value = "/meschargeinfo/select")
    public Object selectMeschargeinfo() {
        RetModel retModel = new RetModel();
        List<MesChargeInfo> meschargeinfoList = new ArrayList<MesChargeInfo>();
        try {
            meschargeinfoList = this.meschargeinfoService.getMeschargeinfoRepository().selectAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/meschargeinfo/select begining......");
        return meschargeinfoList;
    }
}
