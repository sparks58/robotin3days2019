package frc.robot.mechanisms;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.IO.RobotMap;
import frc.robot.OI;

public class Lift extends Subsystem {
    XboxController xboxController = new XboxController(0);
    Spark lift = new Spark(RobotMap.lift);
    Spark liftArm = new Spark(RobotMap.hatchArm);
    @Override
    protected void initDefaultCommand() {

    }

    public void liftUp() {
        if (xboxController.getXButton()) {
            lift.set(.8);
        }
    }

    public void liftDown() {
        if(xboxController.getYButton()) {
            lift.set(-.5);
        }
    }

    public void liftArmUp() {
        if(xboxController.getStartButton()){
            liftArm.set(.8);
        }
    }

    public void liftArmDown() {
        if(xboxController.getBackButton()){
            liftArm.set(-.8);
        }
    }

}
