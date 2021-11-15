package model;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JComponent;

public class PizarraDibujo extends JComponent{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Shape>formas=new ArrayList<Shape>();
	private ArrayList<Color>relleno=new ArrayList<Color>();
	private ArrayList<Color>trazo=new ArrayList<Color>();
	private Point comienzo; 
	private Point fin;
	private boolean carga = false;
	private String guardar;
	private String abrir;
	private Graphics2D conf_grafico;
	private int actual=1;
	private FuncionesDibujo misFunciones = new FuncionesDibujo();
	public PizarraDibujo(){
	
	}
	
	public void paint(Graphics g){
		//Clase utilizada para definir las formas a ser dibujada
		conf_grafico=(Graphics2D)g;
		//Suaviza las líneas dentadas
		conf_grafico.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		dibujar();
         
        if (carga){
        	conf_grafico.setComposite(AlphaComposite.getInstance(
                     AlphaComposite.SRC_OVER, 1));
	     	Image img1 = Toolkit.getDefaultToolkit().getImage(abrir);
	     	conf_grafico.setStroke(new BasicStroke(5));  

	        for (int i = 0; i < formas.size(); i++) {

	       	// Toma el siguiente trazo de la lista de matrices de colores 
	       	conf_grafico.setPaint(trazo.get(i));
	       	conf_grafico.draw(formas.get(i));
	           // Toma el siguiente relleno de la lista de matrices de colores 
	       	conf_grafico.setPaint(relleno.get(i)); 	
	       	conf_grafico.fill(formas.get(i));
			}
        }
         
         
        //Forma de guía utilizada para dibujar 
        if (comienzo != null && fin != null){
        	
        	Shape Forma = null;
        	if (actual==2){
        		Forma = misFunciones.drawLine(comienzo.x, comienzo.y,
            		fin.x, fin.y);
        	} else if (actual==3){
        		Forma = misFunciones.drawEllipse(comienzo.x, comienzo.y,
                		fin.x, fin.y);
        	} else if (actual==4){
        		Forma = misFunciones.drawRectangle(comienzo.x, comienzo.y,
                		fin.x, fin.y);
        	}
        	conf_grafico.draw(Forma);
        	 
        }
	}
	
	public void dibujar() {
		
		conf_grafico.setStroke(new BasicStroke(5));  

        for (int i = 0; i < formas.size(); i++) {

       	// Toma el siguiente trazo de la lista de matrices de colores 
       	conf_grafico.setPaint(trazo.get(i));
       	conf_grafico.draw(formas.get(i));
           // Toma el siguiente relleno de la lista de matrices de colores 
       	conf_grafico.setPaint(relleno.get(i)); 	
       	conf_grafico.fill(formas.get(i));
		}
		
	}
	
	public Point getComienzo() {
		return comienzo;
	}

	public void setComienzo(Point comienzo) {
		this.comienzo = comienzo;
	}

	public Point getDrawEnd() {
		return fin;
	}

	public void setDrawEnd(Point fin) {
		this.fin = fin;
	}

	
	
	public ArrayList<Shape> getShapes() {
		return formas;
	}

	public void setShapes(ArrayList<Shape> formas) {
		this.formas = formas;
	}

	public ArrayList<Color> getShapeFill() {
		return relleno;
	}

	public void setShapeFill(ArrayList<Color> relleno) {
		this.relleno = relleno;
	}

	public ArrayList<Color> getShapeStroke() {
		return trazo;
	}

	public void setShapeStroke(ArrayList<Color> trazo) {
		this.trazo = trazo;
	}

	
	public int getCurrentAction() {
		return actual;
	}

	public void setCurrentAction(int actual) {
		this.actual = actual;
	}
	
	

	public String getOpenPath() {
		return abrir;
	}

	public void setOpenPath(String path) {
		this.abrir = path;
	}

	
	public String getSavePath() {
		return guardar;
	}

	public void setSavePath(String savePath) {
		this.guardar = savePath;
	}

	public boolean isLoad() {
		return carga;
	}

	public void setLoad(boolean cargar) {
		this.carga = cargar;
	}

	public Graphics2D getGraphicSettings() {
		return conf_grafico;
	}

	public void setGraphicSettings(Graphics2D graphicSettings) {
		this.conf_grafico = graphicSettings;
	}

	public void addMyMouseActivity(MouseAdapter mouse){
		this.addMouseListener(mouse);
	}
	public void addMyMotionActivity(MouseMotionAdapter mouseM){
		this.addMouseMotionListener(mouseM);
	}
}
