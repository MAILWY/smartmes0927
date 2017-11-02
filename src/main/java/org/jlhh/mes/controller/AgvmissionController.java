package org.jlhh.mes.controller;

import org.jlhh.mes.model.AgvMission;
import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.service.AgvmissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyong on 2017/11/1.
 */
@RestController
public class AgvmissionController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AgvmissionService agvmissionService;


    @RequestMapping(value = "/agvmission/insert")
    public Object insertMenu(AgvMission agvmission) {
        RetModel retModel = new RetModel();
        try {
            System.out.println(agvmission.getEndPoint() + "-----------------------");
            this.agvmissionService.getAgvmissionRepository().insert(agvmission);
            retModel.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("insert-----agvmission begining......");
        return retModel;
    }
}
