package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_central_general;
	private JPanel panel_3;
	private JPanel contenedor_centro;
	private JLabel label_llamados_recientes;
	private JPanel contenedor_izq;
	private JPanel contenedor_der;
	private JPanel panel_label_box;
	private JPanel panel_list_box;
	private JLabel label_box;
	private JList list_box;
	private JPanel panel_label_dni;
	private JPanel panel_list_dni;
	private JLabel label_dni;
	private JList list_dni;
	
	//list models
	DefaultListModel modeloListaBox = new DefaultListModel();
	DefaultListModel modeloListaDni = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panel_1.getLayout();
		flowLayout.setHgap(10);
		this.panel.add(this.panel_1, BorderLayout.WEST);
		
		this.panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) this.panel_2.getLayout();
		flowLayout_1.setHgap(10);
		this.panel.add(this.panel_2, BorderLayout.EAST);
		
		this.panel_central_general = new JPanel();
		this.panel.add(this.panel_central_general, BorderLayout.CENTER);
		this.panel_central_general.setLayout(new BorderLayout(0, 0));
		
		this.panel_3 = new JPanel();
		this.panel_central_general.add(this.panel_3, BorderLayout.NORTH);
		
		this.label_llamados_recientes = new JLabel("LLAMADOS RECIENTES");
		this.label_llamados_recientes.setFont(new Font("Microsoft YaHei", Font.PLAIN, 17));
		this.panel_3.add(this.label_llamados_recientes);
		
		this.contenedor_centro = new JPanel();
		this.contenedor_centro.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		this.panel_central_general.add(this.contenedor_centro, BorderLayout.CENTER);
		this.contenedor_centro.setLayout(new BorderLayout(0, 0));
		
		this.contenedor_izq = new JPanel();
		this.contenedor_centro.add(this.contenedor_izq, BorderLayout.WEST);
		this.contenedor_izq.setLayout(new BorderLayout(0, 0));
		
		this.panel_label_box = new JPanel();
		this.panel_label_box.setBorder(new EmptyBorder(0, 0, 0, 3));
		FlowLayout fl_panel_label_box = (FlowLayout) this.panel_label_box.getLayout();
		fl_panel_label_box.setHgap(40);
		this.contenedor_izq.add(this.panel_label_box, BorderLayout.NORTH);
		
		this.label_box = new JLabel("Box");
		this.label_box.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.panel_label_box.add(this.label_box);
		
		this.panel_list_box = new JPanel();
		this.panel_list_box.setBorder(new EmptyBorder(0, 0, 0, 3));
		this.contenedor_izq.add(this.panel_list_box, BorderLayout.CENTER);
		this.panel_list_box.setLayout(new BorderLayout(0, 0));
		
		this.list_box = new JList();
		this.panel_list_box.add(this.list_box, BorderLayout.CENTER);
		this.list_box.setModel(this.modeloListaBox); //agrego modelo de lista box
		
		this.contenedor_der = new JPanel();
		this.contenedor_centro.add(this.contenedor_der, BorderLayout.CENTER);
		this.contenedor_der.setLayout(new BorderLayout(0, 0));
		
		this.panel_label_dni = new JPanel();
		this.panel_label_dni.setBorder(new EmptyBorder(0, 3, 0, 0));
		this.contenedor_der.add(this.panel_label_dni, BorderLayout.NORTH);
		
		this.label_dni = new JLabel("DNI");
		this.label_dni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.panel_label_dni.add(this.label_dni);
		
		this.panel_list_dni = new JPanel();
		this.panel_list_dni.setBorder(new EmptyBorder(0, 3, 0, 0));
		this.contenedor_der.add(this.panel_list_dni, BorderLayout.CENTER);
		this.panel_list_dni.setLayout(new BorderLayout(0, 0));
		
		this.list_dni = new JList();
		this.list_dni.setBorder(new EmptyBorder(0, 1, 0, 0));
		this.panel_list_dni.add(this.list_dni, BorderLayout.CENTER);
		this.list_dni.setModel(this.modeloListaDni); //agrego modelo de lista dni
	}
	
	//metodos
	public void publicarTurno() { //invocado desde controller con parametro Turno turno (pendiente por librerias)
		//parametros inventados hasta que se implemente TURNO
		String dni = "41.123.123";
		int box = 5;
		//---------------------------------------------------
		
		//poner texto en list_box y list_dni
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
