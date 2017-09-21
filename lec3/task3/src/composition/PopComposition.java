package composition;

import artist.Artist;

public class PopComposition extends Composition {
    private Integer reiting;
    public static Integer popCount = 0;

    public PopComposition(String name, Artist artist, Integer duration, Integer reiting) {
        super(name, artist, duration);
        this.reiting = reiting;
        popCount++;
    }
    public Integer getPopCount() {
        return popCount;
    }
}
