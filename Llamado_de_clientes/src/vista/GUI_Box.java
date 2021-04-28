package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GUI_Box extends JFrame {

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
	private JPanel panelDNI;
	private JLabel lblDNI;
	private JPanel panelBottom;
	private JPanel panelBox;
	private JLabel lblBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Box frame = new GUI_Box();
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
		
		this.panelDER = new JPanel();
		panel1.add(panelDER);
		
		this.panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel2);
		panel2.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panelMiddle = new JPanel();
		panel2.add(panelMiddle);
		panelMiddle.setLayout(new BorderLayout(0, 0));
		
		this.panelDatos = new JPanel();
		panelMiddle.add(panelDatos, BorderLayout.WEST);
		panelDatos.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panelCliente = new JPanel();
		panelDatos.add(panelCliente);
		panelCliente.setLayout(new BorderLayout(0, 0));
		
		this.lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(Color.DARK_GRAY);
		lblCliente.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		panelCliente.add(lblCliente, BorderLayout.CENTER);
		
		this.panelDNI = new JPanel();
		panelDatos.add(panelDNI);
		panelDNI.setLayout(new BorderLayout(0, 0));
		
		this.lblDNI = new JLabel("DNI: ********");
		lblDNI.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		lblDNI.setForeground(Color.DARK_GRAY);
		panelDNI.add(lblDNI, BorderLayout.CENTER);
		
		this.panelBottom = new JPanel();
		panel2.add(panelBottom);
		panelBottom.setLayout(new BorderLayout(0, 0));
		
		this.panelBox = new JPanel();
		panelBottom.add(panelBox, BorderLayout.EAST);
		panelBox.setLayout(new BorderLayout(0, 0));
		
		this.lblBox = new JLabel("Nro Box: **");
		lblBox.setForeground(Color.DARK_GRAY);
		lblBox.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panelBox.add(lblBox, BorderLayout.SOUTH);
		
		JPanel panelEmpty1 = new JPanel();
		JPanel panelEmpty2 = new JPanel();
	}
}
