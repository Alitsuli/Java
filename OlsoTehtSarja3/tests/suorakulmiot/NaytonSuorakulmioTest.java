
package suorakulmiot;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hakka, 20.1.2013, muutos 20.8.2019: JUnit Jupiter.
 */
public class NaytonSuorakulmioTest {

    private static final int LEVEYS = 1024;
    private static final int KORKEUS = 768;
	
    @BeforeEach
    public void setUp() {
        System.out.println("NaytonSuorakulmioTest: @BeforeEach");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("NaytonSuorakulmiotest: @AfterEach");
        System.out.println("---------------------------------");
    }
     
    /* Rajakohtien testaaminen tärkeää, sillä of-by-one virhe on helppo
     * tehdä: ts. kuuluuko vertailussa olla yhtäsuuruusmerkki vai ei?
     */
    
    @Test
    @DisplayName("mahtuu(): liian leveä, ei mahdu")
    public void testMahtuu1() {
        System.out.println("mahtuu(): liian leveä, ei mahdu");
        NaytonSuorakulmio instance = new NaytonSuorakulmio(225, 120, 800, 30);
        boolean expResult = false;
        boolean result = instance.mahtuu(LEVEYS, KORKEUS);
        assertEquals(expResult, result, LEVEYS + "x" + KORKEUS +": (" + instance +") ");
     }
   
    @Test
    @DisplayName("mahtuu(): suurin leveys, joka vielä mahtuu")
    public void testMahtuu2() {
        System.out.println("mahtuu(): suurin leveys, joka vielä mahtuu");
        NaytonSuorakulmio instance = new NaytonSuorakulmio(224, 120, 800, 30);
        boolean expResult = true;
        boolean result = instance.mahtuu(LEVEYS, KORKEUS);
        assertEquals(expResult, result, LEVEYS + "x" + KORKEUS +": (" + instance +") ");
     }
    
    @Test
    @DisplayName("mahtuu(): liian korkea, ei mahdu")
    public void testMahtuu3() {
        System.out.println("mahtuu(): liian korkea, ei mahdu");
        NaytonSuorakulmio instance = new NaytonSuorakulmio(200, 100, 800, 669);
        boolean expResult = false;
        boolean result = instance.mahtuu(LEVEYS, KORKEUS);
        assertEquals(expResult, result, LEVEYS + "x" + KORKEUS +": (" + instance +") ");
     }
  
    @Test
    @DisplayName("mahtuu(): suurin korkeus, joka vielä mahtuu")
    public void testMahtuu4() {
        System.out.println("mahtuu(): suurin korkeus, joka vielä mahtuu");
         NaytonSuorakulmio instance = new NaytonSuorakulmio(200, 100, 800, 668);
        boolean expResult = true;
        boolean result = instance.mahtuu(LEVEYS, KORKEUS);
        assertEquals(expResult, result, LEVEYS + "x" + KORKEUS +": (" + instance + ") ");
     }
    
    @Test
    @DisplayName("toString(): oikea muotoilu")
    public void testToString() {
        System.out.println("toString(): merkkijonon muotoilu");
        NaytonSuorakulmio instance = new NaytonSuorakulmio(225, 120, 800, 30);
        String expResult = "x=225, y=120, leveys=800, korkeus=30";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
