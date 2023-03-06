import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Animal fish = new Fish(80, 80, 2, 1);
        Animal piranha = new Piranha(80, 240, 1, 2);
        ArrayList<Sprite> animals = new ArrayList<>();
        animals.add(fish);
        animals.add(piranha);

        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setTitle("GUI Aquarium");
            frame.setResizable(false);
            frame.setFocusable(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Renderer renderer = new Renderer(animals, 60);
            frame.add(renderer);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
