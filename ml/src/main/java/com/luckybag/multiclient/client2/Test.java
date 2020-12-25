package com.luckybag.multiclient.client2;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.net.URI;

public class Test {
    public static void main(String[] args) throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();

        container.connectToServer(MyClientEndpoint.class, new URI("ws://61.171.37.10:8089"));
        System.out.println(container);
    }
}
