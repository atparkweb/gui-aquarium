package atparkweb.graphics;

import atparkweb.utils.Clock;
import atparkweb.aquarium.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Renderer extends JPanel {
    private final ArrayList<Animal> animalList;
    private final Clock clock;
    private final SpriteSheet spriteSheet;
    private final int width;
    private final int height;
    private Instant startedAt;

    public Renderer(SpriteSheet spriteSheet, ArrayList<Animal> animalList, long durationInSeconds, int width, int height) {
        this.spriteSheet = spriteSheet;
        this.animalList = animalList;
        this.width = width;
        this.height = height;

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
        return new Dimension(width, height);
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
            BufferedImage spriteImage = spriteSheet.getSpriteImage(animal.getType(), animal.getIsAlive());
            if (animal.getVx() < 0) {
                AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
                tx.translate(-spriteImage.getWidth(null), 0);
                AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                spriteImage = op.filter(spriteImage, null);
            }
            g.drawImage(spriteImage, animal.getX(), animal.getY(), null, null);
        }

        g.dispose();
    }
}
