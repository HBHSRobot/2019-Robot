package frc.robot;
import edu.wpi.first.wpilibj.AnalogInput;


public class LineFollower {
    int portVar;
    int thresholdVar = 2500;
    LineFollower(int port) {
        this.portVar = port;
    }


    AnalogInput sensor = new AnalogInput(portVar);
    public int returnvalue() {
        return sensor.getValue();
    }
    
    public boolean color() {
        if (sensor.getValue()>2500) {
            return false;
        } else {
            return true;
        }
    }


}