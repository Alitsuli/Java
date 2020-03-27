package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/* Tällainen pitää tehdä
 * Valuuttakone hakee tiedot DB:stä
 * Pitäisi päästä lisäämään pari valuuttaa tyhjään, ja lopuksi poistamaan.
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ValuuttakoneTest {

	private IValuuttakone valuuttakone = new Valuuttakone();
	private static IValuuttaDAO valuuttaDAO = new ValuuttaAccessObject();
		
	private static Valuutta valuutta1 = new Valuutta("TST1", 10, "Testivaluutta 1");
	private static Valuutta valuutta2 = new Valuutta("TST2", 20, "Testivaluutta 2");
	private static int index1 = -1, index2 = -1;
	private final double DELTA = 0.001;
	
	@BeforeEach
	public void alkutoimet() {
		// Luo kantaan kaksi Valuuttaa näitä testejä varten
		valuuttaDAO.createValuutta(valuutta1);
		valuuttaDAO.createValuutta(valuutta2);
	}
	
	@AfterAll
	public static void lopputoimet() {
		// Poista lopuksi näissä testeissä käytetyt Valuutat tietokannasta
		valuuttaDAO.deleteValuutta(valuutta1.getTunnus());
		valuuttaDAO.deleteValuutta(valuutta2.getTunnus());
		valuuttaDAO.finalize(); // katkaisee tietokantayhteyden
	}
 	
	@Test
	@DisplayName("Testaa valuuttojen nimien haku tietokannasta merkkijonotauluun")
	@Order(1)
	void testGetVaihtoehdot() {
		boolean valuutta1Found = false, valuutta2Found = false;
		
		String [] valuutat = valuuttakone.getVaihtoehdot();
		for (int i = 0; i < valuutat.length; i++) {
			if  (valuutat[i].contains("Testivaluutta 1")) {
				valuutta1Found = true;
				index1 = i;
			}
			if  (valuutat[i].contains("Testivaluutta 2")) {
				valuutta2Found = true;
				index2 = i;
			}
		}

		assertTrue(valuutta1Found && valuutta2Found, "getVaihtoehdot(): Valuutan haku taulukkoon ei onnistunut");
	}

	@Test
	@DisplayName("Testaa valuuttamuunnos")
	@Order(2)
	void testMuunna() {
		// Tärkeää suorittaa vasta toisena: index1:llä ja index2:lla oltava  arvot
		if (index1 == -1 || index2 == -1) {
			fail("Valuuttojen indeksejä ei ole asetettu oikein");
		}

		double tulos = valuuttakone.muunna(index1, index2, 100); // Muunna 100 valuuttayksikköä
		assertEquals(200, tulos, DELTA, "Valuuttamuunnos ei onnistunut");
	}
}
