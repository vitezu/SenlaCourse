package impl.lineStepImpl;

import api.ILineStep;
import api.IProductPart;
import impl.produktPartImpl.Tower;

public class LineStepTower implements ILineStep {

    @Override
    public IProductPart buildProduktPart() {
        Tower tower = new Tower(200, 100);
        System.out.println("Башня создана");
        return tower;
    }
}
