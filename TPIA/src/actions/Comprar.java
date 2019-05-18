package actions;

import search.*;

import java.util.ArrayList;

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
        EstadoAgente sigEstado = (EstadoAgente) agState.clone();
        boolean esSupermercado = false;

        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        for(Supermercado su : agState.getSupermercadosDisponibles()) {
        	//System.out.println(agState.getposActual().toString()+" ------"+su.getUbicacion().toString());
        	if(agState.getposActual().equals(su.getUbicacion())) esSupermercado=true;
        }
        //System.out.println("COMPRAR:"+esSupermercado);
        if(esSupermercado) {//eliminar productos
    		
    		Supermercado superActual=null;
    		//veo en que super estoy
    		for(Supermercado sup : sigEstado.getSupermercadosDisponibles()) {
    			if(sup.getUbicacion().equals(agState.getposActual()))
    				superActual = sup;
    		}
    		//System.out.println("ENTRO AL SUPER: "+superActual.getNombre());
    		ArrayList<String> auxProductos = new ArrayList<String>();
        	auxProductos.addAll(agState.getlistaProductos());
        	
    		for(String s: agState.getlistaProductos()) {  
    			for(Producto prod : superActual.getProductosDisponibles()) {
    				if(s.equals(prod.getNombre())) { 
    					auxProductos.remove(s);
    					switch(sigEstado.getCriterioDeAhorro()) {
    			    	case DINERO:sigEstado.setCostoAcumulado(sigEstado.getCostoAcumulado()+prod.getPrecio());
    			    		break;
    			    	case TIEMPO:sigEstado.setCostoAcumulado(sigEstado.getCostoAcumulado()+300.0);
    			    		break;
    			    	case AMBOS:sigEstado.setCostoAcumulado(sigEstado.getCostoAcumulado()+prod.getPrecio()/5.0);
    			    		break;
    					}
    					
    					
    				}
    			}
    		}
    		   		
    		sigEstado.setlistaProductos(auxProductos);
    		
    		//System.out.println("Agente viejo: "+agState);
    		//System.out.println("Agente clonado: "+sigEstado);
    		
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
        boolean esSupermercado = false;

        // TODO: Use this conditions
        // PreConditions: null
        // PostConditions: null
        
        for(Supermercado su : agState.getSupermercadosDisponibles()) {
        	//System.out.println(agState.getposActual().toString()+" ------"+su.getUbicacion().toString());
        	if(agState.getposActual().equals(su.getUbicacion())) esSupermercado=true;
        }
        //System.out.println("COMPRAR:"+esSupermercado);
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
    				if(s.equals(prod.getNombre())) { 
    					auxProductos.remove(s);
    					switch(agState.getCriterioDeAhorro()) {
    			    	case DINERO:agState.setCostoAcumulado(agState.getCostoAcumulado()+prod.getPrecio());
    			    		break;
    			    	case TIEMPO:agState.setCostoAcumulado(agState.getCostoAcumulado()+300.0);
    			    		break;
    			    	case AMBOS:agState.setCostoAcumulado(agState.getCostoAcumulado()+prod.getPrecio()/5.0);
    			    		break;
    					}
    				}
    			}
    		}
    		   		
    		agState.setlistaProductos(auxProductos);
        }
        return environmentState;
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
        return 0.0;
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