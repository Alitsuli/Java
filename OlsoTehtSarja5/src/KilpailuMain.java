
import saikeet.Kilpajuoksija;

/**
* @author Ali
*/

public class KilpailuMain {

	public static void main(String[] args) {
		// Luo taulukko
		Kilpajuoksija[] kilpailijat = new Kilpajuoksija[8];

		// Luo juoksijasäikeet
		for(int i=0; i<8;i++) {
			kilpailijat[i]= new Kilpajuoksija();
		}
	
		// Pistä poppoo juoksemaan
		for(int i=0; i<8;i++) {
			kilpailijat[i].start();
		}

		// Odota, että kaikki juoksijasäikeet lopettavat
		for(int i=0;i<8;i++) {
			try {
				kilpailijat[i].join();
			}catch (InterruptedException  e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Kilpailu on ohi, onnea voittajalle.");
	}
}
