package composition;

import artist.Artist;

public class RockComposition extends Composition {
    private Integer numOfGuitars;
    public static Integer rockCount = 0;

    public RockComposition(String name, Artist artist, Integer duration, Integer numOfGuitars) {
        super(name, artist, duration);
        this.numOfGuitars = numOfGuitars;
        rockCount++;
}
    public Integer getRockCount() {
        return rockCount;
    }
}
