package frc.robot.Mechanisms;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.IO.RobotMap;

public class Shooter extends Subsystem {
//    SpeedController shooterArm = new Spark(4);
    SpeedController shooterWheels = new Spark(RobotMap.shooter);
    Solenoid kicker = new Solenoid(RobotMap.kicker);

    public void shooterIn() {
        shooterWheels.set(-.70);
    }

    public void shooterOut() {
        shooterWheels.set(1.00);
    }

    public void stop() {
        shooterWheels.stopMotor();
    }

    public void kick() {
        kicker.set(true);
    }

    public void unKick() {
        kicker.set(false);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
