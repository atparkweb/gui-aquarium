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

    public void render(Drawable drawable) {
        ImageIcon sprite = drawable.getSprite();
        sprite.paintIcon(this, graphics, drawable.getX(), drawable.getY());
    }
}
