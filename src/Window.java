import javax.swing.JFrame;

public class Window extends JFrame {
    final int FRAME_WIDTH = 800;
    final int FRAME_HEIGHT = 600;

    private static Window instance;

    private Window() {
        this.setBounds(10, 10, FRAME_WIDTH, FRAME_HEIGHT);
        this.setLayout(null);
        this.setTitle("GUI Aquarium");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static synchronized Window getInstance() {
        if (instance == null) {
            instance = new Window();
        }

        return instance;
    }
}
