import javax.swing.ImageIcon;
import java.net.URL;

public class Fish {
    private final ImageIcon sprite;
    public int x;
    public int y;

    public Fish(URL spriteURL) throws NullPointerException {
        this(spriteURL, 80, 80);
    }

    public Fish(URL spriteURL, int x, int y) throws NullPointerException {
        this.sprite = new ImageIcon(spriteURL);
        this.x = x; this.y = y;
    }

    public ImageIcon getSprite() { return this.sprite; }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
