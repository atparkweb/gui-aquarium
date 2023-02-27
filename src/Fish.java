import javax.swing.ImageIcon;
import java.net.URL;

public class Fish implements Sprite {
    ImageIcon icon;
    private int x;
    private int y;
    private int vx = 1;
    private int vy = 1;

    public Fish(int x, int y) throws NullPointerException {
        final String iconPath = "sprites/fishTile_080.png";

        URL resourceURL = Fish.class.getClassLoader().getResource(iconPath);

        if (resourceURL == null) throw new NullPointerException("Unable to load resource: " + iconPath);
        icon = new ImageIcon(resourceURL);
        this.x = x; this.y = y;
    }

    @Override
    public void move() {
        x += vx;
        y += vy;
    }

    @Override
    public ImageIcon getIcon() { return icon; }

    @Override
    public int getX() { return x; }

    @Override
    public int getY() { return y; }
}
