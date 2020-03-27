package model;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.*;


//tehtävät: 1-5
public class ValuuttaAccessObject implements IValuuttaDAO{
	static SessionFactory istuntotehdas;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void luoIstuntotehdas() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try{
			istuntotehdas = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("Pieleen meni!");
			StandardServiceRegistryBuilder.destroy( registry );
			e.printStackTrace();
		} finally {
			System.out.println("Istuntotehtaan luominen onnistui.");
		}
	}
	
	public void suljeIstuntotehdas() {
		istuntotehdas.close();
	}
	
	//t.3
	@Override
	public boolean createValuutta(Valuutta valuutta) {
		Session istunto = istuntotehdas.openSession();
		Transaction transaction = null;
		boolean tallentuiko = false;

		try{
			transaction = istunto.beginTransaction();
			Valuutta v = new Valuutta(valuutta.getTunnus(), valuutta.getVaihtokurssi(), valuutta.getNimi());
			istunto.saveOrUpdate(v);
			transaction.commit();
			tallentuiko = true;
			
		} catch(Exception e){
			if (transaction!=null) transaction.rollback();
			throw e;
			
		} finally{
			istunto.close();
		}
		return tallentuiko;
	}

	//t.2
	@Override
	public Valuutta readValuutta(String tunus) {
		Session istunto = istuntotehdas.openSession();
		Transaction transaction = null;
		Valuutta val = new Valuutta();

		try{
			istunto = istuntotehdas.openSession();
			transaction = istunto.beginTransaction();
			istunto.load(val, tunus);		
			transaction.commit();
			
		} catch(Exception e){
			if (transaction!=null) transaction.rollback();
			throw e;
			
		} finally{
			istunto.close();
		}
		
		return val;
	}

	//t.2
	@SuppressWarnings("unchecked")
	@Override
	public Valuutta[] readValuutta() {
		Session istunto = istuntotehdas.openSession();
		Transaction transaction = null;
		List<Valuutta> valuutat = new ArrayList<>();
		try{
			transaction = istunto.beginTransaction();
			valuutat = istunto.createQuery( "from Valuutta" ).list();
			transaction.commit();
			
		} catch (Exception e){
			if (transaction!=null) transaction.rollback();
			throw e;
			
		} finally{
			istunto.close();
		}

		/*
		 * @author ali
		 * jotta saadan yhteensopiva ohjelman
		 * muiden luokkien kanssa nii muunnetaan Valuutta[] muotoiseksi
		 */
		Valuutta[] valuutatPalautus = new Valuutta[valuutat.size()];
		int i = 0;
		for (Valuutta val : valuutat) {
			valuutatPalautus[i] = val;
			i++;
		}
		
		return valuutatPalautus;
	}
	
	//t.4
	@Override
	public boolean updateValuutta(Valuutta valuutta) {
		Session istunto = istuntotehdas.openSession();
		Transaction transaction = null;
		boolean tallentuiko = false;

		try{
			istunto = istuntotehdas.openSession();
			transaction = istunto.beginTransaction();
			Valuutta v = (Valuutta)istunto.get(Valuutta.class, valuutta.getTunnus());
			if (v != null) {
				v.setVaihtokurssi(valuutta.getVaihtokurssi());
				v.setNimi(valuutta.getNimi());
			} else {
				System.out.println("Ei löytynyt päivitettävää!");
			}
			transaction.commit();
			tallentuiko = true;
			
		} catch(Exception e){
			if (transaction!=null) transaction.rollback();
			throw e;
			
		} finally{
			istunto.close();			
		}
		
		return tallentuiko;
	}

	//t.5
	@Override
	public boolean deleteValuutta(String tunnus) {
		Session istunto = istuntotehdas.openSession();
		Transaction transaction = null;
		boolean tallentuiko = false;

		try{
			istunto = istuntotehdas.openSession();
			transaction = istunto.beginTransaction();
			Valuutta v = (Valuutta)istunto.get(Valuutta.class, tunnus);
			if (v != null) {
				istunto.delete(v);
			} else {
				System.out.println("Ei löytynyt poistettavaa!");
			}
			transaction.commit();
			tallentuiko = true;
			
		} catch(Exception e){
			if (transaction != null) transaction.rollback();
			throw e;
			
		} finally{
			istunto.close();
		}
		
		return tallentuiko;
	}

}
