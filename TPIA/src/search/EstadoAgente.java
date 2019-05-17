package search;

import java.util.ArrayList;
import java.util.List;

import domain.Coordenadas;
import domain.Habitacion;
import domain.TipoVehiculo;
import frsf.cidisi.exercise.aspiradora.search.EstadoAspiradora;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoAgente extends SearchBasedAgentState {
	
    private Coordenadas posActual;
    private ArrayList<String> listaProductos;
    private int[][] matrizCostosP = {{5,20,-1,80,-1,40,-1,-1,-1},
	 									{10,-1,-1,-1,5,40,-1,-1,35},
	 									{12,-1,10,-1,15,-1,10,10,-1}};;
    private ArrayList<Coordenadas> listaLugaresVisitados;
    private TipoVehiculo tipoVehiculo;
	

    public EstadoAgente() {
    
    	//TODO: Complete Method
    	
			// posActual = initData0;
			// listaProductos = initData1;
			// listaLugaresVisitados = initData3;
			// tipoVehiculo = initData4;
      
        this.initState();
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
    	EstadoAgente newState = new EstadoAgente();
    	
    	//Los atributos de tipo primitvos se pasan por copia
    	//newState.setenergiaDisponible(this.getenergiaDisponible());
    	
		//Los atributos que son objetos (los arrays tambi�n son de tipo objeto) se pasan por
    	//referencia; luego, es necesario clonarlos
    	List<Habitacion> newMapaHabitaciones = new ArrayList<Habitacion>();
    	for(Habitacion h : this.getmapaHabitaciones())
    		newMapaHabitaciones.add(h.clone());
    	newState.setmapaHabitaciones(newMapaHabitaciones);
    	
    	//Buscamos en el nuevo mapa las habitaciones sucias para agregarlas a la nueva lista
    	//de habitaciones sucias
    	List<Habitacion> newHabitacionesSucias = new ArrayList<Habitacion>();
    	for(Habitacion h : newMapaHabitaciones)
    		for(Habitacion hs : this.gethabitacionesSucias())
    			if(h.getNombre().equals(hs.getNombre()))
    				newHabitacionesSucias.add(h);
    	newState.sethabitacionesSucias(newHabitacionesSucias);
    	
    	//Este ultimo atributo (la posicion) ya se encuentra en la lista de habitaciones que
    	//representa el mapa! Entonces debemos buscarlo en la lista (la NUEVA!)
    	for(Habitacion h : newMapaHabitaciones)
    		if(h.getNombre().equals(this.getposicion().getNombre()))
    			newState.setposicion(h);
    	
        return newState;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
        //TODO: Complete Method
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
	//TODO: Complete Method

    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       //TODO: Complete Method
        
        return true;
    }

    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
   	
     public Coordenadas getposActual(){
       return posActual;
    }
     public void setposActual(Coordenadas arg){
        posActual = arg;
     }
     public ArrayList<String> getlistaProductos(){
        return listaProductos;
     }
     public void setlistaProductos(ArrayList<String> arg){
        listaProductos = arg;
     }
     public int[][] getmatrizCostosP(){
        return matrizCostosP;
     }
     public void setmatrizCostosP(int[][] arg){
        matrizCostosP = arg;
     }
     public ArrayList<Coordenadas> getlistaLugaresVisitados(){
        return listaLugaresVisitados;
     }
     public void setlistaLugaresVisitados(ArrayList<Coordenadas> arg){
        listaLugaresVisitados = arg;
     }
     public TipoVehiculo gettipoVehiculo(){
       return tipoVehiculo;
     }
    public void settipoVehiculo(TipoVehiculo arg){
       tipoVehiculo = arg;
     }
	
}

