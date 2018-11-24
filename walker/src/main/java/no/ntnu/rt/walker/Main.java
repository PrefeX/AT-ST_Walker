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
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Walker walker = new Walker();
        //walker.walk();    
        Serial serial = new Serial("/dev/ttyAMA0");
        Thread st = new Thread(serial);
        st.start();
        while (true) {            
            Thread.sleep(1000);
            System.out.println(Constants.gyro[0]);
        }
    }
    
}
