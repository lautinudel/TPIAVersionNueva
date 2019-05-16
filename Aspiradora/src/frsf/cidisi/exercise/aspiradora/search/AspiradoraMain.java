package frsf.cidisi.exercise.aspiradora.search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AspiradoraMain {

    public static void main(String[] args) throws PrologConnectorException {
        Aspiradora agent = new Aspiradora();

        AmbienteAspiradora environment = new AmbienteAspiradora();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
