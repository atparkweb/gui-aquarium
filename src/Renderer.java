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
    private final Timer timer;
    private final ArrayList<Animal> animals;

    public Renderer(Window window, ArrayList<Animal> animals) {
        int width = window.getWidth();
        int height = window.getHeight();

        this.animals = animals;
        setBounds(0, 0, width, height);
        window.add(this);

        graphics = window.getGraphics();

        addKeyListener(this);
        setFocusable(true);
        timer = new Timer(10, this);

        paint();
    }

    public void paint() {
        setBackground(Color.blue);

        for (Animal animal : animals) {
            ImageIcon icon = animal.getIcon();
            animal.move();
            icon.paintIcon(this, graphics, animal.getX(), animal.getY());
        }

        graphics.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
