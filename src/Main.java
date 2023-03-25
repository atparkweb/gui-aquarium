import atparkweb.animation.Renderer;

public class Main {
    public static void main(String[] args) {
        Window frame = new Window(800, 600);
        frame.setTitle("GUI Aquarium");
        Renderer renderer = new Renderer(30, frame.getWidth(), frame.getHeight());
        frame.add(renderer);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
