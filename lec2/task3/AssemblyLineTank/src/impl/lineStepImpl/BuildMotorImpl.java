package impl.lineStepImpl;

import api.ILineStep;
import api.IProductPart;
import impl.produktPartImpl.MotorImpl;

public class BuildMotorImpl implements ILineStep {
    MotorImpl motor = new MotorImpl(001, 600, 1000);

    @Override
    public IProductPart buildProduktPart() {
        System.out.println("Мотор создан");
        return motor;
    }
}
