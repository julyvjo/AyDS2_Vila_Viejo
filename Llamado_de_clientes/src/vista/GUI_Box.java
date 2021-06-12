package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;


import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class GUI_Box extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panelIZQ;
	private JPanel panelCentro;
	private JPanel panelLlamar;
	private JLabel lblLlamarCli;
	private JPanel panelProximo;
	private JButton btnProximo;
	private JPanel panelDER;
	private JPanel panel2;
	private JPanel panelMiddle;
	private JPanel panelDatos;
	private JPanel panelCliente;
	private JLabel lblCliente;
	private JPanel panelBottom;
	private JPanel panelBox;
	private JLabel lblBox;
	ActionListener actionListener;
	private JPanel panelNro;
	private JLabel lblBoxNro;
	private JButton btnEdit;
	private JPanel panelNombre;
	private JLabel lblNom;
	private JLabel lblNombre;
	private JPanel panelDNI;
	private JLabel lblDNI;
	private JLabel lblNroDNI;


	/**
	 * Create the frame.
	 */
	public GUI_Box() {
		setTitle("Box");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 680, 600);
		setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel1 = new JPanel();
		panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel1);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		
		this.panelIZQ = new JPanel();
		panel1.add(panelIZQ);
		
		this.panelCentro = new JPanel();
		panel1.add(panelCentro);
		panelCentro.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panelLlamar = new JPanel();
		panelCentro.add(panelLlamar);
		panelLlamar.setLayout(new BorderLayout(0, 0));
		
		this.lblLlamarCli = new JLabel("LLAMAR CLIENTES");
		lblLlamarCli.setForeground(Color.DARK_GRAY);
		lblLlamarCli.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblLlamarCli.setHorizontalAlignment(SwingConstants.CENTER);
		panelLlamar.add(lblLlamarCli, BorderLayout.CENTER);
		
		this.panelProximo = new JPanel();
		panelCentro.add(panelProximo);
		GridBagLayout gbl_panelProximo = new GridBagLayout();
		gbl_panelProximo.columnWidths = new int[]{0, 0, 0};
		gbl_panelProximo.rowHeights = new int[]{0, 0, 0};
		gbl_panelProximo.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panelProximo.rowWeights = new double[]{0.0, 0.0, 0.0};
		panelProximo.setLayout(gbl_panelProximo);
		
		this.btnProximo = new JButton("PROXIMO");
		GridBagConstraints gbc_btnProximo = new GridBagConstraints();
		gbc_btnProximo.ipady = 10;
		gbc_btnProximo.ipadx = 30;
		gbc_btnProximo.insets = new Insets(0, 0, 5, 0);
		gbc_btnProximo.fill = GridBagConstraints.BOTH;
		gbc_btnProximo.gridx = 2;
		gbc_btnProximo.gridy = 1;
		panelProximo.add(btnProximo, gbc_btnProximo);
		btnProximo.setForeground(Color.DARK_GRAY);
		btnProximo.setFont(new Font("Century Gothic", Font.BOLD, 22));
		btnProximo.setBackground(new Color(102, 204, 102));
		btnProximo.setActionCommand("Proximo");
		btnProximo.addActionListener(this);
		
		this.panelDER = new JPanel();
		panel1.add(panelDER);
		
		this.panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel2);
		panel2.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panelMiddle = new JPanel();
		panel2.add(panelMiddle);
		panelMiddle.setLayout(new GridLayout(0, 1, 0, 0));
		
		//this.panelDatos = new JPanel();
		//panelMiddle.add(panelDatos, BorderLayout.CENTER);
		//panelDatos.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panelCliente = new JPanel();
		panelMiddle.add(panelCliente);
		panelCliente.setLayout(new BorderLayout(0, 0));
		
		this.lblCliente = new JLabel(" Cliente");
		lblCliente.setForeground(Color.DARK_GRAY);
		lblCliente.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		panelCliente.add(lblCliente, BorderLayout.CENTER);
		
		panelDNI = new JPanel();
		panelDNI.setLayout(null);
		panelMiddle.add(panelDNI);
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setForeground(Color.DARK_GRAY);
		lblDNI.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblDNI.setBounds(10, 11, 44, 28);
		panelDNI.add(lblDNI);
		
		lblNroDNI = new JLabel("");
		lblNroDNI.setForeground(Color.DARK_GRAY);
		lblNroDNI.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblNroDNI.setBounds(65, 11, 391, 28);
		panelDNI.add(lblNroDNI);
		
		panelNombre = new JPanel();
		panelMiddle.add(panelNombre);
		panelNombre.setLayout(null);
		
		lblNom = new JLabel("Nombre:");
		lblNom.setBounds(10, 11, 94, 28);
		lblNom.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblNom.setForeground(Color.DARK_GRAY);
		panelNombre.add(lblNom);
		
		lblNombre = new JLabel("");
		lblNombre.setBounds(114, 11, 391, 28);
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblNombre.setForeground(Color.DARK_GRAY);
		panelNombre.add(lblNombre);
		
		this.panelBottom = new JPanel();
		panel2.add(panelBottom);
		panelBottom.setLayout(new BorderLayout(0, 0));
		
		this.panelBox = new JPanel();
		panelBottom.add(panelBox, BorderLayout.EAST);
		panelBox.setLayout(new BorderLayout(0, 0));
		
		panelNro = new JPanel();
		panelBox.add(panelNro, BorderLayout.SOUTH);
		panelNro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnEdit = new JButton("Editar");
		btnEdit.setBackground(new Color(204, 204, 204));
		btnEdit.setForeground(Color.DARK_GRAY);
		btnEdit.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnEdit.setActionCommand("Editar");
		btnEdit.addActionListener(this);
		panelNro.add(btnEdit);
		
		lblBox = new JLabel("Nro Box:");
		panelNro.add(lblBox);
		lblBox.setForeground(Color.DARK_GRAY);
		lblBox.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		lblBoxNro = new JLabel();
		lblBoxNro.setForeground(Color.DARK_GRAY);
		lblBoxNro.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panelNro.add(lblBoxNro);
		
		JPanel panelEmpty1 = new JPanel();
		JPanel panelEmpty2 = new JPanel();
		
		this.setVisible(true);
		this.lblBoxNro.setText(JOptionPane.showInputDialog(this, "Nro box:", "", 3));
	}


	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Proximo")) {
			ActionEvent event = new ActionEvent(this.lblBoxNro.getText(), 0, "Proximo");
			this.actionListener.actionPerformed(event);
		}
		else {
			String box = JOptionPane.showInputDialog(this, "Nro box:", "", 3);
			if(box!=null && !box.equals(""))
				this.lblBoxNro.setText(box);
		}
	}

	public void mostrarCliente(String dni, String nombre) {
		this.lblNroDNI.setText(dni);
		this.lblNombre.setText(nombre);
	}


	public void mostrarMensajeNoHayClientes() {
		
		JOptionPane.showMessageDialog(this, "No hay clientes en espera");
	}


	public void mostrarMensajeErrorDeConexion() {
		
		JOptionPane.showMessageDialog(this, "Error de conexión");
	}
}
