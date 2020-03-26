import saikeet.Juoksija;

/**
* @author Ali
* ratkaisu t.3
*/

public class JuoksijaMain {
	public static void main(String[] args) {

	// Luo ja käynnistä Juoksija-säie
		Juoksija saie = new Juoksija();
		saie.start();
	
	// Odota jonkun aikaa: Thread.sleep()
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	
	// Pysäytä säie
		saie.lopeta();
	// Hae ja tulosta juostujen kerrosten määrä
		System.out.println("Juokstujen kierrosten määrä = " + saie.getKierrokset());
	
	}
}
