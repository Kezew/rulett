
package rulettproject;

/**
 *
 * @author User
 */
public class RandomColor extends Player{
    
    public RandomColor(String name, int allMoney) {
        super(name, allMoney);
    }

    @Override
    public Bet makeABet() {
        Bet actBet = null;
        setBetMoney((int) (Math.random() * (RulettSimulator.getMaxBet() - RulettSimulator.getMinBet()) + RulettSimulator.getMinBet()));
        int randomColor = (int) (Math.random() * 2) + 1;
        actBet = new Simple(randomColor, getBetMoney());
        setAllMoney(getAllMoney() - getBetMoney());
        betHistory.add(actBet);
        return actBet;
    }
    
}
