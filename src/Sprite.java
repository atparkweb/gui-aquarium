import javax.swing.ImageIcon;

public interface Sprite {
    int getX();
    int getY();
    ImageIcon getIcon();
    void move();
}
