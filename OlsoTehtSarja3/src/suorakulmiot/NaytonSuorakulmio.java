
package suorakulmiot;
/**
 *
 * @author Ali
 */

// Kirjoita tähän yleiskommentit

public class NaytonSuorakulmio extends Suorakulmio implements Kuvio {
	
	private int x;
	private int y;
	
	// konstruktori
	public NaytonSuorakulmio(int x, int y, int leveys, int korkeus) {
		
		super(leveys, korkeus);
		this.x = x;
		this.y = y;
	}
	
	// leveys ja korkeuden toteutus
	public boolean mahtuu(int leveys , int korkeus) {
		
		boolean mahtuu = false;
		
		if(leveys >= x + getLeveys() && korkeus >= y + getKorkeus()) {
			mahtuu = true;
		}
		return mahtuu;
	}
	
	// tulostus
	@Override
	public String toString() {
		
		String merkkijono = "x=" +x+", y="+y+", "+super.toString();
		return merkkijono;
	}


}
