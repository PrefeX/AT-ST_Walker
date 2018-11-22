/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andreas
 */
public class LeftFeet implements Runnable {

    private final String side;
    private final ArrayList<Servo> servos;
    private final ArrayList<Thread> threads;
    private final ArrayList<Integer> ports;
    public static AtomicIntegerArray angles;
    private Calculator leftCalc;
    private Thread leftCalcThread;

    boolean recursive = true;

    public LeftFeet(String side) throws IOException {
        LeftFeet.angles = new AtomicIntegerArray(4);
        this.ports = new ArrayList<>();
        this.servos = new ArrayList<>();
        this.threads = new ArrayList<>();
        this.ports.addAll(Arrays.asList(Constants.leftFootPorts));
        this.side = side;
        this.leftCalc = new LeftCalculator(this.side);
        leftCalcThread = new Thread(this.leftCalc);
        leftCalcThread.start();
        int i = 0;
        for (Integer port : this.ports) {

            System.out.println(port);
            this.servos.add(new Servo(port, this.side, i));
            i++;
        }
    }

    @Override
    public void run() {
        servos.forEach((servo) -> {
            this.threads.add(new Thread(servo));
        });
        threads.forEach((thread) -> {
            thread.start();
        });
        while (Constants.walking) {
            setServos(Constants.currentFootStateLeft);
        }
    }

    private void setServos(Integer[] pattern) {
        LeftFeet.angles.set(0, pattern[0]);
        LeftFeet.angles.set(1, pattern[1]);
        LeftFeet.angles.set(2, pattern[2]);
        LeftFeet.angles.set(3, pattern[3]);
    }

}
