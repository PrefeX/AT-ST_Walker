/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.io.IOException;

/**
 *
 * @author andreas
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Process execPython = Runtime.getRuntime()
                .exec("python3 /home/pi/AT-ST_Walker/Servo_Driver/Servo.py");
        Thread.sleep(2000);
        Walker walker = new Walker();
        walker.walk();    
        
        //GyroTest gyroTest = new GyroTest();
        //gyroTest.updateServoAngles();
        
    }
    
}
