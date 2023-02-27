import javax.swing.ImageIcon;
import java.net.URL;

public class Fish implements Sprite {
    ImageIcon icon;
    private int x;
    private int y;

    public Fish() {
        this(80, 80);
    }

    public Fish(int x, int y) throws NullPointerException {
        final String iconPath = "sprites/fishTile_080.png";

        URL resourceURL = Fish.class.getClassLoader().getResource(iconPath);

        if (resourceURL == null) throw new NullPointerException("Unable to load resource: " + iconPath);
        this.icon = new ImageIcon(resourceURL);
        this.x = x; this.y = y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public ImageIcon getIcon() { return this.icon; }

    @Override
    public int getX() { return this.x; }

    @Override
    public int getY() { return this.y; }
}
