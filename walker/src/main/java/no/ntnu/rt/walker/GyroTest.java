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
    private float[] targetValue;

    public GyroTest() throws IOException, InterruptedException {
        roll = new ServoGyroTest(8014, "left", 3);
        pitch = new ServoGyroTest(8015, "left", 4);
        rollThread = new Thread(roll);
        pitchThread = new Thread(pitch);
        serial = new Serial("/dev/ttyUSB0");
        serialThread = new Thread(serial);
        rollThread.start();
        pitchThread.start();
        serialThread.start();
        Thread.sleep(5000);
        this.targetValue = Constants.gyro;
    }

    public void updateServoAngles() {
        while (Constants.walking) {
            float[] currentGyroValue = Constants.gyro;
            System.out.println(currentGyroValue[0]);
            if (currentGyroValue[1] > targetValue[1]) {
                Constants.currentFootStateLeft[4]++;
            } else if ((currentGyroValue[1] < targetValue[1])) {
                Constants.currentFootStateLeft[4]--;
            } else {
                //System.out.println("we are on point");
            }
            if (currentGyroValue[2] > targetValue[2]) {
                Constants.currentFootStateLeft[3]++;
            } else if ((currentGyroValue[2] < targetValue[2])) {
                Constants.currentFootStateLeft[3]--;
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
