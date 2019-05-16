package search;

import java.util.ArrayList;

import domain.Celda;
import domain.Coordenadas;
import domain.Supermercado;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
	
    private Coordenadas posAgente;
    private Celda[][] matrizMapa;
    private ArrayList <Supermercado> listaDeSupermercados;
	
    public EstadoAmbiente() {
        
        
			 posAgente = new Coordenadas();
			 matrizMapa = new Celda[17][11];
			 listaDeSupermercados = new ArrayList <Supermercado>();
        
        this.initState();
    }

    public ArrayList<Supermercado> getListaDeSupermercados() {
		return listaDeSupermercados;
	}

	public void setListaDeSupermercados(ArrayList<Supermercado> listaDeSupermercados) {
		this.listaDeSupermercados = listaDeSupermercados;
	}

	/**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        //COMPLETAR CON INICIALIZACION
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        str += "Posici�n del agente: ";
        str += getposAgente().toString(); 
        str += "}\n";
        

        return str;
    }

	
     public Coordenadas getposAgente(){
        return posAgente;
     }
     public void setposAgente(Coordenadas arg){
       posAgente = arg;
     }
     public Celda[][] getmatrizMapa(){
        return matrizMapa;
     }
     public void setmatrizMapa(Celda[][] arg){
        matrizMapa = arg;
     }
	

}
