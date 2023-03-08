import com.sun.javaws.exceptions.InvalidArgumentException;

public class Icon {
    public static final String fish = "sprites/fishTile_080.png";
    public static final String fishDead = "sprites/fishTile_098.png";
    public static final String piranha = "sprites/fishTile_072.png";
    public static final String piranhaDead = "sprites/fishTile_090.png";

    public static String[] getIcons(AnimalType type) throws InvalidArgumentException {
        switch (type) {
            case FISH:
                return new String[]{ fish, fishDead };
            case PIRANHA:
                return new String[]{ piranha, piranhaDead };
            default:
                throw new InvalidArgumentException(new String[]{"Invalid Animal type", type.toString()});
        }
    }
}
