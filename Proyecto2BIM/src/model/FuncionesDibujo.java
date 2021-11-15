package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class FuncionesDibujo implements configurable{

	 public Line2D.Float drawLine(int x1, int y1, int x2, int y2){
             return new Line2D.Float(x1, y1, x2, y2);
     }
     public Ellipse2D.Float drawEllipse(int x1, int y1, int x2, int y2){
             int x = Math.min(x1, x2);
             int y = Math.min(y1, y2);
             int ancho = Math.abs(x1 - x2);
             int altura = Math.abs(y1 - y2);
             return new Ellipse2D.Float(x, y, ancho, altura);
     }
     public Rectangle2D.Float drawRectangle( int x1, int y1, int x2, int y2){
             int x = Math.min(x1, x2);
             int y = Math.min(y1, y2);
             int ancho = Math.abs(x1 - x2);
             int altura = Math.abs(y1 - y2);
             return new Rectangle2D.Float(x, y, ancho, altura);
     }
     public void saveImage(String path,Graphics2D g2, PizarraDibujo drawB) { 
		 try {
		        BufferedImage image = new BufferedImage(drawB.getWidth(),
		                drawB.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		        Graphics g = image.getGraphics();
		        drawB.printAll(g);
		        g.dispose();
		        ImageIO.write(image, "png", new File(path));
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
    }
     public void loadImage(Graphics2D g2, PizarraDibujo drawB) { 
  		 try {
  		        BufferedImage image = new BufferedImage(drawB.getWidth(),
  		                drawB.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
  		        Graphics g = image.getGraphics();
  		        drawB.printAll(g);
  		        g.dispose();
  		        ImageIO.write(image, "png", new File("saves/img.png"));
  		    } catch (Exception e) {
  		        e.printStackTrace();
  		    }
      }
	@Override
	public Connection cadenaConexion() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void cerrarConexion() {
		// TODO Auto-generated method stub
	}
     
  
}













