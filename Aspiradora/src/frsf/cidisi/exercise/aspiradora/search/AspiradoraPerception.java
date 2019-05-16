package frsf.cidisi.exercise.aspiradora.search;

import domain.Habitacion;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AspiradoraPerception extends Perception {

    public static int UNKNOWN_PERCEPTION = -1;   
	private int suciedad;

    public  AspiradoraPerception() {
    	//Aquí crearimos los objetos, listas, arrays que componen la percepción
    	suciedad = UNKNOWN_PERCEPTION;
    }

    public AspiradoraPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method initializa a perception of the agent.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
        Aspiradora agent = (Aspiradora) agentIn;
        AmbienteAspiradora environment = (AmbienteAspiradora) environmentIn;
        EstadoAmbiente environmentState = environment.getEnvironmentState();
       
        //Aquí creamos la percepción inicial del agente
        //Pimero chequeamos que la habitación en la que está el agente está sucia
        Habitacion h = environmentState.getposicionAspiradora();
        boolean estaSucia = environmentState.gethabitacionesSucias().contains(h);
        
        //Si lo está, el valor de la percepción será 1; en caso contrario será 0
        if(estaSucia)
        	suciedad = 1;
        else
        	suciedad = 0;
        
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += "La habitación está ";
        str += (suciedad == 1)?"sucia.":"limpia.";

        return str.toString();
    }

    // The following methods are agent-specific:	
     public int getsuciedad(){
        return suciedad;
     }
     
     public void setsuciedad(int arg){
        this.suciedad = arg;
     }
	
   
}
