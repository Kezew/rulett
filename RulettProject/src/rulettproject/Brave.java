package rulettproject;

/**
 *
 * @author User
 */
public class Brave extends Player {

    public Brave(String name, int allMoney) {
        super(name, allMoney);
        setBetMoney(RulettSimulator.getMaxBet());
    }

    @Override
    public Bet makeABet() {
        // TODO tétek nyagyságát ellenőrizni!! mit rakhat ??
        Bet actBet = new Simple(0, getBetMoney());
        setAllMoney(getAllMoney() - getBetMoney());
        betHistory.add(actBet);
        return actBet;

    }

}
