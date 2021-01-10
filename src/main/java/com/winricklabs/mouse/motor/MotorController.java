package com.winricklabs.mouse.motor;

import com.pi4j.io.gpio.*;

public class MotorController {
    // create gpio controller
    private static final GpioController gpio = GpioFactory.getInstance();
    // provision gpio pin #01 as an output pin and turn on
    private static final GpioPinDigitalOutput leftOnPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED", PinState.HIGH);
    private static final GpioPinDigitalOutput leftOffPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.LOW);

    private static final GpioPinDigitalOutput rightOnPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "MyLED", PinState.HIGH);
    private static final GpioPinDigitalOutput rightOffPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "MyLED", PinState.LOW);
    private static final GpioPinPwmOutput leftMotorSpeed;
    private static final GpioPinPwmOutput rightMotorSpeed;

    static {
        leftMotorSpeed = gpio.provisionPwmOutputPin(RaspiPin.GPIO_23);
        leftMotorSpeed.setPwmRange(1000);


        rightMotorSpeed = gpio.provisionPwmOutputPin(RaspiPin.GPIO_03);
        rightMotorSpeed.setPwmRange(1000);

        leftMotorSpeed.setPwm(100);
        rightMotorSpeed.setPwm(100);
        System.err.println("Yuxiu: static block runs");

    }

    public static void updateMotors(int leftInputSpeed, int rightInputSpeed) {
        leftMotorSpeed.setPwm(leftInputSpeed);
        rightMotorSpeed.setPwm(rightInputSpeed);
        System.err.println("Yuxiu: updated motor with speed :  "+leftInputSpeed + ", "+rightInputSpeed);

    }

}
