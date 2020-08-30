package com.winricklabs.mouse.motor;

import com.pi4j.io.gpio.*;

public class MotorController {

    public static void updateMotors(int left, int right) {
        final GpioController gpio = GpioFactory.getInstance();

        GpioPinPwmOutput meLeftFeetPin = gpio.provisionSoftPwmOutputPin(RaspiPin.GPIO_01);
        meLeftFeetPin.setPwmRange(100);

        GpioPinPwmOutput meRightFeetPin = gpio.provisionSoftPwmOutputPin(RaspiPin.GPIO_02);
        meRightFeetPin.setPwmRange(100);

        meLeftFeetPin.setPwm(left);
        meRightFeetPin.setPwm(right);

    }

}
