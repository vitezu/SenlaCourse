package impl;
import api.IProductPart;
import api.IProdukt;

import java.util.ArrayList;
import java.util.List;

public class Tank implements IProdukt {
    private Integer serNum;
    private List<IProductPart> productParts = new ArrayList<>();

    public Tank(Integer serNum) {
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
}
