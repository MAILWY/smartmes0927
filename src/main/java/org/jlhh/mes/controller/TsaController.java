package org.jlhh.mes.controller;

import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.model.Tsa;
import org.jlhh.mes.service.TsaService;
import org.jlhh.mes.utils.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.jlhh.mes.utils.ByteUtils.getBooleanArray;

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
            //卓岚6842模块DI1-DI8的查询命令
            byte[] Query = new byte[12];
            Query[0] = (byte) 0x00;
            Query[1] = (byte) 0x00;
            Query[2] = (byte) 0x00;
            Query[3] = (byte) 0x00;
            Query[4] = (byte) 0x00;
            Query[5] = (byte) 0x06;
            Query[6] = (byte) 0x01;
            Query[7] = (byte) 0x01;
            Query[8] = (byte) 0x00;
            Query[9] = (byte) 0x00;
            Query[10] = (byte) 0x00;
            Query[11] = (byte) 0x08;

            //每次查询时，查询上位机的状态，10秒实时更新一次。
            Socket socketTsaLtk00 = null;
            socketTsaLtk00 = new Socket("192.168.1.210", 1092);
            //读取服务器端数据
            DataInputStream inputLtk00 = new DataInputStream(socketTsaLtk00.getInputStream());
            //向服务器端发送数据
            DataOutputStream outLtk00 = new DataOutputStream(socketTsaLtk00.getOutputStream());
            System.out.println("-----TsaController------192.168.1.210：1092--222--");
            outLtk00.write(Query);
            byte[] ltk00State = new byte[10];
            inputLtk00.read(ltk00State);
            System.out.println("-----TsaController------192.168.1.210：1092----" + Arrays.toString(getBooleanArray(ltk00State[9])));
            outLtk00.close();
            inputLtk00.close();

















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

