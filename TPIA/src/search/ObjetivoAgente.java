

package search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoAgente extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    
    	EstadoAgente e = (EstadoAgente) agentState;
    	
    	
        if  (e.getlistaProductos().isEmpty()) //(listaProductos = {})
        	{
            return true;
        	}
        return false;
	}
}