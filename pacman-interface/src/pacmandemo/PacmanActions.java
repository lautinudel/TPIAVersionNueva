package pacmandemo;
//PacmanActions.java
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
  class PacmanActions extends GObject
  {
  /** 
   * Vista de las acciones que ejecuta el pacman 
   */
	  
    /** determina el estilo de los elementos que conforman la vista de las acciones */
    private GStyle[]    pieceStyle_;

    /** contiene las partes estáticas de la vista de las acciones ejecutadas*/
    private GSegment  acciones_;
    
    /** vista de la acción Izquierda */
    private GSegment  accionIzquierda_;
    
    /** vista de la acción Arriba */
    private GSegment  accionArriba_;
    
    /** vista de la acción Derecha*/
    private GSegment  accionDerecha_;
    
    /** vista de la acción Abajo */
    private GSegment  accionAbajo_;
    
    /** vista de la acción Avanzar */
    private GSegment  accionAvanzar_;
    
    /** vista de la acción comer */
    private GSegment  accionComer_;
    
    /** vista de la acción Pelear */
    private GSegment  accionPelear_;
    
    /** vista de la energía del pacman */
    private GSegment  energia_;
    
    /** Estado del pacman. */
   	private PacmanState  pacmanState_;
    
    /**
     * Crea una instancia de la vista de las acciones del pacman.
     * @param pacmanState_ estado del pacman.
     */
   	public PacmanActions(PacmanState pacmanState_)
    {
	  this.pacmanState_ = pacmanState_;
	  
      GStyle gridStyle = new GStyle();
      gridStyle.setForegroundColor (new Color (255, 0, 0));
      gridStyle.setLineWidth (2);

      pieceStyle_ = new GStyle[2];
      pieceStyle_[0] = new GStyle();
      pieceStyle_[0].setForegroundColor (new Color (0, 0, 0));
      pieceStyle_[0].setBackgroundColor (new Color (0, 0, 0));
      pieceStyle_[0].setLineStyle(GStyle.LINESTYLE_INVISIBLE);

      pieceStyle_[1] = new GStyle();
      pieceStyle_[1].setForegroundColor (new Color (0, 200, 0));
      pieceStyle_[1].setBackgroundColor (new Color (0, 200, 0));

      acciones_ = new GSegment();
      acciones_.setStyle(pieceStyle_[0]);
      addSegment(acciones_);

      //Creo los segementos que representan las acciones ejecutadas
      accionIzquierda_ = new GSegment();
      accionIzquierda_.setStyle(pieceStyle_[0]);
      addSegment(accionIzquierda_);
      accionArriba_ = new GSegment();
      accionArriba_.setStyle(pieceStyle_[0]);
      addSegment(accionArriba_);
      accionDerecha_ = new GSegment();
      accionDerecha_.setStyle(pieceStyle_[0]);
      addSegment(accionDerecha_);
      accionAbajo_ = new GSegment();
      accionAbajo_.setStyle(pieceStyle_[0]);
      addSegment(accionAbajo_);
      accionAvanzar_ = new GSegment();
      accionAvanzar_.setStyle(pieceStyle_[0]);
      addSegment(accionAvanzar_);
      accionComer_ = new GSegment();
      accionComer_.setStyle(pieceStyle_[0]);
      addSegment(accionComer_);
      accionPelear_ = new GSegment();
      accionPelear_.setStyle(pieceStyle_[0]);
      addSegment(accionPelear_);
      energia_ = new GSegment();
      energia_.setStyle(pieceStyle_[0]);
      addSegment(energia_);
    }
    
    public void setState(PacmanState  pacmanState){
    	pacmanState_ = pacmanState;
    }
    
    /**
     * Dibuja la vista de las acciones ejecutadas.
     */
    public void draw()
    {
      acciones_.setGeometry(new double[] {0.75, 2.6,
              5.0, 1.0,
              5.0, 5.0,
              1.0, 5.0,
              3.0, 3.0});
      acciones_.removeImages();
      acciones_.addImage(new GImage(new File ("acciones_fondo.jpg"),GPosition.CENTER));

      String on = "0";
      
      accionIzquierda_.setGeometry(new double[] {0.3, 4.0,
              5.0, 1.0,
              5.0, 5.0,
              1.0, 5.0,
              3.0, 3.0});
      accionIzquierda_.removeImages();
      if (pacmanState_.getLastAction().equals("izquierda"))
    	  on = "1";
      accionIzquierda_.addImage(new GImage(new File ("accion_izquierda_"+on+".jpg"),GPosition.CENTER));
	  on = "0";

      accionDerecha_.setGeometry(new double[] {0.76, 4.0,
              5.0, 1.0,
              5.0, 5.0,
              1.0, 5.0,
              3.0, 3.0});
      accionDerecha_.removeImages();
      if (pacmanState_.getLastAction().equals("derecha"))
    	  on = "1";
      accionDerecha_.addImage(new GImage(new File ("accion_derecha_"+on+".jpg"),GPosition.CENTER));
	  on = "0";
      
      accionArriba_.setGeometry(new double[] {0.53, 4.34,
              5.0, 1.0,
              5.0, 5.0,
              1.0, 5.0,
              3.0, 3.0});
      accionArriba_.removeImages();
      if (pacmanState_.getLastAction().equals("arriba"))
    	  on = "1";
      accionArriba_.addImage(new GImage(new File ("accion_arriba_"+on+".jpg"),GPosition.CENTER));
	  on = "0";

      accionAbajo_.setGeometry(new double[] {0.53, 3.68,
              5.0, 1.0,
              5.0, 5.0,
              1.0, 5.0,
              3.0, 3.0});
      accionAbajo_.removeImages();
      if (pacmanState_.getLastAction().equals("abajo"))
    	  on = "1";
      accionAbajo_.addImage(new GImage(new File ("accion_abajo_"+on+".jpg"),GPosition.CENTER));
	  on = "0";

	  
      accionAvanzar_.setGeometry(new double[] {0.76, 3.27,
              5.0, 1.0,
              5.0, 5.0,
              1.0, 5.0,
              3.0, 3.0});
      accionAvanzar_.removeImages();
      if (pacmanState_.getLastAction().equals("izquierda") | pacmanState_.getLastAction().equals("arriba") | pacmanState_.getLastAction().equals("derecha") | pacmanState_.getLastAction().equals("abajo"))
    	  on = "1";
      accionAvanzar_.addImage(new GImage(new File ("accion_avanzar_"+on+".jpg"),GPosition.CENTER));
	  on = "0";

      accionComer_.setGeometry(new double[] {0.76, 2.86,
              5.0, 1.0,
              5.0, 5.0,
              1.0, 5.0,
              3.0, 3.0});
      accionComer_.removeImages();
      if (pacmanState_.getLastAction().equals("comer"))
    	  on = "1";
      accionComer_.addImage(new GImage(new File ("accion_comer_"+on+".jpg"),GPosition.CENTER));
	  on = "0";

      accionPelear_.setGeometry(new double[] {0.76, 2.45,
              5.0, 1.0,
              5.0, 5.0,
              1.0, 5.0,
              3.0, 3.0});
      accionPelear_.removeImages();
      if (pacmanState_.getLastAction().equals("pelear"))
    	  on = "1";
      accionPelear_.addImage(new GImage(new File ("accion_pelear_"+on+".jpg"),GPosition.CENTER));
	  on = "0";

	  
      energia_.setGeometry(new double[] {0.54, 1.92,
              5.0, 1.0,
              5.0, 5.0,
              1.0, 5.0,
              3.0, 3.0});
      energia_.removeImages();
      energia_.addImage(new GImage(new File ("energia.jpg"),GPosition.CENTER));
	  
    }
  }
  
