package halkohomma;

import java.util.Random;

/**
* @author Ali tehtävä 3,4
*/

public class Partiolainen extends Thread {
	
	private Halkovarasto varasto;
	private volatile boolean valmis = false;
	
	public Partiolainen (Halkovarasto var) {
		this.varasto = var;
	}
	
	public void run() {
		Random random = new Random();
		try {
			while (!valmis) {
				int halkoja = random.nextInt(9) + 1;
				System.out.println("Haluan " + halkoja + " halkoa");
				sleep(1000);
				varasto.annaHalkoja(halkoja);
				System.out.println("Ja sain ne varastosta.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void terminate() {
		valmis = true;
	}
	 
}