import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Window window = Window.getInstance();

        Animal fish = new Fish(80, 80);
        Animal piranha = new Piranha(80, 240);
        ArrayList<Sprite> animals = new ArrayList<>();
        animals.add(fish);
        animals.add(piranha);

        new Renderer(window, animals);
    }
}
