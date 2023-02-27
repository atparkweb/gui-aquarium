public class Animal extends Sprite {
    private int vx = 1;
    private int vy = 1;

    public Animal(int x, int y, String iconPath) {
        super(x, y, iconPath);
    }

    public void move() {
        x += vx;
        y += vy;
    }
}
