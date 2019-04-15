
package rulettproject;

import java.util.ArrayList;

public class SixLine extends Bet{

    public SixLine(int menuNumber, int money) {
        super(menuNumber, money);
        this.prizeRate=5;
    }
    
    @Override
    public void loadPossibeNumberList(int menuNumber){
        
        for (int i=menuNumber; i<menuNumber+7; i++){
            possibleNumbers.add(i);
        }
        
    }
    
    
    
}
