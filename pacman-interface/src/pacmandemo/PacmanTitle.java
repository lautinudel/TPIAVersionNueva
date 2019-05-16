package pacmandemo;
// PacmanTitle.java
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

  class PacmanTitle extends GObject
  {
  /** 
   * Vista del título de la aplicación 
   */
	  
    private GStyle[]    pieceStyle_;

    private GSegment  puntajes_;
    
   	private PacmanState  pacmanState_;
    
    public PacmanTitle(PacmanState pacmanState_)
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
      pieceStyle_[1].setForegroundColor (new Color (0, 200, 0));
      pieceStyle_[1].setBackgroundColor (new Color (0, 200, 0));

      puntajes_ = new GSegment();
      puntajes_.setStyle(pieceStyle_[0]);
      addSegment(puntajes_);
      
    }

    
    public void setState(PacmanState  pacmanState){
    	pacmanState_ = pacmanState;
    }
    
    public void draw()
    {
      puntajes_.setGeometry(new double[] {2.7, 5.52,
              5.0, 1.0,
              5.0, 5.0,
              1.0, 5.0,
              3.0, 3.0});
      puntajes_.removeImages();
      puntajes_.addImage(new GImage(new File ("cabecera.jpg"),GPosition.CENTER));
      
    }
  }
  
