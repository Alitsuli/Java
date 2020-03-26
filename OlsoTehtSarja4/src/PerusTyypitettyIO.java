/**
* @author Ali 29.1
*/

import java.io.*;

public class PerusTyypitettyIO {

	public static void kirjoita(int luvut[], String tiedosto) {
		try(
			FileOutputStream fileOut = new FileOutputStream(tiedosto);
			DataOutputStream dataOut = new DataOutputStream (fileOut)){

		// TODO: täydennä
		for(int luku : luvut) {
			dataOut.writeInt(luku);
		}

	}catch (IOException e) {
		e.printStackTrace();
	}
	}

	public static int kerroKoko(String tiedosto) {
		int lukumäärä = 0;
		try(
			FileInputStream f = new FileInputStream(tiedosto)){
			lukumäärä = f.available();
			
		}catch (IOException e) {
			e.printStackTrace();
		}

		return lukumäärä;
	}

	public static byte[] annaTavuina(String tiedosto) {
		// TODO: täydennä
		int koko = kerroKoko(tiedosto);
		byte[] tavut = new byte[koko];
		try( FileInputStream f = new FileInputStream(tiedosto)) {
			f.read(tavut); // tulosta kaikki tavut
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return tavut; // Palauta byte-taulukko
	}

	public static int[] annaKokonaislukuina(String tiedosto) {
		// TODO: täydennä
		int koko = kerroKoko(tiedosto);
		int [] luvut = new int[koko/4];
		try(
				FileInputStream f = new FileInputStream(tiedosto);
				DataInputStream din = new DataInputStream(f);) {
			for(int i=0; i<koko/4;i++) {
				luvut[i] = din.readInt();
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}

		return luvut; // Palauta int-taulukko
	}


	public static void main(String args[]) {
		String tiedosto = "Luvut.bin";
		int luvut[] = { 1, 200, 3, 4, 5 };
		byte tavut[];
		int iLuvut[];

		kirjoita(luvut, tiedosto);

		System.out.println("Tiedostossa on " + kerroKoko(tiedosto) + " tavua");

		System.out.println ("Tiedoston sisältö tavuittain:");
		tavut = annaTavuina(tiedosto);
		for (int i = 0; i < tavut.length; i++) {
			System.out.print(tavut[i] + " ");
		}

		System.out.println ("\nTiedoston sisältö kokonaislukuina:");
		iLuvut = annaKokonaislukuina(tiedosto);
		for (int i = 0; i < iLuvut.length; i++) {
			System.out.print(iLuvut[i] + " ");
		}
	}

}
