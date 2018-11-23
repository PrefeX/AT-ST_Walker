package no.ntnu.rt.walker;

import java.util.ArrayList;


/**
 *
 * @author Christian
 */
public class Foot implements Runnable {

    protected final String side;
    protected final ArrayList<Servo> servos;
    protected final ArrayList<Thread> threads;
    protected final ArrayList<Integer> ports;
    protected Calculator calc;
    protected Thread calcThread;


    public Foot(String side) {
        this.ports = new ArrayList<>();
        this.servos = new ArrayList<>();
        this.threads = new ArrayList<>();
        this.side = side;
    }


    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
