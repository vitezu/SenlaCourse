package run;

import impl.AssemblyLineImpl;
import impl.TankImpl;
import impl.lineStepImpl.BuildBodyImpl;
import impl.lineStepImpl.BuildMotorImpl;
import impl.lineStepImpl.BuildTowerImpl;

public class Run {
    public static void main(String[] args) {
        BuildMotorImpl motor = new BuildMotorImpl();
        BuildBodyImpl body = new BuildBodyImpl();
        BuildTowerImpl tower = new BuildTowerImpl();

        AssemblyLineImpl assemblyLine = new AssemblyLineImpl(motor, body, tower);
        TankImpl tank = new TankImpl(007);
        assemblyLine.assembleProduct(tank);
        System.out.println(tank);
    }

}
