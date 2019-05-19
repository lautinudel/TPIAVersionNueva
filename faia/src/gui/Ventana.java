package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Roa Santiago
 */
public class Ventana extends JFrame implements ActionListener {

    private JLabel txtposagente;           // etiqueta o texto no editable
    private JLabel txtprodacomprar;           // etiqueta o texto no editable
    private JLabel txtpossupermer;           // etiqueta o texto no editable
    private JLabel lblposagente;           // etiqueta o texto no editable
    private JLabel lblprodacomprar;           // etiqueta o texto no editable
    private JLabel lblpossupermer;           // etiqueta o texto no editable
    private JLabel lblreachedgoal;           // etiqueta o texto no editable
    private JLabel lblaccion;           // etiqueta o texto no editable
    private JTextField caja;        // caja de texto, para insertar datos
    private JButton boton;          // boton con una determinada accion
    private JList listaposiciones;

    public Ventana() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    private void configurarVentana() {
        this.setTitle("Agente compras IA");                   // colocamos titulo a la ventana
        this.setSize(450, 450);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    public JList getListaposiciones() {
		return listaposiciones;
	}

	public void s(String listaposiciones) {
		this.listaposiciones.;
	}

	private void inicializarComponentes() {
       
    	// creamos los componentes
        txtposagente = new JLabel();
        txtprodacomprar = new JLabel();
        lblposagente = new JLabel();
        lblprodacomprar = new JLabel();
        lblpossupermer = new JLabel();
        lblreachedgoal = new JLabel(); 
        lblaccion = new JLabel();
        //DefaultListModel<String> listposiciones = new DefaultListModel<>();
        
        DefaultListModel model= new DefaultListModel();
        listaposiciones = new JList(model);
        listaposiciones.setVisible(true);
        model.addElement("hola");
        model.addElement("caca");
        
        caja = new JTextField();
        boton = new JButton();
        
        // configuramos los componentes
        txtposagente.setText("");    // colocamos un texto a la etiqueta
        txtposagente.setBounds(50, 50, 200, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        txtprodacomprar.setText("Productos a comprar");    // colocamos un texto a la etiqueta
        txtprodacomprar.setBounds(50, 100, 200, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        lblposagente.setText("");    // colocamos un texto a la etiqueta
        lblposagente.setBounds(50, 70, 500, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        lblprodacomprar.setText("");    // colocamos un texto a la etiqueta
        lblprodacomprar.setBounds(50, 120, 500, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        lblpossupermer.setText("");    // colocamos un texto a la etiqueta
        lblpossupermer.setBounds(50, 170, 200, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        lblreachedgoal.setText("");    // colocamos un texto a la etiqueta
        lblreachedgoal.setBounds(50, 200, 200, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        lblaccion.setText("");    // colocamos un texto a la etiqueta
        lblaccion.setBounds(50, 150, 200, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        listaposiciones.setBounds(50, 50, 200, 200);
        
        
        
        caja.setBounds(150, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        boton.setText("Avanzar");   // colocamos un texto al boton
        boton.setBounds(100, 300, 200, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        
        // adicionamos los componentes a la ventana
        //this.add(txtposagente);
        this.add(txtprodacomprar);
        //this.add(txtpossupermer);
        this.add(lblposagente);
        //this.add(listaposiciones);
        this.add(lblprodacomprar);
        this.add(lblaccion);
        this.add(lblpossupermer);
        this.add(lblreachedgoal);
        this.add(boton);
    }

    

	

	@Override
    public void actionPerformed(ActionEvent e) {
        /*try {
			Thread.sleep(0);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
        
        
    }

    public static void main(String[] args) {
        Ventana V = new Ventana();      // creamos una ventana
        V.setVisible(true);             // hacemos visible la ventana creada
    }

	public JLabel getTxtposagente() {
		return txtposagente;
	}

	public void setTxtposagente(JLabel txtposagente) {
		this.txtposagente = txtposagente;
	}

	public JLabel getTxtprodacomprar() {
		return txtprodacomprar;
	}

	public void setTxtprodacomprar(JLabel txtprodacomprar) {
		this.txtprodacomprar = txtprodacomprar;
	}

	public JLabel getTxtpossupermer() {
		return txtpossupermer;
	}

	public void setTxtpossupermer(JLabel txtpossupermer) {
		this.txtpossupermer = txtpossupermer;
	}

	public JLabel getLblposagente() {
		return lblposagente;
	}

	public void setLblposagente(String lblposagente) {
		this.lblposagente.setText(lblposagente);
	}

	public JLabel getLblprodacomprar() {
		return lblprodacomprar;
	}

	public void setLblprodacomprar(String lblprodacomprar) {
		this.lblprodacomprar.setText(lblprodacomprar);
	}

	public JLabel getLblpossupermer() {
		return lblpossupermer;
	}

	public void setLblpossupermer(String lblpossupermer) {
		this.lblpossupermer.setText(lblpossupermer);
	}

	public JTextField getCaja() {
		return caja;
	}

	public void setCaja(JTextField caja) {
		this.caja = caja;
	}

	public JButton getBoton() {
		return boton;
	}

	public void setBoton(JButton boton) {
		this.boton = boton;
	}
    
	public JLabel getLblreachedgoal() {
		return lblreachedgoal;
	}

	public void setLblreachedgoal(String lblreachedgoal) {
		this.lblreachedgoal.setText(lblreachedgoal);;
	}
	
	public void setColorElblreachedgoal() {
		this.lblreachedgoal.setForeground(Color.green);
	}
	public void setColorFlblreachedgoal() {
		this.lblreachedgoal.setForeground(Color.red);
	}
	
	public JLabel getLblaccion() {
		return lblaccion;
	}

	public void setLblaccion(String lblaccion) {
		this.lblaccion.setText(lblaccion);;
	}
    
}