package model;
import java.sql.*;


//tehtävät: 3,4,5
public class ValuuttaAccessObject implements IValuuttaDAO{
	private int maara;
	
	// JDBC ajurin lataus
	public ValuuttaAccessObject() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.err.println("JDBC-ajurin lataus ei onnistunut!");
			System.exit(-1);
		}
	}
	
	//yhteyden luomaminen sql
	public static Connection lueYhteys() {
		Connection connection = null;
		
		String URL = "jdbc:mysql://localhost/valuuttadb";
		String USERNAME = "olso";
		String PASSWORD = "olso";
		
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Yhteys epäonnistui!");
		}
		
		return connection;		
	}

	//valuutan lisäminen tietokantaan t.4
	@Override
	public boolean createValuutta(Valuutta valuutta) {
		if(loytyyTietokannasta(valuutta)) {
			return false;
		}
		
		Connection connection = lueYhteys();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(
					//lisää sql 
					"INSERT INTO Valuutta(tunnus,vaihtokurssi,nimi) VALUES (?,?,?);");
			stmt.setString(1, valuutta.getTunnus());
			stmt.setDouble(2, valuutta.getVaihtokurssi());
			stmt.setString(3, valuutta.getNimi());
			stmt.executeUpdate();
			connection.close();
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//tarkista löytyyko tietokannasta sama valuutta
	private boolean loytyyTietokannasta(Valuutta val) {

		Valuutta[] valuutat = readValuutta();
		
		for(Valuutta valuutta : valuutat) {
			if(valuutta.getTunnus().equals(val.getTunnus())) {
				return true;
			}
		}
		
		return false;
	}

	//yhden valuutan lukeva rutiini t.3
	@Override
	public Valuutta readValuutta(String tunnus) {
		Connection connection = lueYhteys();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT * FROM Valuutta WHERE tunnus = ?");
			stmt.setString(1, tunnus);
			ResultSet rs = stmt.executeQuery();
			
			//
				if(!rs.next()) {
				return null;
				}
			
			Valuutta valuutta = new Valuutta(rs.getString("tunnus"),
					rs.getDouble("vaihtokurssi"),rs.getString("nimi"));
			
			//sulkee
			stmt.close();
			rs.close();
			connection.close();
			return valuutta;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// lukee kaikkien valuuttojen tiedot tietokannasta taulukkoon t.3
	@Override
	public Valuutta[] readValuutta() {
		
		rivienMaara();
		
		Valuutta[] valuutat = new Valuutta[this.maara];
		if(valuutat.length == 0) {
			return null;
		}
		
		Connection connection = lueYhteys();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT * FROM valuutta;");
			ResultSet rs = stmt.executeQuery();
			
			int i = 0;
			while(rs.next()){
				Valuutta valuutta = new Valuutta(rs.getString("tunnus"),
						rs.getDouble("vaihtokurssi"),rs.getString("nimi"));
				valuutat[i] = valuutta;
				i++;
			}
			
			stmt.close();
			rs.close();
			connection.close();
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return valuutat;
		
	}
	
	// rivien määrän hakeminen sql:stä
	private void rivienMaara() {

		Connection connection = lueYhteys();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"SELECT COUNT(*) AS 'maara' FROM Valuutta;");
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				this.maara = rs.getInt("maara");
			}
			
			stmt.close();
			rs.close();
			connection.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	//yksittäisen valuutan päivittäminen t.5
	@Override
	public boolean updateValuutta(Valuutta valuutta) {
		Connection connection = lueYhteys();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE Valuutta SET vaihtokurssi = ?, nimi = ?, Where tunnus = ?;");
			stmt.setDouble(1, valuutta.getVaihtokurssi());
			stmt.setString(2, valuutta.getNimi());
			stmt.setString(3, valuutta.getTunnus());
			
			stmt.executeUpdate();
			connection.close();
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	//yksittäisen valuutan poisto tietokannasta t.6
	@Override
	public boolean deleteValuutta(String tunnus) {
		Connection connection = lueYhteys();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"DELETE FROM Valuutta WHERE tunnus = ?; ");
			stmt.setString(1, tunnus);
			
			stmt.executeUpdate();
			connection.close();
			
			return true;

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
