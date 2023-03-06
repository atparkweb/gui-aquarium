import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Renderer extends JPanel {
    private final ArrayList<Sprite> spriteList;
    private final Clock clock;
    private Instant startedAt;

    public Renderer(ArrayList<Sprite> spriteList, long durationInSeconds) {
        this.spriteList = spriteList;

        clock = new Clock();

        Duration duration = Duration.ofSeconds(durationInSeconds);

        clock.setCallback(clock -> {
            if (startedAt == null) {
                startedAt = Instant.now();
            }

            // To limit animation to a certain duration
            Duration runtime = Duration.between(startedAt, Instant.now());
            double progress = runtime.toMillis() / (double) duration.toMillis();

            if (progress >= 1.0) {
                stopAnimation();
            }

            repaint();
        });
    }

    protected void stopAnimation() {
        clock.stop();
    }
    protected void startAnimation() {
        clock.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        startAnimation();
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        stopAnimation();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.blue);
        for (Sprite sprite : spriteList) {
            sprite.update();
            ImageIcon icon = sprite.getIcon();
            icon.paintIcon(this, g, sprite.getX(), sprite.getY());
        }

        g.dispose();
    }
}
