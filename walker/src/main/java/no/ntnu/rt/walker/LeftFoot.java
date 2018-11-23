package no.ntnu.rt.walker;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;


/**
 *
 * @author Andreas, Christian
 */
public class LeftFoot extends Foot {

    public static AtomicIntegerArray angles;


    public LeftFoot(String side, Synchronizer sync) throws IOException {
        super(side, sync);
        LeftFoot.angles = new AtomicIntegerArray(5);

        this.ports.addAll(Arrays.asList(Constants.leftFootPorts));

        this.calc = new LeftCalculator(this.side, super.getSync());
        calcThread = new Thread(this.calc);
        calcThread.start();
        int i = 0;
        for (Integer port : this.ports) {

            System.out.println(port);
            this.servos.add(new Servo(port, this.side, i));
            i++;
        }
    }


    @Override
    public void run() {
        setServos(Constants.currentFootStateLeft);

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
        LeftFoot.angles.set(0, pattern[0]);
        LeftFoot.angles.set(1, pattern[1]);
        LeftFoot.angles.set(2, pattern[2]);
        LeftFoot.angles.set(3, pattern[3]);
        LeftFoot.angles.set(4, pattern[4]);
    }

}
