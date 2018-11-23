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

    public static String serverAddress = "158.38.140.203";
    public static Integer[] leftFootPorts = new Integer[]{8011, 8012, 8013, 8014, 8015};
    public static Integer[] rightFootPorts = new Integer[]{8016, 8017, 8018, 8019, 8020};

    public static Integer[] startValuesL = new Integer[]{37, 80, 20, 90, 100};
    public static Integer[] startValuesR = new Integer[]{37, 80, 20, 90, 90};

    public static final Integer[] l1 = new Integer[]{37, 80, 20, 90, 100};
    public static final Integer[] r1 = new Integer[]{37, 80, 35, 90, 90};
    
    public static final Integer[] l2 = new Integer[]{37, 80, 20, 60, 105};
    public static final Integer[] r2 = new Integer[]{37, 80, 35, 60, 90};
    
    public static final Integer[] l21 = new Integer[]{37, 80, 15, 60, 105};
    public static final Integer[] r21 = new Integer[]{37, 40, 80, 90, 100};
    
    public static final Integer[] l3 = new Integer[]{37, 80, 15, 90, 110};
    public static final Integer[] r3 = new Integer[]{37, 100, 30, 90, 70};
    
    public static final Integer[] l4 = new Integer[]{37, 80, 35, 90, 110};
    public static final Integer[] r4 = new Integer[]{37, 100, 30, 90, 80};
    
    public static final Integer[] l5 = new Integer[]{37, 80, 10, 130, 125};
    public static final Integer[] r5 = new Integer[]{37, 100, 40, 60 , 80   };
    

    public static volatile Integer[] currentFootStateLeft = new Integer[]{37, 100, 20, 90, 100};
    public static volatile Integer[] currentFootStateRight = new Integer[]{37, 100, 20, 90, 90};
    public static volatile Integer[] leftFootWalk0 = new Integer[]{37, 100, 70, 90, 90};
    public static volatile Integer[] leftFootWalk1 = new Integer[]{37, 10, 70, 90, 90};
    public static volatile Integer[] rightFootWalk0 = new Integer[]{37, 30, 100, 40, 90};
    
    public static Integer[] WalkL = new Integer[]{37, 40, 100, 90, 68};

    // Gyroscope data
    public static volatile float[] gyro = new float[]{0,0,0};
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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