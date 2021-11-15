package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class query extends conexion {

	//El parámetro sql es el encargado de llevar la consulta sql "Select * from empleados"
		public ResultSet getQuery(String sql) {
			try {
				//establece la línea de conexión para realizar una operación sql
				stmt=(Statement)cadenaConexion().createStatement();
				//res se encarga de capturar todos los registros consultados;
				res=stmt.executeQuery(sql);
			}
			catch(SQLException sqle) {
				print("Error al consultar en la bbdd");
				sqle.printStackTrace();
			}
			return res;
		}
	
}
