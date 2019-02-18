/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


// import com.ctre.phoenix.motorcontrol.can.*;
// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.FeedbackDevice;
// import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  DifferentialDrive myRobot;
	Joystick stickl, stickr;
  Timer timer;
	SpeedControllerGroup left;
  SpeedControllerGroup right;
  SpeedControllerGroup intake;
  SpeedControllerGroup ramp;
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    // left = new SpeedControllerGroup(new Talon(1), new Talon(2));
    // right = new SpeedControllerGroup(new Talon(3), new Talon(4));
    ramp = new SpeedControllerGroup(new Victor(1), new Victor(0));
    intake = new SpeedControllerGroup(new VictorSP(3), new VictorSP(2));
    // SpeedController leftFront = new TalonSRX(1);
    // leftBack = new Victor(1);
    // myRobot = new DifferentialDrive(left, right);
		
		// stickl = new Joystick(0);
    // stickr = new Joystick(1);
    
    // RobotTriggerDrive drive = new RobotTriggerDrive(1,1,2,3);
  }
  
  

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // autoSelected = SmartDashboard.getString("Auto Selector",
    // defaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }
  

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        while(true)
        {
          System.out.println("test");
          intake.set(.25);
          System.out.println("test");
        }
        
        //   */
      //break;
    }
  }
  @Override
	public void teleopInit() {
		
	}

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    myRobot.tankDrive(stickl.getY(), stickr.getY()); 
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    //Line Follower Sensor test
    /*Timer timer = new Timer();
    LineFollower sensorOne = new LineFollower(0);
    LineFollower sensorTwo = new LineFollower(1);
    LineFollower sensorThree = new LineFollower(2);
    System.out.println("test");
    while (true){
       System.out.println(sensorOne.returnvalue()+"  "
       + sensorTwo.returnvalue() + "  "
       + sensorThree.returnvalue());
       
       timer.delay(1);
    } */
    //  intake.set(.25);


    //Distance Sensor Test
    /*DistanceSensor sensor = new DistanceSensor(3);
        while(true)
        {
           if (sensor.getDistance() < 5)
           {
              left.stopMotor();
              right.stopMotor();
           }
        }*/
        
        
        //Solenoid Test
        /*Piston p = new Piston(0);
        p.test();
        Solenoid solenoidOne = new Solenoid(0);
        System.out.println(1);
        solenoidOne.set(true);
        System.out.println(2);
        Timer.delay(3);
        System.out.println(4);
        solenoidOne.set(false);
        System.out.println(5);*/
  }
}


