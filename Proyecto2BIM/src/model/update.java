package model;

import java.sql.SQLException;
import java.sql.Statement;
public class update extends conexion{
	
	//Con este método es posible realizar la siguientes operaciones: INSERT INTO, UPDATE, y DELETE 
	public boolean setQuery(String sql) {
		try {
			stmt=(Statement)cadenaConexion().createStatement();
			stmt.executeUpdate(sql);
			return true;
		}
		catch(SQLException sqle) {
			print("Error al actualizar la bbdd");
			sqle.printStackTrace();
			return false;
		}
	}

}