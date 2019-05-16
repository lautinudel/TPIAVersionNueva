package pacmandemo;
// PacmanDemo.java

import java.awt.*;
import javax.swing.*;

import calculador.Calculador;
import calculador.Pair;
import no.geosoft.cc.graphics.*;
import java.util.Vector;

/**
 * Esta aplicación fue desarrollada para la cátedra Inteligencia Artificial
 * de la Universidad Tecnológica Nacional - Facultad Regional Santa Fe.<br>
 * La misma tiene como objetivo realizar una simulación del juego Pacman. 
 * Recibe como entrada el estado inicial del ambiente en el cual se desenvuelve 
 * el Pacman y una lista de acciones que deben ser ejecutadas por el mismo.<br><br>
 * 
 * La aplicación fue desarrollada utilizando la librería de gráficos
 * para Java G (http://geosoft.no/graphics/index.html)
 * 
 * @author Ma. de los Milagros Gutierrez 
 * @author Georgina Stegmayer
 * @author Jorge M. Roa
 * @author CIDISI -  Centro de Investigación y Desarrollo de Ingeniería en Sistemas de Información (http://cidisi.frsf.utn.edu.ar)
 * @author UTN - FRSF
 * @version 1.0
 * 
 */
public class PacmanDemo extends JFrame
  implements GInteraction {
  /** 
   * Punto de entrada a la clase y a la aplicación
   */	
  
  static final long serialVersionUID=1;
	
  /** Estado del pacman */
  private PacmanState  pacmanState_;
  
  /** Lista de acciones que debe ejecutar el pacman */
  private String[] actions_;
  
  /** Indica el índice de la siguiente acción a ejecutar */
  private int actionIndex_;
  
  /** Vista del ambiente en el cual se desenvuelve el pacman */
  private PacmanBoard pacmanBoard_;
  
  /** Vista del puntaje asociado a la comida y de los enemigos muertos por el pacman */
  private PacmanScore pacmanScore_;
  
  /** Vista de las acciones que va ejecutando el pacman */
  private PacmanActions pacmanActions_;
  
  /** Vista del título del simulador (cabecera) */
  private PacmanTitle pacmanTitle_;
  
  private static int BOARD_SIZE=4; 
  
  /**
   * <b>True:</b> La simulación se realiza mediante clics del mouse<br>
   * <b>False:</b> La simulación se realiza automáticamente */
  private boolean gameDebug_;
  
  /** 
   * Crea una instancia del simulador PacmanDemo.<br>
   * @param boardSize determina el tamaño del tablero<br>
   * @param enemies array de Nx2 que contiene las posiciones de los enemigos<br>
   * 		el primer elemento indica el enemigo, mientras que el segundo indica la 
   * 		coordenada x,y. En el siguiente ejemplo hay enemigos en las coordenadas
   * 		(0,0) - (1,3) - (2,0) - (3,1). Ej:<br>   
   * 		enemies[0][0]=0;enemies[0][1]=0;<br>
   * 		enemies[1][0]=1;enemies[1][1]=3;<br>
   *		enemies[2][0]=2;enemies[2][1]=0;<br>
   *		enemies[3][0]=3;enemies[3][1]=1;<br>
   * @param enemies array de Nx2 que contiene las posiciones de los enemigos
   * 		el primer elemento indica el enemigo, mientras que el segundo indica la 
   * 		coordenada x,y. En el siguiente ejemplo hay enemigos en las coordenadas
   * 		(0,0) - (0,1) - (2,3) - (1,3). Ej:<br>   
   *		food[0][0]=0;food[0][1]=0;<br>
   *		food[1][0]=0;food[1][1]=1;<br>
   *	    food[2][0]=2;food[2][1]=3;<br>
   *	    food[3][0]=1;food[3][1]=3;<br>
   * @param pacmanX indica la columna inicial del pacman<br>
   * @param pacmanY indica la fila inicial del pacman<br>
   * @param actions lista de acciones que debe ejeuctar el pacman<br>
   * @param gameDebug<br>    
   * 		<i>True:</i> Modo DEBUG. La simulación se realiza mediante clics del mouse<br>
   * 		<i>False:</i> Modo NO DEBUG. La simulación se realiza automáticamente
   * 
   **/
  public PacmanDemo (Calculador calculador, String[] actions, boolean gameDebug)
  {
    super ("UTN - FRSF - Inteligencia Artificial - Pacman Demo");
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    
    JPanel topLevel = new JPanel();
    
    topLevel.setLayout (new BorderLayout());
    getContentPane().add (topLevel);        

    GWindow window = new GWindow (new Color (0, 0, 0));
    topLevel.add (window.getCanvas(), BorderLayout.CENTER);
    
    // Se crea la escena
    GScene scene = new GScene (window);
    double w0[] = {0.0,              0.0,             0.0};
    double w1[] = {BOARD_SIZE + 2.0,  0.0,             0.0};
    double w2[] = {0.0,              BOARD_SIZE + 2.0, 0.0};
    scene.setWorldExtent (w0, w1, w2);

    actionIndex_ = 0;
    this.actions_ = actions;
    
    this.gameDebug_ = gameDebug;
    
//    this.setIconImage(new Image("pacman2.ico"));
    this.setResizable(false);
    

    // Obtiene la posición incial del pacman desde el "Calculador".
	int pacmanX = calculador.getPosicionInicial().x()-1;
	int pacmanY = calculador.getPosicionInicial().y()-1;
	
	// Obtiene la comida incial desde el "Calculador".
	Vector comida = calculador.inicializarComida();
	int[][] food = new int[comida.size()][2];
	
	for (int i=0;i<comida.size();i++){
		food[i][0]=((Pair)comida.elementAt(i)).x()-1;
		food[i][1]=((Pair)comida.elementAt(i)).y()-1;
	}

	// Obtiene los enemigos inciales desde el "Calculador".
	Vector enemigos = calculador.inicializarEnemigo();
	int[][] enemies = new int[enemigos.size()][2];
	
	for (int i=0;i<enemigos.size();i++){
		enemies[i][0]=((Pair)enemigos.elementAt(i)).x()-1;
		enemies[i][1]=((Pair)enemigos.elementAt(i)).y()-1;
	}

    // Crea el estado del pacman y la representación gráfica
    pacmanState_ = new PacmanState (BOARD_SIZE, enemies, food, pacmanX, pacmanY);
    pacmanBoard_ = new PacmanBoard(pacmanState_);
    scene.add (pacmanBoard_);
    pacmanActions_ = new PacmanActions(pacmanState_);
    scene.add (pacmanActions_);
    pacmanScore_ = new PacmanScore(pacmanState_);
    scene.add (pacmanScore_);
    pacmanTitle_ = new PacmanTitle(pacmanState_);
    scene.add (pacmanTitle_);

    pack();
    setSize (new Dimension (800, 600));
    setVisible (true);
    
    // Si no es necesario ir paso a paso, entonces simular.- 
    if (!gameDebug){
//    	while (true){
    		play();
/*    		// Reinicializo la simulación.-
    	    pacmanState_ = new PacmanState (BOARD_SIZE, enemies, food, pacmanX, pacmanY);
    	    scene.removeAll();
    	    pacmanBoard_ = new PacmanBoard(pacmanState_);
    	    scene.add (pacmanBoard_);
    	    pacmanActions_ = new PacmanActions(pacmanState_);
    	    scene.add (pacmanActions_);
    	    pacmanScore_ = new PacmanScore(pacmanState_);
    	    scene.add (pacmanScore_);
    	    pacmanTitle_ = new PacmanTitle(pacmanState_);
    	    scene.add (pacmanTitle_);
    	}*/
    }
    
    // Make sure plot can be scrolled
    window.startInteraction (this);
  }
  
  /**
   * Inicia la simulación del pacman en modo NO DEBUG.
   * Realiza una iteración a través de las acciones del pacman y las va ejecutando.
   * Con cada acción ejecutada efectúa una demora de 1 segundo y ejecuta la 
   * siguiente acción. Luego actualiza la vista del simulador.
   */
  public void play(){
	  for (int i=0; i<actions_.length; i++){
		  try {
			  Thread.sleep(1000);	//Demora 1 segundo.-
			}
			catch(InterruptedException ex) {
			}
		  if (actions_[i].toLowerCase().equals("arriba")){
		    pacmanState_.up();
		  }
		  else if (actions_[i].toLowerCase().equals("izquierda")){
			  pacmanState_.left();
		  }
		  else if (actions_[i].toLowerCase().equals("abajo")){
			  pacmanState_.down();
		  }
		  else if (actions_[i].toLowerCase().equals("derecha")){
			  pacmanState_.right();
		  }
		  else if (actions_[i].toLowerCase().equals("comer")){
			  pacmanState_.eat();
		  }
		  else if (actions_[i].toLowerCase().equals("pelear")){
			  pacmanState_.fight();
		  }
		  // Incrementa el índice de las acciones
		  actionIndex_++;
		  
		  // Actualiza la vista del simulador
		  pacmanBoard_.redraw();
		  pacmanBoard_.refresh();
		  pacmanScore_.redraw();
		  pacmanScore_.refresh();
		  pacmanActions_.redraw();
		  pacmanActions_.refresh();
		  pacmanTitle_.redraw();
		  pacmanTitle_.refresh();
	  }
  }
  
  /**
   * Permite detectar los eventos que ocurren en el ambiente.
   * Si se realiza clic con el mouse, ejecuta la siguiente acción.
   */
  public void event (GScene scene, int event, int x, int y)
  {
    if (scene == null) return;

    GObject interaction = scene.find ("interaction");
    if (interaction == null) {
      interaction = new GObject ("interaction");
      scene.add (interaction);
    }

    interaction.removeSegments();

    switch (event) {
      case GWindow.BUTTON1_UP :
    	  if (gameDebug_){
	    	  if (actionIndex_<actions_.length){
				  if (actions_[actionIndex_]== "ARRIBA"){
					    pacmanState_.up();
					  }
				  else if (actions_[actionIndex_].toLowerCase().equals("izquierda")){
					  pacmanState_.left();
				  }
				  else if (actions_[actionIndex_].toLowerCase().equals("abajo")){
					  pacmanState_.down();
				  }
				  else if (actions_[actionIndex_].toLowerCase().equals("derecha")){
					  pacmanState_.right();
				  }
				  else if (actions_[actionIndex_].toLowerCase().equals("comer")){
					  pacmanState_.eat();
				  }
				  else if (actions_[actionIndex_].toLowerCase().equals("pelear")){
					  pacmanState_.fight();
				  }
				  actionIndex_++;
	    	  }
    	  }
    }
    scene.redraw();
    scene.refresh();    
  }


  /**
   * Crea una instancia de PacmanDemo e inicializa el estado del ambiente 
   * y del pacman.
   */
  public static void main (String[] args)
  {
/*    int boardSize = 4;
    
    int pacmanX = 0;
    int pacmanY = 0;
    
    int[][] food = new int[10][2];
    food[0][0]=0;food[0][1]=0;
    food[1][0]=0;food[1][1]=1;
    food[2][0]=2;food[2][1]=3;
    food[3][0]=1;food[3][1]=3;
    food[4][0]=3;food[4][1]=2;
    food[5][0]=3;food[5][1]=0;
    food[6][0]=2;food[6][1]=1;
    food[7][0]=0;food[7][1]=2;
    food[8][0]=0;food[8][1]=3;
    food[9][0]=1;food[9][1]=2;
*/
/*    int[][] enemies = new int[4][2];
    enemies[0][0]=0;enemies[0][1]=0;
    enemies[1][0]=1;enemies[1][1]=3;
    enemies[2][0]=2;enemies[2][1]=0;
    enemies[3][0]=3;enemies[3][1]=1;
//    enemies[4][0]=2;enemies[4][1]=1;
*/
    String[] actions = new String[32];
    actions[0]="COMER";
    actions[1]="PELEAR";
    actions[2]="IZQUIERDA";
    actions[3]="COMER";
    actions[4]="IZQUIERDA";
    actions[5]="COMER";
    actions[6]="IZQUIERDA";
    actions[7]="COMER";
    actions[8]="ABAJO";
    
    actions[9]="DERECHA";
    actions[10]="COMER";
    actions[11]="DERECHA";
    actions[12]="PELEAR";
    actions[13]="COMER";

    actions[14]="ARRIBA";
    
    actions[15]="ARRIBA";
    
    actions[16]="IZQUIERDA";
    actions[17]="COMER";
    actions[18]="IZQUIERDA";
    actions[19]="PELEAR";
    actions[20]="IZQUIERDA";
    actions[21]="COMER";
    actions[22]="ARRIBA";
    
    actions[23]="PELEAR";
    actions[24]="DERECHA";
    actions[25]="COMER";
    actions[26]="DERECHA";
    actions[27]="DERECHA";
    actions[28]="COMER";

    actions[29]="IZQUIERDA";
    actions[30]="IZQUIERDA";
    actions[31]="ARRIBA";
    

	Calculador calculador = new Calculador();

	new PacmanDemo (calculador, actions, false);
  }
}
