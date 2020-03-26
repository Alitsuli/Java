package saikeet;

/**
* @author Ali
* ratkaisu 3
*/

public class Juoksija extends Thread {
	volatile boolean jatkuu = true;
	long kierrokset = 0;

	// Kirjoita kierrokset-muuttujan getteri
	public long getKierrokset() {
		return kierrokset;
	}
	
	@Override
	public void run(){
		//toista niin kauan kun jatkuu
		while(jatkuu) {
			//lisää kierrokset
			kierrokset++;
			//tulosta kierrokset
			System.out.println(kierrokset);
			//jokaisen kierrosnumeron jälkeen meneee 100ms "pysähty"
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// Kun juokseminen halutaan lopettaa, joku toinen säie kutsuu 
	// lopeta()-metodia.
	public void lopeta(){
		jatkuu = false;
		 
	}
}
