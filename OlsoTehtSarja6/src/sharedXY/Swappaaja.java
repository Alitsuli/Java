package sharedXY;

/**
* @author Ali tehtävä 2
*/

public class Swappaaja extends Thread{
	
	private SharedXY xy;
	 
	// Kirjoita konstruktori
	public Swappaaja(SharedXY xy) {
		this.xy = xy;
	}
	 
	// Kirjoita metodi run()
	public void run() {
		while (xy.getX() != xy.getY()) {
			xy.swap();
		}
		System.exit(0);
	}
}
