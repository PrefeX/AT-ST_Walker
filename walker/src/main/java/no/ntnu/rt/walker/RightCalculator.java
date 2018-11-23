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

    public RightCalculator(String side) {
        super(side);

    }

    @Override
    public void walkingPattern() {
        try {
            if (!Constants.reset) {
                while (Constants.walking) {

                    Thread.sleep(3000);
                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r1, super.getSide(), 10);
                    System.out.println("Right foot: " + timing());
                    Thread.sleep(2000);
                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r2, super.getSide(), 15);
                    System.out.println("Right foot: " + timing());
                    Thread.sleep(1000);
                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r21, super.getSide(), 15);
                    System.out.println("Right foot: " + timing());
                    Thread.sleep(1000);
                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r3, super.getSide(), 15);
                    System.out.println("Right foot: " + timing());
                    Thread.sleep(1200);
                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r31, super.getSide(), 15);
                    System.out.println("Right foot: " + timing());
                    Thread.sleep(500);
                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r4, super.getSide(), 10);
                    System.out.println("Right foot: " + timing());
                    Thread.sleep(1000);

                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r5, super.getSide(), 15);
                    System.out.println("Right foot: " + timing());
                    Thread.sleep(1000);
                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r51, super.getSide(), 20);
                    System.out.println("Right foot: " + timing());
                    Thread.sleep(1000);
                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r52, super.getSide(), 20);
                    System.out.println("Right foot: " + timing());
                    Thread.sleep(1000);
                    super.getWalk().calculate(Constants.currentFootStateRight, Constants.r6, super.getSide(), 20);
                    System.out.println("Right foot: " + timing());
                    Thread.sleep(1000);
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
