package com.winricklabs.mouse.state;

public class Hunt implements MouseState {

    private final long startTime;

    public Hunt() {
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public MouseState run() {
        // Switch back to being prey if we've been hunting for too long
        if (System.currentTimeMillis() - startTime > 30 * 1000) {
            return new Escape();
        }

        // find mouse in view, change direction.
        // if not in view, return
        new StateRunner().run(new CatSearch());

        return this;
    }

    private class CatSearch implements MouseState {

        private final long startTime;

        public CatSearch() {
            this.startTime = System.currentTimeMillis();
        }

        @Override
        public MouseState run() {
            boolean foundCat = false; // todo
            if (foundCat) {
                return new CatAttack();
            }
            return this;
        }
    }

    private class CatAttack implements MouseState {

        private final long startTime;

        public CatAttack() {
            this.startTime = System.currentTimeMillis();
        }

        @Override
        public MouseState run() {
            boolean foundCat = false; // todo
            if (foundCat) {
                // TODO move and stuff
                return this;
            }
            return null;
        }
    }
}
