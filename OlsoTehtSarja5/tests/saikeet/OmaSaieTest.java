package saikeet;

/**
* @author Simo Silander. Muutetteu 28.8.2019 Auvo Häkkinen
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class OmaSaieTest {

	private OmaSaie saie;

	@BeforeEach
	public void setUp() throws Exception {
		saie = new OmaSaie(5);
	}

	@AfterEach
	public void tearDown() throws Exception {
		saie = null;
	}

	@Test
	public void testRun() {

		int luku = 5; 		// Testissä asetettu luku
		int ajokerrat = 0; 	// Metodia run() ei oel kutsuttu (ei suorittavaa säiettä)

		saie.run();			// sekä luku että ajokerrat kasvavat nyt yhdellä
		assertEquals(luku+1, saie.luku,
				"Säikeen run ei toimi oikein (luku)");
		assertEquals(ajokerrat+1, OmaSaie.yhteisetAjokerrat, 
				"Säikeen run ei toimi oikein (staticLuku)");

		OmaSaie saie2 = new OmaSaie(); // luku alustuu 0:ksi
		saie2.run(); 		// sekä luku että ajokerrat kasvavat jälleen  yhdellä
		assertEquals(1, saie2.luku, "Säikeen run ei toimi oikein (luku)" );
		assertEquals(ajokerrat+2, OmaSaie.yhteisetAjokerrat, 
				"Säikeen run ei toimi oikein (staticLuku)");
	}

	@Test
	public void testOmaSaie() {
		assertEquals(5, saie.luku, 
				"Alustus konstruktorissa ei toimi oikein");
	}

	@Test
	public void testGetLuku() {
		assertEquals(saie.luku, saie.getLuku(), 
				"getLuku() ei toimi oikein");
	}

	@Test
	public void testSetLuku() {
		saie.setLuku(10);
		assertEquals(10, saie.luku, 
				"setLuku() ei toimi oikein");
	}

	@Test
	public void testGetYhteisetAjokerrat() {
		assertEquals(OmaSaie.yhteisetAjokerrat, OmaSaie.getYhteisetAjokerrat(),
				"getYhteisetAjokerrat() ei toimi oikein");
	}

	@Test
	public void testSetYhteisetAjokerrat() {
		OmaSaie.setYhteisetAjokerrat(10);
		assertEquals(10, OmaSaie.yhteisetAjokerrat,
				"setYhteisetAjokerrat() ei toimi oikein");
	}
}
