package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeListener;

import model.PizarraDibujo;

import javax.swing.Icon;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class PaintView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel PanelTrabajo;
	
	private JButton btnLinea;
	private JButton btnElipse;
	private JButton btnRectangulo;
	private JButton btnPlay;
	private JButton btnColor;
	
	private ImageIcon iconLinea;
	private ImageIcon iconEllipse;
	private ImageIcon iconRectangle;
	private ImageIcon iconPlay;
	private ImageIcon iconPause;
	private ImageIcon iconColor;
	private ImageIcon iconRelleno;
	private ImageIcon iconNuevo;
	private ImageIcon iconAtras;
	private ImageIcon iconGuardar;
	private ImageIcon iconCargar;
	private ImageIcon iconAbrir;
	private ImageIcon iconSave;
	
	private Box theBox; 
	private JButton btnRelleno;
	private JButton btnNuevo;
	private JButton btnAtras;
	private JButton btnGuardar;
	private JButton btnAbrir;
	private JMenuBar menuBar;
	private JMenu Archivo;
	private JMenuItem menu_conf;
	private JMenu Ayuda;
	private JButton btnPause;
	private JSeparator separator;
	private JButton btnAbrir_png;
	private JButton btnGuardar_png;
	private JSeparator separator_1;
	private JMenuItem acerca;
	
	
	
	
	public PaintView(PizarraDibujo myDrawingBoard){
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ecuaa\\eclipse-workspace\\Proyecto2BIM\\images\\paint.png"));
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();	
		Border compound = BorderFactory.createCompoundBorder(
                raisedbevel, loweredbevel);
		Border negroline = BorderFactory.createLineBorder(Color.BLACK);
		compound = BorderFactory.createCompoundBorder(
                negroline, compound);	
		((JComponent) this.getContentPane()).setBorder(compound);
		
		
		setTitle("Proyecto Paint++");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 700);
		setResizable(true);
		
		 PanelTrabajo=new JPanel();		
		 PanelTrabajo.setBorder(new CompoundBorder(new LineBorder(new Color(64, 64, 64)), new CompoundBorder(new LineBorder(new Color(64, 64, 64)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)))));
		 iconLinea = new ImageIcon("images/linea.png");
		 iconEllipse = new ImageIcon("images/circulo.png");
		 iconRectangle = new ImageIcon("images/cuadrado.png");
		 iconPlay = new ImageIcon("images/boton_play.png");
		 iconPause = new ImageIcon("images/boton-de-pausa.png");
		 iconColor = new ImageIcon("images/Color.png");
		 iconRelleno = new ImageIcon("images/relleno.png");
		 iconNuevo = new ImageIcon("images/nuevo.png");
		 iconAtras = new ImageIcon("images/atras.png");
		 iconGuardar = new ImageIcon("images/guardar_nube.png");
		 iconCargar = new ImageIcon("images/descargar_nube.png");
		 iconSave = new ImageIcon("images/Guardar.png");
		 iconAbrir = new ImageIcon("images/Abrir.png");
		 
		btnLinea = new JButton(iconLinea);
		btnLinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnLinea.setBounds(236, 492, 70, 70);

		
		btnElipse = new JButton(iconEllipse);
		btnElipse.setBounds(334, 492, 70, 70);
		
		btnRectangulo = new JButton(iconRectangle);
		btnRectangulo.setBounds(442, 492, 70, 70);

		
		btnColor = new JButton(iconColor);
		getContentPane().add(myDrawingBoard, BorderLayout.CENTER);
		
		theBox = Box.createHorizontalBox();
		
		btnAbrir_png = new JButton(iconAbrir);
		theBox.add(btnAbrir_png);
		
		btnGuardar_png = new JButton(iconSave);
		theBox.add(btnGuardar_png);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.ORANGE);
		separator_1.setBackground(Color.ORANGE);
		theBox.add(separator_1);
		
		btnNuevo = new JButton(iconNuevo);
		theBox.add(btnNuevo);
		
		btnAtras = new JButton(iconAtras);
		theBox.add(btnAtras);
		
		
		
		theBox.add(btnLinea);
		theBox.add(btnElipse);
		theBox.add(btnRectangulo);
		theBox.add(btnColor);
		
		btnRelleno = new JButton(iconRelleno);
		theBox.add(btnRelleno);
		
		separator = new JSeparator();
		separator.setForeground(Color.ORANGE);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.ORANGE);
		theBox.add(separator);
		
		btnGuardar = new JButton(iconGuardar);
		theBox.add(btnGuardar);
		
		btnAbrir = new JButton(iconCargar);
		theBox.add(btnAbrir);
		PanelTrabajo.add(theBox);
		
		
		btnPlay = new JButton(iconPlay);
		btnPlay.setEnabled(false);
		theBox.add(btnPlay);
		
		btnPause = new JButton(iconPause);
		btnPause.setEnabled(false);
		theBox.add(btnPause);
		
		compound = BorderFactory.createCompoundBorder(
                negroline, compound);

		getContentPane().add(PanelTrabajo, BorderLayout.NORTH);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		Archivo = new JMenu("Archivo");
		menuBar.add(Archivo);
		
		menu_conf = new JMenuItem("Configuraci\u00F3n");
		Archivo.add(menu_conf);
		
		Ayuda = new JMenu("Ayuda");
		menuBar.add(Ayuda);
		
		acerca = new JMenuItem("Acerca de . . .");
		Ayuda.add(acerca);
		
		
		
		
		
	}
	public JButton getBtnLinea() {
		return btnLinea;
	}
	public void setBtnLinea(JButton btnLine) {
		this.btnLinea = btnLine;
	}
	public JButton getBtnEllipse() {
		return btnElipse;
	}
	public void setBtnEllipse(JButton btnEllipse) {
		this.btnElipse = btnEllipse;
	}
	public JButton getBtnRectangle() {
		return btnRectangulo;
	}
	public void setBtnRectangle(JButton btnRectangle) {
		this.btnRectangulo = btnRectangle;
	}
	
	
	
	public JButton getBtnLoad() {
		return btnAbrir;
	}
	public void setBtnLoad(JButton btnLoad) {
		this.btnAbrir = btnLoad;
	}
	
	public JButton getBtnAbrir() {
		return btnAbrir_png;
	}
	public void setBtnAbrir(JButton btnLoad) {
		this.btnAbrir_png = btnLoad;
	}
	
	
	public JButton getBtnFill() {
		return btnRelleno;
	}
	public void setBtnFill(JButton btnFill) {
		this.btnRelleno = btnFill;
	}
	public JButton getBtnColor() {
		return btnColor;
	}
	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}
	
	
	public JButton getBtnRefresh() {
		return btnNuevo;
	}
	public void setBtnRefresh(JButton btnRefresh) {
		this.btnNuevo = btnRefresh;
	}
	
	public JButton getBtnPlay() {
		return btnPlay;
	}
	public void setBtnPlay(JButton btnPlay) {
		this.btnPlay = btnPlay;
	}
	
	public JButton getBtnPause() {
		return btnPause;
	}
	public void setBtnPause(JButton btnPause) {
		this.btnPause = btnPause;
	}
		
	
	public JButton getBtnUndo() {
		return btnAtras;
	}
	public void setBtnUndo(JButton btnUndo) {
		this.btnAtras = btnUndo;
	}

	
	public JButton getBtnSave() {
		return btnGuardar;
	}
	public void setBtnSave(JButton btnSave) {
		this.btnGuardar = btnSave;
	}
	
	public JButton getBtnGuargar() {
		return btnGuardar_png;
	}
	public void setBtnGuardar(JButton btnSave) {
		this.btnGuardar_png = btnSave;
	}
	
	public JMenuItem getBtnconfig() {
		return menu_conf;
	}
	public void setBtnconfig (JMenuItem  btnconfig) {
		this.menu_conf =  btnconfig;
	}
	
	public JMenuItem getBtnAcerca() {
		return acerca;
	}
	public void setBtnAcerca (JMenuItem  btnacerca) {
		this.acerca =  btnacerca;
	}
	
	public void addButtonActionListener(ActionListener listener){
		
		//Guardar Archivo y Abrir archivos PNG
		btnAbrir_png.addActionListener(listener);
		btnGuardar_png.addActionListener(listener);
		
		btnLinea.addActionListener(listener);
		btnElipse.addActionListener(listener);
		btnRectangulo.addActionListener(listener);
		btnColor.addActionListener(listener);
		btnRelleno.addActionListener(listener);
		btnNuevo.addActionListener(listener);
		btnAtras.addActionListener(listener);
		
		//Botones de la BD
		btnGuardar.addActionListener(listener);
		btnAbrir.addActionListener(listener);
		btnPlay.addActionListener(listener);
		btnPause.addActionListener(listener);
		
		//Configuración SQL
		menu_conf.addActionListener(listener);
		
		//Acerca de
		acerca.addActionListener(listener);
	}
}





