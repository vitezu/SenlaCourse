package impl.produktPartImpl;

import api.IProductPart;

public class Body implements IProductPart {
    private String color;
    private String armor;
    private Integer weight;

    public Body(String color, String armor, Integer weight) {
        this.color = color;
        this.armor = armor;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public String getArmor() {
        return armor;
    }

    public Integer getWeight() {
        return weight;
    }

}
