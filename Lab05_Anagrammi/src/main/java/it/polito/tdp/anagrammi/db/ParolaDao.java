package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Parola;

public class ParolaDao {
	
	public boolean verificaCorrettezza(Parola p) {
		
		final String sql="SELECT COUNT(*) AS result "+
				"FROM parola "+
				"WHERE nome=?";
		
		Integer i;
		
		try {
			Connection conn=DBConnect.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, p.getParola());
			
			ResultSet rs=st.executeQuery();
			
			rs.next();
			i=rs.getInt("result");
			
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Errore DB", e);
		}
		
		if(i==0)
			return false;
		
		return true;
	}

}
