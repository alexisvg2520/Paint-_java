package model;

import java.util.ArrayList;

public class generica <T>{
	T atributo1, atributo2, atributo3, atributo4, atributo5,
	atributo6, atributo7, atributo8, atributo9, atributo10, atributo11;
	ArrayList<T> registro;
	
	public generica(){
		registro = new ArrayList<T>();
		
	}

	// metodos para el arrayList
	public void asignar(T new_element) {
		registro.add(new_element);
	}
	
	public ArrayList<T> registrosAlmacenados(){
		return registro;	
	}
	
	generica(T at1 , T at2 , T at3 , T at4, T at5, T at6, T at7, T at8, T at9, T at10, T at11){
		this.atributo1=at1;
		this.atributo2=at2;
		this.atributo3=at3;
		this.atributo4=at4;
		this.atributo5=at5;
		this.atributo6=at6;
		this.atributo7=at7;
		this.atributo8=at8;
		this.atributo9=at9;
		this.atributo10=at10;
		this.atributo11=at11;
	}
	
	public T getAtributo1() {
		return atributo1;
	}

	public void setAtributo1(T atributo1) {
		this.atributo1 = atributo1;
	}

	public T getAtributo2() {
		return atributo2;
	}

	public void setAtributo2(T atributo2) {
		this.atributo2 = atributo2;
	}

	public T getAtributo3() {
		return atributo3;
	}

	public void setAtributo3(T atributo3) {
		this.atributo3 = atributo3;
	}

	public T getAtributo4() {
		return atributo4;
	}

	public void setAtributo4(T atributo4) {
		this.atributo4 = atributo4;
	}
	
	public T getAtributo5() {
		return atributo5;
	}

	public void setAtributo5(T atributo5) {
		this.atributo5 = atributo5;
	}

	public T getAtributo6() {
		return atributo6;
	}

	public void setAtributo6(T atributo6) {
		this.atributo6 = atributo6;
	}

	public T getAtributo7() {
		return atributo7;
	}

	public void setAtributo7(T atributo7) {
		this.atributo7 = atributo7;
	}

	public T getAtributo8() {
		return atributo8;
	}

	public void setAtributo8(T atributo8) {
		this.atributo8 = atributo8;
	}

	public T getAtributo9() {
		return atributo9;
	}

	public void setAtributo9(T atributo9) {
		this.atributo9 = atributo9;
	}

	public T getAtributo10() {
		return atributo10;
	}

	public void setAtributo10(T atributo10) {
		this.atributo10 = atributo10;
	}

	public T getAtributo11() {
		return atributo11;
	}

	public void setAtributo11(T atributo11) {
		this.atributo11 = atributo11;
	}
	
}
