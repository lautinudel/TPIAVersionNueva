package search;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
	//TODO: Setup Variables
    //private Other posAgente;
    private int[][] matrizMapa;
	
    public EstadoAmbiente() {
        
        //TODO: Complete Method
    	/*
			// posAgente = initData0;
			// matrizMapa = initData1;
        */
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        //TODO: Complete Method
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	
//     public Other getposAgente(){
//        return posAgente;
//     }
//     public void setposAgente(Other arg){
//        posAgente = arg;
//     }
     public int[][] getmatrizMapa(){
        return matrizMapa;
     }
     public void setmatrizMapa(int[][] arg){
        matrizMapa = arg;
     }
	

}

