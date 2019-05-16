package pacmandemo;
// PacmanState.java

/**
 * Esta aplicaci�n fue desarrollada para la c�tedra Inteligencia Artificial
 * de la Universidad Tecnol�gica Nacional - Facultad Regional Santa Fe.<br>
 * La misma tiene como objetivo realizar una simulaci�n del juego Pacman. 
 * Recibe como entrada el estado inicial del ambiente en el cual se desenvuelve 
 * el Pacman y una lista de acciones que deben ser ejecutadas por el mismo.<br><br>
 * 
 * La aplicaci�n fue desarrollada utilizando la librer�a de gr�ficos
 * para Java G (http://geosoft.no/graphics/index.html)
 * 
 * @author Ma. de los Milagros Gutierrez 
 * @author Georgina Stegmayer
  * @author Jorge M. Roa
 * @author CIDISI -  Centro de Investigaci�n y Desarrollo de Ingenier�a en Sistemas de Informaci�n (http://cidisi.frsf.utn.edu.ar)
 * @author UTN - FRSF
 * @version 1.0
 * 
 */

class PacmanState {
	
	/** Indica el tama�o del tablero*/
	private int		size_;
	
	/** Es un array que almacena en cada coordenada x,y 3 elementos:<br>
	 * state_[][][0]: Pacman, enemigo y/o fruta<br>
	 * state_[][][1]: Imagen del enemigo<br>
	 * state_[][][2]: Imagen de la comida */
    private int[][][]	state_;

	/** Fila en la que se encuentra el pacman*/
    private int 	pacmanX;

    /** columna en la que se encuentra el pacman*/
    private int		pacmanY;
    
	/** �ltima acci�n ejecutada por el pacman*/
    private String	lastAction_;
    
   /** Permite llevar un conteo de la cantidad de frutas consumidas */
    private int[] 	contFood_;
    
    /** Permite llevar un conteo de la cantidad de enemigos matados */
    private int 	contEnemies_;
    
    /** Permite indicar que una celda est� desocupada */
    final static int EMPTY = 0; 
    /** Permite indicar que en una celda est� el pacman */
    final static int PACMAN = 1; 
    /** Permite indicar que en una celda hay un enemigo */
    final static int ENEMY = 2; 
    /** Permite indicar que en una celda hay comida */
    final static int FOOD = 3; 
    /** Permite indicar que en una celda est� el pacman y hay un enemigo */
    final static int PACMAN_ENEMY = 4; 
    /** Permite indicar que en una celda est� el pacman y hay comida */
    final static int PACMAN_FOOD = 5; 
    /** Permite indicar que en una celda hay un enemigo y hay comida */
    final static int ENEMY_FOOD = 6; 
    /** Permite indicar que en una celda est� el pacman, hay un enemigo y hay comida */
    final static int PACMAN_ENEMY_FOOD = 7; 

    /**
    * Crea una nueva instancia del estado del pacman.
    * @param size tama�o del tablero en el cual se desenvuelve el agente
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
	* 
	**/
    public PacmanState (int size, int[][] enemies, int[][] food, int pacmanX, int pacmanY)
    {
	size_ = size;
	lastAction_ = "";
	
	this.pacmanX = pacmanX;
	this.pacmanY = pacmanY;

	state_ = new int[size_][size_][3];
	//initialState_ = new int[size_][size_][3];
	for (int i = 0; i < state_.length; i++)
	    for (int j = 0; j < state_.length; j++){
	    	state_[i][j][0] = PacmanState.EMPTY;	//�ndice pacman, enemigo y/o fruta
	    	state_[i][j][1] = PacmanState.EMPTY;	//�ndice imagen enemigo
	    	state_[i][j][2] = PacmanState.EMPTY;	//�ndice imagen comida
	    }

	
	contFood_ = new int[8];
	for (int i = 0; i < contFood_.length; i++)
	  	  contFood_[i] = 0;
	
	contEnemies_ = 0;

	state_[pacmanX][pacmanY][0] = PacmanState.PACMAN;

	for (int i = 0; i < enemies.length; i++){
		state_[enemies[i][0]][enemies[i][1]][0] = calculateStateEnemies(state_[enemies[i][0]][enemies[i][1]][0]);
		state_[enemies[i][0]][enemies[i][1]][1] = new Double(Math.random()*4).intValue();
	}
	
	for (int i = 0; i < food.length; i++){
		state_[food[i][0]][food[i][1]][0] = calculateStateFood(state_[food[i][0]][food[i][1]][0]);
		state_[food[i][0]][food[i][1]][2] = new Double(Math.random()*8).intValue();
	}
	
    }
    
    /**
     * Calcula el nuevo estado de la celda luego de ejecutar una acci�n sobre un enemigo
     * @param state entero que indica el estado actual de la celda
     * @return entero que indica el nuevo estado de la celda
     */
    private int calculateStateEnemies(int state){
    	int s=0;
    	switch (state){
    	case PacmanState.EMPTY:
    		s=PacmanState.ENEMY;
    		break;
    	case PacmanState.PACMAN:
    		s=PacmanState.PACMAN_ENEMY;
    		break;
    	case PacmanState.FOOD:
    		s=PacmanState.ENEMY_FOOD;
    		break;
    	case PacmanState.PACMAN_FOOD:
    		s=PacmanState.PACMAN_ENEMY_FOOD;
    		break;
    	case PacmanState.PACMAN_ENEMY:
    		s=PacmanState.PACMAN;
    		break;
    	case PacmanState.PACMAN_ENEMY_FOOD:
    		s=PacmanState.PACMAN_FOOD;
    		break;
    	}
    	return s;
    }

    /**
     * Calcula el nuevo estado de la celda luego de ejecutar una acci�n sobre comida
     * @param state entero que indica el estado actual de la celda
     * @return entero que indica el nuevo estado de la celda
     */
    private int calculateStateFood(int state){
    	int s=0;
    	switch (state){
    	case PacmanState.EMPTY:
    		s=PacmanState.FOOD;
    		break;
    	case PacmanState.PACMAN:
    		s=PacmanState.PACMAN_FOOD;
    		break;
    	case PacmanState.ENEMY:
    		s=PacmanState.ENEMY_FOOD;
    		break;
    	case PacmanState.PACMAN_ENEMY:
    		s=PacmanState.PACMAN_ENEMY_FOOD;
    		break;
    	case PacmanState.PACMAN_FOOD:
    		s=PacmanState.PACMAN;
    		break;
    	case PacmanState.PACMAN_ENEMY_FOOD:
    		s=PacmanState.PACMAN_ENEMY;
    		break;
    	}
    	
    	return s;
    }

    /**
     * Calcula el nuevo estado de la celda luego de ejecutar una acci�n sobre el pacman
     * @param state entero que indica el estado actual de la celda
     * @return entero que indica el nuevo estado de la celda
     */
    private int calculateStatePacman(int state){
    	int s=0;
    	switch (state){
    	case PacmanState.EMPTY:
    		s=PacmanState.PACMAN;
    		break;
    	case PacmanState.PACMAN:
    		s=PacmanState.EMPTY;
    		break;
    	case PacmanState.ENEMY:
    		s=PacmanState.PACMAN_ENEMY;
    		break;
    	case PacmanState.FOOD:
    		s=PacmanState.PACMAN_FOOD;
    		break;
    	case PacmanState.PACMAN_ENEMY:
    		s=PacmanState.ENEMY;
    		break;
    	case PacmanState.PACMAN_FOOD:
    		s=PacmanState.FOOD;
    		break;
    	case PacmanState.ENEMY_FOOD:
    		s=PacmanState.PACMAN_ENEMY_FOOD;
    		break;
    	case PacmanState.PACMAN_ENEMY_FOOD:
    		s=PacmanState.ENEMY_FOOD;
    		break;
    	}
    	
    	return s;
    }

    /**
     * devuelve el tama�o del tablero
     * @return entero que representa el tama�o del tablero 
     */
    public int getSize()
    {
      return size_;
    }
    

    /**
     * 
     * @return array que representa el estado del pacman
     */
    public int[][][] getState()
    {
      return state_;
    }

    /**
     * 
     * @return devuelve la �ltima acci�n ejecutada
     */
    public String getLastAction()
    {
      return lastAction_;
    }

    /**
     * devuelve la cantidad de comida del tipo indicado en el par�metro idx 
     * @param idx entero que indica el tipo de comida
     * @return entero que indica la cantida de comida
     */
    public int getContFood(int idx)
    {
      return contFood_[idx];
    }

    /**
     * 
     * @return cantidad de enemigos muertos
     */
    public int getContEnemies()
    {
      return contEnemies_;
    }
    
    /**
     * setea la �ltima acci�n ejecutada
     * @param action acci�n
     */
    public void setLastAction(String action)
    {
      lastAction_ = action;
    }
    
    /**
     * ejecuta la acci�n "arriba" y actualiza el ambiente 
     */
    public void up(){
		state_[pacmanX][pacmanY][0]=calculateStatePacman(state_[pacmanX][pacmanY][0]);

		if (pacmanX==0)
    		pacmanX=3;
    	else
    		pacmanX--;
		
		state_[pacmanX][pacmanY][0]=calculateStatePacman(state_[pacmanX][pacmanY][0]);
		lastAction_ = "arriba";
    }

    /**
     * ejecuta la acci�n "izquierda" y actualiza el ambiente 
     */
    public void left(){
		state_[pacmanX][pacmanY][0]=calculateStatePacman(state_[pacmanX][pacmanY][0]);

		if (pacmanY==0)
    		pacmanY=3;
    	else
    		pacmanY--;
		
		state_[pacmanX][pacmanY][0]=calculateStatePacman(state_[pacmanX][pacmanY][0]);
    	
		lastAction_ = "izquierda";
    }

    /**
     * ejecuta la acci�n "abajo" y actualiza el ambiente 
     */
    public void down(){
		state_[pacmanX][pacmanY][0]=calculateStatePacman(state_[pacmanX][pacmanY][0]);

		if (pacmanX==3)
    		pacmanX=0;
    	else
    		pacmanX++;
		
		state_[pacmanX][pacmanY][0]=calculateStatePacman(state_[pacmanX][pacmanY][0]);
		lastAction_ = "abajo";
    }

    /**
     * ejecuta la acci�n "derecha" y actualiza el ambiente 
     */
    public void right(){
		state_[pacmanX][pacmanY][0]=calculateStatePacman(state_[pacmanX][pacmanY][0]);

		if (pacmanY==3)
    		pacmanY=0;
    	else
    		pacmanY++;
		
		state_[pacmanX][pacmanY][0]=calculateStatePacman(state_[pacmanX][pacmanY][0]);
		lastAction_ = "derecha";
    }

    /**
     * ejecuta la acci�n "comer" y actualiza el ambiente 
     */
    public void eat(){
    	if (puedeComer(pacmanX,pacmanY)){
	    	state_[pacmanX][pacmanY][0]=calculateStateFood(state_[pacmanX][pacmanY][0]);
			lastAction_ = "comer";
			//Actualizo el contador de las frutas.-
			contFood_[state_[pacmanX][pacmanY][2]]++;
    	}
    }

    /**
     * ejecuta la acci�n "pelear" y actualiza el ambiente 
     */
    public void fight(){
    	if (puedePelear(pacmanX,pacmanY)){
	    	state_[pacmanX][pacmanY][0]=calculateStateEnemies(state_[pacmanX][pacmanY][0]);
			lastAction_ = "pelear";
			contEnemies_++;
    	}
    }
    
    /**
     * determina si hay comida en la posici�n x,y 
     * @param pacmanX 
     * @param pacmanY
     * @return 	true: si hay comida en la celda<br>
     * 			false: si no hay comida en la celda
     */
    private boolean puedeComer(int pacmanX, int pacmanY){
    	boolean v = false;
    	
    	v = state_[pacmanX][pacmanY][0]==PacmanState.PACMAN_FOOD; 
    	v = v | state_[pacmanX][pacmanY][0]==PacmanState.PACMAN_ENEMY_FOOD; 
    	
    	return v;
    }

    /**
     * determina si hay un enemigo en la posici�n x,y
     * @param pacmanX
     * @param pacmanY
     * @return 	true: si hay un enemigo en la celda<br>
     * 			false: si no hay un enemigo en la celda
     */
    private boolean puedePelear(int pacmanX, int pacmanY){
    	boolean v = false;
    	
    	v = state_[pacmanX][pacmanY][0]==PacmanState.PACMAN_ENEMY; 
    	v = v | state_[pacmanX][pacmanY][0]==PacmanState.PACMAN_ENEMY_FOOD; 
    	
    	return v;
    }
}
