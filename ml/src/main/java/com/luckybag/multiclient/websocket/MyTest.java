package com.luckybag.multiclient.websocket;

import org.java_websocket.client.WebSocketClient;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * http://218.78.51.29:18013/luckybag/main/home
 * 测试环境：
 * 	机器：172.16.100.18    izkml		1u%VOMW$er
 * 	数据库：您的人力资源产品线测试环境的数据库已经创建成功。DBName：zkml_hrssc_test，User：zkmlhrsstestuser，Password: BFIq3fu!jrPp，IP：10.5.4.243，Port：33891。请您及时做连接测试。
 *
 *
 *
 * 生产环境：
 * 	电信云机器
 * 	61.171.37.10 8g
 * 	218.78.51.29 16g
 * 	用户名密码都是：administrator / Izkml@123
 *
 * 	数据库：您的数据库已经创建成功。DBName：zkml_lucky_bag，User：zkluckybaguser，Password: bh3H!RAw3E43ID，公网IP：121.37.189.223，Port：33917 ，内网IP：192.168.8.150，Port：33891。请您及时做连接测试。
 *
 *
 * [{"Receivers":["99999"],"MessageBody":{"MSGID":"89856FA0-478A-41B1-9E29-82593E5B9D42","MSGCONTENT":"qqqq","USERID":"3","USERNAME":"纪文静","MSGCREATETIME":"2020-12-25 05:44:25","RECEIVER":"99999","RECEIVERTYPEID":"1","RowState":"1"}}]
 *
 * {<15000000001@123@8008>}
 * subscribe:99999@lm.com.100
 */
public class MyTest {
    private static final WebSocketClient client = null;


//    https://www.cnblogs.com/jieerma666/p/10342435.html
    public static void main(String[] arg0) throws URISyntaxException, InterruptedException {

        // 此处的WebSocket服务端URI，上面服务端第2点有详细说明
        MyWebSocketClient myClient = new MyWebSocketClient(new URI("ws://61.171.37.10:8089"));
        myClient.connectBlocking();
        myClient.setConnectionLostTimeout(3000);
//        myClient.connect();
        if(myClient.isOpen()){
            myClient.send("{<15000000003@123@8008>}");

            System.out.println("send successful");
        }

        System.out.println(myClient.getToken());

    }
}
