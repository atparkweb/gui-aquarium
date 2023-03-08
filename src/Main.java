import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Animal fish = new Animal(80, 80, 2, 1, AnimalType.FISH);
        Animal piranha = new Animal(80, 240, 1, 2, AnimalType.PIRANHA);
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(fish);
        animals.add(piranha);

        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setTitle("GUI Aquarium");
            frame.setResizable(false);
            frame.setFocusable(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Renderer renderer = new Renderer(animals, 2);
            frame.add(renderer);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
