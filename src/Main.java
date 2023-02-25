public class Main {
    public static void main(String[] args) {
        Window window = Window.getInstance();

        Renderer renderer = new Renderer(window);

        renderer.render(new Fish());
    }
}
