package model;

public class almacen_figuras {
	generica<Integer> datos;
	
	public almacen_figuras(int x1, int y1, int x2, int y2, int forma, int red_trazo, int green_trazo, int blue_trazo, 
			int red_relleno, int green_relleno, int blue_relleno) {
		datos = new generica <Integer>(x1,y1,x2,y2,forma, red_trazo, green_trazo, blue_trazo, red_relleno, green_relleno, blue_relleno);
	}
	
	public Object [] getComponentes() {
		Object [] componentes = {datos.getAtributo1(),datos.getAtributo2(),datos.getAtributo3(),datos.getAtributo4(),datos.getAtributo5(),
				datos.getAtributo6(),datos.getAtributo7(),datos.getAtributo8(),datos.getAtributo9(),datos.getAtributo10(),datos.getAtributo11()};
		return componentes;
	}
}
