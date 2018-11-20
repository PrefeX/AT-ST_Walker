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
public class RightFeet implements Runnable {

    private final String side;
    private final ArrayList<Servo> servos;
    private final ArrayList<Thread> threads;
    private final ArrayList<Integer> ports;
    public static AtomicIntegerArray angles;

    public RightFeet(String side) throws IOException {
        RightFeet.angles = new AtomicIntegerArray(4);
        Integer[] pattern = Constants.rightFootInit;
        setServos(pattern);
        this.ports = new ArrayList<>();
        this.servos = new ArrayList<>();
        this.threads = new ArrayList<>();
        this.ports.add(8015);
        this.ports.add(8016);
        this.ports.add(8017);
        this.ports.add(8018);
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
        servos.forEach((servo) -> {
            this.threads.add(new Thread(servo));
        });
        threads.forEach((thread) -> {
            thread.start();
        });
        while (Constants.walking) {
            Integer state = Constants.state.get();
            switch (state) {
                case 0:
                    {
                        Integer[] pattern = Constants.rightFootInit;
                        setServos(pattern);
                        break;
                    }
                case 1:
                    {
                        Integer[] pattern = Constants.rightFootInit;
                        setServos(pattern);
                        break;
                    }
                case 2:
                    {
                        Integer[] pattern = Constants.leftFootWalk0;
                        setServos(pattern);
                        break;
                    }
                case 5:
                    setServos(Constants.sitPartlyDown);
                    break;
                default:
                    break;
            }
        }
    }

    private void setServos(Integer[] pattern) {
        RightFeet.angles.set(0, pattern[0]);
        RightFeet.angles.set(1, pattern[1]);
        RightFeet.angles.set(2, pattern[2]);
        RightFeet.angles.set(3, pattern[3]);
    }

}
