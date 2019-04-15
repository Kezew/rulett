/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rulettproject;

import java.util.ArrayList;

/**
 *
 * @author én
 */
public class HorizontalSplit extends Bet{

    public HorizontalSplit(int menuNumber, int money) {
        super(menuNumber, money);
        this.prizeRate=17;
    }

    @Override
    public void loadPossibeNumberList(int menuNumber) {
        
        possibleNumbers.add(menuNumber);
        possibleNumbers.add(menuNumber+1);
        
    }
    
    
    
}
