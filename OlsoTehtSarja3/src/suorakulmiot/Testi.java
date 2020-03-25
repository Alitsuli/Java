
package suorakulmiot;
/**
 *
 * @author Ali
 */

// Kirjoita tähän yleiskommentit

public class Testi {

    public static void main(String[] args) {

    // Kirjoita tähän testaamisessa tarvitsemasi lauseet
    	NaytonSuorakulmio NSK = new NaytonSuorakulmio(225, 120, 800, 30);
    
    //tulosta luomasi olio tiedot
    	System.out.println(NSK.toString());
    	boolean mahtuu = NSK.mahtuu(1024, 768);
    // testaus mahtuu metodi
    	if (mahtuu) {
    		System.out.println("Mahtuu!");
    	} else {
    		System.out.println("Ei mahdu!");
    	}
    // suorakulmio olio
    	Suorakulmio SK = new Suorakulmio(80, 40);
    	System.out.println(SK.toString());
    	System.out.println(SK.ala());

    }
}
