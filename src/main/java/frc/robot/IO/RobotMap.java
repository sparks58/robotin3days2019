package frc.robot.IO;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;

public class RobotMap {
    //controllers
//    public final static XboxController xbox1 = new XboxController(0);
//    xbox2 = new XboxController(1);
//    public static XboxController xbox2 = new XboxController(1);
    public final static int frontLeft = 2;
    public final static int backLeft = 3;
    public final static int frontRight = 0;
    public final static int backRight = 1;


    //Mechanisms
    //Lift
    public final static int lift = 6;
    public final static int hatchArm = 7;

    //Shooter
    public final static int shooterArm = 5;
    public final static int shooter = 4;

    public final static int kicker = 0;


}
