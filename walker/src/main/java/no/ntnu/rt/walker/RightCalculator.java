/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author rasmu
 */
public class RightCalculator extends Calculator implements Runnable {

    public RightCalculator(String side, Synchronizer sync) {
        super(side, sync);

    }


    @Override
    public void walkingPattern() {
        try {
            if (!Constants.reset) {
                while (Constants.walking) {

                    Thread.sleep(3000);
                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r1, super.getSide(), 10);
                    System.out.println("[R Step 1] " + Constants.currentFootStateRight[0] + ", " + Constants.currentFootStateRight[1] + ", " + Constants.currentFootStateRight[2] + ", " + Constants.currentFootStateRight[3] + ", " + Constants.currentFootStateRight[4]);
                    Thread.sleep(2000);
                    super.getSync().sync();

                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r2, super.getSide(), 15);
                    System.out.println("[R Step 2] " + Constants.currentFootStateRight[0] + ", " + Constants.currentFootStateRight[1] + ", " + Constants.currentFootStateRight[2] + ", " + Constants.currentFootStateRight[3] + ", " + Constants.currentFootStateRight[4]);
                    Thread.sleep(1000);
                    super.getSync().sync();

                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r21, super.getSide(), 15);
                    System.out.println("[R Step 3] " + Constants.currentFootStateRight[0] + ", " + Constants.currentFootStateRight[1] + ", " + Constants.currentFootStateRight[2] + ", " + Constants.currentFootStateRight[3] + ", " + Constants.currentFootStateRight[4]);
                    Thread.sleep(1000);
                    super.getSync().sync();

                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r3, super.getSide(), 15);
                    System.out.println("[R Step 4] " + Constants.currentFootStateRight[0] + ", " + Constants.currentFootStateRight[1] + ", " + Constants.currentFootStateRight[2] + ", " + Constants.currentFootStateRight[3] + ", " + Constants.currentFootStateRight[4]);
                    Thread.sleep(1200);
                    super.getSync().sync();

                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r31, super.getSide(), 15);
                    System.out.println("[R Step 5] " + Constants.currentFootStateRight[0] + ", " + Constants.currentFootStateRight[1] + ", " + Constants.currentFootStateRight[2] + ", " + Constants.currentFootStateRight[3] + ", " + Constants.currentFootStateRight[4]);
                    Thread.sleep(500);
                    super.getSync().sync();

                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r4, super.getSide(), 10);
                    System.out.println("[R Step 6] " + Constants.currentFootStateRight[0] + ", " + Constants.currentFootStateRight[1] + ", " + Constants.currentFootStateRight[2] + ", " + Constants.currentFootStateRight[3] + ", " + Constants.currentFootStateRight[4]);
                    Thread.sleep(1000);
                    super.getSync().sync();

                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r5, super.getSide(), 15);
                    System.out.println("[R Step 7] " + Constants.currentFootStateRight[0] + ", " + Constants.currentFootStateRight[1] + ", " + Constants.currentFootStateRight[2] + ", " + Constants.currentFootStateRight[3] + ", " + Constants.currentFootStateRight[4]);
                    Thread.sleep(1000);
                    super.getSync().sync();

                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r51, super.getSide(), 20);
                    System.out.println("[R Step 8] " + Constants.currentFootStateRight[0] + ", " + Constants.currentFootStateRight[1] + ", " + Constants.currentFootStateRight[2] + ", " + Constants.currentFootStateRight[3] + ", " + Constants.currentFootStateRight[4]);
                    Thread.sleep(1000);
                    super.getSync().sync();

                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r52, super.getSide(), 20);
                    System.out.println("[R Step 9] " + Constants.currentFootStateRight[0] + ", " + Constants.currentFootStateRight[1] + ", " + Constants.currentFootStateRight[2] + ", " + Constants.currentFootStateRight[3] + ", " + Constants.currentFootStateRight[4]);
                    Thread.sleep(1000);
                    super.getSync().sync();

                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r6, super.getSide(), 20);
                    System.out.println("[R Step 10] " + Constants.currentFootStateRight[0] + ", " + Constants.currentFootStateRight[1] + ", " + Constants.currentFootStateRight[2] + ", " + Constants.currentFootStateRight[3] + ", " + Constants.currentFootStateRight[4]);
                    Thread.sleep(1000);
                    super.getSync().sync();

                    Constants.currentFootStateRight = Constants.startValuesR;
                    System.out.println("[R Resetting step]");

                    Thread.sleep(2000);

                    super.getSync().sync();
                }

                //Thread.sleep(5000);
                //super.getWalk().calculate(Constants.currentFootStateRight, Constants.startValuesR, super.getSide(), 25);
            } else {
                super.getWalk().calculate(Constants.currentFootStateRight, Constants.startValuesR, super.getSide(), 10);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RightFoot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
