package com.winricklabs.mouse.motor;

import com.pi4j.io.gpio.*;

public class MotorController {
    // create gpio controller
    private static final GpioController gpio = GpioFactory.getInstance();
    // provision gpio pin #01 as an output pin and turn on
    private static final GpioPinDigitalOutput leftOnPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "MyLED", PinState.HIGH);
    private static final GpioPinDigitalOutput leftOffPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "MyLED", PinState.LOW);

    private static final GpioPinDigitalOutput rightOnPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "MyLED", PinState.HIGH);
    private static final GpioPinDigitalOutput rightOffPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLED", PinState.LOW);
    private static final GpioPinPwmOutput leftMotorSpeed;
    private static final GpioPinPwmOutput rightMotorSpeed;

    static {
        leftMotorSpeed = gpio.provisionSoftPwmOutputPin(RaspiPin.GPIO_13);
        leftMotorSpeed.setPwmRange(1000);

        rightMotorSpeed = gpio.provisionSoftPwmOutputPin(RaspiPin.GPIO_22);
        rightMotorSpeed.setPwmRange(1000);

        leftMotorSpeed.setPwm(500);
        rightMotorSpeed.setPwm(500);

    }

    public static void updateMotors(int leftInputSpeed, int rightInputSpeed) {
        leftMotorSpeed.setPwm(leftInputSpeed);
        rightMotorSpeed.setPwm(rightInputSpeed);

    }

}
