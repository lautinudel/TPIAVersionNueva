package domain;

import java.util.ArrayList;

public class Supermercado {
	
	public String nombre;
	public Coordenadas ubicacion;
	public boolean disponibilidad;
	public ArrayList<Producto> productosDisponibles;
	
	public Supermercado(String nombre, Coordenadas ubicacion, boolean disponibilidad,
			ArrayList<Producto> productosDisponibles) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.disponibilidad = disponibilidad;
		this.productosDisponibles = productosDisponibles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Coordenadas getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Coordenadas ubicacion) {
		this.ubicacion = ubicacion;
	}

	public boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public ArrayList<Producto> getProductosDisponibles() {
		return productosDisponibles;
	}

	public void setProductosDisponibles(ArrayList<Producto> productosDisponibles) {
		this.productosDisponibles = productosDisponibles;
	}
	
	public boolean equals(Supermercado s) {
		boolean mismosProductos = true;
		for(Producto actual : this.productosDisponibles) {
			mismosProductos=false;
			for(Producto real : s.getProductosDisponibles()) {
				if(actual.equals(s)) mismosProductos=true;
			}
		}
		if(this.nombre.equals(s.getNombre()) && this.disponibilidad==s.getDisponibilidad() && this.ubicacion.equals(s.getUbicacion()) && mismosProductos)
			return true;
		else return false;
	}
	
	
	
	

}
