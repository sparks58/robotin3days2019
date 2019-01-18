/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.IO.GripPipeline;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.vision.VisionThread;

import org.opencv.core.*;
import org.opencv.imgproc.*;

/**
 * Add your docs here.
 */
public class Vision extends PIDSubsystem {
    GripPipeline grip;
    private Thread visionThread;
    double centerX = 0;
    private final Object imgLock = new Object();
    boolean empty = true;
    double realAngle;
    double boundedAngle;
    AHRS navx = new AHRS(I2C.Port.kMXP);

    public Vision(String name, double p, double i, double d) {
        super("Vision", .11, 0, .01);
    }

    public void init() {
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
//        camera.setResolution(640, 480);
        camera.setFPS(10);

        visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {

            if (!pipeline.filterContoursOutput().isEmpty()) {
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                synchronized (imgLock) {
                    centerX = r.x + (r.width / 2);
                    empty = false;
                }
            }
            else{
                empty = true;
            }
        });
        visionThread.start();
    }

    public double getHeading() {
        double centerX;
        double turn;
        synchronized (imgLock) {
            centerX = this.centerX;
        }
        turn = centerX - (160 / 2);
        return turn;
    }

//    public double gyroCorrect(){
//        return
//    }

    public double getRealAngle(){
        return navx.getAngle();
    }

    public boolean isEmpty(){
        return empty;
    }

    @Override
    protected double returnPIDInput() {
        return 0;
    }

    @Override
    protected void usePIDOutput(double output) {

    }

    @Override
    protected void initDefaultCommand() {

    }
}
