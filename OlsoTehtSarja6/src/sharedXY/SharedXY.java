package sharedXY;

/**
* @author Ali tehtävä 2
*/

public class SharedXY {
	private int x;
	private int y;

	// Kirjoita konstruktori, joka asettaa muuttujille alkuarvot
	public SharedXY() {
		this.x = 0;
		this.y = 1;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	// Kirjoita metodi swap(), joka vaihtaa arvot keskenään
	public void swap() {
		int apu = x;
		x = y;
		y = apu;
		System.out.println("x = " + x + ", y = " + y);
	}
}