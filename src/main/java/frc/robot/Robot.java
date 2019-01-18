/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Drive.DriveStraight;
import frc.robot.Drive.Drivetrain;
import frc.robot.Mechanisms.Lift;
import frc.robot.Mechanisms.Shooter;
import frc.robot.Mechanisms.ShooterArm;

//import static frc.robot.OI.xbox1;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static XboxController xbox1 = new XboxController(0);
  OI oi;
  Drivetrain drive = new Drivetrain();
  Scheduler scheduler;
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  // CameraServer cam1 = CameraServer.getInstance();
  DriveStraight autothing;
  double angle;
  double speeds[] = new double[2];
  AHRS navx;
  double tempheading = 0.0;
  public static ShooterArm shoot = new ShooterArm();
  public static Lift lift = new Lift();
  public static Shooter shooter = new Shooter();
  Compressor comp = new Compressor(0);

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    navx = new AHRS(Port.kMXP);
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    // cam1.startAutomaticCapture();
//    autothing = new DriveStraight();
//    autothing.init(navx);
//    System.out.println(navx.isConnected());
//    cam.init();
    comp.start();
    // UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    // camera.setResolution(640, 480);
    // camera.setFPS(10);

    // visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {

    //   if (!pipeline.filterContoursOutput().isEmpty()) {
    //     Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
    //     synchronized (imgLock) {
    //       centerX = r.x + (r.width / 2);
    //     }
    //   }
    // });
    // visionThread.start();
    scheduler = Scheduler.getInstance();
    oi = new OI();

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

//    speeds = autothing.smth(navx, 0, angle, .03);
//    System.out.println(angle);
//    angle = navx.getAngle();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
//    switch (m_autoSelected) {
//    case kCustomAuto:
//      // Put custom auto code here
//      break;
//    case kDefaultAuto:
//    default:
//      // Put default auto code here
      speeds = autothing.smth(navx, 0, angle, .03);
      System.out.println("left = " + speeds[1] + " , right = " + speeds[0]);
      System.out.println("Heading = " + navx.getAngle());
      drive.tankdrive(-speeds[0], speeds[1], false);
//
//      break;


  }

  @Override
  public void teleopInit() {
    comp.start();
    scheduler.removeAll();
    scheduler.enable();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    drive.curveDrive(xbox1.getX(Hand.kRight), xbox1.getY(Hand.kLeft), xbox1.getBumper(Hand.kRight));
    shoot.armUp(xbox1.getTriggerAxis(Hand.kRight));
    shoot.armUp(-xbox1.getTriggerAxis(Hand.kLeft));
    lift.liftArmUp();
    lift.liftDown();
    lift.liftArmDown();
    lift.liftUp();
    scheduler.run();
//    System.out.println("Heading = " + navx.getAngle());

//    shoot.armUp(xbox1);
//    Drive.tankdrive(xbox1.getY(Hand.kRight), xbox1.getY(Hand.kLeft), false);
  }

  @Override
  public void disabledInit() {
    scheduler.removeAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    // double centerX;
    // synchronized (imgLock) {
    //   centerX = this.centerX;
    // }
    // turn = centerX - (192 / 2);
    // double tempangle = turn;
    // System.out.println("turn = " + tempangle +", navx = "+ navx.getAngle());
    // speeds = autothing.smth(navx, 0, angle + turn*.4, .011);
    // Drive.tankdrive(-speeds[0]*.5, speeds[1]*.5, false);



//
    double heading = cam.getHeading();
//    double raw = navx.getAngle();
//    double tempturn = raw + heading;
//
//    if(Math.abs(heading - tempheading) < 30 && !cam.isEmpty()) {
//      speeds = autothing.smth(navx, .4, tempturn, .011);
//
//      if (speeds[0] < -.7) {
//        speeds[0] = -.3;
//      }
//      if (speeds[0] > .7){
//        speeds[0] = .3;
//      }
//      if (speeds[1] < -.7) {
//        speeds[1] = -.3;
//      }
//      if (speeds[1] > .7){
//        speeds[1] = .3;
//      }
//      System.out.println("Right Speed = " + speeds[0] + "Left Speed = " + speeds[1]);
//            Drive.tankdrive(speeds[0], speeds[1], false);
//    }
//    else if (!cam.isEmpty() || (-7 < heading && heading < 7) ){
//      Drive.tankdrive(-.4, -.4, false);
//      System.out.println("isEmpty and go forwards");
////      System.out.println("Stopped");
//
//    }
//    else {
////      Drive.tankdrive(0.0, 0.0, false);
//      System.out.println("Stopped");
////      System.out.println("isEmpty and go forwards");
//    }
//
//    tempheading = heading;
  }

}
