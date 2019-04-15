
package rulettproject;

import java.util.ArrayList;

public class Corner extends Bet{

    public Corner(int menuNumber, int money) {
        super(menuNumber, money);
        this.prizeRate=8;
    }

    @Override
    public void loadPossibeNumberList(int menuNumber) {
        
        for(int i=menuNumber; i<menuNumber+5; i++){
            possibleNumbers.add(i);
        }
        
    }
    
    
    
}
