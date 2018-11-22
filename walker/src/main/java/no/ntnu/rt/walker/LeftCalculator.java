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
            Thread.sleep(2000);

            super.getWalk().calculate(Constants.currentFootStateLeft, Constants.WalkL, super.getSide());
            Thread.sleep(100);
            super.getWalk().calculate(Constants.currentFootStateLeft, Constants.leftFootWalk090, super.getSide());
            Thread.sleep(8000);
            super.getWalk().calculate(Constants.currentFootStateLeft, Constants.startValues, super.getSide());

        } catch (InterruptedException ex) {
            Logger.getLogger(LeftFeet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
