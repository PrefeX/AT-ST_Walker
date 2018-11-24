package no.ntnu.rt.walker;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andreas
 */
public class ServoGyroTest implements Runnable {

    //Current andle of the servo
    private int angle;

    private Socket socket;
    private PrintWriter out;
    private int port;
    private String side;
    private int servoNumber;
    private long time;

    public ServoGyroTest(int port, String side, int servoNumber) throws IOException {
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
            //System.out.println("Angle of " + this.port + " is " + angle);
        }
    }

    public void startup(int angle) {

        out.print("" + angle);
        out.flush();
        this.angle = angle;
        //System.out.println("Angle of " + this.port + " is " + angle);

    }

    @Override 
    public void run() {
        if (this.side.equalsIgnoreCase("left")) {
            //System.out.println(LeftFeet.angles.get(servoNumber));
            startup(Constants.currentFootStateLeft[this.servoNumber]);

        } else {
            startup(RightFoot.angles.get(servoNumber));

        }
        while (Constants.walking) {
            if (this.side.equalsIgnoreCase("left")) {
                //System.out.println(LeftFeet.angles.get(servoNumber));
                move(Constants.currentFootStateLeft[this.servoNumber]);

            } else {
                move(RightFoot.angles.get(servoNumber));

            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServoGyroTest.class.getName()).log(Level.SEVERE, null, ex);
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
