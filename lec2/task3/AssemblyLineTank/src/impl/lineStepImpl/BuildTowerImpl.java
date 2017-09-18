package impl.lineStepImpl;

import api.ILineStep;
import api.IProductPart;
import impl.produktPartImpl.TowerImpl;

public class BuildTowerImpl implements ILineStep {

    @Override
    public IProductPart buildProduktPart() {
        TowerImpl tower = new TowerImpl(200, 100);
        System.out.println("Башня создана");
        return tower;
    }
}
