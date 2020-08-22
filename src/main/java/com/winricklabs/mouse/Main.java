package com.winricklabs.mouse;

import com.winricklabs.mouse.state.StateRunner;
import com.winricklabs.mouse.state.Wakeup;

public class Main {
    public static void main(String[] args) throws Exception {
        new StateRunner().run(new Wakeup());
    }
}
