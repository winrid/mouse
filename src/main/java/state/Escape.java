package state;

public class Escape implements MouseState {

    private final long startTime;

    public Escape() {
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public MouseState run() {
        // Switch back to hunting if we've been running away for too long
        if (System.currentTimeMillis() - startTime > 15 * 1000) {
            return new Hunt();
        }

        // TODO move erratically.

        return this;
    }
}
