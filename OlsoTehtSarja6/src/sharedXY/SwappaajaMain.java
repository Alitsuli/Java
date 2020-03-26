package sharedXY;

import readerwriter.Lukija;
import halkohomma.Halonhakkaaja;

/**
* @author Ali tehtävä 2
*/

public class SwappaajaMain {
	 public static void main(String args[]) {
		// Luo yhteiskäyttöinen tietorakenneolio
		 SharedXY uusi = new SharedXY();
		 Swappaaja swapS1 = new Swappaaja(uusi);
		 Swappaaja swapS2 = new Swappaaja(uusi);
		 Swappaaja swapS3 = new Swappaaja(uusi);

		// Luo useita Swappaaja-säikeitä
		 swapS1.start();
		 swapS2.start();
		 swapS3.start();
		 try {
				swapS1.join();
				swapS2.join();
				swapS3.join();
		 } catch (InterruptedException e) {
				e.printStackTrace();
		 }
	 }
}