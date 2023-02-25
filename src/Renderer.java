import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;

public class Renderer {
    JPanel panel;
    Graphics graphics;

    public Renderer(Window window) {
        int width = window.getWidth();
        int height = window.getHeight();

        panel = new JPanel();
        panel.setBounds(0, 0, width, height);
        panel.setBackground(Color.blue);

        window.add(panel);

        graphics = window.getGraphics();
    }

    public void render(Drawable drawable) {
        ImageIcon sprite = drawable.getSprite();
        sprite.paintIcon(panel, graphics, drawable.getX(), drawable.getY());
    }
}
