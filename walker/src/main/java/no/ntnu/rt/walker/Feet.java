/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.util.ArrayList;

/**
 *
 * @author andreas
 */
public class Feet {
    private String side;
    private ArrayList<Servo> servos;

    public Feet(String side, ArrayList<Servo> servos) {
        this.side = side;
        this.servos = servos;
    }
    
}
