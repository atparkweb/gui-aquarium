public class Animal extends Sprite {
    private final int vx;
    private final int vy;

    public Animal(int x, int y, String iconPath) {
        super(x, y, iconPath);
        vx = 10;
        vy = 0;
    }

    public void move() {
        x += vx;
        y += vy;
    }
}
