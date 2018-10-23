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
        for (int x = 0; x < 5; x++) {
            if (this.foot.equals(Foot.Left)) {
                for (int y = 0; y < 4; y++) {
                    if (Constants.pattern[x][y] == 1){
                        System.out.println("Engine nr. " + y);
                    }
                    
                }

            }
            if (this.foot.equals(Foot.Right)) {
                for (int y = 4; y < 8; y++) {
                    if (Constants.pattern[x][y] == 1){
                        System.out.println("Engine nr. " + y);
                    }
                    
                }

            }

        }
    }

}
