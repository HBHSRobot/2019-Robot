package frc.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Timer;


public class Piston {
    int num;
    Piston (int port) {
        num = port;
    }
    public void loadCompressor() {
        Compressor c = new Compressor();
        Solenoid s = new Solenoid(num);
        c.setClosedLoopControl(true);
        while(!c.getPressureSwitchValue()) {
            Timer.delay(.1);
        }
    }
    public void move() {
        Compressor c = new Compressor();
        Solenoid s = new Solenoid(num);
        c.setClosedLoopControl(true);
        while(!c.getPressureSwitchValue()) {
            Timer.delay(.1);
        }
        if (s.get()) {
            s.set(false);
        } else {
            s.set(true);
        }
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