package com.winricklabs.mouse.websocket;

import com.winricklabs.mouse.websocket.message.Message;
import com.winricklabs.mouse.websocket.message.MessageDecoder;
import com.winricklabs.mouse.websocket.message.MessageEncoder;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class MouseSocketServer extends WebSocketServer {

    public MouseSocketServer(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.err.println("Yuxiu: onClose "+handshake.toString());

    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.err.println("Yuxiu: onClose ");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.err.println("Yuxiu: onMessage "+message.toString());
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.err.println("Yuxiu: onError "+ex.toString());

    }

    @Override
    public void onStart() {
        System.err.println("Yuxiu: on start ");
    }
}
