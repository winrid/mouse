package com.winricklabs.mouse.websocket;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.winricklabs.mouse.dto.UpdateMotors;
import com.winricklabs.mouse.motor.MotorController;
import com.winricklabs.mouse.websocket.message.Message;
import com.winricklabs.mouse.websocket.message.MessageDecoder;
import com.winricklabs.mouse.websocket.message.MessageEncoder;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class MouseSocketServer extends WebSocketServer {

    private static final Gson gson = new Gson();

    public MouseSocketServer(int port) {
        super(new InetSocketAddress(port));
        setReuseAddr(true);
        try {
            System.out.println("Debugging - setting motors to half speed. Did this deploy?");
            MotorController.updateMotors(500, 500);
        } catch(Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.err.println("Yuxiu: onOpen "+handshake.toString());

    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.err.println("Yuxiu: onClose ");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.err.println("Yuxiu: onMessage "+message.toString());
        JsonObject jsonObject = (JsonObject) JsonParser.parseString(message);
        String action = jsonObject.get("action").getAsString();

        String data = jsonObject.get("data").getAsString();
        System.out.println("Action is:" + data);
        switch (action) {
            case "update-motors":
                UpdateMotors updateMotors = gson.fromJson(data, UpdateMotors.class);
                MotorController.updateMotors(updateMotors.leftMotor, updateMotors.rightMotor);
                break;
        }

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
