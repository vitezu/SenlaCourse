package impl.lineStepImpl;

import api.ILineStep;
import api.IProductPart;
import impl.produktPartImpl.Motor;

public class LineStepMotor implements ILineStep {
    @Override
    public IProductPart buildProduktPart() {
        Motor motor = new Motor(001, 600, 1000);
        System.out.println("Мотор создан");
        return motor;
    }
}
