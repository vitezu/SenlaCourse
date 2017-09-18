package impl;

import api.IAssemblyLine;
import api.IProdukt;
import impl.lineStepImpl.BuildBodyImpl;
import impl.lineStepImpl.BuildMotorImpl;
import impl.lineStepImpl.BuildTowerImpl;

public class AssemblyLineImpl implements IAssemblyLine {
    private BuildMotorImpl motor;
    private BuildBodyImpl body;
    private BuildTowerImpl tower;

    public AssemblyLineImpl(BuildMotorImpl motor, BuildBodyImpl body, BuildTowerImpl tower) {
        this.motor = motor;
        this.body = body;
        this.tower = tower;
    }

    @Override
    public IProdukt assembleProduct(IProdukt produkt) {

        produkt.installFirstPart(motor.buildProduktPart());
        produkt.installSecondPart(body.buildProduktPart());
        produkt.installThirdPart(tower.buildProduktPart());
        System.out.println("Танк построен");
        return produkt;
    }
}
