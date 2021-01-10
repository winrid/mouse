package com.winricklabs.mouse.motor;

import com.pi4j.io.gpio.*;

public class MotorController {
    // create gpio controller
    private static final GpioController gpio = GpioFactory.getInstance();
    // provision gpio pin #01 as an output pin and turn on
    private static final GpioPinDigitalOutput leftOnPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "left motor forward", PinState.HIGH);
    private static final GpioPinDigitalOutput leftOffPin = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_27, "left motor backward", PinState.LOW);

    private static final GpioPinDigitalOutput rightOnPin = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_06, "right motor forward", PinState.HIGH);
    private static final GpioPinDigitalOutput rightOffPin = gpio.provisionDigitalOutputPin(RaspiBcmPin.GPIO_05, "right motor backward", PinState.LOW);
    private static final GpioPinPwmOutput leftMotorSpeed;
//    private static final GpioPinPwmOutput rightMotorSpeed;

    static {
        leftOnPin.setShutdownOptions(true, PinState.LOW);
        leftOnPin.high();
        leftOffPin.low();
        leftMotorSpeed = gpio.provisionPwmOutputPin(RaspiBcmPin.GPIO_13);
        leftMotorSpeed.setPwmRange(1000);

//        rightMotorSpeed = gpio.provisionPwmOutputPin(RaspiBcmPin.GPIO_22);
//        rightMotorSpeed.setPwmRange(100);

        leftMotorSpeed.setPwm(500);
//        rightMotorSpeed.setPwm(100);
        System.err.println("Yuxiu: static block runs");

    }

    public static void updateMotors(int leftInputSpeed, int rightInputSpeed) {
        leftMotorSpeed.setPwm(leftInputSpeed);
//        rightMotorSpeed.setPwm(rightInputSpeed);
        System.err.println("Yuxiu: updated motor with speed :  "+leftInputSpeed + ", "+rightInputSpeed);

    }

}
