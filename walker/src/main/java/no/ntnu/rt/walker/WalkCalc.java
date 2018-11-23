/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 *
 * @author rasmu
 */
/**
 * TODO: Fikse gåmønster starte i en positiv boolean, bevege seg til enden av
 * mønster flippe boolean, retractivt mønster tilbake flippe boolean, rince
 * repeat Bruke inputs fra gyro her til å trekke fra/legge til
 */
public class WalkCalc {

    public void calculate(int[] start, int[] stop, String foot, long speed) throws InterruptedException {
        
        int[] current = start;
        boolean calculating = true;
        while (calculating) {
            for (int i = 0; i <= 4; i++) {
                if (current[i] != stop[i]) {
                    if (current[i] > stop[i]) {
                        current[i] = current[i] - 1;
                        //System.out.println("" + current[i] + "  " + stop[i]);
                    } else if (current[i] < stop[i]) {
                        current[i] = current[i] + 1;
                        //System.out.println("" + current[i] + "  " + stop[i]);
                    }

                }
            }
            if (foot.equalsIgnoreCase("left")) {
                
                Constants.currentFootStateLeft = new AtomicIntegerArray(current);
            } else {
                Constants.currentFootStateLeft = new AtomicIntegerArray(current);
            }
            
            
            if (Arrays.equals(current, stop)) {
                calculating = false;
            }
            /*for (Integer currentInteger : current) {
            for (Integer stopInteger : stop) {
            if (!currentInteger.equals(stopInteger)) {
            currentInteger = currentInteger + 1;
            
            }
            }
            }*/

            Thread.sleep(speed);
        }
    }

}
