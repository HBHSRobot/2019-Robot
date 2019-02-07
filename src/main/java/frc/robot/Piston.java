package frc.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Timer;


public class Piston {
    int num;
    Piston (int port) {
        num = port;
    }
    public void test(){
        Compressor c = new Compressor();
        Solenoid s = new Solenoid(num);
        c.setClosedLoopControl(true);
        while(!c.getPressureSwitchValue()) {
        Timer.delay(.1);
        }
        Timer.delay(10);
        while (true) {
            //System.out.println(c.getPressureSwitchValue());
            c.setClosedLoopControl(true);
            s.set(true);
            Timer.delay(5);
            s.set(false);
            Timer.delay(5);
        }
    }
}