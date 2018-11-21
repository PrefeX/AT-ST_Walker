/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author andreas
 */
class Walker {

    private final LeftFeet left;
    private final RightFeet right;
    Thread leftFoot;
    Thread rightFoot;

    public Walker() throws IOException {
        left = new LeftFeet("left");
        right = new RightFeet("right");
        leftFoot = new Thread(left);
        rightFoot = new Thread(right);

    }

    public boolean walk() throws InterruptedException {
        Constants.state = new AtomicInteger(0);
        leftFoot.start();
        rightFoot.start();
        Thread.sleep(2000);
        Constants.state = new AtomicInteger(1);
        Thread.sleep(2000);
        Constants.state = new AtomicInteger(2);
        
        return true;
    }

}
