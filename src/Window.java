import javax.swing.JFrame;

public class Window extends JFrame {
    private final int width;
    private final int height;

    public Window(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        this.setResizable(false);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
