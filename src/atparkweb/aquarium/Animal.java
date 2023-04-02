package atparkweb.aquarium;

import atparkweb.animation.Drawable;

public class Animal extends Drawable {
    private int vx;
    private int vy;
    private boolean isAlive = true;
    private final AnimalType type;

    public Animal(int x, int y, int vx, int vy, AnimalType type) {
        super(x, y);
        this.type = type;

        this.vx = vx;
        this.vy = vy;
    }

    public void update(int xBound, int yBound) {
        if (isAlive) {
            // Reverse direction at x boundaries
            if (x > xBound || x < 0) {
                vx = -vx;
            }

            // Reverse direction at y boundaries
            if (y > yBound || y < 0) {
                vy = -vy;
            }
        } else {
            if (y <= 0) {
                vy = 0;
            }
        }

        x += vx;
        y += vy;
    }

    public int getVx() { return vx; }

    public void kill() {
        isAlive = false;
        vx = 0;
        vy = 1;
    }
    public AnimalType getType() { return type; }
    public boolean getIsAlive() { return isAlive; }
}
