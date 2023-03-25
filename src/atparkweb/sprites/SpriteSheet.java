package atparkweb.sprites;

import atparkweb.aquarium.AnimalType;

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

    // TODO Make a dictionary of all types to images
    public static String getSpriteKey(AnimalType type, boolean isAlive) {
        switch(type) {
            case FISH:
                return isAlive ? "fishTile_080.png" : "fishTile_098.png";
            case PIRANHA:
                return isAlive ? "fishTile_072.png" : "fishTile_090.png";
            default:
                return "";
        }
    }

    public BufferedImage getSpriteImage(AnimalType type, boolean isAlive) {
        SpriteDataStore ds = SpriteDataStore.getInstance();
        SpriteProps sprite = ds.getSpriteData(getSpriteKey(type, isAlive));

        return sheetImage.getSubimage(
            sprite.x,
            sprite.y,
            sprite.width,
            sprite.height
        );
    }
}
