package kahvila;

/**
 *
 * @author Ali 
 *  */
public class Tuote {

    // Esittele instanssimuuttujat
	private int tuotenumero;
	private String nimi;
	private double hinta;

    // Esittele staattinen muuttuja seuraavan vapaan tuotenumeron ylläpitämiseksi
	private static int seuravaVapaaTuotenumero =1;
	
    // Ohjelmoi staattinen metodi alustaSeuraavaVapaaTuotenumero()
	public static void alustaSeuraavaVapaaTuotenumero() {
		seuravaVapaaTuotenumero =1;
	}

    // Ohjelmoi kahden parametrin konstruktori
	public Tuote(String nimi,double hinta) {
		this.nimi = nimi;
		this.hinta = hinta;
		this.tuotenumero = seuravaVapaaTuotenumero;
		seuravaVapaaTuotenumero++;
	}

    // Ohjelmoi getHinta()
	public double getHinta() {
		return hinta;
	}

    // Ohjelmoi getTuotenumero()
	public int getTuotenumero() {
		return tuotenumero;
	}

    // Ohjelmoi tosString()
	public String toString() {
		String tulosta = tuotenumero + " " + nimi + ", " + hinta + " €";
		return tulosta;
	}
}
