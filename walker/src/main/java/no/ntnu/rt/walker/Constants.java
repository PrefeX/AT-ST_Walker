/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

import java.util.concurrent.atomic.AtomicIntegerArray;

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

    public static int[] startValuesL = new int[]{40, 80, 20, 90, 100};
    public static int[] startValuesR = new int[]{40, 80, 20, 90, 90};

    public static final int[] l1 = new int[]{40, 80, 20, 90, 100};
    public static final int[] r1 = new int[]{40, 80, 35, 90, 90};
    
    public static final int[] l2 = new int[]{40, 80, 20, 60, 105};
    public static final int[] r2 = new int[]{40, 80, 35, 60, 90};
    
    public static final int[] l21 = new int[]{40, 80, 15, 60, 105};
    public static final int[] r21 = new int[]{40, 40, 80, 85, 100};
    
    public static final int[] l3 = new int[]{40, 80, 15, 60, 110};
    public static final int[] r3 = new int[]{40, 90, 50, 85, 70};
    
    public static final int[] l31 = new int[]{40, 80, 25, 100, 110};
    public static final int[] r31 = new int[]{40, 100, 65, 70, 70};
    
    public static final int[] l4 = new int[]{40, 80, 25, 120, 110};
    public static final int[] r4 = new int[]{40, 100, 65, 60, 70};
    
    public static final int[] l41 = new int[]{40, 80, 25, 90, 130};
    public static final int[] r41 = new int[]{40, 100, 65, 60, 70};
    
    public static final int[] l42 = new int[]{40, 120, 70, 90, 130};
    public static final int[] r42 = new int[]{40, 100, 65, 60, 70};
    
    public static final int[] l5 = new int[]{40, 80, 10, 130, 125};
    public static final int[] r5 = new int[]{40, 100, 40, 60 , 80};
    

    public static volatile int[] footStateL = new int[]{40, 100, 20, 90, 100};
    public static volatile int[] footStateR = new int[]{40, 100, 20, 90, 90};
    public static volatile AtomicIntegerArray currentFootStateRight = new AtomicIntegerArray(footStateR);
    public static volatile AtomicIntegerArray currentFootStateLeft = new AtomicIntegerArray(footStateL);


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