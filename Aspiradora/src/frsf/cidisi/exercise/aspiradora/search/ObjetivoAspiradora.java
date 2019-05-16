package frsf.cidisi.exercise.aspiradora.search;

import domain.Habitacion;
import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoAspiradora extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    	EstadoAspiradora estado = (EstadoAspiradora) agentState;
    	
        if( estado.gethabitacionesSucias().isEmpty()
        	&& Habitacion.todasVisitadas(estado.getmapaHabitaciones()) ){
        		return true;      
        }
        else
        	return false;
        
	}
    
}