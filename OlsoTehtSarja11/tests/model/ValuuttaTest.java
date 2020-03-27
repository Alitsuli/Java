package model;

/**
 * @author hakka
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

public class ValuuttaTest {

	private Valuutta valuutta;
	private final static double DELTA = 0.001;

	@BeforeEach
	public void setUp() {
		valuutta = new Valuutta("EUR", 1.0, "Euroopan euro");
	}

	@Test
	public void testGetTunnus() {
		assertEquals("EUR", valuutta.getTunnus(), "Valuutan tunnus väärin");
	}

	@Test
	public void testGetNimi() {
		assertEquals("Euroopan euro", valuutta.getNimi(), "Valuutan tunnus väärin");
	}

	@Test
	public void testGetVaihtokurssi() {
		assertEquals(1.0, valuutta.getVaihtokurssi(), DELTA, "Valuutan vaihtoarvo väärin");
	}

	@Test
	public void testSetTunnus() {
		valuutta.setTunnus("EURO");
		assertEquals("EURO", valuutta.getTunnus(), "Valuutan tunnuksen asetus ei onnistunut");
	}

	@Test
	public void testSetNimi() {
		valuutta.setNimi("Euroopan valuutta");
		assertEquals("Euroopan valuutta", valuutta.getNimi(), "Valuutan nimi asetus ei onnistunut");
	}

	@Test
	public void testSetVaihtokurssi() {
		valuutta.setVaihtokurssi(1.01);
		assertEquals(1.01, valuutta.getVaihtokurssi(), DELTA, "Valuutan vaihtokurssin päivitys väärin");
	}

}
