package rulettproject;

/**
 *
 * @author User
 */
public class Conservative extends Player {

    public Conservative(String name, int allMoney) {
        super(name, allMoney);
        setBetMoney(RulettSimulator.getMinBet());
    }

    @Override
    public Bet makeABet() {

        Bet actBet = new Simple(0, getBetMoney());
        setAllMoney(getAllMoney() - getBetMoney());
        betHistory.add(actBet);
        return actBet;

    }

}
