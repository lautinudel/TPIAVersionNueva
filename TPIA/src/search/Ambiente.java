package search;

import domain.Coordenadas;
import domain.Supermercado;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
//import sun.management.resources.agent;

public class Ambiente extends Environment {
	
	
	
    public Ambiente() {
        // Create the environment state
        this.environmentState = new EstadoAmbiente();
    }

    public EstadoAmbiente getEnvironmentState() {
        return (EstadoAmbiente) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  AgentedeComprasPerception getPercept() {
        // Create a new perception to return
         AgentedeComprasPerception perception = new AgentedeComprasPerception();
         
         Coordenadas c = this.getEnvironmentState().getposAgente();
         //boolean esSupermercado = false;
         Coordenadas posAgente = this.getEnvironmentState().getposAgente();
         double factorDeAumento = this.getEnvironmentState().getFactorDeAumento();
        
         perception.setestadoCelda(this.getEnvironmentState().getmatrizMapa()[posAgente.getFila()][posAgente.getColumna()]);
         perception.setSupermercadosDisponibles(this.getEnvironmentState().getListaDeSupermercados());
         perception.setFactorDeAumento(factorDeAumento);
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    
    public boolean agentFailed(Action actionReturned) {

        //EstadoAmbiente envState = this.getEnvironmentState();

              

        return false;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    
}
