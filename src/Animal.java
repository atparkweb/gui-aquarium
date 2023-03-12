public class Animal {
    private int x;
    private int y;
    private int vx;
    private int vy;
    private int health;
    private boolean isAlive = true;
    private final AnimalType type;
    private final Window frame;
    private final SpriteProps sprite;

    public Animal(int x, int y, int vx, int vy, AnimalType type) {
        this.type = type;

        frame = Window.getInstance();
        final SpriteDataStore dataStore = SpriteDataStore.getInstance();
        sprite = dataStore.getSpriteData(SpriteSheet.getSpriteKey(type, isAlive));

        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.health = 100;
    }

    public void update() {
        if (health == 0) {
            isAlive = false;
            return;
        }

        if (x > frame.getWidth() - sprite.width || x < 0) {
            vx = -vx;
        }

        if (y > frame.getHeight() - sprite.height || y < 0) {
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
    public boolean getIsAlive() { return isAlive; }
}
