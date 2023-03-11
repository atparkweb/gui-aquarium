import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class SpriteSheet {
    private BufferedImage sheetImage;

    public SpriteSheet(String path) {
        try {
            URL resource = SpriteSheet.class.getResource(path);
            if (resource == null) throw new NullPointerException("Unable to get resource from path: " + path);

            File f = Paths.get(resource.toURI()).toFile();

            sheetImage = ImageIO.read(f);
        } catch(IOException | URISyntaxException | NullPointerException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
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

    public static int getSpriteWidth(AnimalType type) {
        switch (type) {
            case FISH: return 54;
            case PIRANHA: return 54;
            default: return 0;
        }
    }

    public static int getSpriteHeight(AnimalType type) {
        switch (type) {
            case FISH: return 30;
            case PIRANHA: return 38;
            default: return 0;
        }
    }
}
