package search;

import java.util.ArrayList;

import domain.Celda;
import domain.Coordenadas;
import domain.Supermercado;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgentedeComprasPerception extends Perception {
    
	//Setup statics
	public static Celda UNKNOWN_PERCEPTION ;   
	//Setup sensors
	private Celda estadoCelda;
	private ArrayList<Supermercado> supermercadosDisponibles;

    public  AgentedeComprasPerception() {
    	UNKNOWN_PERCEPTION = new Celda(false,false,false,false);
    	estadoCelda = UNKNOWN_PERCEPTION;
    	supermercadosDisponibles = new ArrayList<Supermercado>();
    }

    public AgentedeComprasPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
        AgentedeCompras agent = (AgentedeCompras) agentIn;
        Ambiente environment = (Ambiente) environmentIn;
        EstadoAmbiente environmentState = environment.getEnvironmentState();
        
        //Aquí creamos la percepción inicial del agente
        //Pimero chequeamos que la ubicación inicial no sea la de un supermercado
        
        Coordenadas posAgente = environmentState.getposAgente();
        
        estadoCelda = environmentState.getmatrizMapa()[posAgente.getFila()][posAgente.getColumna()];
        supermercadosDisponibles = environmentState.getListaDeSupermercados();
        /*for(Supermercado s : environmentState.getListaDeSupermercados()) {
        	if(posAgente.equals(s.getUbicacion())) esSupermercado=true;
        }*/
        
        
    }
    
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method
        str += "Estado de la celda: ";
        str+= " Arriba: "+estadoCelda.getArriba();
        str+= " Abajo: "+estadoCelda.getAbajo();
        str+= " Derecha: "+estadoCelda.getDerecha();
        str+= " Izquierda: "+estadoCelda.getIzquierda();
        str+= " Supermercados disponibles: "+getSupermercadosDisponibles().size();
       /* str += "Estoy en un supermercado: ";
        str+=(esSupermercado==true)?"Si":"No";*/


        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
     public ArrayList<Supermercado> getSupermercadosDisponibles() {
		return supermercadosDisponibles;
	}

	public void setSupermercadosDisponibles(ArrayList<Supermercado> supermercadosDisponibles) {
		this.supermercadosDisponibles = supermercadosDisponibles;
	}

	public Celda getestadocelda(){
        return estadoCelda;
     }
     public void setestadoCelda(Celda arg){
        this.estadoCelda = arg;
     }
   
}
