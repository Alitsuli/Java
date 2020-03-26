package halkohomma;

/**
 * 
* @author Ali tehtävä 3,4
*/

public class HalkohommaMain { 
	
	public static void main(String args[]) {
	
	// Luo Halkovarasto
		Halkovarasto var = new Halkovarasto(200);
		Halonhakkaaja hak1 = new Halonhakkaaja(var);
		Halonhakkaaja hak2 = new Halonhakkaaja(var);
		Halonhakkaaja hak3 = new Halonhakkaaja(var);
		Halonhakkaaja hak4 = new Halonhakkaaja(var);
		Halonhakkaaja hak5 = new Halonhakkaaja(var);
		
		Partiolainen par1 = new Partiolainen(var);
		Partiolainen par2 = new Partiolainen(var);
		Partiolainen par3 = new Partiolainen(var);
		Partiolainen par4 = new Partiolainen(var);
		Partiolainen par5 = new Partiolainen(var);
	
		// Luo useita Halonhakkaaja-säikeitä
		hak1.start();
		hak2.start();
		hak3.start();
		hak4.start();
		hak5.start();
	
		// Luo useita Partiolainen säikeitä
		par1.start();
		par2.start();
		par3.start();
		par4.start();
		par5.start();
		
		try {
			hak1.join();
			hak2.join();
			hak3.join();
			hak4.join();
			hak5.join();
			
			par1.join();
			par2.join();
			par3.join();
			par4.join();
			par5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		


	}
}