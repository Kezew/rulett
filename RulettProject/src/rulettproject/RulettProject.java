/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rulettproject;


import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author Roth Reka
 */
public class RulettProject {

    private RulettSimulator rs;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        RulettProject rp = new RulettProject();
        int min = rp.setMinBetValue();
        int max = min * 500;
        rp.rs = new RulettSimulator(min, max);

        rp.setPlayers(); // TODO setHumanPlayers,  setComputerPlayers   >>> 

        int r = rp.setRoundNumber();
        rp.rs.simulateRound(r);

    }

    public int setMinBetValue() {
        int minBetValue = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Add meg a minimum tétet: ");
            minBetValue = sc.nextInt();
        } while (minBetValue < 1);

        return minBetValue;
    }

    public void setPlayers() {
        Scanner sc = new Scanner(System.in);
        Scanner nameScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Adj hozzá játékost!  (szimulátor - csak stratégiát adj hozzá,  játék esetén válassz élő játékost is) ");
            System.out.println("");
            System.out.println("1 - Élő játékos");
            System.out.println("2 - Martingel stratégia");
            System.out.println("3 - Bátor stratégia");
            System.out.println("4 - Konzervatív startégia");
            System.out.println("5 - Véletlen szín stratégia");
            System.out.println("6 - Mostmár biztos a másik szín jön stratégia");
            System.out.println("7 - Nem kell több játékos");
            System.out.println("");
            int answer = sc.nextInt();
            if (answer == 1) {
                System.out.println("Add meg a játékos nevét!");
                String playerName = nameScanner.nextLine();
                rs.getPlayerList().add(new Human(playerName, 1000));
                System.out.println("");
            } else if (answer == 2) {
                rs.getPlayerList().add(new Martingel("Martingél Béla", 1000));
            } else if (answer == 3) {
                rs.getPlayerList().add(new Brave("Bátor Tibor", 1000));
            } else if (answer == 4) {
                rs.getPlayerList().add(new Conservative("Konzervatív Katalin", 1000));
            } else if (answer == 5) {
                rs.getPlayerList().add(new RandomColor("Random Robi", 1000));
            } else if (answer == 6) {
                rs.getPlayerList().add(new OtherColorComesForSure("L. Fekete Piroska", 1000));
            } else if (answer == 7) {
                break;
            }
        }

    }

    public int setRoundNumber() {
        int numberRound = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Add meg a körök számát: ");
            numberRound = sc.nextInt();
        } while (numberRound < 1);

        return numberRound;
    }

}
