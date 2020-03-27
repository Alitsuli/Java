package model;

// Ali t.1

public class Valuutta {
	
	//instanssimuuttujia
	private String nimi;
	private double vaihtokurssi;
	
	// parametrillinen konstruktori
	public Valuutta(String nimi, double vaihtokurssi) {
		this.nimi= nimi;
		this.vaihtokurssi = vaihtokurssi;
	}
	
	// get nimi
	public String getNimi() {
		return nimi;
	}
	
	// get vaihtokurssi
	public double getVaihtokurssi() {
		return vaihtokurssi;
	}
	
	//set vaihtokurssi
	public void setVaihtokurssi(double vkurssi) {
		this.vaihtokurssi = vkurssi;
	}
	
	

}
