
package rulettproject;

import java.util.ArrayList;
import java.util.HashMap;

public class Simple extends Bet{
    
    private static HashMap<Integer, String> numbers = new HashMap<>();
    
    private static String black = "Black";
    private static String red = "Red";
    private static String green = "Green";

    public Simple(int menuNumber, int money) {
        super(menuNumber, money);
        this.prizeRate=2;
        
    }

    @Override
    public void  loadPossibeNumberList(int menuNumber) {
        fillNumbers();
        if (menuNumber==0){
            for (Integer integer : numbers.keySet()) {
                if(numbers.get(integer).equals(red)){
                    possibleNumbers.add(integer);
                }
            }            
        }else if(menuNumber==1){
            for (Integer integer : numbers.keySet()) {
                if(numbers.get(integer).equals(black)){
                    possibleNumbers.add(integer);
                }
            } 
        }else if(menuNumber==2){
            for (int i=1; i<37;i++){
                if(i%2==0){
                    possibleNumbers.add(i);
                }
            }
        }else if(menuNumber==3){
            for (int i=1; i<37;i++){
                if(i%2==1){
                    possibleNumbers.add(i);
                }
            }
        }else if (menuNumber==4){
            for(int i=0; i<19; i++){
                possibleNumbers.add(i);
            }
        }else if (menuNumber==5){
            for(int i=19; i<37; i++){
                possibleNumbers.add(i);
            }
        }
        
    }

    public void fillNumbers() {
        numbers.put(0, green);
        numbers.put(1, red);
        numbers.put(2, black);
        numbers.put(3, red);
        numbers.put(4, black);
        numbers.put(5, red);
        numbers.put(6, black);
        numbers.put(7, red);
        numbers.put(8, black);
        numbers.put(9, red);
        numbers.put(10, black);
        numbers.put(11, black);
        numbers.put(12, red);
        numbers.put(13, black);
        numbers.put(14, red);
        numbers.put(15, black);
        numbers.put(16, red);
        numbers.put(17, black);
        numbers.put(18, red);
        numbers.put(19, red);
        numbers.put(20, black);
        numbers.put(21, red);
        numbers.put(22, black);
        numbers.put(23, red);
        numbers.put(24, black);
        numbers.put(25, red);
        numbers.put(26, black);
        numbers.put(27, red);
        numbers.put(28, black);
        numbers.put(29, black);
        numbers.put(30, red);
        numbers.put(31, black);
        numbers.put(32, red);
        numbers.put(33, black);
        numbers.put(34, red);
        numbers.put(35, black);
        numbers.put(36, red);

    }   
}
