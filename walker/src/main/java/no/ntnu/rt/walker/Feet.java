/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreas
 */
public class Feet implements Runnable{
    private String side;
    private ArrayList<Servo> servos;
    private ArrayList<Thread> threads;
    private ArrayList<Integer> ports;
    public Feet(String side) throws IOException {
        ports = new ArrayList<>();
        servos = new ArrayList<>();
        threads = new ArrayList<>();
        ports.add(8011);
        ports.add(8012);
        ports.add(8013);
        this.side = side;

        for (Integer port : this.ports) {
            System.out.println(port);
            this.servos.add(new Servo(port));
        }
    }



    @Override
    public void run() {
        for (Servo servo : servos) {
            this.threads.add(new Thread(servo));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        while (Constants.walking) {            
            
        }
    }

    
}
