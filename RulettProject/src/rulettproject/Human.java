package rulettproject;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Human extends Player {

    public Human(String name, int allMoney) {
        super(name, allMoney);
    }

    @Override
    public Bet makeABet() {
        Bet actBet = null;
        int choosenNumber = 0;
        int actBetValue = 0;
        
        Scanner sc = new Scanner(System.in);
        // helyes tét
        do {
            System.out.println(getName() + " add meg a tétet ( " + RulettSimulator.getMinBet() + " - " + RulettSimulator.getMaxBet() + ", a rendelkezésre álló pénzed: " + getAllMoney() + " )");
            actBetValue = sc.nextInt();
            setBetMoney(actBetValue);
        } while (getBetMoney() < RulettSimulator.getMinBet() || getBetMoney() > getAllMoney() || getBetMoney() > RulettSimulator.getMaxBet());
        // levonni a tétet
        setAllMoney(getAllMoney() - getBetMoney());

        printMenuForHuman();
        int betType = sc.nextInt();

        // Simple tét
        if (betType == 1) {

            System.out.println("Melyik mezőre:");
            System.out.println("(0)-piros   (1)-fekete  (2)-páros   (3)-páratlan    (4)- 1-18   (5)- 19-36");
            choosenNumber = sc.nextInt();
            actBet = new Simple(choosenNumber, getBetMoney());
            betHistory.add(actBet);
            return actBet;
        }

        // konkrét számra
        if (betType == 2) {
            do {
                System.out.println("Melyik számra szeretnél tenni?");
                choosenNumber = sc.nextInt();

            } while (choosenNumber < 0 || choosenNumber > 36);
            actBet = new Plain(choosenNumber, getBetMoney());
            betHistory.add(actBet);
            return actBet;

        }
        // egymás melletti számpárok    
        if (betType == 3) {

            do {
                System.out.println("Add meg a számpár bal oldali tagját!");
                choosenNumber = sc.nextInt();
                if (choosenNumber % 3 == 0) {
                    System.out.println("Rossz számot adtál meg, próbáld újra!");
                    choosenNumber = 50;
                }
            } while (choosenNumber < 0 || choosenNumber > 36);
            actBet = new HorizontalSplit(choosenNumber, getBetMoney());
            betHistory.add(actBet);
            return actBet;

        }
        // egymás alatti számpárok
        if (betType == 4) {

            do {
                System.out.println("Add meg a számpár felső tagját!");
                choosenNumber = sc.nextInt();

            } while (choosenNumber < 0 || choosenNumber > 33);
            actBet = new VerticalSplit(choosenNumber, getBetMoney());
            betHistory.add(actBet);
            return actBet;

        }
        // szám négyesek
        if (betType == 5) {
            do {
                System.out.println("Add meg a számnégyes bal felső tagját!");
                choosenNumber = sc.nextInt();
                if (choosenNumber % 3 == 0) {
                    System.out.println("Rossz számot adtál meg, próbáld újra!");
                    choosenNumber = 33;
                }
            } while (choosenNumber < 0 || choosenNumber > 32);
            actBet = new Corner(choosenNumber, getBetMoney());
            betHistory.add(actBet);
            return actBet;
        }
        // Dozen
        if (betType == 6) {
            do {
                System.out.println("Melyik \"tucat?\"");
                System.out.println("(1)- bal oszlop   (2)- középső oszlop  (3)- jobb oszlop   (4)- 1st12    (5)- 2nd12   (6)- 3rd12");
                choosenNumber = sc.nextInt();

            } while (choosenNumber < 1 || choosenNumber > 6);
            actBet = new Dozen(choosenNumber, getBetMoney());
            betHistory.add(actBet);
            return actBet;
        }
        // FirstFour >> első 4 >>> 0,1,2,3
        if (betType == 7) {
            actBet = new FirstFour(choosenNumber, getBetMoney());
            betHistory.add(actBet);
            return actBet;
        }
        // szám hatosok
        if (betType == 8) {
            do {
                System.out.println("Add meg a számhatos bal felső tagját!");
                choosenNumber = sc.nextInt();
                if (choosenNumber % 3 == 0 || choosenNumber % 3 == 2) {
                    System.out.println("Rossz számot adtál meg, próbáld újra!");
                    choosenNumber = 32;
                }
            } while (choosenNumber < 0 || choosenNumber > 31);
            actBet = new SixLine(choosenNumber, getBetMoney());
            betHistory.add(actBet);
            return actBet;
        } else {
            System.out.println("Rosszat írtál be.");
            makeABet();
        }

        return actBet;
    }
    
    private void printMenuForHuman() {
        System.out.println("Válassz a következő lehetőségek közül:");
        System.out.println("1. Egyszerű tét (1:2 odds)");
        System.out.println("2. Konkrét számra");
        System.out.println("3. Szám párokra (egymás melletti)");
        System.out.println("4. Szám párokra (egymás alatti)");
        System.out.println("5. 4 szám (bal felsőt add meg)");
        System.out.println("6. Tucat");
        System.out.println("7. FirstFour");
        System.out.println("8. 6-os számcsoport (bal felsőt add meg)");
    }

}
