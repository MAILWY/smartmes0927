package org.jlhh.mes.service;

import org.jlhh.mes.model.Batterycell;
import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.utils.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/**
 * Created by wangjialin on 2017/10/10.
 */
@Service(value = "B1001")
public class B1001 implements IBusiness {
    String socketB1001 = new String();
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private BatterycellService batterycellService;

    @Override
    public Map<String, Object> trade(Map<String, Object> msgMap) {
        Batterycell batterycell = new Batterycell();
        String[] dataMessageB1001 = (String[]) msgMap.get("dataMessage");

        for (int i = 0; i < dataMessageB1001.length - 1; i++) {
            dataMessageB1001[i] = dataMessageB1001[i].trim();
            System.out.println("IP地址：" + msgMap.get("socketAddress").toString().replace("/", "") + "--dataMessageB1001报文内容--" + i + "--" + dataMessageB1001[i]);
            logger.info("IP地址：" + msgMap.get("socketAddress").toString().replace("/", "") + "--dataMessageB1001报文内容--" + i + "--" + dataMessageB1001[i]);
        }
        batterycell.setPedestalId(dataMessageB1001[2].trim());
        batterycell.setCmoduleId(dataMessageB1001[3].trim());

        RetModel retModel = new RetModel();
        try {
            this.batterycellService.getBatterycellRepository().update(batterycell);
            retModel.success().setRetObj(batterycell);
        } catch (Exception ex) {
            ex.printStackTrace();
            retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        logger.trace(" B1001 updateBatterycell begining......");
        String[] socketB1001 = (String[]) msgMap.get("socketAddress").toString().replace("/", "").split(":");
        System.out.println("客户端地址：" + socketB1001[0] + ":" + socketB1001[1]);
        Socket socketSend = null;

        try {
            System.out.println(socketB1001[0].toString());
            //ByteUtils.byteArrayToInt(socketB1001[1].getBytes())
            socketSend = new Socket(socketB1001[0].toString(), Integer.parseInt(socketB1001[1]));
            System.out.println(socketSend.getPort());
            //读取服务器端数据
            DataInputStream input = new DataInputStream(socketSend.getInputStream());
            //向服务器端发送数据
            DataOutputStream out = new DataOutputStream(socketSend.getOutputStream());
            out.writeUTF(ByteUtils.encodeHex("3333333333"));
            System.out.println(" socketB1001发送回执报文地址端口:" + socketB1001[0] + ":" + socketB1001[1] + "--");
            out.close();
            input.close();
        } catch (Exception e) {
            System.out.println(" socketB1001 客户端 finally 异常:" + socketB1001[0] + ":" + socketB1001[1] + "--" + e.getMessage());
        } finally {
            if (socketSend != null) {
                try {
                    socketSend.close();
                } catch (IOException e) {
                    socketSend = null;
                    System.out.println(" socketB1001 客户端 finally 异常:" + socketB1001[1] + "--" + e.getMessage());
                }
            }
        }
        return null;
    }
}