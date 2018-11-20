/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

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

    public LeftFeet(String side) throws IOException {
        LeftFeet.angles = new AtomicIntegerArray(4);
        this.ports = new ArrayList<>();
        this.servos = new ArrayList<>();
        this.threads = new ArrayList<>();
        this.ports.add(8011);
        this.ports.add(8012);
        this.ports.add(8013);
        this.ports.add(8014);
        this.side = side;
        int i = 0;
        for (Integer port : this.ports) {

            System.out.println(port);
            this.servos.add(new Servo(port, this.side, i));
            i++;
        }
    }

    @Override
    public void run() {
        System.out.println("starting left");
        if (Constants.state.equals(0)) {
            Integer[] pattern = Constants.leftFootInit;
            setServos(pattern);
        }
        servos.forEach((servo) -> {
            this.threads.add(new Thread(servo));
        });
        threads.forEach((thread) -> {
            thread.start();
        });
        while (Constants.walking) {
            if (Constants.state.equals(0)) {
                Integer[] pattern = Constants.leftFootInit;
                setServos(pattern);
            }
        }
    }

    private void setServos(Integer[] pattern) {
        LeftFeet.angles.set(0, pattern[0]);
        LeftFeet.angles.set(1, pattern[1]);
        LeftFeet.angles.set(2, pattern[2]);
        LeftFeet.angles.set(3, pattern[3]);
    }

}
