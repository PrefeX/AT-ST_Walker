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
class Walker {
    private Feet left;
    private Feet right;
    
    
    public Walker() {
        left = new Feet("left");
        //right = new Feet(WalkerFoot.Foot.Right);
        Thread leftFoot = new Thread(left);
        leftFoot.start();
        //right.start();
    }

    
    public boolean walk() {
        return false;
    }
    
}
