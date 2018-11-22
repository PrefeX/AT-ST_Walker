package no.ntnu.rt.walker;

import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.*;


/**
 * Represents a single serial connection to a arduino with a gyroscope. The
 * class establishes the communication, and transmission between the devices,
 * and parses the incomming serial data so it can be accessed in other parts of
 * the program
 *
 * @author Christian
 */
public class Serial implements Runnable {

    private final SerialPort serialPort;
    private final String portNr;

    private float[] values;


    /**
     *
     * @param portNr
     */
    public Serial(String portNr) {
        getPorts();
        this.serialPort = new SerialPort(portNr);
        this.portNr = portNr;

        try {
            startSerial(portNr);
        }
        catch (InterruptedException | SerialPortException ex) {
            Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Lists all the detected COM/Serial ports on the system
     *
     * @return A string array containing all detected ports
     */
    public String[] getPorts() {
        String[] portNames;
        portNames = SerialPortList.getPortNames();

        System.out.println("Detected system COM/Seriel ports:");
        for (String portName : portNames) {
            System.out.println(portName);
        }

        return portNames;
    }


    /**
     * <p>
     * Start a serial connection on a given port.</p>
     *
     * <p>
     * Sends the initialize command to the Arduino, and waits for 1 second for
     * the reciever to start transmitting.</p>
     *
     * The recieved data is in the format <code>[0.00,0.00,0.00]</code> where
     * the data represents <code>[yaw, pitch, roll]</code>.
     *
     * @param port The COM/Serial port to connect to
     * @throws InterruptedException
     * @throws SerialPortException
     */
    private void startSerial(String port) throws InterruptedException, SerialPortException {

        // Attempt to open the port and initialize the transmission
        serialPort.openPort();

        serialPort.setParams(
                SerialPort.BAUDRATE_115200,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE,
                false,
                false);

        // Wait so the connection can be established, send a message to start the slave and wait for it to initilize
        System.out.println("Waiting for connection, and sending the start command");
        Thread.sleep(1000);
        serialPort.writeBytes("Start".getBytes()); //Write data to port

        while (true) {
            String transmissionString = serialPort.readString();
            if (transmissionString != null) {
                if (transmissionString.startsWith("[") && transmissionString.endsWith("]")) {
                    //System.out.println(transmissionString);
                    parseInput(transmissionString);
                }
            }
        }
        //serialPort.closePort();
    }


    /**
     * Transforms and splits the transmited string back to readable float values.
     * @param transmissionString The string that should be parsed
     */
    private void parseInput(String transmissionString) {
        String s = transmissionString.substring(1, transmissionString.length() - 1); // Strip brackets
        String[] values = s.split(","); // Split values

        // Cast to float
        for (int i = 0; i < values.length; i++) {
            this.values[i] = Float.parseFloat(values[i]);
        }
    }


    /**
     * Return an array with all the gyroscope values for yaw, roll and pitch.
     * Index 0: yaw Index 1: pitch Index 2: roll
     *
     * @return Am array containing the gyroscope values
     */
    public float[] getValues() {
        return this.values;
    }


    /**
     * Default method that runs when starting the thread
     */
    @Override
    public void run() {
        try {
            startSerial(portNr);
        }
        catch (InterruptedException | SerialPortException ex) {
            Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
