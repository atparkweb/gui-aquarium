import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Renderer extends JPanel {
    private final ArrayList<Animal> animalList;
    private final Clock clock;
    private Instant startedAt;

    public Renderer(ArrayList<Animal> animalList, long durationInSeconds) {
        this.animalList = animalList;

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
                for (Animal animal : animalList) {
                    animal.kill();
                }
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
        for (Animal animal : animalList) {
            animal.update();
            ImageIcon icon = animal.getSprite().getIcon();
            icon.paintIcon(this, g, animal.getX(), animal.getY());
        }

        g.dispose();
    }
}
