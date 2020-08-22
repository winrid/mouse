package com.winricklabs.mouse.state;

public interface MouseState {

    // Return the next state if it changes
    public MouseState run();

}
