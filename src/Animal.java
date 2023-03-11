import com.sun.javaws.exceptions.InvalidArgumentException;

public class Animal {
    private int x;
    private int y;
    private int vx;
    private int vy;
    private boolean isAlive = true;
    private final AnimalType type;
    private final Window frame;
    private final int width;
    private final int height;

    public Animal(int x, int y, int vx, int vy, AnimalType type) {
        this.type = type;

        frame = Window.getInstance();

        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.width = SpriteSheet.getSpriteWidth(type);
        this.height = SpriteSheet.getSpriteHeight(type);
    }

    public void update() {
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
    public AnimalType getType() { return type; }
}
