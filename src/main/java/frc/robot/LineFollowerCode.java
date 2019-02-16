package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class LineFollowerCode {
    LineFollower sensorOne = new LineFollower(0);
    LineFollower sensorTwo = new LineFollower(1);
    LineFollower sensorThree = new LineFollower(2);
    DistanceSensor distanceSensor = new DistanceSensor();
    double goPoint; //distance from wall 
    RobotTriggerDrive myRobot = new RobotTriggerDrive(0,1,2,3);
    public LineFollowerCode (double distance) {
        goPoint = distance;
    }
    public void run(DifferentialDrive myrobot) {

        while(!sensorOne.color()&&!sensorTwo.color()&&!sensorThree.color()){
            //drive forward
        } 
        if (sensorOne.color()){
            //drive forward until sensor two is triggered
            while(!sensorTwo.color())
            //turn left motors until sensor one is triggered
            followline();
        } else if (sensorThree.color()) {
            //drive forward until sensor two is triggered
            //turn right motors until sensor two is triggered
            followline();
        }
    }
    public void followline() {
        
        while (distanceSensor.getDistance()>goPoint) {
            if (sensorOne.color()) {
                //slight right turn   
                myRobot.arcadeDrive(0, .05, true);
            } else if (sensorThree.color()) {
                //slight left turn
                myRobot.arcadeDrive(0, -.05, true);
            } else {
                //slight move forward
                myRobot.arcadeDrive(.05, 0, true);
            }
        }
    }
}