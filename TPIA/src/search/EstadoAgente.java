package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Celda;
import domain.Coordenadas;
import domain.CriterioDeAhorro;
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
    private ArrayList<Supermercado> supermercadosDisponibles;
    //private Double costoAcumulado;
    private TipoVehiculo tipoVehiculo;
    private CriterioDeAhorro criterioDeAhorro;
    private double factorDeAumento;
    //Matriz hasta Castelli
    /*private Celda[][] matrizMapa = 
    {{new Celda (false,true,false,false),new Celda (false,true,true,false),new Celda (false,false,true,false),new Celda (false,true,true,false),new Celda (false,false,true,false),new Celda (false,true,true,false),new Celda (false,false,true,false),new Celda (false,true,true,false),new Celda (false,false,true,false),new Celda (false,true,true,false)},
    {new Celda (true,true,false,true), new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (true,true,false,false)},
    {new Celda (true,true,false,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (true,true,true,false)},
    {new Celda (true,true,false,true), new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (true,true,false,false)},
    {new Celda (true,true,false,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (true,true,true,false)},
    {new Celda (true,true,false,true), new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (true,true,false,false)},
    {new Celda (true,true,false,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (true,true,true,false)},
    {new Celda (true,true,false,true), new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (true,true,false,false)},
    {new Celda (true,true,false,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (false,true,true,false), new Celda (true,false,true,false), new Celda (true,true,true,false)},
    {new Celda (true,true,false,true), new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (true,true,false,false)},
    {new Celda (true,false,false,false), new Celda (false,false,true,false), new Celda (true,false,true,false), new Celda (false,false, true,false), new Celda (true,false,true,false), new Celda (false,false,true,false), new Celda (true,false,true,false), new Celda (false,false,true,false), new Celda (true,false,true,false), new Celda (true,false,true,false)}
    };*/
    //matriz de ejemplo
    private Celda[][] matrizMapa = 
    	{{new Celda (false,true,false,false),new Celda (false,true,true,false),new Celda (false,false,true,false),new Celda (false,true,true,false)},
    	{new Celda (true,true,false,true), new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,false)},
    	{new Celda (true,false,false,false), new Celda (false,false,true,false), new Celda (true,false,true,false), new Celda (false,false,true,false)}};
    /*private Celda[][] matrizMapa = 
    	{{new Celda (false,true,false,false),new Celda (false,true,true,false),new Celda (false,false,true,false),new Celda (false,true,true,false),new Celda (false,false,true,false),new Celda (false,true,true,false),new Celda (false,false,true,false),new Celda (false,true,true,false),new Celda (false,false,true,false),new Celda (false,true,true,false)},
    	{new Celda (true,true,false,true), new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (true,true,false,false)},
    	{new Celda (true,false,false,false), new Celda (false,false,true,false), new Celda (true,false,true,false), new Celda (false,false,true,false), new Celda (true,false,true,false), new Celda (false,false,true,false), new Celda (true,false,true,false), new Celda (false,false,true,false), new Celda (true,false,true,false), new Celda (true,false,true,false)}};
	
    */
    /*
    private Celda[][] matrizMapa = 
    	{{new Celda (false,false,false,false),new Celda (false,true,true,false),new Celda (false,false,true,false),new Celda (false,true,true,false)},
    	{new Celda (true,true,false,true), new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,false)},
    	{new Celda (true,false,false,false), new Celda (false,false,true,false), new Celda (true,false,true,false), new Celda (false,false,true,false)}};
    */
    public EstadoAgente() {	
      
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
    	
    	Celda[][] newMatrizMapa=this.matrizMapa;
    	for(int i=0;i<this.getMatrizMapa().length;i++) {
    		for(int j=0;j<this.getMatrizMapa()[i].length;j++) {
    			newMatrizMapa[i][j]=this.matrizMapa[i][j];
    		}
    	}
    	newState.setMatrizMapa(newMatrizMapa);

    	
    	//newState.setCostoAcumulado(this.getCostoAcumulado());
    	
    	TipoVehiculo aux = this.gettipoVehiculo();
    	newState.settipoVehiculo(aux);
    	
    	CriterioDeAhorro cda = this.getCriterioDeAhorro();
    	newState.setCriterioDeAhorro(cda);
    	
    	newState.setFactorDeAumento(this.getFactorDeAumento());
    	
        return newState;
    }

    

	/**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
    	
    	AgentedeComprasPerception percepcion = (AgentedeComprasPerception) p;
    	Celda c = percepcion.getestadocelda();
    	double f = percepcion.getFactorDeAumento();
    	
    	
    	if(!this.matrizMapa[this.posActual.getFila()][this.posActual.getColumna()].equals(c)) { //si la celda en la que estoy parado no es igual a la del ambiente actualizo
    		this.matrizMapa[this.posActual.getFila()][this.posActual.getColumna()] = c;
    	}
    	this.setSupermercadosDisponibles(percepcion.getSupermercadosDisponibles()); //actualizo mi lista de supermercados
    	this.factorDeAumento=f;
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
    	//ESTADO INICIAL DEL AGENTE
    	
    	//POSACTUAL
    	posActual = new Coordenadas(0,0);
    	//PRODUCTOS A COMPRAR
    	listaProductos = new ArrayList<String>();
    	//listaProductos.add("P1"); 
    	listaProductos.add("P2"); 
    	listaProductos.add("P3"); 
    	//listaProductos.add("P4"); 
    	//listaProductos.add("P5");
    	//listaProductos.add("P6");
    	//listaProductos.add("P7");
    	//listaProductos.add("P8");
    	listaProductos.add("P9"); 
		//SUPERMERCADOS DISPONIBLES
    	ArrayList<Producto> listaProd1 = new ArrayList<Producto>();
    	listaProd1.add(new Producto("P1", 5.0));
    	listaProd1.add(new Producto("P2", 60.0));
    	listaProd1.add(new Producto("P4", 80.0));
    	listaProd1.add(new Producto("P6", 40.0));
    	Supermercado S1 = new Supermercado ("S1", new Coordenadas(1,0),true, listaProd1);
    	ArrayList<Producto> listaProd2 = new ArrayList<Producto>();
    	listaProd2.add(new Producto("P1", 10.0));
    	listaProd2.add(new Producto("P2", 10.0));
    	listaProd2.add(new Producto("P5", 5.0));
    	listaProd2.add(new Producto("P6", 40.0));
    	listaProd2.add(new Producto("P10", 35.0));
    	Supermercado S2 = new Supermercado ("S2", new Coordenadas(1,3),true, listaProd2);
    	ArrayList<Producto> listaProd3 = new ArrayList<Producto>();
    	listaProd3.add(new Producto("P1", 12.0));
    	listaProd3.add(new Producto("P3", 10.0));
    	listaProd3.add(new Producto("P5", 15.0));
    	listaProd3.add(new Producto("P7", 10.0));
    	listaProd3.add(new Producto("P8", 10.0));
    	Supermercado S3 = new Supermercado ("S3", new Coordenadas(2,2),true, listaProd3);
    	this.supermercadosDisponibles = new ArrayList<Supermercado>();
    	this.supermercadosDisponibles.add(S1);
    	this.supermercadosDisponibles.add(S2);
    	this.supermercadosDisponibles.add(S3);
		//TIPO DE VEHICULO
		tipoVehiculo = TipoVehiculo.AUTO;
		//CRITERIO DE AHORRO
		criterioDeAhorro = CriterioDeAhorro.DINERO;
		//FACTOR DE AUMENTO
		factorDeAumento=1.0;
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        str+="Posicion ("+this.posActual.getFila()+","+this.posActual.getColumna()+")\n";
        str+="Cantidad de productos a comprar "+this.listaProductos.size();
        str+=" Factor de aumento: "+this.getFactorDeAumento();
        //str+=" Costo acumulado: "+this.getCostoAcumulado();
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
    	//boolean mismoCostoAcumulado = this.getCostoAcumulado() == e.getCostoAcumulado();
    	
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
    	
    	
    	
    	boolean mismoMapa = true;
    	for(int i=0;i<matrizMapa.length;i++) {
    		for(int j=0;j<matrizMapa[i].length;j++) {
    			if(matrizMapa.equals(e.getMatrizMapa()[i][j])) //se asume que ambas matrices son del mismo tamañp
    				mismoMapa=false;
    				
    		}
    	}
    	
    	boolean mismoCriterio = this.getCriterioDeAhorro() == e.getCriterioDeAhorro();
    	boolean mismoFactorDeAumento = this.factorDeAumento == e.getFactorDeAumento();
    	
    	
    	
    	//System.out.println("MISMO ESTADO: "+mismaPosicion+" "+ mismoTipoVehiculo +" "+ mismoCostoAcumulado +" "+ mismosProductos +" "+ mismosSupermercados);
    	return (mismaPosicion && mismoTipoVehiculo && /*mismoCostoAcumulado &&*/ mismosProductos && mismosSupermercados && mismoMapa && mismoCriterio && mismoFactorDeAumento );
       
        
    	
        
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
        this.listaProductos = arg;
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
   /* public void setCostoAcumulado(Double arg) {
    	this.costoAcumulado=arg;
    }
    public Double getCostoAcumulado() {
    	return this.costoAcumulado;
    }*/

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

	public Celda[][] getMatrizMapa() {
		return matrizMapa;
	}

	public void setMatrizMapa(Celda[][] matrizMapa) {
		this.matrizMapa = matrizMapa;
	}

	public CriterioDeAhorro getCriterioDeAhorro() {
		return criterioDeAhorro;
	}

	public void setCriterioDeAhorro(CriterioDeAhorro criterioDeAhorro) {
		this.criterioDeAhorro = criterioDeAhorro;
	}

	public double getFactorDeAumento() {
		return factorDeAumento;
	}

	public void setFactorDeAumento(double factorDeAumento) {
		this.factorDeAumento = factorDeAumento;
	} 
	
	
	
}

