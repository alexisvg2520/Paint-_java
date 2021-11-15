package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.PizarraDibujo;
import model.almacen_figuras;
import model.generica;
import model.FuncionesDibujo;
import view.PaintView;

public class Controlador implements parametrizable{
	
	//Datos del servidor para la BD SQL
	public String dir_serv="127.0.0.1";
	public String user="root";
	public  String contra="";
	private ResultSet res;
	//Fecha actual del sistema
	public Date fecha = new Date();
	//llamada del hilo
	public static hilo hilo1;
	private int bandera=0;
	//Figuras
	public PizarraDibujo lienzo = new PizarraDibujo();
	public PaintView ventana = new PaintView(lienzo);
	private Color ColorTrazo = Color.BLACK;
	private Color ColorRelleno = Color.white;
	public generica <almacen_figuras> figuras = new generica<almacen_figuras>();
	
	public boolean add(Integer forma, Integer red_trazo, Integer green_trazo, Integer blue_trazo, Integer x1, Integer y1, Integer x2, 
			Integer y2, Integer red_relleno, Integer green_relleno, Integer blue_relleno) {
		//INSERT INTO figuras VALUES (null, 'forma', 'color_trazo', 'color_relleno');
		if(actualizacion.setQuery("INSERT INTO figuras VALUES (null, '"+forma+"', '"+red_trazo+"', '"+green_trazo+"', '"+blue_trazo
				+"', '"+x1+"', '"+y1+"', '"+x2+"', '"+y2+"', '"+red_relleno+"', '"+green_relleno+"', '"+blue_relleno+"');")) {
			actualizacion.cerrarConexion();
			return true;
		}
		else {
			actualizacion.cerrarConexion();
			return false;
		}
		
	}
	
	public void cargarfiguras() {
		FuncionesDibujo funciones = new FuncionesDibujo();
		//sube los cargos de los empleados en la vista (Componente cbCargos);
		res=consulta.getQuery("SELECT * FROM figuras;");
		try {
			while(res.next()) {
				
				Shape Forma = null; 
		    	  if(res.getInt(2)==2){
		    		  Forma=funciones.drawLine(res.getInt(6),res.getInt(7),res.getInt(8),res.getInt(9));
		    	  }
		    	  else if(res.getInt(2)==3){	    		  
	            		Forma = funciones.drawEllipse(res.getInt(6),res.getInt(7),res.getInt(8),res.getInt(9));
	
		    	  }
		    	  else if(res.getInt(2)==4){	    		  
	            		Forma = funciones.drawRectangle(res.getInt(6),res.getInt(7),res.getInt(8),res.getInt(9));
		    	  }
		    	  lienzo.getShapes().add(Forma);
		    	  ColorTrazo =new Color(res.getInt(3),res.getInt(4),res.getInt(5));
		    	  ColorRelleno =new Color(res.getInt(10),res.getInt(11),res.getInt(12));
		    	  lienzo.getShapeFill().add(ColorRelleno);
		    	  lienzo.getShapeStroke().add(ColorTrazo);
	
		    	  lienzo.setComienzo(null);
		    	  lienzo.setDrawEnd(null);
		    	  lienzo.repaint();
				hilo1= new hilo(null, res.getInt(2),res.getInt(3),res.getInt(4),res.getInt(5),res.getInt(6),
						res.getInt(7),res.getInt(8),res.getInt(9),res.getInt(10),res.getInt(11),res.getInt(12));
		}
			consulta.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			print("Error al ingresar los cargos");
		}
	}
	
	public Controlador(){

		FuncionesDibujo funciones = new FuncionesDibujo();
		

		ventana.addButtonActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==ventana.getBtnLinea()){
					lienzo.setCurrentAction(2);
				}
				if (e.getSource()==ventana.getBtnEllipse()){
					lienzo.setCurrentAction(3);
				}
				if (e.getSource()==ventana.getBtnRectangle()){
					lienzo.setCurrentAction(4);
				}
				if(e.getSource()==ventana.getBtnColor()){
						ColorTrazo = JColorChooser.showDialog(null, "Elige color de TRAZO", Color.BLACK);
				}
				if(e.getSource()==ventana.getBtnFill()){
					ColorRelleno = JColorChooser.showDialog(null, "Elige color de RELLENO", Color.BLACK);
				}
				if(e.getSource()==ventana.getBtnRefresh()){
					lienzo.getShapes().clear();
					lienzo.getShapeFill().clear();
					lienzo.getShapeStroke().clear();
					lienzo.repaint();
					lienzo.setLoad(false);
					figuras.registrosAlmacenados().clear();
					ventana.getBtnPlay().setEnabled(false);
					ventana.getBtnPause().setEnabled(false);
					bandera=0;
					
				}
				if(e.getSource()==ventana.getBtnUndo()){
					if (lienzo.getShapes().size()>1 && 
							lienzo.getShapeFill().size()>1 && 
								lienzo.getShapeStroke().size()>1)
					{
						lienzo.getShapes().remove(lienzo.getShapes().size()-1);
						lienzo.getShapeFill().remove(lienzo.getShapeFill().size()-1);
						lienzo.getShapeStroke().remove(lienzo.getShapeStroke().size()-1);
						
					} else 
					{
						lienzo.getShapes().clear();
						lienzo.getShapeFill().clear();
						lienzo.getShapeStroke().clear();
						figuras.registrosAlmacenados().clear();
						ventana.getBtnPlay().setEnabled(false);
						ventana.getBtnPause().setEnabled(false);
						bandera=0;
						
					}
					lienzo.repaint();
				}
				if(e.getSource()==ventana.getBtnSave()){
					//Obtengo los datos de las figuras ingresadas y guardar en la BD
					for(almacen_figuras figura: figuras.registrosAlmacenados()) {
						Object [] componentes = figura.getComponentes();
						System.out.println("Tipo: "+componentes[4]+" Puntos: "+componentes[0] +" "+componentes[1]+" "+componentes[2]+" "+componentes[3]+
								" ColorTrazo: "+componentes[5]+" "+componentes[6]+" "+componentes[7]+" ColorRelleno: "+componentes[8]+" "+componentes[9]+" "+componentes[10]);
						add(Integer.valueOf(componentes[4].toString()), Integer.valueOf(componentes[5].toString()), Integer.valueOf(componentes[6].toString()), Integer.valueOf(componentes[7].toString()), 
								Integer.valueOf(componentes[0].toString()),Integer.valueOf(componentes[1].toString()), Integer.valueOf(componentes[2].toString()), Integer.valueOf(componentes[3].toString()), 
								Integer.valueOf(componentes[8].toString()), Integer.valueOf(componentes[9].toString()), Integer.valueOf(componentes[10].toString()));
					}

				}
				if(e.getSource()==ventana.getBtnLoad()){
					cargarfiguras();
					ventana.getBtnPlay().setEnabled(true);
				}
				
				if(e.getSource()==ventana.getBtnGuargar()) {

					JFileChooser chooser = new JFileChooser();
				    FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "PNG Images", "png");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showSaveDialog(ventana);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	System.out.println(chooser.getSelectedFile().getPath());

				    	lienzo.setSavePath(chooser.getSelectedFile().getPath());
				    	funciones.saveImage(lienzo.getSavePath(),lienzo.getGraphicSettings(), lienzo);
				    }
				}
				
				if(e.getSource()==ventana.getBtnAbrir()) {
					
					JFileChooser chooser = new JFileChooser();
				    FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "PNG Images", "png");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(ventana);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	lienzo.setOpenPath(chooser.getSelectedFile().getPath());
				    	lienzo.setLoad(true);
						lienzo.repaint();
				    }
				}
				//Botón PLAY
				if(e.getSource()==ventana.getBtnPlay()){
					if(bandera==0) {
						ventana.getBtnPlay().setEnabled(false);
						//print("Función play");
						ventana.getBtnPause().setEnabled(true);
						hilo1.start();
					}else {
						ventana.getBtnPlay().setEnabled(false);
						//print("Función resume");
						ventana.getBtnPause().setEnabled(true);
						hilo1.resume();
					}
					
				}
				//Botón PAUSE
				if(e.getSource()==ventana.getBtnPause()) {
					bandera=1;
					ventana.getBtnPlay().setEnabled(true);
					ventana.getBtnPause().setEnabled(false);
					hilo1.suspend();
				}
				
				if(e.getSource()==ventana.getBtnconfig()) {
				 	dir_serv= JOptionPane.showInputDialog(" Digite  la direccion del sevidor: ");
				 	System.out.print(dir_serv);
				 	user= JOptionPane.showInputDialog(" Digite  el usuario: ");
					System.out.print(user);
				 	contra= JOptionPane.showInputDialog(" Digite  la contraseña: ");
				 	 
				}
				if(e.getSource()==ventana.getBtnAcerca()) {
					JOptionPane.showMessageDialog(null, "INFORMACIÓN DEL PROYECTO\n\n"
							+ "Integrantes:\n\n"
							+ "1. Camila Cedeño\n"
							+ "2. Joselyn Chérrez\n"
							+ "3. Gustavo Contreras\n"
							+ "4. Jonathan Guerra\n"
							+ "5. Alexis Vallejo\n\n"
							+ "Fecha de entrega: "+ fecha);
				}
			}
		});

		
		//Mouse: permite dibujar
		lienzo.addMyMouseActivity(new MouseAdapter() {
		      public void mousePressed(MouseEvent e){
		    	  if(lienzo.getCurrentAction() != 1)
		    	  {
		    		  lienzo.setComienzo(new Point(e.getX(), e.getY()));
		    		  lienzo.setDrawEnd(lienzo.getComienzo());
		    		  lienzo.repaint();
		    	  }
		      }
		      public void mouseReleased(MouseEvent e){
		    	  
		    	  if(lienzo.getCurrentAction()!=1){
		    	  
		    	  Shape Forma = null; 
		    	  if(lienzo.getCurrentAction()==2){
		    		  Forma=funciones.drawLine(lienzo.getComienzo().x,
		    				  lienzo.getComienzo().y,
		    				  e.getX(),
		    				  e.getY());
		    		  almacen_figuras nuevo = new almacen_figuras(lienzo.getComienzo().x,lienzo.getComienzo().y,
		    				  e.getX(),e.getY(),lienzo.getCurrentAction(),ColorTrazo.getRed(),ColorTrazo.getGreen(),ColorTrazo.getBlue(),
		    				  ColorRelleno.getRed(),ColorRelleno.getGreen(),ColorRelleno.getBlue());
		    		  figuras.asignar(nuevo);
		    	  }
		    	  else if(lienzo.getCurrentAction()==3){	    		  
                  		Forma = funciones.drawEllipse(lienzo.getComienzo().x,
  		    				  lienzo.getComienzo().y,
                  				e.getX(), e.getY());
                  		almacen_figuras nuevo = new almacen_figuras(lienzo.getComienzo().x,lienzo.getComienzo().y,
  		    				  e.getX(),e.getY(),lienzo.getCurrentAction(),ColorTrazo.getRed(),ColorTrazo.getGreen(),ColorTrazo.getBlue(),
  		    				  ColorRelleno.getRed(),ColorRelleno.getGreen(),ColorRelleno.getBlue());
                  		figuras.asignar(nuevo);
		    	  }
		    	  else if(lienzo.getCurrentAction()==4){	    		  
                  		Forma = funciones.drawRectangle(lienzo.getComienzo().x,
  		    				 lienzo.getComienzo().y,
                  				e.getX(), e.getY());
                  		almacen_figuras nuevo = new almacen_figuras(lienzo.getComienzo().x,lienzo.getComienzo().y,
  		    				  e.getX(),e.getY(),lienzo.getCurrentAction(),ColorTrazo.getRed(),ColorTrazo.getGreen(),ColorTrazo.getBlue(),
  		    				  ColorRelleno.getRed(),ColorRelleno.getGreen(),ColorRelleno.getBlue());
                  		figuras.asignar(nuevo);
		    	  }
		    	  lienzo.getShapes().add(Forma);
		    	  lienzo.getShapeFill().add(ColorRelleno);
		    	  lienzo.getShapeStroke().add(ColorTrazo);
		    	  
		    	  lienzo.setComienzo(null);
		    	  lienzo.setDrawEnd(null);
		    	  lienzo.repaint();
		    	  
		    	  }		    	  
		      }
		});
		lienzo.addMyMotionActivity(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e){
			if (lienzo.getCurrentAction()==1){	
				int x = e.getX();
				int y = e.getY();
				
				Shape aShape=null; 
				ColorTrazo=ColorRelleno; 
								
				lienzo.getShapes().add(aShape);
				lienzo.getShapeFill().add(ColorRelleno);
				lienzo.getShapeStroke().add(ColorTrazo);

			}
			lienzo.setDrawEnd(new Point(e.getX(),e.getY()));
			lienzo.repaint();
			}
		});
	}
	
	public Object [] obtener() {
		for(almacen_figuras figura: figuras.registrosAlmacenados()) {
			return figura.getComponentes();
		}
		return null;
	}
	
	public static void main (String[] args){
		Controlador c = new Controlador();
		c.ventana.setVisible(true);

	}
	
	
}
