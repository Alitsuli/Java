package kahvila;

import java.util.ArrayList;

/**
 *
 * @author Ali
 */
public class Kahvila {

    // Esittele instanssimuuttuja valikoiman ja tilausten tallettamiseksi (ArrayList)
	ArrayList<Tilaus> tilausket = new ArrayList();
	private Valikoima valikoima;

    // Ohjelmoi yhden parametrin konstruktori
	public Kahvila(Valikoima valikoima) {
		this.valikoima = valikoima;
	}

    // Ohjelmoi lisääTilaus()
	public void lisääTilaus(Tilaus tilaus) {
		tilausket.add(tilaus);
	}

    // Ohjelmoi tulostaTilaukset()
	public void tulostaTilaukset() {
		for(Tilaus tilaus : tilausket) {
			tilaus.tulostaRivit();
		}
	}

}
