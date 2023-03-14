package atparkweb.utils;

import javax.swing.Timer;

public class Clock {
    public interface Callback {
        void tick(Clock clock);
    }

    private Timer timer;

    private Callback callback;

    public void setCallback(Callback tick) {
        this.callback = tick;
    }

    public void start() {
        if (timer == null) {
            timer = new Timer(5, e -> {
                if (callback != null) {
                    callback.tick(Clock.this);
                }
            });

            timer.start();
        }
    }

    public void stop() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }
}
