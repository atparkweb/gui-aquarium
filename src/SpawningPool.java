import java.util.ArrayList;

public class SpawningPool {
    public static ArrayList<Animal> getAnimals() {
        Animal fish = new Animal(80, 80, 2, 1, AnimalType.FISH);
        Animal piranha = new Animal(80, 240, 1, 2, AnimalType.PIRANHA);
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(fish);
        animals.add(piranha);

        return animals;
    }
}
