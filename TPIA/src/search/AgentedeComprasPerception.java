package search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgentedeComprasPerception extends Perception {

	//TODO: Setup Statics
    //public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//TODO: Setup Sensors
	private int estadocelda;
	
 

    public  AgentedeComprasPerception() {
    	//TODO: Complete Method
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
        
        //AgentedeCompras agent = (AgentedeCompras) agentIn;
        //Ambiente environment = (Ambiente) environmentIn;
        //EstadoAmbiente environmentState =
        //        environment.getEnvironmentState();
       
        
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
     public int getestadocelda(){
        return estadocelda;
     }
     public void setestadocelda(int arg){
        this.estadocelda = arg;
     }
	
   
}
