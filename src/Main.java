import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aquarium");

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 600, 600);
        panel.setBackground(Color.blue);
        frame.add(panel);

        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);

        Graphics gfx = frame.getGraphics();
        URL iconPath = Main.class.getClassLoader().getResource("sprites/fishTile_080.png");

        try {
            ImageIcon fishSprite = new ImageIcon(iconPath);
            fishSprite.paintIcon(panel, gfx, 80, 80);
        } catch (NullPointerException e) {
            System.out.println(e.toString());
            System.out.println("Resource not found at: " + iconPath);
        }
    }
}
