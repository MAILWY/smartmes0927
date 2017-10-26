package org.jlhh.mes.service;

import org.jlhh.mes.utils.AcUtils;
import org.jlhh.mes.utils.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjialin on 2017/10/10.
 */
@Service("socketServerHandler")
@Scope("prototype")
public class SocketServerHandler implements Runnable {
    public static int count = 0;
    Socket socket = null;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public void setSocket(Socket socket) {
        count++;
        this.socket = socket;
        System.out.println("用户" + socket.getRemoteSocketAddress().toString() + "接入");
        logger.info("用户" + socket.getRemoteSocketAddress().toString() + "接入");
    }

    @Override
    public void run() {
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(socket.getInputStream());
            while (true) {
                Map<String, Object> msgMap = new HashMap<>();
                byte[] head = new byte[1024];
                bis.read(head);
                String dataStr = ByteUtils.hexStringToString(ByteUtils.bytesToHexString(head));
                //根据|分割传过来的报文内容。
                String dataMessage[] = dataStr.split("\\|");
                for (int i = 0; i < dataMessage.length - 1; i++) {
                    System.out.println("报文内容--" + i + "--" + dataMessage[i].trim());
                    logger.info("报文内容--" + i + "--" + dataMessage[i].trim());
                }
                msgMap.put("dataMessage", dataMessage);
                msgMap.put("socketAddress", socket.getRemoteSocketAddress().toString());
                if (dataMessage[1].trim().equals("1001")) {
                    AcUtils.getBusinessObject("B" + "1001").trade(msgMap);
                }
                if (dataMessage[1].trim().equals("1002")) {
                    AcUtils.getBusinessObject("B" + "1002").trade(msgMap);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                socket.close();
                System.out.println("用户" + socket.getRemoteSocketAddress().toString() + "断开");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}