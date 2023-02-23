import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Main {
    private static void renderFish(JPanel panel, Graphics graphics) {
        try {
            URL iconPath = Main.class.getClassLoader().getResource("sprites/fishTile_080.png");
            if (iconPath != null) {
                ImageIcon fishSprite = new ImageIcon(iconPath);
                fishSprite.paintIcon(panel, graphics, 80, 80);
            }
        } catch (NullPointerException e) {
            System.out.println("Unable to load icon");
        }
    }

    public static void main(String[] args) {
        // Make a panel
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 600, 600);
        panel.setBackground(Color.blue);

        // Make a frame
        JFrame frame = new JFrame("Aquarium");
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);

        // Add a sprite
        Graphics graphics = frame.getGraphics();
        renderFish(panel, graphics);
    }
}
