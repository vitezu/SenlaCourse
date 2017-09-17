package impl;

import api.IAssemblyLine;
import api.IProdukt;
import impl.lineStepImpl.LineStepBody;
import impl.lineStepImpl.LineStepMotor;
import impl.lineStepImpl.LineStepTower;

public class AssemblyLine implements IAssemblyLine {
   private LineStepMotor lineStepMotor;
    private LineStepBody lineStepBody;
    private LineStepTower lineStepTower;

    public AssemblyLine(LineStepMotor lineStepMotor, LineStepBody lineStepBody, LineStepTower lineStepTower) {
        this.lineStepMotor = lineStepMotor;
        this.lineStepBody = lineStepBody;
        this.lineStepTower = lineStepTower;
    }

    @Override
    public IProdukt assembleProduct(IProdukt produkt) {

        produkt.installFirstPart(lineStepMotor.buildProduktPart());
        produkt.installSecondPart(lineStepBody.buildProduktPart());
        produkt.installThirdPart(lineStepTower.buildProduktPart());
        System.out.println("Танк построен");
        return produkt;
    }
}
