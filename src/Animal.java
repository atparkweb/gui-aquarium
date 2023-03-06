public class Animal extends Sprite {
    private int vx;
    private int vy;

    public Animal(int x, int y, int vx, int vy, String iconPath) {
        super(x, y, iconPath);
        this.vx = vx;
        this.vy = vy;
    }

    public void update() {
        if (x > 800 || x < 0) {
            vx = -vx;
        }

        if (y > 600 || y < 0) {
            vy = -vy;
        }

        x += vx;
        y += vy;
    }
}
