/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.rt.walker;

/**
 *
 * @author rasmu
 */

/**
 * TODO: Fikse gåmønster
 * starte i en positiv boolean, bevege seg til enden av mønster
 * flippe boolean, retractivt mønster tilbake
 * flippe boolean, rince repeat
 * Bruke inputs fra gyro her til å trekke fra/legge til
 */
public class WalkCalc {
    
    int hipTurnBase = 37;
    
    int hipBase = 30;
    int kneeBase = 130;
    int ancleBase = 50;
    
    int hipMax = 50;
    int kneeMax = 170;
    int ancleMax = 90;
    
    public Integer[] Walk(int steps, boolean forward){
        
        Integer[] foot;
        
        if(forward){
            hipBase += (steps/2);
            kneeBase += steps;
            ancleBase += steps;
            foot = new Integer[]{hipTurnBase, hipBase, kneeBase, ancleBase};
        }else{
            hipMax -= (steps/2);
            kneeMax -= steps;
            ancleMax -= steps;
            foot = new Integer[]{hipTurnBase, hipMax, kneeMax, ancleMax};
        }
        return foot;
        
        
    }
}

