package domain;

public class Celda {
	 public boolean arriba;
	 public boolean abajo;
	 public boolean izquierda;
	 public boolean derecha;
	 
	public boolean isArriba() {
		return arriba;
	}
	public void setArriba(boolean arriba) {
		this.arriba = arriba;
	}
	public boolean isAbajo() {
		return abajo;
	}
	public void setAbajo(boolean abajo) {
		this.abajo = abajo;
	}
	public boolean isIzquierda() {
		return izquierda;
	}
	public void setIzquierda(boolean izquierda) {
		this.izquierda = izquierda;
	}
	public boolean isDerecha() {
		return derecha;
	}
	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}
	public Celda(boolean arriba, boolean abajo, boolean izquierda, boolean derecha) {
		super();
		this.arriba = arriba;
		this.abajo = abajo;
		this.izquierda = izquierda;
		this.derecha = derecha;
	}
	public Celda() {
		super();
	}
	 
	 
	 
	 
	 
}
