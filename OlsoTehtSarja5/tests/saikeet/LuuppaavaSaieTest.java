package saikeet;

/**
* @author Simo Silander. Muutettu 28.8.2019, Auvo Häkkinen
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LuuppaavaSaieTest {

	LuuppaavaSaie saie;

	@BeforeEach
	public void setUp() throws Exception {
		saie = new LuuppaavaSaie(10);
	}

	@Test
	public void testRun() throws InterruptedException {
		saie.start();
		saie.join();
		assertEquals(saie.pyydetytKierrokset, saie.kierretytKierrokset, 
				"Run ei toimi oikein");
	}

	@Test
	public void testLuuppaavaSaie() {
		assertEquals(10, saie.pyydetytKierrokset,
				"Alustus konstruktorissa ei toimi oikein");
	}

	@Test
	public void testGetKierretytKierrokset() {
		assertEquals(saie.kierretytKierrokset, saie.getKierretytKierrokset(),
				"getKierretytKierrokset ei toimi oikein");
	}
}
