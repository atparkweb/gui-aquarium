import com.sun.javaws.exceptions.InvalidArgumentException;

public class Animal {
    private int x;
    private int y;
    private int vx;
    private int vy;
    private boolean isAlive = true;
    private Sprite sprite;
    private String[] icons;

    public Animal(int x, int y, int vx, int vy, AnimalType type) {
        try {
            icons = Icon.getIcons(type);
            sprite = new Sprite(icons[0]);
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
        } catch (InvalidArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update() {
        if (!isAlive) {
            sprite.updateIcon(icons[1]);
            return;
        }

        if (x > 800 || x < 0) {
            vx = -vx;
        }

        if (y > 600 || y < 0) {
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
    public Sprite getSprite() { return sprite; }
}
