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
public class Constants {

    public static boolean reset = false;
    public static boolean walking = true;
    public static boolean waitingForSync = false;
    

    public static String serverAddress = "158.38.140.203";
    public static Integer[] leftFootPorts = new Integer[]{8011, 8012, 8013, 8014, 8015};
    public static Integer[] rightFootPorts = new Integer[]{8016, 8017, 8018, 8019, 8020};

    public static Integer[] startValuesL = new Integer[]{40, 80, 20, 90, 100};
    public static Integer[] startValuesR = new Integer[]{50, 80, 20, 90, 90};

    public static volatile Integer[] l1 = new Integer[]{40, 80, 20, 90, 100};
    public static volatile Integer[] r1 = new Integer[]{50, 80, 35, 90, 90};

    public static volatile Integer[] l2 = new Integer[]{40, 80, 20, 55, 105};
    public static volatile Integer[] r2 = new Integer[]{50, 80, 35, 65, 90};

    public static volatile Integer[] l21 = new Integer[]{40, 80, 15, 50, 105};
    public static volatile Integer[] r21 = new Integer[]{50, 40, 80, 60, 100};

    public static volatile Integer[] l3 = new Integer[]{40, 80, 15, 90, 110};
    public static volatile Integer[] r3 = new Integer[]{50, 100, 55, 90, 70};

    public static volatile Integer[] l31 = new Integer[]{40, 80, 25, 100, 100};
    public static volatile Integer[] r31 = new Integer[]{50, 100, 65, 50, 70};

    public static volatile Integer[] l4 = new Integer[]{40, 80, 55, 90, 120};
    public static volatile Integer[] r4 = new Integer[]{50, 100, 65, 50, 70};

    public static volatile Integer[] l5 = new Integer[]{40, 110, 55, 90, 80};
    public static volatile Integer[] r5 = new Integer[]{50, 100, 65, 50, 70};
    
    public static volatile Integer[] l51 = new Integer[]{40, 110, 55, 90, 80};
    public static volatile Integer[] r51 = new Integer[]{50, 100, 63, 90, 70};
    
    public static volatile Integer[] l52 = new Integer[]{40, 110, 40, 90, 90};
    public static volatile Integer[] r52 = new Integer[]{50, 100, 40, 90, 80};
    
    public static volatile Integer[] l6 = new Integer[]{40, 80, 20, 90, 100};
    public static volatile Integer[] r6 = new Integer[]{50, 80, 20, 90, 90};

    public static volatile Integer[] currentFootStateLeft = new Integer[]{40, 80, 20, 90, 100};
    public static volatile Integer[] currentFootStateRight = new Integer[]{50, 80, 20, 90, 90};

    // Gyroscope data
    public static volatile float[] gyro = new float[]{0, 0, 0};

    //OLD SHIT!!!
    /*
    public static Integer[] leftFootInit = new Integer[]{37, 60, 70, 80};
    public static Integer[] rightFootInit = new Integer[]{37, 60, 70, 80};
    public static Integer[] leftFootWalk00 = new Integer[]{37, 60, 90, 80};
    public static Integer[] rightFootWalk00 = new Integer[]{37, 60, 90, 80};
    public static Integer[] leftFootWalk0 = new Integer[]{37, 35, 80, 70};
    public static Integer[] leftFootWalk1 = new Integer[]{37, 60, 170, 90};
    public static Integer[] leftFootWalk2 = new Integer[]{37, 50, 130, 90};
    public static Integer[] setToZero = new Integer[]{37, 50, 30, 90};
    public static Integer[] sitPartlyDown = new Integer[]{37, 10, 180, 30};*/
}
