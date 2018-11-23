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
    private Synchronizer sync;


    public Foot(String side, Synchronizer sync) {
        this.sync = sync;
        this.ports = new ArrayList<>();
        this.servos = new ArrayList<>();
        this.threads = new ArrayList<>();
        this.side = side;
    }

    public Synchronizer getSync() {
        return sync;
    }

 
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
