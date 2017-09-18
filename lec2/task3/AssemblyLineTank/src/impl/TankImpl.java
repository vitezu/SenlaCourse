package impl;
import api.IProductPart;
import api.IProdukt;

import java.util.ArrayList;
import java.util.List;

public class TankImpl implements IProdukt {
    private Integer serNum;
    private List<IProductPart> productParts = new ArrayList<>();

    public TankImpl(Integer serNum) {
        this.serNum = serNum;
    }

    public Integer getSerNum() {
        return serNum;
    }

    public void setSerNum(Integer serNum) {
        this.serNum = serNum;
    }

    public List<IProductPart> getProductParts() {
        return productParts;
    }

    @Override
    public void installFirstPart(IProductPart productPart) {
        productParts.add(productPart);
        System.out.println("Мотор установлен");
    }

    @Override
    public void installSecondPart(IProductPart productPart) {
        productParts.add(productPart);
        System.out.println("Корпус установлен");
    }

    @Override
    public void installThirdPart(IProductPart productPart) {
        productParts.add(productPart);
        System.out.println("Башня установлена");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TankImpl{");
        sb.append("serNum=").append(serNum);
        sb.append(", productParts=").append(productParts);
        sb.append('}');
        return sb.toString();
    }
}
