import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animals = SpawningPool.getAnimals(5, 2);

        EventQueue.invokeLater(() -> {
            JFrame frame = Window.getInstance();
            Renderer renderer = new Renderer(animals, 2, frame.getWidth(), frame.getHeight());
            frame.add(renderer);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
