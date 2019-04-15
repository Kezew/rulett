
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
public class MartingelIT {
    
    public MartingelIT() {
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
     * Test of makeABet method, of class Martingel.
     */
    @Test
    public void testMakeABet() throws FileNotFoundException {
        System.out.println("makeABet");
        RulettSimulator rs = new RulettSimulator(20, 300);
        Martingel instance = new Martingel("Martingel", 1000);

        // az első alkalommal: minimum tét, levonódik-e a tét?
        assertEquals(0, instance.betHistory.size());
        Bet result = instance.makeABet();
        assertEquals(20, result.money);

        // harmadik alkalommal : duplázódik-e?
        result = instance.makeABet();
        result = instance.makeABet();
        assertEquals(80, result.money);

        // nyerés után: alap tétet rakja-e?
        result.setIsWinner(true);
        result = instance.makeABet();
        assertEquals(20, result.money);
        assertEquals(840, instance.getAllMoney());

        // max téten felüli duplázás esetén a max-tétet rakja-e?
        result.setIsWinner(false);
        for (int i = 0; i < 4; i++) {
            result = instance.makeABet();
        }
        assertEquals(300, result.money);
        assertEquals(260, instance.getAllMoney());

        // ha az összes pénze kisebb mint a max és a duplázás összege akkor az összes pénzét teszi-e fel?
        result = instance.makeABet();
        assertEquals(260, result.money);
    }
    
}
