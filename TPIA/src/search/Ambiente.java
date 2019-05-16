package search;

import domain.Coordenadas;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import sun.management.resources.agent;

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
		
         //Pimero chequeamos que la habitaci�n en la que est� el agente est� sucia
         
         Coordenadas c = this.getEnvironmentState().getposAgente();
         boolean esSupermercado = false;
         
         
         for (int i = 0; i<this.getEnvironmentState().getListaDeSupermercados().size();i++) {
         	if (c.equals(this.getEnvironmentState().getListaDeSupermercados().get(i).getUbicacion())) {
         		esSupermercado = true;
         	}
         }
         
         //Si lo est�, el valor de la percepci�n ser� 1; en caso contrario ser� 0
         /*if(esSupermercado)
         	perception.setestadocelda(arg);
         else
         	perception.setsuciedad(0);*/
      
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    
    public boolean agentFailed(Action actionReturned) {

        EstadoAmbiente envState =
                this.getEnvironmentState();

        // TODO: Complete Method        

        return false;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    
}