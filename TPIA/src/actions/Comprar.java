package actions;

import search.*;

import java.util.ArrayList;

import domain.Celda;
import domain.Producto;
import domain.Supermercado;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class Comprar extends SearchAction {

    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState state) {
        EstadoAgente agState = (EstadoAgente) state;
        boolean esSupermercado = false;

        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        for(Supermercado su : agState.getSupermercadosDisponibles()) {
        	if(agState.equals(su.getUbicacion())) esSupermercado=true;
        }
        
        if(esSupermercado) {//eliminar productos
    		
    		Supermercado superActual=null;
    		//veo en que super estoy
    		for(Supermercado sup : agState.getSupermercadosDisponibles()) {
    			if(sup.getUbicacion().equals(agState.getposActual()))
    				superActual = sup;
    		}
    		
    		ArrayList<String> auxProductos = new ArrayList<String>();
        	auxProductos.addAll(agState.getlistaProductos());
    		for(String s: agState.getlistaProductos()) {
    			for(Producto prod : superActual.getProductosDisponibles()) {
    				if(s.equals(prod.getNombre())) auxProductos.remove(s);
    			}
    		}
    		
    		return agState;
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
        boolean esSupermercado = false;

        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        for(Supermercado s : agState.getSupermercadosDisponibles()) {
        	if(agState.equals(s.getUbicacion())) esSupermercado=true;
        }
        
        if(esSupermercado) {//eliminar productos
    		
    		Supermercado superActual=null;
    		//veo en que super estoy
    		for(Supermercado s : agState.getSupermercadosDisponibles()) {
    			if(s.getUbicacion().equals(agState.getposActual()))
    				superActual = s;
    		}
    		
    		ArrayList<String> auxProductos = new ArrayList<String>();
        	auxProductos.addAll(agState.getlistaProductos());
    		for(String s: agState.getlistaProductos()) {
    			for(Producto prod : superActual.getProductosDisponibles()) {
    				if(s.equals(prod.getNombre())) auxProductos.remove(s);
    			}
    		}
    		return environmentState;
    	}

        return null;
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
        return new Double(0);
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "Comprar";
    }
}