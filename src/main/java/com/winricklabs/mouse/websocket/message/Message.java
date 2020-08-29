package com.winricklabs.mouse.websocket.message;

public class Message {
    private double leftMotor;
    private double rightMotor;
    public Message(double leftMotor, double rightMotor) {
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }
}
