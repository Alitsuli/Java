package Controller;

import Model.tervehdysModel_IF;
import View.tervehdysGUI_Interface;

public class tervehdysKontrolli implements tervehdysKontrolli_Interface{
	
	// kutsu interface
	tervehdysModel_IF model;
	tervehdysGUI_Interface gui; 
	
	//konstruktori 
	public tervehdysKontrolli(tervehdysGUI_Interface gui,tervehdysModel_IF model) {
		this.gui = gui;
		this.model = model;
	}
	
	//kutsu aamu
	public void aamu() {
		String tervehdys = model.aamu();
		gui.setTervehdys(tervehdys);
	}
	
	//kutsu paiva
	public void paiva() {
		String tervehdys = model.paiva();
		gui.setTervehdys(tervehdys);
	}
	
	//kutsu ilta
	public void ilta() {
		String tervehdys = model.ilta();
		gui.setTervehdys(tervehdys);
	}
	
	//kutsu yö
	public void yo() {
		String tervehdys = model.yo();
		gui.setTervehdys(tervehdys);
	}
	

}
