package halkohomma;

import java.util.Random;

/**
* @author Ali tehtävä 3,4
*/

public class Halonhakkaaja extends Thread  {
	
	private Halkovarasto varasto;
	private volatile boolean valmis = false;
	
	public Halonhakkaaja (Halkovarasto var) {
		this.varasto = var;
	}
	
	public void run() {
		Random random = new Random();
		try {
			while (!valmis) {
				int halkoja = random.nextInt(29)+1;
				System.out.println("Hakkasin " + halkoja + " halkoa");			
				sleep(1000);
				varasto.lisaaHalkoja(halkoja);
				System.out.println("Ja vein varastoon.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void terminate() {
		valmis = true;
	}
	 
}