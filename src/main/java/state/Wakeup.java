package state;

public class Wakeup implements MouseState {
    @Override
    public MouseState run() {
        return new Hunt();
    }
}
