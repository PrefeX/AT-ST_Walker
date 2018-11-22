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
            super.getWalk().calculate(Constants.currentFootStateRight, Constants.currentFootStateRight, super.getSide());
            Thread.sleep(8000);
            super.getWalk().calculate(Constants.currentFootStateRight, Constants.startValues, super.getSide());
        } catch (InterruptedException ex) {
            Logger.getLogger(LeftFeet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
