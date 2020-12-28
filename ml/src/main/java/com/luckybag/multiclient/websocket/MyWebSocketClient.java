package com.luckybag.multiclient.websocket;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;


import java.net.URI;

public class MyWebSocketClient extends WebSocketClient {
    String token = "";

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    Logger logger = Logger.getLogger(MyWebSocketClient.class);


    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }


    @Override
    public void onOpen(ServerHandshake arg0) {
        logger.info("------ MyWebSocket onOpen ------");
    }


    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {

        logger.info("------ MyWebSocket onClose ------");
    }


    @Override
    public void onError(Exception arg0) {

        logger.info("------ MyWebSocket onError ------" + arg0);
    }


    @Override
    public void onMessage(String arg0) {
        logger.info("-------- 接收到服务端数据： " + arg0 + "--------");
        if("CHB".equalsIgnoreCase(arg0)){
            logger.info("-------- 接收到服务端数据： " + arg0 + "--------");
            return;
        }

        JSONObject jsonObject = JSONObject.parseObject(arg0);

        if(jsonObject.getString("Token") != null){
            this.setToken(jsonObject.getString("Token"));
            this.send("subscribe:99999@lm.com.100");
//            this.send("subscribe:99999@lm.com.100@{USER}");
            logger.info("token is: " + this.getToken());
            this.setToken(jsonObject.getString("Token"));
        }else if(jsonObject.getString("CONTENT") != null){
            JSONObject content = JSONObject.parseObject(jsonObject.getString("CONTENT"));
            String coustomname = content.getString("COUSTOMNAME");
            if(coustomname != null){

                logger.info(coustomname + "登陆了");
            }else{
                String userName = content.getString("USERNAME");
                String msgcontent = content.getString("MSGCONTENT");
                String msgcreatetime = content.getString("MSGCREATETIME");
                logger.info(userName + " 发了消息: " + msgcontent + " 发送时间: " + msgcreatetime);
            }
        }

    }
}
