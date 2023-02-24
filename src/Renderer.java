import javax.swing.ImageIcon;

public class Renderer {
    Window window;

    public Renderer(Window window) {
        this.window = window;
    }

    public void render(Drawable drawable) {
        ImageIcon sprite = drawable.getSprite();
        sprite.paintIcon(this.window.panel, this.window.graphics, drawable.getX(), drawable.getY());
    }
}
