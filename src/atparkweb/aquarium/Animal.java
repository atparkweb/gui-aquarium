package atparkweb.aquarium;

import atparkweb.graphics.Window;

public class Animal {
    private int x;
    private int y;
    private int vx;
    private int vy;
    private int health;
    private boolean isAlive = true;
    private final AnimalType type;
    private final Window frame;

    public Animal(int x, int y, int vx, int vy, AnimalType type) {
        this.type = type;

        frame = Window.getInstance();

        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.health = 100;
    }

    public void update(int width, int height) {
        if (health == 0) {
            isAlive = false;
            return;
        }

        if (x > frame.getWidth() - width || x < 0) {
            vx = -vx;
        }

        if (y > frame.getHeight() - height || y < 0) {
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
