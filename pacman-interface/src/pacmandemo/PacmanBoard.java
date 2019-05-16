package pacmandemo;
// PacmanBoard.java
import no.geosoft.cc.geometry.Geometry;
import no.geosoft.cc.graphics.*;

import java.util.List;
import java.awt.*;
import java.util.ArrayList;

import java.io.File;

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


  class PacmanBoard extends GObject{
  /** 
   * Vista del ambiente en el que se desenvuelve el pacman 
   */
	  
    /** Segmento que representa el tablero */
	private GSegment    board_;
	
    /** Segmentos que conforman la grilla */
    private GSegment[]  grid_;
    
    /** Lista de piezas que integran el tablero (Pacman, comida, fantasmas) */
    private List        pieces_;
    
    /** Estilo de las piezas del tablero */
    private GStyle[]    pieceStyle_;

    /** Pieza que permite realizar el sprite del pacman */
//    private GSegment variablePiece;
   	
    /** Estado del pacman */
   	private PacmanState  pacmanState_;
    
    /** Crea una instancia del ambiente en el cual se desenvuelve el pacman.<br>
    * @param pacmanState es el estado del pacman<br>
    * */
    public PacmanBoard(PacmanState pacmanState)
    {
	  this.pacmanState_ = pacmanState;
	  
      board_ = new GSegment();

      GStyle boardStyle = new GStyle();
      boardStyle.setBackgroundColor (new Color (255, 251, 157));
      board_.setStyle (boardStyle);
      addSegment (board_);

      GStyle gridStyle = new GStyle();
      gridStyle.setForegroundColor (new Color (248, 196, 0));
      gridStyle.setLineWidth (2);
      grid_ = new GSegment[(pacmanState_.getSize() + 1) * 2];
      
      for (int i = 0; i < grid_.length; i++) {
        grid_[i] = new GSegment();
        grid_[i].setStyle (gridStyle);
        //grid_[i].setVertexImage(new GImage(new File("pac_left.gif"), GPosition.CENTER));
        addSegment (grid_[i]);
      }

      pieceStyle_ = new GStyle[2];
      pieceStyle_[0] = new GStyle();
      pieceStyle_[0].setForegroundColor (new Color (255, 251, 157));
      pieceStyle_[0].setBackgroundColor (new Color (255, 251, 157));

      pieceStyle_[1] = new GStyle();
      pieceStyle_[1].setForegroundColor (new Color (0, 200, 0));
      pieceStyle_[1].setBackgroundColor (new Color (0, 200, 0));

      pieces_ = new ArrayList();
    }

    /**
     * Setea el estado del pacman.
     * @param pacmanState estado del pacman
     */
    public void setState(PacmanState  pacmanState){
    	pacmanState_ = pacmanState;
    	//getWindow().redraw();
    	//draw();
    	//getWindow().refresh();
    }
    
    /**
     * Dibuja la vista del tablero y todo su contenido.
     */
    public void draw()
    {
      int size = pacmanState_.getSize();

      // Setea las dimensiones del tablero.
      board_.setGeometryXy (new double[] {1.5, 1.0,
                                          size + 1.5, 1.0,
                                          size + 1.5, size + 1.0,
                                          1.5, size + 1.0,
                                          1.5, 1.0});

      // Setea las dimensiones de los elementos que componene la grilla.
      for (int i = 0; i <= size; i++) {
        grid_[i*2 + 0].setGeometry (1.5, i + 1.0, size + 1.5, i + 1.0);
        grid_[i*2 + 1].setGeometry (i + 1.5, 1.0, i + 1.5, size + 1.0);
      }

      int[][][] state = pacmanState_.getState();
      int j = 0;
      double y =5.5;
      double x;
      // Recorre cada posición de la grilla y actualiza la vista
      for (int r = 0; r < state.length; r++) {
    	  y = y - 1;
    	  x = 1.0;
          for (int c = 0; c < state.length; c++) {
        	x = x + 1;
          int[] xy = getTransformer().worldToDevice (x, y);

          GSegment piece;
          if (j < pieces_.size()){
            piece = (GSegment) pieces_.get (j);
          }
          else {
            piece = new GSegment();
            pieces_.add (piece);
            addSegment (piece);
          }

          j++;
          
          piece.removeImages(); 
    	  piece.setStyle (pieceStyle_[0]);
          switch (state[r][c][0]){
          case PacmanState.PACMAN:
	          piece.addImage(new GImage(new File ("pacman.gif"),GPosition.CENTER));
	          break;
          case PacmanState.ENEMY:
	          piece.addImage(new GImage(new File ("fantasma"+state[r][c][1]+".gif"),GPosition.CENTER));
        	  break;
          case PacmanState.FOOD:
        	  piece.addImage(new GImage(new File ("comida"+state[r][c][2]+".gif"),GPosition.CENTER));
        	  break;
          case PacmanState.PACMAN_ENEMY:
	          piece.addImage(new GImage(new File ("fantasma"+state[r][c][1]+".gif"),GPosition.RIGHT));
	          piece.addImage(new GImage(new File ("pacman.gif"),GPosition.LEFT));
        	  break;
          case PacmanState.PACMAN_FOOD:
	          piece.addImage(new GImage(new File ("pacman.gif"),GPosition.LEFT));
	          piece.addImage(new GImage(new File ("comida"+state[r][c][2]+".gif"),GPosition.CENTER));
        	  break;
          case PacmanState.ENEMY_FOOD:
	          piece.addImage(new GImage(new File ("fantasma"+state[r][c][1]+".gif"),GPosition.RIGHT));
        	  piece.addImage(new GImage(new File ("comida"+state[r][c][2]+".gif"),GPosition.CENTER));
        	  break;
          case PacmanState.PACMAN_ENEMY_FOOD:
	          piece.addImage(new GImage(new File ("fantasma"+state[r][c][1]+".gif"),GPosition.RIGHT));
	          piece.addImage(new GImage(new File ("pacman.gif"),GPosition.LEFT));
        	  piece.addImage(new GImage(new File ("comida"+state[r][c][2]+".gif"),GPosition.CENTER));
        	  break;
	          }
	          piece.setGeometry (Geometry.createCircle (xy[0], xy[1], 5));
	      	          
          }
      }
    }
  }
  
