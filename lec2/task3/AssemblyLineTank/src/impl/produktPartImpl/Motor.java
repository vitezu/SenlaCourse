package impl.produktPartImpl;

import api.IProductPart;

public class Motor implements IProductPart {
    private Integer serialNum;
    private Integer power;
    private Integer capacity;

    public Motor(Integer serialNum, Integer power, Integer capacity) {
        this.serialNum = serialNum;
        this.power = power;
        this.capacity = capacity;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void buzz () {
        System.out.println("Trrrr-trrrrr");
    }

}
