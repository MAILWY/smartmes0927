package org.jlhh.mes.service;

import org.jlhh.mes.model.ModuleGroup;
import org.jlhh.mes.model.RetModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wangyong on 2017/10/11.
 */
@Service("B1002")
public class B1002 implements IBusiness {
    RetModel retModel = new RetModel();
    ModuleGroup moduleGroup = new ModuleGroup();
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ModulegroupService modulegroupService;

    @Override
    public Map<String, Object> trade(Map<String, Object> msgMap) {
        String modulId = new String();
        String groupId = new String();
        String tmpString = new String();
        String[] dataMessageB1002 = (String[]) msgMap.get("dataMessage");
        for (int i = 0; i < dataMessageB1002.length - 1; i++) {
            dataMessageB1002[i] = dataMessageB1002[i].trim();
            System.out.println("IP地址：" + msgMap.get("socketAddress").toString().replace("/", "") + "--dataMessageB1002报文内容--" + i + "--" + dataMessageB1002[i]);
            logger.info("IP地址：" + msgMap.get("socketAddress").toString().replace("/", "") + "--dataMessageB1002报文内容--" + i + "--" + dataMessageB1002[i]);
        }
        moduleGroup.setGroupId(dataMessageB1002[2].trim());
        moduleGroup.setModuleId1(dataMessageB1002[2].trim());
        moduleGroup.setModuleId2(dataMessageB1002[3].trim());
        moduleGroup.setModuleId3(dataMessageB1002[4].trim());
        moduleGroup.setModuleId4(dataMessageB1002[5].trim());
        moduleGroup.setModuleId5(dataMessageB1002[6].trim());
        moduleGroup.setModuleId6(dataMessageB1002[7].trim());
        moduleGroup.setModuleId7(dataMessageB1002[8].trim());
        moduleGroup.setModuleId8(dataMessageB1002[9].trim());
        moduleGroup.setModuleId9(dataMessageB1002[10].trim());
        moduleGroup.setModuleId10(dataMessageB1002[11].trim());
        moduleGroup.setModuleId11(dataMessageB1002[12].trim());
        moduleGroup.setModuleId12(dataMessageB1002[13].trim());
        this.modulegroupService.getModulegroupRepository().insertmodulegroup(moduleGroup);
        logger.trace(" B1002 insertmodulegroup begining......");
        return null;
    }
}
