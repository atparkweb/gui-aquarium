package atparkweb.animation;

import atparkweb.aquarium.Animal;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpatialPartition {
    private final int numPartitions;
    private final ArrayList<Animal> objects;
    double partitionSize;

    Map<Point, ArrayList<Drawable>> partitions;
    public SpatialPartition (int numPartitions, ArrayList<Animal> objects, int width, int height) {
        this.numPartitions = numPartitions;
        partitionSize = (double)Math.min(width, height) / numPartitions;
        partitions = new HashMap<>();
        this.objects = objects;
    }

    public Map<Point, ArrayList<Drawable>> partitionObjects() {
        // assign each object to the appropriate partition
        for (Drawable obj : objects) {
            // calculate the coordinates of the partition that contains the object
            int partitionX = Math.min((int) (obj.getX() / partitionSize), numPartitions - 1);
            int partitionY = Math.min((int) (obj.getY() / partitionSize), numPartitions - 1);
            Point partition = new Point(partitionX, partitionY);

            // add the object to the list of objects in the partition
            partitions.computeIfAbsent(partition, k -> new ArrayList<>()).add(obj);
        }

        return partitions;
    }
}
