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
    private WalkerFoot left;
    private WalkerFoot right;
    
    
    public Walker() {
        left = new Feet("left", Constants.ports);
        right = new WalkerFoot(WalkerFoot.Foot.Right);
        left.start();
        right.start();
    }

    
    public boolean walk() {
        return false;
    }
    
}
