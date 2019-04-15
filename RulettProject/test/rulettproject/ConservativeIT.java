
package rulettproject;

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ConservativeIT {
    
    public ConservativeIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeABet method, of class Conservative.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testMakeABet() throws FileNotFoundException {
        //System.out.println("makeABet");
        RulettSimulator rs = new RulettSimulator(20, 500);
        
        Conservative instance = new Conservative("Konzervatív", 1000);
        
        Bet expResult = new Simple(0, 20);
        
        int expBetMoney = 20;
        int resultBetMoney = instance.getBetMoney();
        instance.makeABet();
        int moneyAfterBet = instance.getAllMoney();
//        Bet result = instance.makeABet();
        assertEquals(expBetMoney, resultBetMoney);
        assertEquals(980,moneyAfterBet);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
