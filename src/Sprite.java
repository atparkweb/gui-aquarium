import javax.swing.ImageIcon;
import java.net.URL;

public class Sprite {
    private ImageIcon icon;
    private String iconPath;
    private int width;
    private int height;

    public Sprite(String iconPath) {
        updateIcon(iconPath);
    }

    private ImageIcon loadIcon() throws NullPointerException {
        URL resourceURL = Sprite.class.getClassLoader().getResource(iconPath);
        if (resourceURL == null) throw new NullPointerException("Unable to load resource: " + iconPath);
        return new ImageIcon(resourceURL);
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void updateIcon(String iconPath) {
        this.iconPath = iconPath;
        icon = loadIcon();
        width = icon.getIconWidth();
        height = icon.getIconHeight();
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
