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

    private final LeftFoot left;
    private final RightFoot right;
    Thread leftFoot;
    Thread rightFoot;
    Serial serial;
    Thread serialThread;
    WalkCalc walkCalc;
    private Synchronizer sync;

    public Walker() throws IOException {
        sync = new Synchronizer();
        left = new LeftFoot("left", sync);
        right = new RightFoot("right", sync);
        leftFoot = new Thread(left);
        rightFoot = new Thread(right);
        serial = new Serial("COM1");
        serialThread = new Thread(serial);
        //serialThread.start();
        walkCalc = new WalkCalc();

    }

    public boolean walk() throws InterruptedException {
        
        leftFoot.start();
        rightFoot.start();

        Thread.sleep(2000);

        /*System.out.println("plz dont rip");
        walkCalc.calculate(Constants.rightFootInit, Constants.rightFootWalk090, "Right");
        walkCalc.calculate(Constants.leftFootInit, Constants.leftFootWalk090, "Left");
        Thread.sleep(200);
        walkCalc.calculate(Constants.leftFootWalk090, Constants.leftFootWalk091, "Left");
        Thread.sleep(200);
        walkCalc.calculate(Constants.leftFootWalk091, Constants.leftFootWalk092, "Left");
         */
        return true;
    }

}
