package halkohomma;

/**
* @author Oma Nimesi
*/

public class Halkovarasto {
	 private int kapasiteetti;
	 private int halkoja;
	 
	 public Halkovarasto (int kapasiteetti) {
		 this.kapasiteetti = kapasiteetti;
		 this.halkoja = 0;
	 }
	 
	 public synchronized void lisaaHalkoja(int tuotavatHalot) throws InterruptedException {
		 if (this.halkoja + tuotavatHalot > kapasiteetti) {
			 wait();
		 }
		 this.halkoja += tuotavatHalot;
		 notifyAll();
	 }
	 
	 public synchronized void annaHalkoja(int halututHalot) throws InterruptedException {
		 if (halututHalot > this.halkoja) {
			 wait();
		 }
		 this.halkoja -= halututHalot;
		 notifyAll();
	 }
	 
}