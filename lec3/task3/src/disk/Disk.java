package disk;

import composition.Composition;

public class Disk {
    private String name;
    private Composition[] compositions = new Composition[5];
    private Integer year;
    private Integer n = 0;

    public Disk(String name, Integer year) {
        this.name = name;
        this.year = year;
    }

    public void addCompositions (Composition composition) {
        compositions[n] = composition;
        n++;
    }

    public Composition[] getCompositions() {
        return compositions;
    }

    public Integer getSumDuration (Disk disk){
        Integer sum = 0;
 for (int i = 0; i<disk.compositions.length; i++){
    sum += disk.compositions[i].getDuration();
}
        return sum;
    }
}
