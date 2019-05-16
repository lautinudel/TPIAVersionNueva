//import java.io.*;
import java.util.Vector;

import calculador.Calculador;
import calculador.Pair;
public class Prueba {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calculador calculin = new Calculador();
		Pair posIni;
		posIni = calculin.getPosicionInicial();
		System.out.print("posición inicial agente: " + posIni.x()+ "," + posIni.y());
		System.out.print("Energía pacman: " + calculin.calcularEnergiaPacMan("comer"));
		System.out.print("Energía pacman: " + calculin.calcularEnergiaPacMan("pelear"));
		System.out.print("performance pacman: " + calculin.getPerformance());
		Vector enemigos = calculin.inicializarEnemigo();
		for(int i=0; i< enemigos.size(); i++)
			System.out.println("posicion enemigo: " + i +"-" + ((Pair)enemigos.elementAt(i)).x() + ","+ ((Pair)enemigos.elementAt(i)).y());
		
		enemigos = calculin.inicializarComida();
		
		for(int i=0; i< enemigos.size(); i++)
			System.out.println("posicion comida: " + i +" - "+ ((Pair)enemigos.elementAt(i)).x()+ ","+ ((Pair)enemigos.elementAt(i)).y());
		
	}

}
