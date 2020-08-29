package com.winricklabs.mouse;

import com.winricklabs.mouse.state.StateRunner;
import com.winricklabs.mouse.state.Wakeup;
import com.winricklabs.mouse.websocket.MouseSocketServer;

import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        MouseSocketServer servere = new MouseSocketServer( 8080);

        servere.start();

        new StateRunner().run(new Wakeup());
    }
}