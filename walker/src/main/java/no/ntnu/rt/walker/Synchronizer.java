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
    public synchronized boolean sync() {
        while (Constants.otherFootNotFinshed) {
            try {
                wait();
            } catch (InterruptedException e)  {
                System.out.println("should not happen");
            }
        }
        Constants.otherFootNotFinshed = true;
 
        notifyAll();
        return true;
    }
}
