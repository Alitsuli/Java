package model;

/**
 * @author Ali tehtävä 2
 */
 
public class Valuutta {
	private String tunnus;
	private double vaihtokurssi;
	private String nimi;
	
	public Valuutta (String tunnus, double vaihtokurssi, String nimi) {
		
		this.tunnus = tunnus;
		this.vaihtokurssi = vaihtokurssi;
		this.nimi = nimi;
	}

	public String getTunnus() {
		return tunnus;
	}

	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
	}

	public double getVaihtokurssi() {
		return vaihtokurssi;
	}

	public void setVaihtokurssi(double vaihtokurssi) {
		this.vaihtokurssi = vaihtokurssi;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public String toString() {
		return "Valuutan tiedot: "+tunnus+", "+vaihtokurssi+", "+nimi;
	}

}
