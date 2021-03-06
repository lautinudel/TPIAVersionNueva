package search;

import java.util.ArrayList;

import domain.Celda;
import domain.Coordenadas;
import domain.Producto;
import domain.Supermercado;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
	
    private Coordenadas posAgente;
    private double factorDeAumento;
    //Matriz hasta Hernandarias
    private Celda[][] matrizMapa = 
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
    };
    
    //Matriz de ejemplo
    /*private Celda[][] matrizMapa = 
    	{{new Celda (false,true,false,false),new Celda (false,true,true,false),new Celda (false,false,true,false),new Celda (false,true,true,false)},
    	{new Celda (true,true,false,true), new Celda (false,true,false,true),new Celda (true,false,false,true),new Celda (false,true,false,false)},
    	{new Celda (true,false,false,false), new Celda (false,false,true,false), new Celda (true,false,true,false), new Celda (false,false,true,false)}};*/
    private ArrayList <Supermercado> listaDeSupermercados;
	
    public EstadoAmbiente() {
			 posAgente = new Coordenadas();
			 listaDeSupermercados = new ArrayList <Supermercado>();
			 
        this.initState();
    }

    

	/**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

    	//POSACTUAL
    	posAgente = new Coordenadas(8,5);
    	//FACTOR DE AUMENTO
    	this.factorDeAumento=1.0;
    	ArrayList<Producto> listaProd1 = new ArrayList<Producto>();
    	listaProd1.add(new Producto("P1", 1.0));
    	listaProd1.add(new Producto("P2", 3.0));
    	listaProd1.add(new Producto("P3", 7.0));
    	listaProd1.add(new Producto("P4", 5.0));
    	listaProd1.add(new Producto("P6", 6.0));
    	//SUPERMERCADOS DISPONIBLES
    	Supermercado S1 = new Supermercado ("S1", new Coordenadas(1,0),true, listaProd1);
    	ArrayList<Producto> listaProd2 = new ArrayList<Producto>();
    	listaProd2.add(new Producto("P1", 8.0));
    	listaProd2.add(new Producto("P2", 4.0));
    	listaProd2.add(new Producto("P5", 1.0));
    	listaProd2.add(new Producto("P6", 3.0));
    	listaProd2.add(new Producto("P9", 6.0));
    	Supermercado S2 = new Supermercado ("S2", new Coordenadas(8,0),true, listaProd2);
    	ArrayList<Producto> listaProd3 = new ArrayList<Producto>();
    	listaProd3.add(new Producto("P1", 7.0));
    	listaProd3.add(new Producto("P2", 2.0));
    	listaProd3.add(new Producto("P5", 2.0));
    	listaProd3.add(new Producto("P7", 1.0));
    	listaProd3.add(new Producto("P8", 3.0));
    	Supermercado S3 = new Supermercado ("S3", new Coordenadas(10,4),true, listaProd3);
    	this.listaDeSupermercados = new ArrayList<Supermercado>();
    	this.listaDeSupermercados.add(S1);
    	this.listaDeSupermercados.add(S2);
    	this.listaDeSupermercados.add(S3);
    	
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        str += "Posici�n del agente: ";
        str += getposAgente().toString(); 
        str += "}";
        str += "Factor de aumento: "+this.getFactorDeAumento();

        return str;
    }

	
     public Coordenadas getposAgente(){
        return posAgente;
     }
     public void setposAgente(Coordenadas arg){
       posAgente = arg;
     }
     public Celda[][] getmatrizMapa(){
        return matrizMapa;
     }
     public void setmatrizMapa(Celda[][] arg){
        matrizMapa = arg;
     }
     public ArrayList<Supermercado> getListaDeSupermercados() {
 		return listaDeSupermercados;
 	 }

 	public void setListaDeSupermercados(ArrayList<Supermercado> listaDeSupermercados) {
 		this.listaDeSupermercados = listaDeSupermercados;
 	 }

	public double getFactorDeAumento() {
		return factorDeAumento;
	}

	public void setFactorDeAumento(double factorDeAumento) {
		this.factorDeAumento = factorDeAumento;
	}
	

}

