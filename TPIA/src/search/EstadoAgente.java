package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Coordenadas;
import domain.Producto;
import domain.Supermercado;
import domain.TipoVehiculo;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoAgente extends SearchBasedAgentState {
	
    private Coordenadas posActual;
    private ArrayList<String> listaProductos;
    /*private int[][] matrizCostosP = {{5,20,-1,80,-1,40,-1,-1,-1},
	 									{10,-1,-1,-1,5,40,-1,-1,35},
	 									{12,-1,10,-1,15,-1,10,10,-1}};*/
    private ArrayList<Supermercado> supermercadosDisponibles;
    private int costoAcumulado;
    private TipoVehiculo tipoVehiculo;
	

    public EstadoAgente() {
    
    	//TODO: Complete Method
    	
			 posActual = new Coordenadas();
			// listaProductos = new ArrayList<String>();
			 supermercadosDisponibles = new ArrayList<Supermercado>();
			 costoAcumulado=0;
			 tipoVehiculo = TipoVehiculo.AUTO;
			
      
        this.initState();
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
    	EstadoAgente newState = new EstadoAgente();
    	
    	newState.setposActual(this.posActual.clone());
    	
    	ArrayList<String> newListaProductos = new ArrayList<String>();
    	for(String s : this.getlistaProductos()) {
    		String aux = s;
    		newListaProductos.add(aux);
    	}
    	newState.setlistaProductos(newListaProductos);
    	
    	ArrayList<Supermercado> newSupermercadosDisponibles = new ArrayList<Supermercado>();
    	for(Supermercado s : this.getSupermercadosDisponibles()) {
    		Supermercado aux = s;
    		newSupermercadosDisponibles.add(aux);
    	}
    	newState.setSupermercadosDisponibles(newSupermercadosDisponibles);
    	
    	
    	/*int[][] newMatrizCostosP = {{0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0}};
    	for(int i=0;i<this.getmatrizCostosP().length;i++) {
    		for(int j=0; j<this.getmatrizCostosP()[i].length;j++) {
    			newMatrizCostosP[i][j]=matrizCostosP[i][j];
    		}
    	}
    	newState.setmatrizCostosP(newMatrizCostosP);*/
    	
    	newState.setCostoAcumulado(this.getCostoAcumulado());
    	
    	TipoVehiculo aux = this.gettipoVehiculo();
    	newState.settipoVehiculo(aux);
    	
    	
    	
        return newState;
    }

    

	/**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
        //TODO: Complete Method
    	
    	AgentedeComprasPerception percepcion = (AgentedeComprasPerception) p;
    	
    	boolean esSupermercado = percepcion.getEsSupermercado();
    	
    	
    	
    	if(esSupermercado) {//eliminar productos
    		
    		Supermercado superActual=null;
    		//veo en que super estoy
    		for(Supermercado s : this.getSupermercadosDisponibles()) {
    			if(s.getUbicacion().equals(this.getposActual()))
    				superActual = s;
    		}
    		
    		ArrayList<String> auxProductos = new ArrayList<String>();
        	auxProductos.addAll(this.getlistaProductos());
    		for(String s: this.getlistaProductos()) {
    			for(Producto prod : superActual.getProductosDisponibles()) {
    				if(s.equals(prod.getNombre())) auxProductos.remove(s);
    			}
    		}
    	}else {
    		//se sigue moviendo
    	}
    	
    	
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
	//TODO: Complete Method
    	
    	//INICIALIZAR EL ESTADO DEL AGENTE

    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       //TODO: Complete Method
    	
    	EstadoAgente e = (EstadoAgente) obj;
    	
    	boolean mismaPosicion = this.getposActual().equals(e.getposActual());
    	boolean mismosProductos = true;
    	mismosProductos = this.getlistaProductos().size() == e.getlistaProductos().size();
    	if(mismosProductos) {
    		String[] nombresActuales = getArrayOfNames(this.getlistaProductos());
    		String[] nobresComparadas = getArrayOfNames(e.getlistaProductos());
    		Arrays.sort(nombresActuales);
    		Arrays.sort(nobresComparadas);
    		for(int i=0;i<nombresActuales.length;i++)
    			if(!(nombresActuales[i].equals(nobresComparadas[i])))
    				mismosProductos = false;
    	}
    	boolean mismoTipoVehiculo = this.gettipoVehiculo() == e.gettipoVehiculo();
    	boolean mismoCostoAcumulado = this.getCostoAcumulado() == e.getCostoAcumulado();
    	
    	boolean mismosSupermercados = true;
    	mismosSupermercados = this.getSupermercadosDisponibles().size() == e.getSupermercadosDisponibles().size();
    	if(mismosSupermercados) {
    		String[] nombresActuales = getArrayOfNamesSuper(this.getSupermercadosDisponibles());
    		String[] nobresComparadas = getArrayOfNamesSuper(e.getSupermercadosDisponibles());
    		Arrays.sort(nombresActuales);
    		Arrays.sort(nobresComparadas);
    		for(int i=0;i<nombresActuales.length;i++)
    			if(!(nombresActuales[i].equals(nobresComparadas[i])))
    				mismosSupermercados = false;
    	}
    	
    	return (mismaPosicion && mismoTipoVehiculo && mismoCostoAcumulado && mismosProductos && mismosSupermercados);
       
        
    	
        
    }

    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
   	
     public Coordenadas getposActual(){
       return posActual;
    }
     public void setposActual(Coordenadas arg){
        posActual = arg;
     }
     
     public void setposActual(int fila, int columna){
         posActual.setColumna(columna);
         posActual.setFila(fila);
      }
     
     
     public ArrayList<String> getlistaProductos(){
        return listaProductos;
     }
     public void setlistaProductos(ArrayList<String> arg){
        listaProductos = arg;
     }
     /*public int[][] getmatrizCostosP(){
        return matrizCostosP;
     }
     public void setmatrizCostosP(int[][] arg){
        matrizCostosP = arg;
     }*/
     public TipoVehiculo gettipoVehiculo(){
       return tipoVehiculo;
     }
    public void settipoVehiculo(TipoVehiculo arg){
       tipoVehiculo = arg;
     }
    public void setCostoAcumulado(int arg) {
    	this.costoAcumulado=arg;
    }
    public int getCostoAcumulado() {
    	return this.costoAcumulado;
    }

	public ArrayList<Supermercado> getSupermercadosDisponibles() {
		return supermercadosDisponibles;
	}

	public void setSupermercadosDisponibles(ArrayList<Supermercado> supermercadosDisponibles) {
		this.supermercadosDisponibles = supermercadosDisponibles;
	}
	
	private String[] getArrayOfNames(List<String> productos){
   	 String[] arrayOfNames = new String[productos.size()];
   	 
   	 for(int i=0;i<productos.size();i++)
   		 arrayOfNames[i] = productos.get(i);
   	 
   	 return arrayOfNames;
    } 
	private String[] getArrayOfNamesSuper(List<Supermercado> supermercados){
	   	 String[] arrayOfNames = new String[supermercados.size()];
	   	 
	   	 for(int i=0;i<supermercados.size();i++)
	   		 arrayOfNames[i] = supermercados.get(i).getNombre();
	   	 
	   	 return arrayOfNames;
	    } 
	
	
	
}

