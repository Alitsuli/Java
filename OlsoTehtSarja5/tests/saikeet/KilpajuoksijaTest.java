package saikeet;

/**
* @author Simo Silander. Muutettu 20.9.2019 Auvo Häkkinen.
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KilpajuoksijaTest {

	@DisplayName("Testaa, että syntynyt aika on reaalistinen")
	@Test
	public void testRealistisuus() {
		Kilpajuoksija k = new Kilpajuoksija();
		k.start();
		try {
			k.join();
		} catch (InterruptedException e) {
			System.out.println("Tuli poikkeus join()-rutiinissa");
		}
		double aika = k.getAika();
		assertTrue(aika>=43 && aika <=55, "Epärealistinen loppuaika (aika < 43s tai aika > 55s");
	}

}
