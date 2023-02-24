import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Window window = Window.getInstance();
        Fish fish = new Fish();
        fish.render(window);
    }
}
