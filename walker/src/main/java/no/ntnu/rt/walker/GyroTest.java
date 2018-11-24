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
public class GyroTest {

    private ServoGyroTest roll;
    private ServoGyroTest pitch;
    private Thread rollThread;
    private Thread pitchThread;
    private Serial serial;
    private Thread serialThread;
    private int[] targetValue;

    public GyroTest() throws IOException, InterruptedException {
        roll = new ServoGyroTest(8014, "left", 3);
        pitch = new ServoGyroTest(8015, "left", 4);
        rollThread = new Thread(roll);
        pitchThread = new Thread(pitch);
        serial = new Serial("/dev/ttyUSB0");
        serialThread = new Thread(serial);
        this.targetValue = new int[3];
        rollThread.start();
        pitchThread.start();
        serialThread.start();
        Constants.currentFootStateLeft[4] = 110;
        Constants.currentFootStateLeft[3] = 90;
        Thread.sleep(10000);
        this.targetValue[0] = (int) Constants.gyro[0];
        this.targetValue[1] = (int) Constants.gyro[1];
        this.targetValue[2] = (int) Constants.gyro[2];
    }

    public void updateServoAngles() throws InterruptedException {
        while (Constants.walking) {
            float[] currentGyroValue = Constants.gyro;
            Thread.sleep(10);
            System.out.println("gyro: " + currentGyroValue[1] + ",  " + currentGyroValue[2]);
            System.out.println("target: " + targetValue[1] + ", " + targetValue[2]);
            
            //pitch
            if ((int) currentGyroValue[1] > (targetValue[1] + 5)) {
                if (Constants.currentFootStateLeft[3] < 180) {
                    Constants.currentFootStateLeft[3]--;
                    System.out.println("pitch--");
                }
            } else if (((int) currentGyroValue[1] < (targetValue[1]) - 5)) {
                if (Constants.currentFootStateLeft[3] > 0) {
                    Constants.currentFootStateLeft[3]++;
                    System.out.println("pitch++");
                }
            } else {
                //System.out.println("we are on point");
            }
            
            //roll
            if ((int) currentGyroValue[2] > (targetValue[2] + 5)) {
                if (Constants.currentFootStateLeft[4] < 180) {  
                    Constants.currentFootStateLeft[4]++;
                    System.out.println("roll++");
                }

            } else if (((int) currentGyroValue[2] < (targetValue[2] - 5))) {
                if (Constants.currentFootStateLeft[4] > 0) {  
                    Constants.currentFootStateLeft[4]--;
                    System.out.println("roll--");
                }
                
            } else {
                //System.out.println("we are on point");
            }

        }
    }

    /* private void sadf() {
    while (true) {
    if (Constants.gyro[1] < this.targetValue)
    // move engine -1degree
    else if
    }
    }*/
}
