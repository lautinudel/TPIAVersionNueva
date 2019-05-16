package domain;

import java.util.List;

public class Habitacion {

	private String nombre;
	private boolean visitada;
	
	public Habitacion(){
		this.visitada = false;
	}
	
	public Habitacion(String nombre){
		this.nombre = nombre;
		this.visitada = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean isVisitada() {
		return visitada;
	}

	public void setVisitada(boolean visitada) {
		this.visitada = visitada;
	}

	public Habitacion clone(){
		Habitacion newHabitacion = new Habitacion();
		
		newHabitacion.setNombre(this.getNombre());
		newHabitacion.setVisitada(this.isVisitada());
		
		return newHabitacion;
	}
	
	public String toString(){
		return nombre+"-"+visitada;
	}
	
	public static boolean todasVisitadas(List<Habitacion> habitaciones){
		boolean allVisited = true;
		
		for(Habitacion h : habitaciones)
			allVisited = allVisited && h.isVisitada();
		
		return allVisited;
	}

}
