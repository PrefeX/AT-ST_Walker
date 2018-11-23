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
class Calculator implements Runnable {

    private WalkCalc walk;
    private final String side;

    public Calculator(String side) {
        this.side = side;
        walk = new WalkCalc();
    }

    public void walkingPattern() {
    }

    public WalkCalc getWalk() {
        return walk;
    }

    public Calculator() {
        this.side = null;
    }

    public String timing() {
        Calendar cal;
        SimpleDateFormat sdf;
        cal = Calendar.getInstance();
        sdf = new SimpleDateFormat("HH:mm:ss:SSS");
        
        String time = sdf.format(cal.getTime());
        sdf = null;
        return time;
    }

    public String getSide() {
        return side;
    }

    @Override
    public void run() {
        walkingPattern();
    }

}
