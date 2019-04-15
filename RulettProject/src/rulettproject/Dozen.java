/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rulettproject;

/**
 *
 * @author én
 */
public class Dozen extends Bet {

    public Dozen(int menuNumber, int money) {
        super(menuNumber, money);
        this.prizeRate = 3;
    }

    @Override
    public void loadPossibeNumberList(int menuNumber) {
        if (menuNumber == 1) {
            for (int i = 1; i < 37; i = i + 3) {
                possibleNumbers.add(i);
            }
        } else if (menuNumber == 2) {
            for (int i = 2; i < 37; i = i + 3) {
                possibleNumbers.add(i);
            }
        } else if (menuNumber == 3) {
            for (int i = 1; i < 37; i = i + 3) {
                possibleNumbers.add(i);
            }
        } else if (menuNumber == 4) {
            for (int i = 1; i < 13; i++) {
                possibleNumbers.add(i);
            }
        } else if (menuNumber == 5) {
            for (int i = 13; i < 25; i++) {
                possibleNumbers.add(i);
            }
        } else if (menuNumber == 6) {
            for (int i = 25; i < 37; i++) {
                possibleNumbers.add(i);
            }
        }
    }
}
