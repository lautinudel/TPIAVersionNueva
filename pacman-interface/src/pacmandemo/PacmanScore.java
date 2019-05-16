package pacmandemo;
// PacmanScore.java
import no.geosoft.cc.graphics.*;
import java.awt.*;
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

  class PacmanScore extends GObject
  {
  /** 
   * Vista de la acumulación de puntos que va obteniendo el pacman. 
   */
	  
	/** determina el estilo de los elementos que conforman la vista de las acciones. */
    private GStyle[]    pieceStyle_;

    /** contiene las partes estáticas de la vista de los elementos que consume el pacman */
    private GSegment  comidas_;

    /** contiene la vista del puntaje de los elementos que consume el pacman */
    private GSegment[]  puntajes_;
    
    /** estado del pacman. */
   	private PacmanState  pacmanState_;
    
    /**
     * Crea una nueva instancia de la vista de los puntajes del pacman
     * @param pacmanState_ estado del pacman.
     */
   	public PacmanScore(PacmanState pacmanState_)
    {
	  this.pacmanState_ = pacmanState_;
	  

      GStyle gridStyle = new GStyle();
      gridStyle.setForegroundColor (new Color (255, 0, 0));
      gridStyle.setLineWidth (2);

      pieceStyle_ = new GStyle[2];
      pieceStyle_[0] = new GStyle();
      pieceStyle_[0].setForegroundColor (new Color (0, 0, 0));
      pieceStyle_[0].setBackgroundColor (new Color (0, 0, 0));

      pieceStyle_[1] = new GStyle();
      pieceStyle_[1].setForegroundColor (new Color (0, 0, 0));
      //pieceStyle_[1].setBackgroundColor (new Color (0, 200, 0));
      pieceStyle_[1].setLineStyle(GStyle.LINESTYLE_INVISIBLE);
      pieceStyle_[1].setFont(new Font("courier new",Font.BOLD,30));

      comidas_ = new GSegment();
      comidas_.setStyle(pieceStyle_[0]);
      addSegment(comidas_);
      
      puntajes_ = new GSegment[9];
      for (int i = 0; i < puntajes_.length; i++) {
          puntajes_[i] = new GSegment();
          puntajes_[i].setStyle (pieceStyle_[1]);
          addSegment (puntajes_[i]);
        }
      
    }

    
    public void setState(PacmanState  pacmanState){
    	pacmanState_ = pacmanState;
    }
    
    /**
     * Dibuja la vista de los puntajes obtenidos por el pacman.
     */
    public void draw()
    {
      comidas_.setGeometry(new double[] {3.5, 0.48,
              1.0, 1.0,
              1.0, 1.0,
              1.0, 1.0,
              3.0, 3.0});
      comidas_.removeImages();
      comidas_.addImage(new GImage(new File ("puntaje_comida_fondo.jpg"),GPosition.CENTER));
      
	  for (int i = 1; i < puntajes_.length; i++) {
          puntajes_[i].setGeometry(new double[] {1.9+0.4*i, 0.65,
                  1.0, 1.0,
                  1.0, 1.0,
                  1.0, 1.0,
                  3.0, 3.0});
    	  GText puntaje;
          puntaje = new GText(String.valueOf(pacmanState_.getContFood(i-1)));
          puntajes_[i].setText(puntaje);
        }

      puntajes_[0].setGeometry(new double[] {1.9, 0.65,
              1.0, 1.0,
              1.0, 1.0,
              1.0, 1.0,
              3.0, 3.0});
      puntajes_[0].setText(new GText(String.valueOf(pacmanState_.getContEnemies())));
	  
    }
  }
  
