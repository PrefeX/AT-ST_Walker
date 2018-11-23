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
public class LeftCalculator extends Calculator implements Runnable {


    public LeftCalculator(String side, Synchronizer sync) {
        super(side, sync);

    }

    @Override
    public void walkingPattern() {

        try {
            if (!Constants.reset) {
                Thread.sleep(2000);
                while (Constants.walking) {

                    super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l1, super.getSide(), 15);
                    System.out.println("" + Constants.currentFootStateLeft[0] + ", " + Constants.currentFootStateLeft[1] + ", " + Constants.currentFootStateLeft[2] + ", " + Constants.currentFootStateLeft[3] + ", " + Constants.currentFootStateLeft[4]);
                    Thread.sleep(3000);
                    super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l2, super.getSide(), 25);
                    System.out.println("" + Constants.currentFootStateLeft[0] + ", " + Constants.currentFootStateLeft[1] + ", " + Constants.currentFootStateLeft[2] + ", " + Constants.currentFootStateLeft[3] + ", " + Constants.currentFootStateLeft[4]);
                    Thread.sleep(1000);
                    super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l21, super.getSide(), 15);
                    System.out.println("" + Constants.currentFootStateLeft[0] + ", " + Constants.currentFootStateLeft[1] + ", " + Constants.currentFootStateLeft[2] + ", " + Constants.currentFootStateLeft[3] + ", " + Constants.currentFootStateLeft[4]);
                    Thread.sleep(1500);
                    super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l3, super.getSide(), 15);
                    System.out.println("" + Constants.currentFootStateLeft[0] + ", " + Constants.currentFootStateLeft[1] + ", " + Constants.currentFootStateLeft[2] + ", " + Constants.currentFootStateLeft[3] + ", " + Constants.currentFootStateLeft[4]);
                    Thread.sleep(1000);
                    super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l31, super.getSide(), 15);
                    System.out.println("" + Constants.currentFootStateLeft[0] + ", " + Constants.currentFootStateLeft[1] + ", " + Constants.currentFootStateLeft[2] + ", " + Constants.currentFootStateLeft[3] + ", " + Constants.currentFootStateLeft[4]);
                    Thread.sleep(1000);
                    super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l4, super.getSide(), 15);
                    System.out.println("" + Constants.currentFootStateLeft[0] + ", " + Constants.currentFootStateLeft[1] + ", " + Constants.currentFootStateLeft[2] + ", " + Constants.currentFootStateLeft[3] + ", " + Constants.currentFootStateLeft[4]);
                    Thread.sleep(1500);

                    super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l5, super.getSide(), 15);
                    System.out.println("" + Constants.currentFootStateLeft[0] + ", " + Constants.currentFootStateLeft[1] + ", " + Constants.currentFootStateLeft[2] + ", " + Constants.currentFootStateLeft[3] + ", " + Constants.currentFootStateLeft[4]);
                    Thread.sleep(1000);
                    super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l51, super.getSide(), 20);
                    System.out.println("" + Constants.currentFootStateLeft[0] + ", " + Constants.currentFootStateLeft[1] + ", " + Constants.currentFootStateLeft[2] + ", " + Constants.currentFootStateLeft[3] + ", " + Constants.currentFootStateLeft[4]);
                    Thread.sleep(1000);
                    super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l52, super.getSide(), 20);
                    System.out.println("" + Constants.currentFootStateLeft[0] + ", " + Constants.currentFootStateLeft[1] + ", " + Constants.currentFootStateLeft[2] + ", " + Constants.currentFootStateLeft[3] + ", " + Constants.currentFootStateLeft[4]);
                    Thread.sleep(1000);
                    super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l6, super.getSide(), 20);
                    System.out.println("" + Constants.currentFootStateLeft[0] + ", " + Constants.currentFootStateLeft[1] + ", " + Constants.currentFootStateLeft[2] + ", " + Constants.currentFootStateLeft[3] + ", " + Constants.currentFootStateLeft[4]);
                    Thread.sleep(1000);
                    Constants.currentFootStateLeft = Constants.startValuesL;
                    Thread.sleep(10000);
                    
                    super.getSync().sync();
                }

                //Thread.sleep(5000);
                //super.getWalk().calculate(Constants.currentFootStateLeft, Constants.startValuesL, super.getSide(), 25);
            } else {
                super.getWalk().calculate(Constants.currentFootStateLeft, Constants.startValuesL, super.getSide(), 10);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(LeftFoot.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
