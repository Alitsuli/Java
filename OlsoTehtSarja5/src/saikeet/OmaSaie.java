package saikeet;

/**
* @author Ali
* ratakisu t.1
*/

public class OmaSaie extends Thread {
    // Nämä tunnukset näkyvät saman pakkauksen luokkiin
	int luku;
	static int yhteisetAjokerrat = 0;

	//Kirjoita parametriton konstruktori, joka ei tee mitään
	public OmaSaie() {
		
	}

	// Kirjoita parametrillinen konstruktori, joka asettaa arvon instanssimuuttujalle luku
	public OmaSaie(int luku) {
		this.luku = luku;
	}
	// Kirjoita getterit ja setterit

	public int getLuku() {
		return luku;
	}

	public void setLuku(int luku) {
		this.luku = luku;
	}

	public static int getYhteisetAjokerrat() {
		return yhteisetAjokerrat;
	}

	public static void setYhteisetAjokerrat(int yhteisetAjokerrat) {
		OmaSaie.yhteisetAjokerrat = yhteisetAjokerrat;
	}	
  
	// Kirjoita metodi run(), joka kasvattaa kummankin muuttujan arvoa yhdellä 
	public void run() {
		luku++;
		yhteisetAjokerrat++;
	}
}
