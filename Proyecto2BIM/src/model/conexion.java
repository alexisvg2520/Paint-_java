package model;

import java.awt.geom.Line2D.Float;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class conexion implements configurable{
	
	//variable para la conexi�n con la bbdd
		private Connection connec=null;
		//para las operaciones con la bbdd
		protected Statement stmt=null;
		protected ResultSet res=null;
		@Override
		//M�todo que establece la cadena de conexi�n a la bbdd
		public Connection cadenaConexion() {
			// TODO Auto-generated method stub
			
				try {
					Class.forName(driver);
					connec=DriverManager.getConnection(url);
					if(connec!=null) 
						print("Conexi�n exitosa: Server:"+ip);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					print("Error con el driver");
					e.printStackTrace();
					
				}
				catch(SQLException sqle) {
					print("Error de conexi�n");
					sqle.printStackTrace();
				}
			
			return connec;
		}

		@Override
		//M�todo para cerrar la conexi�n
		public void cerrarConexion() {
			// TODO Auto-generated method stub
			try {
				connec.close(); //cierre de la conexi�n con la bbdd
				stmt.close(); //cierre de la linea de conexi�n 
				print("Conexi�n cerrada exitosamente");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				print("Error al cerrar la conexi�n");
				e.printStackTrace();
			}
			
		}

		@Override
		public Float drawLine(int x1, int y1, int x2, int y2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public java.awt.geom.Ellipse2D.Float drawEllipse(int x1, int y1, int x2, int y2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public java.awt.geom.Rectangle2D.Float drawRectangle(int x1, int y1, int x2, int y2) {
			// TODO Auto-generated method stub
			return null;
		}

}
