package com.winricklabs.mouse.state;

import java.util.logging.Logger;

public class StateRunner {

    private static final Logger logger = Logger.getLogger(StateRunner.class.getName());

    public void run(MouseState initialState) {
        logger.info("StateRunner BEGIN " + initialState.getClass().getName());
        MouseState state = initialState;
        MouseState lastState = state;
        while (state != null) {
            state = state.run();
            if (state != null && state != lastState) {
                logger.info("StateRunner UPDATE " + lastState.getClass().getName() + " -> " + state.getClass().getName());
                lastState = state;
            }
        }
        logger.info("StateRunner END");
    }

}
