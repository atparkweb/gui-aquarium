import javax.swing.*;
import java.awt.*;

public class Window {
    final int FRAME_WIDTH = 800;
    final int FRAME_HEIGHT = 600;

    private static Window instance;
    public JFrame frame;
    public JPanel panel;
    public Graphics graphics;

    private Window() {
        this.panel = new JPanel();
        this.panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        this.panel.setBackground(Color.blue);

        this.frame = new JFrame();
        frame.add(panel);
        this.frame.setBounds(10, 10, FRAME_WIDTH, FRAME_HEIGHT);
        this.frame.setLayout(null);
        this.frame.setTitle("GUI Aquarium");
        this.frame.setResizable(false);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        graphics = this.frame.getGraphics();
    }

    public static synchronized Window getInstance() {
        if (instance == null) {
            instance = new Window();
        }

        return instance;
    }
}
