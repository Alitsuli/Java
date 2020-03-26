package saikeet;
/**
* @author Simo Silander. Muutettu 28.9.2019, Auvo Häkkinen

*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JuoksijaTest {
	Juoksija juoksija;

	@DisplayName("Testaa kierrosmäärän alustus ja kasvatus - run()")
	@Test
	public void testRun() { 
		juoksija = new Juoksija();
		long kierrokset = juoksija.getKierrokset();
		assertEquals(0, kierrokset, "Kierrosmäärä alustettu väärin");

		juoksija.start();
		// Anna aikaa 10 kierroksen juoksemiseen, yksi kierros on 100 ms
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Tuli poikkeus System.sleep() rutiinissa");
		}
		juoksija.lopeta();

		long kierroksetNyt = juoksija.getKierrokset();
		assertTrue(kierroksetNyt > kierrokset, "Säikeen kierrokset eivät kasva");
	}

	@DisplayName("Testaa lopettaminen - lopeta()")
	@Test
	public void testLopeta() {
		juoksija = new Juoksija();

		juoksija.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Tuli poikkeus System.sleep() rutiinissa");
		}
		juoksija.lopeta();

		assertTrue(juoksija.jatkuu==false, "lopeta()-metodi ei muuta lopetusehtoa");
	}

	@DisplayName("Testaa juostujen kierrosten kysely - getKierrokset()")
	@Test
	public void testGetKierrokset() {
		juoksija = new Juoksija();
		assertEquals(juoksija.kierrokset, juoksija.getKierrokset(), "getKierrokset() ei toimi oikein");
	}
}
