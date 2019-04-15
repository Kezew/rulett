/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rulettproject;

/**
 *
 * @author Roth Reka
 */
public class OtherColorComesForSure extends Player {

    public OtherColorComesForSure(String name, int allMoney) {
        super(name, allMoney);
    }

    @Override
    public Bet makeABet() {
        Bet actBet = null;
        setBetMoney(RulettSimulator.getMinBet());
        if (betHistory.size() > 5) {
            int redCnt = 0;
            for (int i = betHistory.size() - 6; i < betHistory.size(); i++) {
                if (betHistory.get(i).getMenuNumber() == 0) {
                    redCnt++;
                }
            }
            if (redCnt == 5) {
                actBet = new Simple(0, getBetMoney());
                setAllMoney(getAllMoney() - getBetMoney());
                betHistory.add(actBet);
                return actBet;
            } else if (redCnt == 0) {
                actBet = new Simple(1, getBetMoney());
                setAllMoney(getAllMoney() - getBetMoney());
                betHistory.add(actBet);
                return actBet;
            } else {
                int random = (int) (Math.random() * 2);
                actBet = new Simple(random, getBetMoney());
                setAllMoney(getAllMoney() - getBetMoney());
                betHistory.add(actBet);
                return actBet;
            }
        } else {
            int random = (int) (Math.random() * 2);
            actBet = new Simple(random, getBetMoney());
            setAllMoney(getAllMoney() - getBetMoney());
            betHistory.add(actBet);
            return actBet;
        }
    }
}
