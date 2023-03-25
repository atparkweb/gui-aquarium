package atparkweb.aquarium;

public class Animal {
    private int x;
    private int y;
    private int vx;
    private int vy;
    private int health;
    private boolean isAlive = true;
    private final AnimalType type;

    public Animal(int x, int y, int vx, int vy, AnimalType type) {
        this.type = type;

        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.health = 100;
    }

    public void update(int xBound, int yBound) {
        if (health == 0) {
            isAlive = false;
            return;
        }

        if (x > xBound || x < 0) {
            vx = -vx;
        }

        if (y > yBound || y < 0) {
            vy = -vy;
        }

        x += vx;
        y += vy;
    }

    public void kill() {
        isAlive = false;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getVx() { return vx; }
    public AnimalType getType() { return type; }
    public boolean getIsAlive() { return isAlive; }
}
