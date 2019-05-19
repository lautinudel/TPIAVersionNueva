package actions;

import search.*;
import domain.Celda;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class AvanzarIzquierda extends SearchAction {
	private EstadoAgente agState;
    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        this.agState = (EstadoAgente) s;
        EstadoAgente sigEstado = (EstadoAgente) agState.clone();
        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        Celda c = agState.getMatrizMapa()[agState.getposActual().getFila()][agState.getposActual().getColumna()];
        if (c.getIzquierda()) {        	
        	//System.out.println("IZQUIERDA");
        	//System.out.println("Posicón antes de avanzar: "+sigEstado.getposActual());
        	sigEstado.setposActual(sigEstado.getposActual().getFila(),sigEstado.getposActual().getColumna()-1);
        	//System.out.println(sigEstado.toString());
        	//sigEstado.setCostoAcumulado(sigEstado.getCostoAcumulado()+this.getCost());
        	
            return sigEstado;
        	
        }
        
        
        return null;
    }

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoAmbiente environmentState = (EstadoAmbiente) est;
        EstadoAgente agState = ((EstadoAgente) ast);

        Celda c = environmentState.getmatrizMapa()[agState.getposActual().getFila()][agState.getposActual().getColumna()];

        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        if (c.getIzquierda()) {
            
            
            // Update the agent state
        	agState.setposActual(agState.getposActual().getFila(),agState.getposActual().getColumna()-1);
        	//agState.setCostoAcumulado(agState.getCostoAcumulado()+this.getCost());
            
            
        	// Update the real world
            environmentState.setposAgente(agState.getposActual());
            
            return environmentState;
        }

        return null;
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
    	Double costo = 0.0;
    	
    	switch(this.agState.getCriterioDeAhorro()) {
    	case DINERO:
    		switch(this.agState.gettipoVehiculo()){
            case AUTO:
         	   costo = 2.0;
         	   break;
            case TAXI:
            	costo = 3.0;
            	break;
            case BICICLETA:
            	costo = 0.0;
            	break;
            case MOTO:
            	costo = 1.0;
            	break;   	      
            }
    		costo = costo * agState.getFactorDeAumento();
    		break;
    	case TIEMPO://EN SEGUNDOS
    		switch(this.agState.gettipoVehiculo()){
            case AUTO:
         	   costo = 15.0;
         	   break;
            case TAXI:
            	costo = 15.0;
            	break;
            case BICICLETA:
            	costo = 50.0;
            	break;
            case MOTO:
            	costo = 25.0;
            	break;   	      
            }
    		break;
    	case AMBOS:
    		switch(this.agState.gettipoVehiculo()){
            case AUTO:
         	   costo = 13.3;
         	   break;
            case TAXI:
            	costo = 20.0;
            	break;
            case BICICLETA:
            	costo = 0.50;
            	break;
            case MOTO:
            	costo = 4.0;
            	break;   	      
            }
    		costo = costo * agState.getFactorDeAumento();
    		break;
    	}
        return costo;
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "AvanzarIzquierda";
    }
}