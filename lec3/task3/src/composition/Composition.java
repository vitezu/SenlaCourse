package composition;

import artist.Artist;

public class Composition {
    private String name;
    private Artist artist;
    private Integer duration;

    public Composition(String name, Artist artist, Integer duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Composition{");
        sb.append("name='").append(name).append('\'');
        sb.append(", artist=").append(artist);
        sb.append(", duration=").append(duration);
        sb.append('}');
        return sb.toString();
    }
}
