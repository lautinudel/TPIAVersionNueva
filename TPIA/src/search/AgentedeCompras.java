package search;

import actions.AvanzarArriba;
import actions.AvanzarIzquierda;
import actions.AvanzarDerecha;
import actions.AvanzarAbajo;
import actions.Comprar;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.search.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;

public class AgentedeCompras extends SearchBasedAgent {
	

    public AgentedeCompras() {

        // The Agent Goal
        ObjetivoAgente agGoal = new ObjetivoAgente();

        // The Agent State
        EstadoAgente agState = new EstadoAgente();
        this.setAgentState(agState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
    	operators.addElement(new Comprar());
        operators.addElement(new AvanzarDerecha());
        operators.addElement(new AvanzarAbajo()); 
        operators.addElement(new AvanzarArriba());
        operators.addElement(new AvanzarIzquierda());
        
        	
         

        // Create the Problem which the agent will resolve
        Problem problem = new Problem(agGoal, agState, operators);
        this.setProblem(problem);
    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {

        // Create the search strategy
        //DepthFirstSearch strategy = new DepthFirstSearch(); //PROFUNDIDAD         
        //BreathFirstSearch strategy = new BreathFirstSearch(); //AMPLITUD
        //UniformCostSearch strategy = new UniformCostSearch(new CostFunction()); //COSTO UNIFORME
    	GreedySearch strategy = new GreedySearch(new Heuristic()); //AVARA
        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);
        
        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        //searchSolver.setVisibleTree(Search.GRAPHVIZ_TREE);
        searchSolver.setVisibleTree(Search.EFAIA_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(AgentedeCompras.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;

    }

    /**
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}
