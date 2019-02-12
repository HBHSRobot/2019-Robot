
package frc.robot;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DistanceSensor {
  // A MB1013 distance sensor - http://www.maxbotix.com/documents/HRLV-MaxSonar-EZ_Datasheet.pdf
  // (pins 3, 6 and 7 from sensor to analog input 0)
  public DistanceSensor(int _channel)
  {
     DistanceSensor s = new DistanceSensor(_channel);
  }
  
  private static final AnalogInput sensor = new AnalogInput(3);
  
  // TODO - You will need to determine how to convert voltage to distance
  // (use information from the data sheet, or your own measurements)
  private static final double VOLTS_TO_DIST = .5;

  public static double getVoltage() {
    return sensor.getVoltage();

  }
  
  public static double getDistance() {
    return getVoltage() * VOLTS_TO_DIST;
  }
  
  public static void updateDashboard() {
    SmartDashboard.putNumber("Distance (volts)", getVoltage());
    SmartDashboard.putNumber("Distance (real)", getDistance());
  }
}
