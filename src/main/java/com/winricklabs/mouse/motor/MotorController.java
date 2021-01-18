package com.winricklabs.mouse.motor;

import com.pi4j.io.gpio.*;

public class MotorController {
    // create gpio controller
    private static final GpioController gpio = GpioFactory.getInstance();
    // provision gpio pin #01 as an output pin and turn on
    private static final GpioPinDigitalOutput leftForwardPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "Left Forward", PinState.HIGH);
    private static final GpioPinDigitalOutput leftReversePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Left Reverse", PinState.LOW);

    private static final GpioPinDigitalOutput rightForwardPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "Right Forward", PinState.HIGH);
    private static final GpioPinDigitalOutput rightReversePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "Right Reverse", PinState.LOW);
    private static final GpioPinPwmOutput leftMotorSpeed;
    private static final GpioPinPwmOutput rightMotorSpeed;

    static {
        leftMotorSpeed = gpio.provisionPwmOutputPin(RaspiPin.GPIO_29);
        leftMotorSpeed.setPwmRange(100);

        rightMotorSpeed = gpio.provisionPwmOutputPin(RaspiPin.GPIO_28);
        rightMotorSpeed.setPwmRange(100);

        leftMotorSpeed.setPwm(100);
        rightMotorSpeed.setPwm(100);
        System.out.println("Static block runs");
    }

    public static void updateMotors(int leftInputSpeed, int rightInputSpeed) {
        try {
            System.out.println(String.format("Updated motor speed left=[%s] right=[%s]", leftInputSpeed, rightInputSpeed));
            updateMotorSpeed(leftForwardPin, leftReversePin, leftMotorSpeed, leftInputSpeed);
            updateMotorSpeed(rightForwardPin, rightReversePin, rightMotorSpeed, rightInputSpeed);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void updateMotorSpeed(GpioPinDigitalOutput forwardPin, GpioPinDigitalOutput reversePin, GpioPinPwmOutput speedPin, int speed) {
        // If positive, consider that as going forward
        if (speed >= 0) {
            forwardPin.high();
            reversePin.low();
        } else {
            forwardPin.low();
            reversePin.high();
        }
        int speedAbs = Math.abs(speed);
        System.out.println("Speed passed to motor is " + speed);
        speedPin.setPwm(speedAbs);
    }

}
