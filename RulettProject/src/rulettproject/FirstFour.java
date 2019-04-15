package rulettproject;

import java.util.ArrayList;

public class FirstFour extends Bet {

    public FirstFour(int menuNumber, int money) {
        super(menuNumber, money);
        this.prizeRate = 8;
    }

    @Override
    public void loadPossibeNumberList(int menuNumber) {
        
        for (int i = 0; i < 5; i++) {
            possibleNumbers.add(i);
        }
        
    }

}
