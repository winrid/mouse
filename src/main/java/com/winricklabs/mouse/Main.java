package com.winricklabs.mouse;

import com.winricklabs.mouse.state.StateRunner;
import com.winricklabs.mouse.state.Wakeup;
import com.winricklabs.mouse.websocket.MouseSocketServer;

public class Main {

    private static final int PORT = 8035;

    public static void main(String[] args) {
        MouseSocketServer server = new MouseSocketServer( PORT);

        server.start();
        System.out.println("Server Started on " + PORT);

//        new StateRunner().run(new Wakeup());
    }
}