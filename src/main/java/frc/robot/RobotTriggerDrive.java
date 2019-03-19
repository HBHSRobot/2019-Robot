package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

// Start of RobotDriveXbox
public class RobotTriggerDrive extends RobotDrive {
	  /**
	   * Constructor for RobotDrive with 2 motors specified with channel numbers. Set up parameters for
	   * a two wheel drive system where the left and right motor pwm channels are specified in the call.
	   * This call assumes Talons for controlling the motors. (Taken from official RobotDrive class)
	   * @param leftMotorChannel is an integer that represents the PWM channel number of the left motor
	   * @param rightMotorChannel is an integer that represents the PWM channel number of the left motor
	   */
	  public RobotTriggerDrive(final int leftMotorChannel, final int rightMotorChannel) {
		  super(leftMotorChannel, rightMotorChannel);
	  } // End of constructor
	
	
	/**
	 * Constructor for RobotDrive with 2 motors specified as SpeedController objects. The
	 * SpeedController version of the constructor enables programs to use the RobotDrive classes with
	 * subclasses of the SpeedController objects, for example, versions with ramping or reshaping of
	 * the curve to suit motor bias or dead-band elimination. (Taken from official RobotDrive class)
	 * @param leftMotor is a SpeedController Object which controls the speed of the left motor of the robot
	 * @param rightMotor is a SpeedController Object which controls the speed of the right motor of the robot
	 */
	public RobotTriggerDrive(SpeedController leftMotor, SpeedController rightMotor) {
		super(leftMotor, rightMotor);
	} // End of constructor
	
	/**
	 * Constructor for RobotDrive with 4 motors specified with channel numbers. Set up parameters for
	 * a four wheel drive system where all four motor pwm channels are specified in the call. This
	 * call assumes Talons for controlling the motors. (Taken from official RobotDrive class)
 	 * @param frontLeftMotor is an integer that represents the channel number of the front left motor
	 * @param rearLeftMotor is an integer that represents the channel number of the back left motor
	 * @param frontRightMotor is an integer that represents the channel number of the front right motor
	 * @param rearRightMotor is an integer that represents the channel number of the back right motor
	 */
	public RobotTriggerDrive(final int frontLeftMotor, final int rearLeftMotor, final int frontRightMotor, final int rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
	} // End of constructor
	
	/**
	 * Constructor for RobotDrive with 4 motors specified as SpeedController objects. Speed controller
	 * input version of RobotDrive (Taken from official RobotDrive class)
	 * @param frontLeftMotor is a SpeedController Object which controls the speed of the front left motor of the robot
	 * @param rearLeftMotor is a SpeedController Object which controls the speed of the back left motor of the robot
	 * @param frontRightMotor is a SpeedController Object which controls the speed of the front right motor of the robot
	 * @param rearRightMotor is a SpeedController Object which controls the speed of the back right motor of the robot
	 */
	 public RobotTriggerDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor, SpeedController rearRightMotor) {
		 super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
	 } // End of constructor 
	 
	/**
	 * Implements an arcadeDrive method with trigger drive functionality 
	 * @param moveStick is a Human Interface Device being used to control the robot forwards & backwards
	 * @param forwardsTrigger is the trigger axis being used to control the forward movement of the robot
	 * @param backwardsTrigger is the trigger axis being used to control the backward movement of the robot
	 * @param rotateAxis is the axis being used to control the left & right movements of the robot
	 */
	public void arcadeDrive(XboxController moveStick, final int forwardsTrigger, final int backwardsTrigger, final int rotateAxis, final boolean fast) {
		// Moves robot using both trigger axes
		double moveValue = .75 * (moveStick.getTriggerAxis(Hand.kRight) - moveStick.getTriggerAxis(Hand.kLeft));
		
		// Rotates robot left and right on a single axis
		double rotateValue = moveStick.getX(Hand.kLeft);
		if (!fast) {
			moveValue = moveValue/2;
		}
		// Drives robot at provided move and rotate values
		arcadeDrive(moveValue, -rotateValue-.03, true);
		System.out.println(rotateValue);
	} // End of method
} // End of class