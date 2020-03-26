import saikeet.LuuppaavaSaie;

/**
* @author Ali 30.1
* ratkaisu t.2
*/

public class LuuppaavaSaieMain {
	public static void main(String[] args) {

    // Luo säie
		LuuppaavaSaie saie = new LuuppaavaSaie(5);
	// Käynnistä säie
		saie.start();
	// Odota säikeen päättymistä
		try {
			saie.join();
		}catch(InterruptedException  e) {
			e.printStackTrace();
		}
	
	}
}
