package com.luckybag.multiclient.websocket;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import javax.websocket.*;
import java.io.IOException;

public class MyWebSocketServer {
    private final Logger logger = Logger.getLogger(MyWebSocketServer.class);
    private Session session;

    /**
     * 连接建立后触发的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        logger.info("onOpen" + session.getId());
        WebSocketMapUtil.put(session.getId(), this);
    }


    /**
     * 连接关闭后触发的方法
     */
    @OnClose
    public void onClose() {
        //从map中删除
        WebSocketMapUtil.remove(session.getId());
        logger.info("====== onClose:" + session.getId() + " ======");
    }


    /**
     * 接收到客户端消息时触发的方法
     */
    @OnMessage
    public void onMessage(String params, Session session) throws Exception {
        //获取服务端到客户端的通道
        MyWebSocketServer myWebSocket = WebSocketMapUtil.get(session.getId());
        logger.info("收到来自" + session.getId() + "的消息" + params);
        String result = "收到来自" + session.getId() + "的消息" + params;
        //返回消息给Web Socket客户端（浏览器）
        myWebSocket.sendMessage(1, "成功！ ", result);
    }


    /**
     * 发生错误时触发的方法
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.info(session.getId() + "连接发生错误" + error.getMessage());
        error.printStackTrace();
    }

    public void sendMessage(int status, String message, Object datas) throws IOException {
        JSONObject result = new JSONObject();
        result.put("status", status);
        result.put("message", message);
        result.put("datas", datas);
        this.session.getBasicRemote().sendText(result.toString());
    }

}
