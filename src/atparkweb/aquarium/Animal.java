package atparkweb.aquarium;

public class Animal {
    private int x;
    private int y;
    private int vx;
    private int vy;
    private boolean isAlive = true;
    private final AnimalType type;

    public Animal(int x, int y, int vx, int vy, AnimalType type) {
        this.type = type;

        this.x = x;
        this.y = y;
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

    public int getX() { return x; }
    public int getY() { return y; }
    public int getVx() { return vx; }

    public void kill() {
        isAlive = false;
        vx = 0;
        vy = 1;
    }
    public AnimalType getType() { return type; }
    public boolean getIsAlive() { return isAlive; }
}
