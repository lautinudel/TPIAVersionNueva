package search;

import domain.Celda;
import domain.Coordenadas;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgentedeComprasPerception extends Perception {
    
	public static Celda UNKNOWN_PERCEPTION ;   
	private Celda estadocelda;
	
 

    public  AgentedeComprasPerception() {
    	UNKNOWN_PERCEPTION = new Celda(false,false,false,false);
    	estadocelda = UNKNOWN_PERCEPTION;
    }

    public AgentedeComprasPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
    	//TODO: Complete Method
        
        AgentedeCompras agent = (AgentedeCompras) agentIn;
        Ambiente environment = (Ambiente) environmentIn;
        EstadoAmbiente environmentState = environment.getEnvironmentState();
        
        //Aqu� creamos la percepci�n inicial del agente
        //Pimero chequeamos que la ubicaci�n no sea la de un supermercado
        Coordenadas posAgente = environmentState.getposAgente();
        boolean esSupermercado = false;
        
        /*for (int i = 0; i<agent.getAgentState().getlistaLugaresVisitados().size();i++) {
        	if (posAgente.equals(agent.getAgentState().getlistaLugaresVisitados().get(i).getCoordenadas())) {
        		esSupermercado = true;
        	}
        }*/
        
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
     public Celda getestadocelda(){
        return estadocelda;
     }
     public void setestadocelda(Celda arg){
        this.estadocelda = arg;
     }
	
   
}