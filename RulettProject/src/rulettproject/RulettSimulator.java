/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rulettproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author Roth Reka
 */
public class RulettSimulator {

    private static HashMap<Integer, Number> rulettNumbers;
    private ArrayList<Player> playerList;
    private static int minBet;
    private static int maxBet;

    public RulettSimulator(int minBet, int maxBet) throws FileNotFoundException {
        playerList = new ArrayList<>();
        rulettNumbers = new HashMap<>();
        this.minBet = minBet;
        this.maxBet = maxBet;
        loadRulettNumbers();
    }

    public HashMap<Integer, Number> getRulettNumbers() {
        return rulettNumbers;
    }

    public static int getMinBet() {
        return minBet;
    }

    public static int getMaxBet() {
        return maxBet;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void loadRulettNumbers() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("numbers.txt"));
        while (sc.hasNext()) {
            String[] lineParts = sc.nextLine().split(",");
            int id = Integer.parseInt(lineParts[0]);
            String color = lineParts[1];
            Color c;
            if (color.equals("black")) {
                c = Color.BLACK;
            } else if (color.equals("red")) {
                c = Color.RED;
            } else {
                c = Color.GREEN;
            }
            Parity p;
            if (id == 0) {
                p = Parity.ZERO;
            } else if (id % 2 == 0) {
                p = Parity.EVEN;
            } else {
                p = Parity.ODD;
            }
            Number n = new Number(id, c, p);
            rulettNumbers.put(id, n);
        }
        sc.close();
    }

    private int roll() {
        int r = (int) (Math.random() * rulettNumbers.size());
        pause(1000);
        return r;
    }

    // „időhúzás”
    private void pause(long millis) {
        long start = System.currentTimeMillis();
        System.out.println("------------------ " + actRoundToPrint + " ------------------");
        System.out.println(ANSI_BLUE + "forog a kerék... gurul a golyó..." + ANSI_BLUE);
        System.out.println("");
        do {

        } while (System.currentTimeMillis() - start < millis);
    }

    public void simulateRound(int round) {
        for (int i = 0; i < round; i++) {
            actRoundToPrint = i + 1;
            for (Player player : playerList) {
                Bet b = player.makeABet();
            }

            int roll = roll();
            rollForColorPrint = roll;
            ListIterator<Player> listIterator = playerList.listIterator();
            while (listIterator.hasNext()) {
                Player p = listIterator.next();
                if (p.getAllMoney() < 1) {
                    listIterator.remove();
                    System.out.println(p.getName() + " nem nyert, a pénze elfogyott, kiesett a játékból...");
                }
            }
            for (Player player : playerList) {
                Bet roundBet = player.getBetHistory().get(player.getBetHistory().size() - 1);
                if (roundBet.getPossibleNumbers().contains(roll)) {
                    roundBet.setIsWinner(true);
                    player.setAllMoney(player.getAllMoney() + (roundBet.getMoney() * roundBet.getPrizeRate()));
                    System.out.println(player.getName() + " nyert, nyereménye: " + roundBet.getMoney() * roundBet.getPrizeRate()
                            + ", összes pénze: " + player.getAllMoney());
                } else {
                    if (player.getAllMoney() > 0) {
                        System.out.println(player.getName() + " nem nyert, összes pénze: " + player.getAllMoney());
                    }
                }
            }

            setPrintColorRoll();
            System.out.println(ANSI_BLUE + "Nyerőszám: " + ANSI_BLUE + printColor + roll + "  " + rulettNumbers.get(roll).getColor() + printColor);
            System.out.println("------------------------------------");
            System.out.println("");
        }

    }

    private void setPrintColorRoll() {
        if (rulettNumbers.get(rollForColorPrint).getColor().equals(Color.RED)) {
            printColor = ANSI_RED;
        }
        if (rulettNumbers.get(rollForColorPrint).getColor().equals(Color.BLACK)) {
            printColor = ANSI_BLACK;
        }
        if (rulettNumbers.get(rollForColorPrint).getColor().equals(Color.GREEN)) {
            printColor = ANSI_GREEN;
        }

    }

    private int actRoundToPrint = 0;
    private int rollForColorPrint = 0;
    private String printColor = "";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
//  String flagColor = ANSI_RED;
//  System.out.print(flagColor + "***" + flagColor);    
//  System.out.print(ANSI_RED + "***" + ANSI_RED);
}
