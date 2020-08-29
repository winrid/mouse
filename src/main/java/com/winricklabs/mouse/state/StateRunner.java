package com.winricklabs.mouse.state;

import java.util.logging.Logger;

public class StateRunner {

    private static final Logger logger = Logger.getLogger(StateRunner.class.getName());

    public void run(MouseState initialState) {
        logger.info("StateRunner BEGIN " + initialState.getClass().getName());
        MouseState state = initialState;
        while (state != null) {
            MouseState newState = state.run();
            if (newState != null && state != newState) {
                logger.info("StateRunner UPDATE " + state.getClass().getName() + " -> " + newState.getClass().getName());
            }
            state = newState;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("StateRunner END");
    }

}
