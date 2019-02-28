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

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
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
  RobotTriggerDrive hbRobot;
	Joystick stickl, stickr;
  Timer timer;
	SpeedControllerGroup left;
  SpeedControllerGroup right;
  SpeedControllerGroup intake;
  SpeedControllerGroup ramp;
  SpeedController leftDrive;
  SpeedController rightDrive; 
  RobotTriggerDrive drive;
  int forwardsTrigger;
  int backwardsTrigger;
  int rotateAxis;
  XboxController moveStick;
  JoystickButton x, a, b;
  Solenoid s;
  Compressor c;
  boolean buttonValueB, buttonValueY;
   
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    leftDrive = new SpeedControllerGroup(new VictorSP(5));
    rightDrive = new SpeedControllerGroup(new VictorSP(4));
    // hbRobot = new RobotDrive(leftDrive, rightDrive);

    // stickl = new Joystick(0);
    
    final int forwardsTrigger = 3;
    final int backwardsTrigger = 2;
    final int rotateAxis = 4;
    s = new Solenoid(0);
    c = new Compressor();
    moveStick = new XboxController(0);
    x = new JoystickButton(moveStick, 2);
    b = new JoystickButton(moveStick, 1);
    a = new JoystickButton(moveStick, 0);

    // buttonValueB = moveStick.getRawButton(2);
    // stickr = new Joystick(1);
 
    ramp = new SpeedControllerGroup(new VictorSP(1), new VictorSP(0));
    // intake = new SpeedControllerGroup(new VictorSP(3), new VictorSP(2));
    
    hbRobot = new RobotTriggerDrive(leftDrive, rightDrive);
    // moveStick = new GenericHID(0);

    CameraServer.getInstance().startAutomaticCapture();
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
    // s.set(true);
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
      //Piston p = new Piston();
      Timer.delay(20);
      // s.set(true);
      // Timer.delay(1);
      // s.set(false);
      // // if (s.get())
      // // {
      // //   s.set(false);
      // // }
      // // }

      break;
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
    // hbRobot.tankDrive(stickl.getY(), stickr.getY());
    hbRobot.arcadeDrive(moveStick, forwardsTrigger, backwardsTrigger, rotateAxis);
    // s.set(true);
      // if (s.get())
      // {
      //   s.set(false);
      // }
    if (moveStick.getRawButton(6)&&!s.get())
    {
      s.set(true);
    }
    if (moveStick.getRawButton(5)&&s.get())
    {
      s.set(false);
    }
    // if (a.get())
    // {
    //    intake.set(.25);
    // }
                  // System.out.println("Test 1");
                  // System.out.println(moveStick.getRawButton(1));
                  // if (moveStick.getRawButton(1))
                  //   {
                  //      System.out.println("Test 2");
                  //      ramp.set(.25);
                  //      System.out.println("Test 3");
                  //   }
                  //   else if (moveStick.getRawButton(3))
                  //     {
                  //       ramp.set(.5);
                  //     }
                  //     else 
                  //     {
                  //        ramp.set(0);
                  //     }
   
    // else if (!b.get())
    // {
    //    ramp.set(0);
    //    System.out.println("Test 3");
    // }
    // System.out.println("Test 4");
    
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
        // Piston p = new Piston();
        // p.work();
        /*Solenoid solenoidOne = new Solenoid(0);
        System.out.println(1);
        solenoidOne.set(true);
        System.out.println(2);
        Timer.delay(3);
        System.out.println(4);
        solenoidOne.set(false);
        System.out.println(5);*/
        
  }
}


