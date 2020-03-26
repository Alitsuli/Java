package Model;
// tehtävä 1 Ali
public class tervehdysModel implements tervehdysModel_IF{
	
	//tehdään aamulle,paivalle,ilalle ja yölle oma tervehdys.
	
	public String aamu() {
		String tervehdys = "Hyvä huomenta sinulle!";
		return tervehdys;
	}
	
	public String paiva() {
		String tervehdys = "Päivä!";
		return tervehdys;
	}
	
	public String ilta() {
		String tervehdys = "Hyvä ilta!";
		return tervehdys;
	}
	
	public String yo() {
		String tervehdys = "Hyvä yötä, nyt nukkumaan!";
		return tervehdys;
	}

}
