package controller;

import javax.swing.JOptionPane;

import model.query;
import model.update;


public interface parametrizable {
	
	public final query consulta=new query();
	public final update actualizacion=new update();

	
	public default void print(String texto) {
		JOptionPane.showMessageDialog(null,texto);
	}

}
