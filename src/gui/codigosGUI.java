package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import controladores.ControladorCodigos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class codigosGUI extends JFrame {

	private JPanel contentPane;
	private JTextField codigoTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					codigosGUI frame = new codigosGUI();
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
	public codigosGUI() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ControladorCodigos cc = new ControladorCodigos();
		String[] codigos = cc.ListaCodigos();
		
		
		setBounds(100, 100, 502, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		codigoTxt = new JTextField();
		codigoTxt.setBackground(Color.WHITE);
		codigoTxt.setEditable(false);
		codigoTxt.setBounds(10, 11, 190, 20);
		contentPane.add(codigoTxt);
		codigoTxt.setColumns(10);
		
		final JComboBox<String> nombresCbx = new JComboBox<String>();
		nombresCbx.setBounds(10, 57, 190, 20);
		contentPane.add(nombresCbx);
		
		
		JButton agregarBtn = new JButton("agregar codigo");
		agregarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object nombres = nombresCbx.getSelectedItem();
				String names = nombres.toString();
				String cod = codigoTxt.getText()+names;
				codigoTxt.setText(cod);
			}
		});
		agregarBtn.setBounds(274, 54, 150, 23);
		contentPane.add(agregarBtn);
		
		
		
		
		JButton nuevoBtn = new JButton("nuevo codigo");
		nuevoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigoTxt.setText(null);
			}
		});
		nuevoBtn.setBounds(274, 10, 150, 23);
		contentPane.add(nuevoBtn);
		
		JButton btnFinalizarCodigo = new JButton("finalizar codigo");
		btnFinalizarCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String unique = ControladorCodigos.generateUniqueID();
				String codigo = codigoTxt.getText()+unique;
				codigoTxt.setText(codigo);
			}
		});
		btnFinalizarCodigo.setBounds(274, 101, 150, 23);
		contentPane.add(btnFinalizarCodigo);
		
				
		for(int i = 0; i < codigos.length; i++) {			
			nombresCbx.addItem(codigos[i]);						
		}
		
	}
}
