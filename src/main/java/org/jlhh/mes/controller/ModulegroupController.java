package org.jlhh.mes.controller;

import org.jlhh.mes.model.ModuleGroup;
import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.service.ModulegroupService;
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
public class ModulegroupController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ModulegroupService modulegroupService;

    @RequestMapping(value = "/modulegroup/insert")
    public Object insertModulegroup(ModuleGroup moduleGroup) {
        RetModel retModel = new RetModel();
        try {
            this.modulegroupService.getModulegroupRepository().insertmodulegroup(moduleGroup);
            retModel.success().setRetObj(moduleGroup);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("insertModulegroup begining......");
        return retModel;
    }

    /*
        @RequestMapping(value = "/modulegroup/updateGroupidByModuleid")
        public Object updateGroupidByModuleid(String BoxId,String Modulegroup) {
            RetModel retModel = new RetModel();
            try {
                this.modulegroupService.getModulegroupRepository().updateGroupidByModuleid(BoxId,Modulegroup);
                retModel.success().setRetObj(moduleGroup);
            } catch (Exception ex) {
                ex.printStackTrace();
                retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
            }
            logger.trace("updateGroupidByModuleid begining......");
            return retModel;
        }
    */
    @RequestMapping(value = "/modulegroup/selectbyid")
    public Object selectByIdModulegroup(String moduleGroupId) {
        RetModel retModel = new RetModel();
        ModuleGroup moduleGroup = new ModuleGroup();
        try {
            moduleGroup = this.modulegroupService.getModulegroupRepository().selectByModuleid(moduleGroupId);
            retModel.success().setRetObj(moduleGroup);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("insertModulegroup begining......");
        return moduleGroup;
    }


    @RequestMapping(value = "/modulegroup/updateBoxidByModuleid")
    public Object updateBoxidByModuleid(String BoxId, String moduleGroupId) {
        RetModel retModel = new RetModel();
        try {
            this.modulegroupService.getModulegroupRepository().updateBoxidByModuleid(BoxId, moduleGroupId);
            retModel.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("updateBoxidByModuleid begining......");
        return retModel;
    }

    @RequestMapping(value = "/modulegroup/selectByBoxid")
    public Object selectByBoxid(String BoxId) {
        List<ModuleGroup> ModuleGroupList = new ArrayList<ModuleGroup>();
        RetModel retModel = new RetModel();
        try {
            ModuleGroupList = this.modulegroupService.getModulegroupRepository().selectByBoxid(BoxId.trim());
            retModel.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("selectByBoxid begining......");
        return ModuleGroupList;
    }

    @RequestMapping(value = "/modulegroup/selectByBoxidBmsid")
    public Object selectByBoxidBmsid(String BoxId, String BmsId) {
        List<ModuleGroup> ModuleGroupList = new ArrayList<ModuleGroup>();
        RetModel retModel = new RetModel();
        try {
            ModuleGroupList = this.modulegroupService.getModulegroupRepository().selectByBoxidBmsid(BoxId, BmsId);
            retModel.success();
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("selectByBoxid begining......");
        return ModuleGroupList;
    }


    @RequestMapping(value = "/modulegroup/updateBmsidByModuleid")
    public Object updateBmsidByModuleid(String Bmsid, String moduleGroupId) {
        RetModel retModel = new RetModel();
        try {
            this.modulegroupService.getModulegroupRepository().updateBmsidByModuleid(Bmsid, moduleGroupId);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("updateBmsidByModuleid begining......");
        return retModel;
    }


}
