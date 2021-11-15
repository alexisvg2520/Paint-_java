package controller;

import java.awt.Color;
import java.awt.Shape;

import model.FuncionesDibujo;
import model.PizarraDibujo;
import view.PaintView;

public class hilo extends Thread{
	private Color ColorTrazo;
	private Color ColorRelleno;
	private Controlador c;
	private int tipo=0, t_red=0, t_green=0, t_blue=0;
	private int x1=0,y1=0,x2=0,y2=0;
	private int r_red=0,r_green=0,r_blue=0;
	public hilo(Controlador c,int tipo, int t_red, int t_green, int t_blue, int x1, int y1, int x2, int y2, int r_red, int r_green, int r_blue){
		this.c=c;
		this.tipo=tipo;
		this.t_red=t_red;
		this.t_green=t_green;
		this.t_green=t_blue;
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.r_red=r_red;
		this.r_green=r_green;
		this.r_blue=r_blue;
	}
	
	public void run() {
		FuncionesDibujo funciones = new FuncionesDibujo();
		for(int i=0; i<100; i+=10) {
			Shape Forma = null; 
	    	  if(tipo==2){
	    		  Forma=funciones.drawLine(x1,y1,x2,y2);
	    	  }
	    	  else if(tipo==3){	    		  
          		Forma = funciones.drawEllipse(x1,y1,x2,y2);

	    	  }
	    	  else if(tipo==4){	    		  
          		Forma = funciones.drawRectangle(x1,y1,x2,y2);
	    	  }
	    	  this.c.lienzo.getShapes().add(Forma);
	    	  ColorTrazo =new Color(t_red,t_green,t_blue);
	    	  ColorRelleno =new Color(r_red,r_green,r_blue);
	    	  this.c.lienzo.getShapeFill().add(ColorRelleno);
	    	  this.c.lienzo.getShapeStroke().add(ColorTrazo);

	    	  this.c.lienzo.setComienzo(null);
	    	  this.c.lienzo.setDrawEnd(null);
	    	  this.c.lienzo.repaint();
		}
	}

}
