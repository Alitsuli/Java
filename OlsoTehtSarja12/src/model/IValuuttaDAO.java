package model;

// Ali tehtävä 2

public interface IValuuttaDAO {
	
	public abstract boolean createValuutta(Valuutta valuutta);
	public abstract Valuutta readValuutta(String tunus);
	public abstract Valuutta[] readValuutta();
	public abstract boolean updateValuutta(Valuutta valuutta);
	public abstract boolean deleteValuutta(String tunnus);
	
	
}
