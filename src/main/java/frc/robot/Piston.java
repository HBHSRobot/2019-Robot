package frc.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Timer;


public class Piston {
    boolean state = true;
    public void loadCompressor() {
        Compressor c = new Compressor();
        c.setClosedLoopControl(true);
        while(!c.getPressureSwitchValue()) {
            Timer.delay(.1);
        }
    }
    public void moveOut() {
        
    Solenoid s = new Solenoid(0);
        s.set(true);
    }
    public void moveIn() {
        
    Solenoid s = new Solenoid(0);
        while (true) {
            System.out.println("Test 1");
            if (state){
                System.out.println("Test 2");
                s.set(false);
                state = false;
            }
            else {
                System.out.println("Test 3");
                break;
            }
        }
    }
    public void test(){
        
    Solenoid s = new Solenoid(0);
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