package model;

import java.awt.geom.Line2D.Float;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class conexion implements configurable{
	
	//variable para la conexión con la bbdd
		private Connection connec=null;
		//para las operaciones con la bbdd
		protected Statement stmt=null;
		protected ResultSet res=null;
		@Override
		//Método que establece la cadena de conexión a la bbdd
		public Connection cadenaConexion() {
			// TODO Auto-generated method stub
			
				try {
					Class.forName(driver);
					connec=DriverManager.getConnection(url);
					if(connec!=null) 
						print("Conexión exitosa: Server:"+ip);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					print("Error con el driver");
					e.printStackTrace();
					
				}
				catch(SQLException sqle) {
					print("Error de conexión");
					sqle.printStackTrace();
				}
			
			return connec;
		}

		@Override
		//Método para cerrar la conexión
		public void cerrarConexion() {
			// TODO Auto-generated method stub
			try {
				connec.close(); //cierre de la conexión con la bbdd
				stmt.close(); //cierre de la linea de conexión 
				print("Conexión cerrada exitosamente");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				print("Error al cerrar la conexión");
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
