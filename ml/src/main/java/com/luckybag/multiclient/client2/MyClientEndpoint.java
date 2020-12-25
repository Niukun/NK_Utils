package com.luckybag.multiclient.client2;

import javax.websocket.*;

@ClientEndpoint
public class MyClientEndpoint {
    @OnOpen
    public void myOnOpen (Session session) {
        System.out.println ("WebSocket opened: "+session.getId());
    }



    @OnMessage
    public void myOnMessage (String txt) {
        System.out.println ("WebSocket received message: "+txt);
    }

    @OnClose
    public void myOnClose (CloseReason reason) {
        System.out.println("Closing a WebSocket due to "+reason.getReasonPhrase());
    }


}
