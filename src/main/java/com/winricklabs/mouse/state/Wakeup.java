package com.winricklabs.mouse.state;

public class Wakeup implements MouseState {
    @Override
    public MouseState run() {
        return new Hunt();
    }
}
