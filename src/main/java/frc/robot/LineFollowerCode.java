package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class LineFollowerCode {
    LineFollower sensorOne = new LineFollower(0);
    LineFollower sensorTwo = new LineFollower(1);
    LineFollower sensorThree = new LineFollower(2);
    public void run(DifferentialDrive myrobot) {

        while(!sensorOne.color()&&!sensorTwo.color()&&!sensorThree.color()){
            //drive forward
        } 
        if (sensorOne.color()){
            
        }
    }
}