import javax.swing.*;
import java.net.URL;

public class Piranha implements Sprite {
    ImageIcon icon;
    private int x;
    private int y;

    public Piranha(int x, int y) throws NullPointerException {
        final String iconPath = "sprites/fishTile_072.png";

        URL resourceURL = Piranha.class.getClassLoader().getResource(iconPath);

        if (resourceURL == null) throw new NullPointerException("Unable to load resource: " + iconPath);
        this.icon = new ImageIcon(resourceURL);
        this.x = x; this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public ImageIcon getIcon() {
        return this.icon;
    }
}
