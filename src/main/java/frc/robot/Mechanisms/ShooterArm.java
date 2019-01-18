package frc.robot.Mechanisms;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.IO.RobotMap;

public class ShooterArm extends Subsystem {
    SpeedController shooterArm = new Spark(RobotMap.shooterArm);
//    SpeedController shooterWheels = new Spark(5);

    public void armUp(double axis) {
        shooterArm.set(axis);
    }
    public void armDown(boolean button) {
        if (button) shooterArm.set(-.7);
    }


    public void kick() {

    }

    @Override
    protected void initDefaultCommand() {

    }
}
