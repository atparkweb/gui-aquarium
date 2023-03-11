import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {
    private BufferedImage sheetImage;

    public SpriteSheet(String path) {
        try {
            sheetImage = ImageIO.read(new File(path));
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // TODO Make method that can get any sprite given a label and resolution
    public BufferedImage getFishSprite() {
        return sheetImage.getSubimage(320, 466, 54, 30);
    }

    // TODO Make method that can get any sprite given a label and resolution
    public BufferedImage getPiranhaSprite() {
        return sheetImage.getSubimage(320, 428, 54, 38);
    }
}
