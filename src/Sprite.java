import javax.swing.ImageIcon;
import java.net.URL;

public class Sprite {
    private ImageIcon icon;
    private String iconPath;

    public Sprite(String iconPath) {
        this.iconPath = iconPath;
        loadIcon();
    }

    private void loadIcon() throws NullPointerException {
        URL resourceURL = Fish.class.getClassLoader().getResource(iconPath);
        if (resourceURL == null) throw new NullPointerException("Unable to load resource: " + iconPath);
        icon = new ImageIcon(resourceURL);
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void updateIcon(String iconPath) {
        this.iconPath = iconPath;
        loadIcon();
    }
}
