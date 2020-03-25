package kahvila;

/**
 *
 * @author Ali
 */
public class Tilausrivi {

    // Esittele instanssimuuttujat
	private Tuote tuote;
	private int kappalemäärä;
    
    // Ohjelmoi kolmen parametrin konstruktori 
	public Tilausrivi(Valikoima valikoima, int tuotenumero, int määrä) {
		this.tuote = valikoima.getTuote(tuotenumero);
		this.kappalemäärä = määrä;
	}

    // Ohjelmoi tulosta()
	public void tulosta() {
		System.out.println(tuote.toString()+", "+ kappalemäärä +" kpl");
	}
         
    // Ohjelmoi annaSumma() 
	public double annaSumma() {
		double hinta = tuote.getHinta() * kappalemäärä;
		return hinta;
	}
}
