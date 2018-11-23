/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Time;
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
    private String side;
    private int servoNumber;
    private long time;

    public Servo(int port, String side, int servoNumber) throws IOException {
        this.port = port;
        this.side = side;
        this.servoNumber = servoNumber;
        this.socket = new Socket(Constants.serverAddress, this.port);
        OutputStream outputstream = socket.getOutputStream();
        out = new PrintWriter(outputstream, false);
        this.angle = 0;
        time = System.currentTimeMillis();

    }

    public int getAngle() {
        return angle;
    }

    public void move(int angle) {
        if ((this.angle != angle) || timeHasGone()) {
            out.print("" + angle);
            out.flush();
            this.angle = angle;
            System.out.println("Angle of " + this.port + " is " + angle);
        }
    }

    public void startup(int angle) {

        out.print("" + angle);
        out.flush();
        this.angle = angle;
        System.out.println("Angle of " + this.port + " is " + angle);

    }

    @Override
    public void run() {
        if (this.side.equalsIgnoreCase("left")) {
                //System.out.println(LeftFeet.angles.get(servoNumber));
                startup(LeftFeet.angles.get(servoNumber));

            } else {
                startup(RightFeet.angles.get(servoNumber));

            }
        while (Constants.walking) {
            if (this.side.equalsIgnoreCase("left")) {
                //System.out.println(LeftFeet.angles.get(servoNumber));
                move(LeftFeet.angles.get(servoNumber));

            } else {
                move(RightFeet.angles.get(servoNumber));

            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Servo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean timeHasGone() {
        if (time + 500 >= System.currentTimeMillis()) {
            return false;
        }
        return false;
    }

}
