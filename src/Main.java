import atparkweb.graphics.Renderer;
import atparkweb.graphics.Window;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = Window.getInstance();
        Renderer renderer = new Renderer(30, frame.getWidth(), frame.getHeight());
        frame.add(renderer);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
