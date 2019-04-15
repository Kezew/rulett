package rulettproject;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public abstract class Player {

    private String name;
    private int allMoney;
    private int betMoney;
    protected ArrayList<Bet> betHistory;

    public Player(String name, int allMoney) {
        this.name = name;
        this.allMoney = allMoney;
        betHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAllMoney() {
        return allMoney;
    }

    public int getBetMoney() {
        return betMoney;
    }

    public ArrayList<Bet> getBetHistory() {
        return betHistory;
    }

    public void setAllMoney(int allMoney) {
        this.allMoney = allMoney;
    }

    public void setBetMoney(int betMoney) {
        this.betMoney = betMoney;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Bet makeABet();

}
