/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author andreas
 */
public class Servo{
    
    //Current andle of the servo
    private int angle;
    
    private Socket socket;
    private PrintWriter out;

    public Servo() throws IOException {
        this.socket = new Socket(Constants.serverAddress, Constants.port);
        OutputStream outputstream = socket.getOutputStream();
        out = new PrintWriter(outputstream);
        this.angle = 0;
    }

    public int getAngle() {
        return angle;
    }

    public void move(int angle) {
        out.print(angle);
        this.angle = angle;
        
        
    }
    
    
}
