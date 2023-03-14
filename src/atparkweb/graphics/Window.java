package atparkweb.graphics;

import javax.swing.JFrame;

public class Window extends JFrame {
    private static Window instance;
    private final int width;
    private final int height;

    private Window() {
        this(800, 600);
    }

    private Window(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        this.setTitle("GUI Aquarium");
        this.setResizable(false);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public static Window getInstance() {
        if (instance == null) {
            instance = new Window();
        }

        return instance;
    }
}
