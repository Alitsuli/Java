
package suorakulmiot;
/**
 *
 * @author Ali
 */
 
// Kirjoita tähän yleiskommentit

public class Suorakulmio {
	
	// instanssimuuttujat suorakulmio leveys ja korkeus tallettamiseksi
	private int leveys;
	private int korkeus;
	
	// kahden parametrin konstruktori   
	public Suorakulmio (int leveys, int korkeus) {
		this.korkeus = korkeus;
		this.leveys = leveys;
	}
	
	//tyhjä oletuskonstruktori
	public Suorakulmio() {
		
	}
	
	// setteri
	public void setLeveys(int uusiLeveys) {
		leveys = uusiLeveys;
	}
	public void setKorkeus(int uusiKorkeus) {
		korkeus = uusiKorkeus;
	}
	
	//getteri
	public int getLeveys() {
		return leveys;
	}
	public int getKorkeus() {
		return korkeus;
	}
	
	//pinta-alan lasku
	public int ala() {
		int ala = leveys * korkeus;
		return ala;
	}
	
	//tulostus
	public String toString() {
		String merkkijono = "leveys="+leveys+", korkeus=" +korkeus;
		return merkkijono;
	}
	
	
    
}
