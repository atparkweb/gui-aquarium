package atparkweb.aquarium;

import java.util.ArrayList;
import java.util.Random;

public class SpawningPool {
    private static int getCoord(Random rand) {
        return rand.nextInt(600);
    }
    private static int getVelocity(Random rand) {
        return Math.max(rand.nextInt(5), 1);
    }

    public static ArrayList<Animal> getAnimals(int numberOfFish, int numberOfPiranhas) {
        Random rand = new Random();

        final int MAX_FISH = 5;
        final int MAX_PIRANHAS = 2;
        int fishCount = 0;
        int piranhaCount = 0;

        ArrayList<Animal> animals = new ArrayList<>();

        while (fishCount < numberOfFish && fishCount < MAX_FISH) {
            int x = getCoord(rand);
            int y = getCoord(rand);
            int vx = getVelocity(rand);
            int vy = getVelocity(rand);
            Animal fish = new Animal(x, y, vx, vy, AnimalType.FISH);
            animals.add(fish);
            fishCount++;
        }

        while (piranhaCount < numberOfPiranhas && piranhaCount < MAX_PIRANHAS) {
            int x = getCoord(rand);
            int y = getCoord(rand);
            int vx = getVelocity(rand);
            int vy = getVelocity(rand);
            Animal piranha = new Animal(x, y, vx, vy, AnimalType.PIRANHA);
            animals.add(piranha);
            piranhaCount++;
        }

        return animals;
    }
}
