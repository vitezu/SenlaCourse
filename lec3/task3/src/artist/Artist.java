package artist;

public class Artist {
    private String name;
    private String placeFrom;

    public Artist(String name, String placeFrom) {
        this.name = name;
        this.placeFrom = placeFrom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Artist{");
        sb.append("name='").append(name).append('\'');
        sb.append(", placeFrom='").append(placeFrom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
