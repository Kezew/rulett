package rulettproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Street extends Bet {

    boolean isHorizontal = false;

    public Street(int menuNumber, int money) {
        super(menuNumber, money);
        this.prizeRate = 11;
        System.out.println("Vízszintesen, vagy függőlegesen lévő 3 számra akarsz tenni?");
        System.out.println("v: vízszintes/f: függőleges");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equals("v")) {
                isHorizontal = true;
                break;
            } else if (input.equals("f")) {
                break;
            } else {
                System.out.println("Hibás bemenet, próbáld újra");
            }
        }
    }

    @Override
    public void loadPossibeNumberList(int menuNumber) {
        if (isHorizontal) {
            
            possibleNumbers.add(menuNumber);
            possibleNumbers.add(menuNumber + 1);
            possibleNumbers.add(menuNumber + 2);
            
        } else {
            
            possibleNumbers.add(menuNumber);
            possibleNumbers.add(menuNumber + 3);
            possibleNumbers.add(menuNumber + 6);
            
        }
    }

}
