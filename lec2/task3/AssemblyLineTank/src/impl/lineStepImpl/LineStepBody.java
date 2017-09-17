package impl.lineStepImpl;

import api.ILineStep;
import api.IProductPart;
import impl.produktPartImpl.Body;

public class LineStepBody implements ILineStep {
    @Override
    public IProductPart buildProduktPart() {
        Body body = new Body ("green", "combi", 7);
        System.out.println("Корпус создан");
        return body;
    }
}
