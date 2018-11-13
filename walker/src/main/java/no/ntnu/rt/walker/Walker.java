/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.io.IOException;

/**
 *
 * @author andreas
 */
class Walker {
    private Feet left;
    private Feet right;
    Thread lefFoot;
    
    
    public Walker() throws IOException {
        left = new Feet("left");
        //right = new Feet(WalkerFoot.Foot.Right);
        lefFoot = new Thread(left);

        
        //right.start();
    }

    
    public boolean walk() {
        lefFoot.start();
        return true;
    }
    
}
