/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.IO.RobotMap;

/**
 * Add your docs here.
 */
public class Drivetrain {
    Spark frontRight = new Spark(RobotMap.frontRight);
    Spark frontLeft = new Spark(RobotMap.frontLeft);
    Spark backRight = new Spark(RobotMap.backRight);
    Spark backLeft = new Spark(RobotMap.backLeft);

    SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);
    SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);

    DifferentialDrive drive = new DifferentialDrive(left, right);

    public void tankdrive(double rightSpeed, double leftSpeed, boolean quickTurn) {
        drive.tankDrive(rightSpeed, leftSpeed, quickTurn);
    }

    public void curveDrive(double turn, double speed, boolean quickTurn) {
        drive.curvatureDrive(speed, turn, quickTurn);
    }
}
