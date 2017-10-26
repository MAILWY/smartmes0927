package org.jlhh.mes.controller;

import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.model.Tsa;
import org.jlhh.mes.service.TsaService;
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
public class TsaController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private TsaService tsaService;

    @RequestMapping(value = "/tsa/select")
    public Object selectTsa() {
        RetModel retModel = new RetModel();
        List<Tsa> TsaList = new ArrayList<Tsa>();
        try {
            /*
            //每次查询时，查询上位机的状态，10秒实时更新一次。
            Socket socketTsa = null;
            socketTsa = new Socket("", 9009);
            System.out.println(socketTsa.getPort());
            //读取服务器端数据
            DataInputStream input = new DataInputStream(socketTsa.getInputStream());
            //向服务器端发送数据
            DataOutputStream out = new DataOutputStream(socketTsa.getOutputStream());
            if (socketTsa !=null) {
                out.writeUTF(ByteUtils.encodeHex("3333333333"));
                //上位机返回数据。
                String ret = input.readUTF();
            }
            out.close();
            input.close();
            */
            TsaList = this.tsaService.getTsaRepository().selectAll();
            logger.trace("用户表记录" + TsaList.size());

        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/tsa/select begining......");
        return TsaList;
    }

    @RequestMapping(value = "/tsa/update")
    public Object updateTsa(Tsa tsa) {
        RetModel retModel = new RetModel();
        try {
            System.out.println(tsa.getTsaId().toString() + "-----------" + tsa.getTsaUseflag().toString());
            this.tsaService.getTsaRepository().updateTsa(tsa);
            retModel.success().setRetObj(tsa);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace("/tsa/update begining......");
        return retModel;
    }

}

