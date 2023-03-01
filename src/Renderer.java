import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Renderer extends JPanel implements ActionListener, KeyListener {
    private final Graphics graphics;
    private Timer timer;
    private final ArrayList<Sprite> spriteList;
    private boolean isPlaying = false;

    public Renderer(Window window, ArrayList<Sprite> spriteList) {
        int width = window.getWidth();
        int height = window.getHeight();

        this.spriteList = spriteList;
        setBounds(0, 0, width, height);
        window.add(this);

        graphics = window.getGraphics();

        addKeyListener(this);
        setFocusable(true);

        paint();
    }

    public void paint() {
        setBackground(Color.blue);

        for (Sprite sprite : spriteList) {
            sprite.update();
            ImageIcon icon = sprite.getIcon();
            icon.paintIcon(this, graphics, sprite.getX(), sprite.getY());
        }

        graphics.dispose();
    }

    public void start() {
        if (timer == null) {
            timer = new Timer(10, this);
        } else {
            timer.start();
        }

        isPlaying = true;
    }

    public void stop() {
        if (timer == null) {
            timer = new Timer(10, this);
        } else {
            timer.stop();
        }

        isPlaying = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isPlaying) {
            start();
        } else {
            stop();
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isPlaying = !isPlaying;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
