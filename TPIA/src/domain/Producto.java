package domain;

public class Producto {
	
	private String nombre;
	private Double precio;
	public Producto(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public boolean equals(Producto p) {
		if(this.nombre==p.getNombre() && this.precio==p.precio) return true;
		else return false;
	}

}
