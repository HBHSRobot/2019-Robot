package frc.robot;
import edu.wpi.first.wpilibj.AnalogInput;


public class LineFollower {
    int portVar;
    LineFollower(int port) {
        portVar = port;
    }
    AnalogInput inputObject = new AnalogInput(portVar);
    public int returnvalue() {
        return inputObject.getValue();
    }
}