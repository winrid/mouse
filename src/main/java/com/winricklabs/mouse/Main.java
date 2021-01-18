package com.winricklabs.mouse;

import com.pi4j.io.gpio.*;
import com.winricklabs.mouse.state.StateRunner;
import com.winricklabs.mouse.state.Wakeup;
import com.winricklabs.mouse.websocket.MouseSocketServer;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    private static final int PORT = 8035;


    public static void main(String[] args) throws InterruptedException {
        MouseSocketServer server = new MouseSocketServer( PORT);
        server.start();
        System.out.println("Server Started on " + PORT);
        final GpioController gpio = GpioFactory.getInstance();

        // Flash our LED on startup.
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "MyLED", PinState.HIGH);
        pin.setShutdownOptions(true, PinState.LOW);
        pin.high();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                pin.low();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 1500);

//        new StateRunner().run(new Wakeup());
    }
}