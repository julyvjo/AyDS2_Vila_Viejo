package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EtchedBorder;

public class GUI_Registro extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel panel1;
	private JLabel labelRegistrarTurno;
	private JPanel panel2;
	private JPanel panelIZQ;
	private JLabel labelIngreseDNI;
	private JPanel panelTecladoNum;
	private JTextField textFieldDNI;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;
	private JButton btnX;
	private JButton btnOk;
	private JPanel panelDER;
	ActionListener actionListener;

	
	/**
	 * Create the frame.
	 */
	public GUI_Registro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 680, 420);
		setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel1 = new JPanel();
		panel1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		this.labelRegistrarTurno = new JLabel("REGISTRAR TURNO");
		labelRegistrarTurno.setForeground(Color.DARK_GRAY);
		labelRegistrarTurno.setFont(new Font("Century Gothic", Font.BOLD, 24));
		labelRegistrarTurno.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(labelRegistrarTurno, BorderLayout.CENTER);
		
		this.panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel2);
		panel2.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.panelIZQ = new JPanel();
		panel2.add(panelIZQ);
		GridBagLayout gbl_panelIZQ = new GridBagLayout();
		gbl_panelIZQ.columnWidths = new int[] {0, 0, 0};
		gbl_panelIZQ.rowHeights = new int[] {0, 0, 0, 0, 0};
		gbl_panelIZQ.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panelIZQ.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panelIZQ.setLayout(gbl_panelIZQ);
		
		this.labelIngreseDNI = new JLabel("Ingrese DNI:");
		GridBagConstraints gbc_labelIngreseDNI = new GridBagConstraints();
		gbc_labelIngreseDNI.anchor = GridBagConstraints.EAST;
		gbc_labelIngreseDNI.ipady = 10;
		gbc_labelIngreseDNI.fill = GridBagConstraints.BOTH;
		gbc_labelIngreseDNI.insets = new Insets(0, 0, 5, 0);
		gbc_labelIngreseDNI.gridx = 3;
		gbc_labelIngreseDNI.gridy = 0;
		panelIZQ.add(labelIngreseDNI, gbc_labelIngreseDNI);
		labelIngreseDNI.setHorizontalAlignment(SwingConstants.RIGHT);
		labelIngreseDNI.setFont(new Font("Century Gothic", Font.BOLD, 16));
		labelIngreseDNI.setForeground(Color.DARK_GRAY);
		
		this.panelTecladoNum = new JPanel();
		panel2.add(panelTecladoNum);
		GridBagLayout gbl_panelTecladoNum = new GridBagLayout();
		gbl_panelTecladoNum.columnWidths = new int[] {0, 0, 0};
		gbl_panelTecladoNum.rowHeights = new int[] {0, 0, 0, 0, 0};
		gbl_panelTecladoNum.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panelTecladoNum.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panelTecladoNum.setLayout(gbl_panelTecladoNum);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBackground(Color.WHITE);
		textFieldDNI.setEditable(false);
		textFieldDNI.setForeground(Color.DARK_GRAY);
		textFieldDNI.setFont(new Font("Century Gothic", Font.BOLD, 18));
		textFieldDNI.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textFieldDNI = new GridBagConstraints();
		gbc_textFieldDNI.fill = GridBagConstraints.BOTH;
		gbc_textFieldDNI.gridwidth = 3;
		gbc_textFieldDNI.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDNI.gridx = 0;
		gbc_textFieldDNI.gridy = 0;
		panelTecladoNum.add(textFieldDNI, gbc_textFieldDNI);
		textFieldDNI.setColumns(10);
		
		this.btn1 = new JButton("1");
		btn1.setBackground(new Color(204, 204, 204));
		btn1.setForeground(Color.DARK_GRAY);
		btn1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btn1.setActionCommand("1");
		btn1.addActionListener(this);
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.ipadx = 15;
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 1;
		panelTecladoNum.add(btn1, gbc_btn1);
		
		this.btn2 = new JButton("2");
		btn2.setBackground(new Color(204, 204, 204));
		btn2.setForeground(Color.DARK_GRAY);
		btn2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btn2.setActionCommand("2");
		btn2.addActionListener(this);
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.ipadx = 15;
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 1;
		panelTecladoNum.add(btn2, gbc_btn2);
		
		this.btn3 = new JButton("3");
		btn3.setBackground(new Color(204, 204, 204));
		btn3.setForeground(Color.DARK_GRAY);
		btn3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btn3.setActionCommand("3");
		btn3.addActionListener(this);
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.ipadx = 15;
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 1;
		panelTecladoNum.add(btn3, gbc_btn3);
		
		this.btn4 = new JButton("4");
		btn4.setBackground(new Color(204, 204, 204));
		btn4.setForeground(Color.DARK_GRAY);
		btn4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btn4.setActionCommand("4");
		btn4.addActionListener(this);
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.ipadx = 20;
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 2;
		panelTecladoNum.add(btn4, gbc_btn4);
		
		this.btn5 = new JButton("5");
		btn5.setBackground(new Color(204, 204, 204));
		btn5.setForeground(Color.DARK_GRAY);
		btn5.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btn5.setActionCommand("5");
		btn5.addActionListener(this);
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn5.ipadx = 20;
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 2;
		panelTecladoNum.add(btn5, gbc_btn5);
		
		this.btn6 = new JButton("6");
		btn6.setBackground(new Color(204, 204, 204));
		btn6.setForeground(Color.DARK_GRAY);
		btn6.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btn6.setActionCommand("6");
		btn6.addActionListener(this);
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.fill = GridBagConstraints.BOTH;
		gbc_btn6.ipadx = 20;
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 2;
		panelTecladoNum.add(btn6, gbc_btn6);
		
		this.btn7 = new JButton("7");
		btn7.setBackground(new Color(204, 204, 204));
		btn7.setForeground(Color.DARK_GRAY);
		btn7.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btn7.setActionCommand("7");
		btn7.addActionListener(this);
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.fill = GridBagConstraints.BOTH;
		gbc_btn7.ipadx = 20;
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 3;
		panelTecladoNum.add(btn7, gbc_btn7);
		
		this.btn8 = new JButton("8");
		btn8.setBackground(new Color(204, 204, 204));
		btn8.setForeground(Color.DARK_GRAY);
		btn8.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btn8.setActionCommand("8");
		btn8.addActionListener(this);
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.fill = GridBagConstraints.BOTH;
		gbc_btn8.ipadx = 20;
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 3;
		panelTecladoNum.add(btn8, gbc_btn8);
		
		this.btn9 = new JButton("9");
		btn9.setBackground(new Color(204, 204, 204));
		btn9.setForeground(Color.DARK_GRAY);
		btn9.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btn9.setActionCommand("9");
		btn9.addActionListener(this);
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.fill = GridBagConstraints.BOTH;
		gbc_btn9.ipadx = 20;
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 3;
		panelTecladoNum.add(btn9, gbc_btn9);
		
		this.btnX = new JButton("x");
		btnX.setBackground(new Color(204, 204, 204));
		btnX.setForeground(new Color(204, 51, 51));
		btnX.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnX.setActionCommand("x");
		btnX.addActionListener(this);
		GridBagConstraints gbc_btnX = new GridBagConstraints();
		gbc_btnX.fill = GridBagConstraints.BOTH;
		gbc_btnX.ipadx = 19;
		gbc_btnX.insets = new Insets(0, 0, 5, 5);
		gbc_btnX.gridx = 0;
		gbc_btnX.gridy = 4;
		panelTecladoNum.add(btnX, gbc_btnX);
		
		this.btn0 = new JButton("0");
		btn0.setBackground(new Color(204, 204, 204));
		btn0.setForeground(Color.DARK_GRAY);
		btn0.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btn0.setActionCommand("0");
		btn0.addActionListener(this);
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.fill = GridBagConstraints.BOTH;
		gbc_btn0.ipadx = 20;
		gbc_btn0.insets = new Insets(0, 0, 5, 5);
		gbc_btn0.gridx = 1;
		gbc_btn0.gridy = 4;
		panelTecladoNum.add(btn0, gbc_btn0);
		
		this.btnOk = new JButton("\u2192");
		btnOk.setBackground(new Color(204, 204, 204));
		btnOk.setForeground(new Color(51, 153, 51));
		btnOk.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnOk.setActionCommand("Ok");
		btnOk.addActionListener(this);		
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.BOTH;
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.ipadx = 15;
		gbc_btnOk.gridx = 2;
		gbc_btnOk.gridy = 4;
		panelTecladoNum.add(btnOk, gbc_btnOk);
		
		this.panelDER = new JPanel();
		panel2.add(panelDER);
		
		JLabel lbl1 = new JLabel("      ");
		GridBagConstraints gbc_lbl1 = new GridBagConstraints();
		gbc_lbl1.ipadx = 50;
		gbc_lbl1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1.gridx = 2;
		gbc_lbl1.gridy = 0;
		panelIZQ.add(lbl1, gbc_lbl1);
		
		JLabel lbl2 = new JLabel(" ");
		GridBagConstraints gbc_lbl2 = new GridBagConstraints();
		gbc_lbl2.fill = GridBagConstraints.BOTH;
		gbc_lbl2.ipady = 20;
		gbc_lbl2.insets = new Insets(0, 0, 5, 0);
		gbc_lbl2.gridx = 3;
		gbc_lbl2.gridy = 1;
		panelIZQ.add(lbl2, gbc_lbl2);
		
		JLabel lbl3 = new JLabel(" ");
		GridBagConstraints gbc_lbl3 = new GridBagConstraints();
		gbc_lbl3.fill = GridBagConstraints.BOTH;
		gbc_lbl3.ipady = 20;
		gbc_lbl3.insets = new Insets(0, 0, 5, 0);
		gbc_lbl3.gridx = 3;
		gbc_lbl3.gridy = 2;
		panelIZQ.add(lbl3, gbc_lbl3);
		
		JLabel lbl4 = new JLabel(" ");
		GridBagConstraints gbc_lbl4 = new GridBagConstraints();
		gbc_lbl4.fill = GridBagConstraints.BOTH;
		gbc_lbl4.ipady = 20;
		gbc_lbl4.insets = new Insets(0, 0, 5, 0);
		gbc_lbl4.gridx = 3;
		gbc_lbl4.gridy = 3;
		panelIZQ.add(lbl4, gbc_lbl4);
		
		JLabel lbl5 = new JLabel(" ");
		GridBagConstraints gbc_lbl5 = new GridBagConstraints();
		gbc_lbl5.fill = GridBagConstraints.BOTH;
		gbc_lbl5.ipady = 20;
		gbc_lbl5.gridx = 3;
		gbc_lbl5.gridy = 4;
		panelIZQ.add(lbl5, gbc_lbl5);
		
		this.setVisible(true);
	}

	
	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		StringBuilder text = new StringBuilder();
		text.append(this.textFieldDNI.getText());
		if(e.getActionCommand().equals("Ok")) {
			if(text.length() > 6) {
				//ActionEvent event = new ActionEvent(text, 0, "Ok");
				this.actionListener.actionPerformed(null);
				this.textFieldDNI.setText("");
			}
		}
		else {
			if(e.getActionCommand().equals("x")) {
				if(text.length() != 0)
					text.deleteCharAt(text.length()-1);
			}
			else 
				if(text.length() < 8)
					text.append(e.getActionCommand());
			this.textFieldDNI.setText(text.toString());
		}
	}
	
	
	public String getInput() {
		return this.textFieldDNI.getText();
	}
	
}
