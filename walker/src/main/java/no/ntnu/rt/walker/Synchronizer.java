/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;


/**
 *
 * @author andreas
 */
public class Synchronizer {

    public synchronized void sync() {
        if (!Constants.waitingForSync) {
            Constants.waitingForSync = true;

            while (Constants.waitingForSync) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("should not happen");
                }
            }
            System.out.println(Thread.currentThread().getName() + " likely woke up?");
            
        } else {
            System.out.println("Sending the wakeup signal from sync to the other threads");
            Constants.waitingForSync = false;
            notifyAll();
        }
    }
}
