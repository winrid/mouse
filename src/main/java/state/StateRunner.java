package state;

public class StateRunner {

    public void run(MouseState initialState) {
        MouseState state = initialState;
        while (state != null) {
            state = state.run();
        }
    }

}
