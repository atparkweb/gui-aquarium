import javax.swing.ImageIcon;
import java.net.URL;

public abstract class Sprite {
    protected int x;
    protected int y;
    private final ImageIcon icon;

    public Sprite(int x, int y, String iconPath) throws NullPointerException {
        URL resourceURL = Fish.class.getClassLoader().getResource(iconPath);
        if (resourceURL == null) throw new NullPointerException("Unable to load resource: " + iconPath);
        icon = new ImageIcon(resourceURL);
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() {
        return y;
    }
    public ImageIcon getIcon() {
        return icon;
    }

    abstract public void update();
}
