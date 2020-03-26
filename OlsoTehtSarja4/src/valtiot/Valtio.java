package valtiot;

import java.io.Serializable;

/**
* @author Ali 29.1.20
*/

public class Valtio implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	// Selvitä itsellesi www-haulla mikä on ylläolevan merkitys/tarve
	
	// instanssimuuttujat
	private String nimi;
	private String pääkaupunki;
	private int asukasluku;
	
	//konstruktori
	Valtio(String nimi,String pääkaupunki, int asukasluku) {
		this.nimi = nimi;
		this.pääkaupunki = pääkaupunki;
		this.asukasluku = asukasluku;
	}
	
	// Lisää getterit ja setterit
	public void setNimi(String nimi) {
		this.nimi= nimi;
	}
	
	public String getNimi() {
		return this.nimi;
	}
	
	public void setPääkaupunki(String pääkaupunki) {
		this.pääkaupunki = pääkaupunki;
	}
	
	public String getPääkaupunki() {
		return this.pääkaupunki;
	}
	
	public void setAsukasluku(int asukasluku) {
		this.asukasluku = asukasluku;
	}
	
	public int getAsukasluku() {
		return this.asukasluku;
	}
	
	// Lisää toString()
	public String toString() {
		return String.format("%-10s %-10s %-10d", nimi, pääkaupunki, asukasluku);
	}
	// Saat tiedot sarakkeittain String-luokan staattisella format-metodilla
	// esim. String.format("%-10s %-10s %-10d", nimi, pääkaupunki, asukasluku);
	
}
