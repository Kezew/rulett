
package rulettproject;

import java.util.ArrayList;

public class Plain extends Bet{

    public Plain(int menuNumber, int money) {
        super(menuNumber, money);
        this.prizeRate=35;
    }

    @Override
    public void loadPossibeNumberList(int menuNumber) {
        
        possibleNumbers.add(menuNumber);
        
    }
    
    
    
}
