import javax.swing.*;
import java.net.URL;

public class Fish implements Drawable {
    private final ImageIcon sprite;
    public int x;
    public int y;

    public Fish() throws NullPointerException {
        this(80, 80);
    }

    public Fish(int x, int y) throws NullPointerException {
        final String spritePath = "sprites/fishTile_080.png";

        URL resourceURL = Fish.class.getClassLoader().getResource(spritePath);

        if (resourceURL == null) throw new NullPointerException("Unable to load resource: " + spritePath);
        this.sprite = new ImageIcon(resourceURL);
        this.x = x; this.y = y;
    }

    @Override
    public void render(Window window) {
        this.sprite.paintIcon(window.panel, window.graphics, this.getX(), this.getY());
    }

    public ImageIcon getSprite() { return this.sprite; }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
