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
public class LeftCalculator extends Calculator implements Runnable {

    public LeftCalculator(String side) {
        super(side);
    }

    @Override
    public void walkingPattern() {

        try {
            if (!Constants.reset) {
                super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l1, super.getSide(), 15);
                Thread.sleep(2000);
                super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l2, super.getSide(), 25);
                Thread.sleep(1000);
                super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l3, super.getSide(), 15);
                Thread.sleep(1000);
                super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l4, super.getSide(), 10);
                Thread.sleep(1000);
                super.getWalk().calculate(Constants.currentFootStateLeft, Constants.l5, super.getSide(), 10);
                Thread.sleep(1000);

                Thread.sleep(5000);
                super.getWalk().calculate(Constants.currentFootStateLeft, Constants.startValuesL, super.getSide(), 25);
            } else {
                super.getWalk().calculate(Constants.currentFootStateLeft, Constants.startValuesL, super.getSide(), 10);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(LeftFeet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
