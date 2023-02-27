import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Graphics;

public class Renderer extends JPanel {
    Graphics graphics;

    public Renderer(Window window) {
        int width = window.getWidth();
        int height = window.getHeight();

        this.setBounds(0, 0, width, height);
        this.setBackground(Color.blue);

        window.add(this);

        graphics = window.getGraphics();
    }

    public void render(Sprite sprite) {
        ImageIcon icon = sprite.getIcon();
        icon.paintIcon(this, graphics, sprite.getX(), sprite.getY());
    }
}
