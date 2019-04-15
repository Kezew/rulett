
package rulettproject;

import java.util.ArrayList;

public abstract class Bet {
    
   int prizeRate;
   ArrayList<Integer> possibleNumbers = new ArrayList<>();
   int menuNumber;
   int money;
   boolean isWinner;

    public Bet(int menuNumber, int money) {
        this.menuNumber = menuNumber;
        this.money = money;
        loadPossibeNumberList(menuNumber);
    }
    
    
    public abstract void loadPossibeNumberList(int menuNumber);

    public int getPrizeRate() {
        return prizeRate;
    }

    public ArrayList<Integer> getPossibleNumbers() {
        return possibleNumbers;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public int getMoney() {
        return money;
    }

    public boolean isIsWinner() {
        return isWinner;
    }

    public void setIsWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }
    
    
   
   
    
}
