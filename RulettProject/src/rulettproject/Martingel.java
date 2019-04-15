package rulettproject;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Martingel extends Player {

    protected int martingelBet;  // ez a változó mindig a stratégiának megfelelő tétet jelenti

    public Martingel(String name, int allMoney) {
        super(name, allMoney);
        // a Casino min téttel kezd
        this.setBetMoney(RulettSimulator.getMinBet());
        martingelBet = RulettSimulator.getMinBet();

    }

    @Override
    public Bet makeABet() {
        Bet actBet = null;
        // eldönteni a tét nagyságát
        // ArrayList-ben a betHistory utolsó Bet-ben lévő isWinner  false or true ???  

// TODO: az első alkalommal még az ArrayList-ben nincs semmi. Tehát a kezdeti tétet tegye meg először. Az első alkalommal még a betHistory.size = 0 >> ekkor a kezdeti téttel legyen a Bet példányosítva
        if (betHistory.size() == 0) {
            actBet = new Simple(0, martingelBet);
            setAllMoney(getAllMoney() - martingelBet);
            betHistory.add(actBet);
            return actBet;
// EZ KERÜL AZ IF-be >>  betHistory.get(betHistory.size()-1).isWinner  
        } else if (betHistory.get(betHistory.size() - 1).isWinner) {  //   ha true >>> akkor a kezdeti tétet játszuk meg 
            martingelBet = this.getBetMoney();
        } else {   // false >>>  martingaleBet duplázása,  ha már elértük a MAX_BET -et akkor csak azt fogja engedni rakni,  !!! a megmaradó pénzt is tegye fel
            martingelBet = Math.min ( getAllMoney() ,Math.min(martingelBet * 2, RulettSimulator.getMaxBet()) );           
        }

        actBet = new Simple(0, martingelBet);
        setAllMoney(getAllMoney() - martingelBet);
        betHistory.add(actBet);
        return actBet;
    }

}
