import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Main {
    private static void renderFish(JPanel panel, Graphics graphics) {
        URL resourceURL = Main.class.getClassLoader().getResource("sprites/fishTile_080.png");
        Fish fish = new Fish(resourceURL);
        ImageIcon fishSprite = fish.getSprite();
        fishSprite.paintIcon(panel, graphics, fish.getX(), fish.getY());
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
