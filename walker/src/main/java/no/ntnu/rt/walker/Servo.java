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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andreas
 */
public class Servo implements Runnable {

    //Current andle of the servo
    private int angle;

    private Socket socket;
    private PrintWriter out;
    private int port;

    public Servo(int port) throws IOException {
        this.port = port;
        this.socket = new Socket(Constants.serverAddress, this.port);
        OutputStream outputstream = socket.getOutputStream();
        out = new PrintWriter(outputstream);
        this.angle = 0;

    }

    public int getAngle() {
        return angle;
    }

    public synchronized void move(int angle) {
        byte bAngle = (byte) angle;
        out.print(bAngle);
        this.angle = angle;
        System.out.println("Angle of " + this.port + " is " + angle);
        try {
        this.wait();
        } catch (InterruptedException ex) {
        Logger.getLogger(Servo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        while (Constants.walking) {
            move(110);
                    }
    }

}
