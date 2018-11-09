/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreas
 */
public class Feet implements Runnable{
    private String side;
    private List<Integer> servos;

    public Feet(String side) {
        
        this.side = side;
        this.servos = Constants.ports;
    }



    @Override
    public void run() {
        while (Constants.walking) {            
            
        }
    }

    
}
