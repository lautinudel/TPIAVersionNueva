package domain;

public class Coordenadas {
	
	public int fila;
	public int columna;
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public Coordenadas(int fila, int columna) {
		super();
		this.fila = fila;
		this.columna = columna;
	}
	public Coordenadas() {
		super();
	}
	public boolean equals(Coordenadas c) {
		if(c.getFila() == this.fila && c.getColumna() == this.columna) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "Posicion: ("+fila+","+columna+")";
	}
	
	public Coordenadas clone() {
		int fila = this.getFila();
		int columna = this.getColumna();
		return new Coordenadas(fila,columna);
		
	}

}
