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
    public static boolean walking = true;
    public static String serverAddress = "158.38.140.203";
    public static Integer[] leftFootPorts = new Integer[]{8011,8012,8013,8014};
    public static Integer[] rightFootPorts = new Integer[]{8015,8016,8017,8018};
    public static Integer[] startValues = new Integer[]{37, 40, 100, 68};

    public static volatile Integer[] currentFootStateLeft = new Integer[]{37, 40, 100, 90};
    public static volatile Integer[] currentFootStateRight = new Integer[]{37, 40, 100, 68};
        public static Integer[] WalkL = new Integer[]{37, 40, 100, 68};

    
    
    // Rasmus leker seg
    public static Integer[] liftKnee = new Integer[]{37, 40, 130, 50};
    public static Integer[] putKnee = new Integer[]{37, 60, 110, 0};

    public static Integer[] leftFootWalk092 = new Integer[]{37, 80, 70, 60};
    public static Integer[] rightFootWalk090 = new Integer[]{37, 50, 80, 60};
    public static Integer[] rightFootWalk091 = new Integer[]{37, 80, 140, 80};
    public static Integer[] rightFootWalk092 = new Integer[]{37, 80, 70, 60};
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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