package no.ntnu.rt.walker;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;


/**
 *
 * @author Andreas, Christian
 */
public class RightFoot extends Foot {

    public static AtomicIntegerArray angles;


    public RightFoot(String side) throws IOException {
        super(side);
        RightFoot.angles = new AtomicIntegerArray(5);

        this.ports.addAll(Arrays.asList(Constants.rightFootPorts));

        this.calc = new RightCalculator(this.side);
        this.calcThread = new Thread(this.calc);
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
        setServos(Constants.currentFootStateRight);

        servos.forEach((servo) -> {
            this.threads.add(new Thread(servo));
        });
        threads.forEach((thread) -> {
            thread.start();
        });
        while (Constants.walking) {
            setServos(Constants.currentFootStateRight);
        }
    }


    private void setServos(Integer[] pattern) {
        RightFoot.angles.set(0, pattern[0]);
        RightFoot.angles.set(1, pattern[1]);
        RightFoot.angles.set(2, pattern[2]);
        RightFoot.angles.set(3, pattern[3]);
        RightFoot.angles.set(4, pattern[4]);
    }

}
