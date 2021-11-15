package model;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import controller.Controlador;

public interface configurable {
	
	//objeto de datos SERVIDOR SQL
	Controlador datos=new Controlador();
	
	Line2D.Float drawLine(int x1, int y1, int x2, int y2);
	Ellipse2D.Float drawEllipse(int x1, int y1, int x2, int y2);
	Rectangle2D.Float drawRectangle( int x1, int y1, int x2, int y2);

	
	public final String user=datos.user; //Usuario de la bbdd
	public final String psw=datos.contra; //password de acceso a la bbdd
	public final String db="proyecto_paint"; //nombre de la bbdd a la que vamos a conectarnos
	public final String driver="com.mysql.cj.jdbc.Driver";//driver de conexión
	public final String port="3306";
	public final String ip=datos.dir_serv;//en caso de conectarme remotamente seria la ip del servidor
	public final String url="jdbc:mysql://"+ip+":"+port+"/"+db+"?user="+user+"&password="+psw+
			                 "&useSSL=false&serverTimezone=UTC";
	public Connection cadenaConexion();
	public void cerrarConexion();
	
	public default void print(String texto) {
		System.out.println(texto);
	}
	
}
