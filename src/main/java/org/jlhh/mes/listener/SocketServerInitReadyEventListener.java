package org.jlhh.mes.listener;

import org.jlhh.mes.service.SocketServerHandler;
import org.jlhh.mes.utils.AcUtils;
import org.jlhh.mes.utils.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wangjialin on 2017/10/10.
 */
@Component
public class SocketServerInitReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private SocketServerHandler socketServerHandler;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            AcUtils.initCac(event.getApplicationContext());
            ServerSocket serverSocket = new ServerSocket(8005);
            String CurrTime = Time.getStringDate();
            while (true) {
                System.out.println(CurrTime.toString() + "服务端口------8001");
                System.out.println(CurrTime.toString() + "报文端口------8005");
                Socket socket = serverSocket.accept();
                socket.setKeepAlive(true);
                socketServerHandler.setSocket(socket);
                Thread t = new Thread(socketServerHandler);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
