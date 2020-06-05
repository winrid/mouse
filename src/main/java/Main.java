import state.StateRunner;
import state.Wakeup;

public class Main {
    public static void main(String[] args) throws Exception {
        new StateRunner().run(new Wakeup());
    }
}
