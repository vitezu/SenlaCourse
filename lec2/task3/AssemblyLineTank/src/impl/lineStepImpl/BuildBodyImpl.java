package impl.lineStepImpl;

import api.ILineStep;
import api.IProductPart;
import impl.produktPartImpl.BodyImpl;

public class BuildBodyImpl implements ILineStep {
    @Override
    public IProductPart buildProduktPart() {
        BodyImpl body = new BodyImpl ("green", "combi", 7);
        System.out.println("Корпус создан");
        return body;
    }
}
