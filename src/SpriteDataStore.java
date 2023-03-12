import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class SpriteDataStore {
    private static SpriteDataStore instance = null;
    private HashMap<String, SpriteProps> data;

    enum Attribute {
        NAME,
        X,
        Y,
        WIDTH,
        HEIGHT;
    }

    private SpriteDataStore() throws IOException, XMLStreamException, URISyntaxException {
        data = new HashMap<>();

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        URL resource = SpriteSheet.class.getResource("fishSpritesheet.xml");
        if (resource == null) throw new NullPointerException("Unable to get resource from path: fishSpritesheet.xml");

        InputStream input = Files.newInputStream(Paths.get(resource.toURI()));
        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(input);

        streamReader.nextTag();

        while (streamReader.hasNext()) {
            int event = streamReader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                String name = streamReader.getAttributeValue(Attribute.NAME.ordinal());
                String x = streamReader.getAttributeValue(Attribute.X.ordinal());
                String y = streamReader.getAttributeValue(Attribute.Y.ordinal());
                String width = streamReader.getAttributeValue(Attribute.WIDTH.ordinal());
                String height = streamReader.getAttributeValue(Attribute.HEIGHT.ordinal());
                data.put(name, new SpriteProps(
                        Integer.parseInt(x),
                        Integer.parseInt(y),
                        Integer.parseInt(width),
                        Integer.parseInt(height)
                ));
            }
        }
    }

    public static SpriteDataStore getInstance() {
        if (instance == null) {
            try {
                instance = new SpriteDataStore();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.exit(1);
            }
        }

        return instance;
    }

    public SpriteProps getSpriteData(String key) {
        return data.get(key);
    }
}
