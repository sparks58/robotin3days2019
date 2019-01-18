/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import com.kauailabs.navx.frc.AHRS;

/**
 * Add your docs here.
 */
public class DriveStraight {
    
    double error;
    double speeds[] = new double[2];

    
    
    public void init(AHRS navx) {
        // navx = new AHRS(Port.kMXP);
        navx.reset();
        System.out.println("Heading" + navx.getAngle());
        
    }


    public double[] smth(AHRS navx, double speed, double heading, double k) {
        error = navx.getAngle() - heading;
        speeds[0] = -speed - k*error;
        speeds[1] = speed - k*error;
        return speeds;
    }
    
    public double getAngle(AHRS navx){
        return navx.getAngle();
    }

    public void turnToAngle(AHRS navx) {
        
    }

}
