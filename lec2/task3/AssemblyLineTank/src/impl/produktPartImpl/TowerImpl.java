package impl.produktPartImpl;

import api.IProductPart;

public class TowerImpl implements IProductPart {
    private Integer rangeFire;
    private Integer caliber;

    public TowerImpl(Integer rangeFire, Integer caliber) {
        this.rangeFire = rangeFire;
        this.caliber = caliber;
    }

    public Integer getRangeFire() {
        return rangeFire;
    }

    public void setRangeFire(Integer rangeFire) {
        this.rangeFire = rangeFire;
    }

    public Integer getCaliber() {
        return caliber;
    }

    public void setCaliber(Integer caliber) {
        this.caliber = caliber;
    }

}
