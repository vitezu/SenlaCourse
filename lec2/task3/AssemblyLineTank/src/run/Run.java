package run;

import impl.AssemblyLine;
import impl.Tank;
import impl.lineStepImpl.LineStepBody;
import impl.lineStepImpl.LineStepMotor;
import impl.lineStepImpl.LineStepTower;

public class Run {
    public static void main(String[] args) {
        LineStepMotor lineStepMotor = new LineStepMotor();
        LineStepBody lineStepBody = new LineStepBody();
        LineStepTower lineStepTower = new LineStepTower();

        AssemblyLine assemblyLine = new AssemblyLine(lineStepMotor, lineStepBody, lineStepTower);
        Tank tank = new Tank(007);
        assemblyLine.assembleProduct(tank);
    }

}
