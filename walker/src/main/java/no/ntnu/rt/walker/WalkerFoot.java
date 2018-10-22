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
 * @author andreas
 */
public class WalkerFoot implements Runnable {

    public enum Foot {
        Left,
        Right
    };

    private final Foot foot;

    public WalkerFoot(Foot foot) {
        this.foot = foot;
    }

    @Override
    public void run() {
        boolean walking = true;
        while (walking) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            walk();
        }

    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    private void walk() {

        System.out.println(this.foot + "  foot walking");
    }

}
