/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

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
          //  Thread.sleep(2000);
          //  Thread.sleep(1000);
            
            //super.getWalk().calculate(Constants.currentFootStateRight, Constants.liftKnee, super.getSide(), 15);
            //super.getWalk().calculate(Constants.currentFootStateRight, Constants.putKnee, super.getSide(), 5);
            //Thread.sleep(8000);
            super.getWalk().calculate(Constants.startValuesR, Constants.r1, super.getSide(), 10);
            Thread.sleep(1000);
            super.getWalk().calculate(Constants.currentFootStateRight, Constants.r2, super.getSide(), 10);
            Thread.sleep(1000);
            super.getWalk().calculate(Constants.currentFootStateRight, Constants.r3, super.getSide(), 10);
            Thread.sleep(1000);
            super.getWalk().calculate(Constants.currentFootStateRight, Constants.r4, super.getSide(), 10);
            Thread.sleep(1000);
            //super.getWalk().calculate(Constants.currentFootStateRight, Constants.rightFootWalk0, super.getSide(), 10);
            //Thread.sleep(8000);
            //super.getWalk().calculate(Constants.currentFootStateRight, Constants.startValuesR, super.getSide(), 25);
        } catch (InterruptedException ex) {
            Logger.getLogger(LeftFeet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
