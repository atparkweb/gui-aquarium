import javax.swing.*;
import java.awt.*;

public class Window {
    private static Window instance;
    public JFrame frame;
    public JPanel panel;
    public Graphics graphics;

    private Window() {
        this.panel = new JPanel();
        this.panel.setBounds(0, 0, 600, 600);
        this.panel.setBackground(Color.blue);

        this.frame = new JFrame("Aquarium");
        frame.add(panel);
        this.frame.setSize(600, 600);
        this.frame.setLayout(null);
        this.frame.setVisible(true);

        graphics = this.frame.getGraphics();
    }

    public static synchronized Window getInstance() {
        if (instance == null) {
            instance = new Window();
        }

        return instance;
    }
}
