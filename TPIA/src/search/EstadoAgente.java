package search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoAgente extends SearchBasedAgentState {
	
	//TODO: Setup Variables
    //private Other posActual;
    //private Other listaProductos;
    private int[][] matrizCostosP;
    //private Other listaLugaresVisitados;
    //private Other tipoVehiculo;
	

    public EstadoAgente() {
    
    	//TODO: Complete Method
    	/*
			// posActual = initData0;
			// listaProductos = initData1;
			// matrizCostosP = initData2;
			// listaLugaresVisitados = initData3;
			// tipoVehiculo = initData4;
        */
        this.initState();
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		//TODO: Complete Method
		
        return null;
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
   	
//     public Other getposActual(){
//        return posActual;
//     }
//     public void setposActual(Other arg){
//        posActual = arg;
//     }
//     public Other getlistaProductos(){
//        return listaProductos;
//     }
//     public void setlistaProductos(Other arg){
//        listaProductos = arg;
//     }
     public int[][] getmatrizCostosP(){
        return matrizCostosP;
     }
     public void setmatrizCostosP(int[][] arg){
        matrizCostosP = arg;
     }
//     public Other getlistaLugaresVisitados(){
//        return listaLugaresVisitados;
//     }
//     public void setlistaLugaresVisitados(Other arg){
//        listaLugaresVisitados = arg;
//     }
//     public Other gettipoVehiculo(){
//        return tipoVehiculo;
//     }
//     public void settipoVehiculo(Other arg){
//        tipoVehiculo = arg;
//     }
	
}

