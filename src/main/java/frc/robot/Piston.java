package frc.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Timer;


public class Piston {
    Solenoid s = new Solenoid(0);
    public void loadCompressor() {
        Compressor c = new Compressor();
        c.setClosedLoopControl(true);
        while(!c.getPressureSwitchValue()) {
            Timer.delay(.1);
        }
    }
    public void moveOut() {
        s.set(true);
    }
    public void moveIn() {
        s.set(false);
    }
    public void test(){
        Compressor c = new Compressor();
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