package frc.robot;

public class LineFollowerCode {
    LineFollower sensorOne = new LineFollower(0);
    LineFollower sensorTwo = new LineFollower(1);
    LineFollower sensorThree = new LineFollower(2);
    public void run() {
        while(!sensorOne.color()&&!sensorTwo.color()&&!sensorThree.color()){

        }
    }
}