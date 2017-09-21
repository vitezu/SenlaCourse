package restaurant;

public class Table {
    private Integer numId;
    private Boolean occupied;

    public Table(Integer numId, Boolean occupied) {
        this.numId = numId;
        this.occupied = occupied;
    }

    public Integer getNumId() {
        return numId;
    }
}
