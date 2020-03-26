import saikeet.Kilpajuoksija;

//	Ali ratkaisu t.5


public class KilpajuoksijaMain {
	
	public static void main(String[] args) {
		
		
		//luodaan saie
		Kilpajuoksija saie = new Kilpajuoksija();
		
		//käynistetään saie
		saie.start();
		
		// Odota säikeen päättymistä
		try {
			saie.join();
		}catch (InterruptedException e) {
		e.printStackTrace();
	}

	}
}
