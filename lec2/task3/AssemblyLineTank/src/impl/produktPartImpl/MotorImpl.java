package impl.produktPartImpl;

import api.IProductPart;

public class MotorImpl implements IProductPart {
    private Integer serialNum;
    private Integer power;
    private Integer capacity;

    public MotorImpl(Integer serialNum, Integer power, Integer capacity) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MotorImpl{");
        sb.append("serialNum=").append(serialNum);
        sb.append(", power=").append(power);
        sb.append(", capacity=").append(capacity);
        sb.append('}');
        return sb.toString();
    }
}
