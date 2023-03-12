import entities.Animal;
import entities.SpawningPool;
import graphics.SpriteSheet;
import ui.Renderer;
import ui.Window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animals = SpawningPool.getAnimals(5, 2);

        EventQueue.invokeLater(() -> {
            JFrame frame = Window.getInstance();
            SpriteSheet spriteSheet = new SpriteSheet("/fishSpritesheet.png");
            ui.Renderer renderer = new Renderer(spriteSheet, animals, 30, frame.getWidth(), frame.getHeight());
            frame.add(renderer);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
