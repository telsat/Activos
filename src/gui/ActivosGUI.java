package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;

import to.PrestamosTO;
import controladores.ControladorActivos;
import controladores.ControladorPrestamos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings({ "serial", "unused" })
public class ActivosGUI extends JFrame {

	private JPanel contentPane;
	private JTextField estadoActivoTxt;
	private JTextField cedulaTxt;
	private JTextField serialTxt;
	private JTextField idObraTxt;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivosGUI frame = new ActivosGUI();
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
	public ActivosGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 716, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		estadoActivoTxt = new JTextField();
		estadoActivoTxt.setBounds(118, 39, 86, 20);
		contentPane.add(estadoActivoTxt);
		estadoActivoTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("estado activo");
		lblNewLabel.setBounds(22, 45, 86, 14);
		contentPane.add(lblNewLabel);
		
		final ControladorActivos ca = new ControladorActivos();
		final String[] columnasCa = {"serial","tipo activo","modelo"};
		final ControladorPrestamos cp = new ControladorPrestamos();
		final String[] columnasCp = {"estado retorno","fecha prestamo","fecha entrega","obra prestamo","serial activo","asignado"};
		final PrestamosTO prestamosTO = new PrestamosTO();
		JButton EstadoBtn = new JButton("consultar");
		EstadoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String estado = estadoActivoTxt.getText();
				Object[][]datos = ca.EstadoActivos(estado);
				
				table.setModel(new DefaultTableModel(datos,columnasCa));
								
			}
		});
		EstadoBtn.setBounds(22, 79, 89, 23);
		contentPane.add(EstadoBtn);
		
		cedulaTxt = new JTextField();
		cedulaTxt.setBounds(118, 187, 86, 20);
		contentPane.add(cedulaTxt);
		cedulaTxt.setColumns(10);
		
		serialTxt = new JTextField();
		serialTxt.setBounds(118, 229, 86, 20);
		contentPane.add(serialTxt);
		serialTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("cedula");
		lblNewLabel_1.setBounds(22, 193, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("serial activo");
		lblNewLabel_2.setBounds(22, 235, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton prestadosBtn = new JButton("Consultar Activos");
		prestadosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ced = cedulaTxt.getText();
				String ser = serialTxt.getText();
				prestamosTO.setAsignado(ced);
				prestamosTO.setSerial_activo(ser);				
				Object[][] datos = cp.ActivosAsignados(prestamosTO);
				table.setModel(new DefaultTableModel(datos,columnasCp));
				
			}
		});
		prestadosBtn.setBounds(22, 272, 151, 23);
		contentPane.add(prestadosBtn);
		
		JLabel lblConsultarActivosPor = new JLabel("consultar activos por estado");
		lblConsultarActivosPor.setBounds(22, 11, 182, 14);
		contentPane.add(lblConsultarActivosPor);
		
		JLabel lblNewLabel_3 = new JLabel("Consultar activos prestados y a quien");
		lblNewLabel_3.setBounds(22, 166, 222, 14);
		contentPane.add(lblNewLabel_3);
		
		idObraTxt = new JTextField();
		idObraTxt.setBounds(419, 39, 86, 20);
		contentPane.add(idObraTxt);
		idObraTxt.setColumns(10);
		
		JLabel lblIdObra = new JLabel("Id Obra");
		lblIdObra.setBounds(320, 42, 46, 14);
		contentPane.add(lblIdObra);
		
		JLabel lblConsultarActivosEn = new JLabel("Consultar activos en obras");
		lblConsultarActivosEn.setBounds(320, 11, 185, 14);
		contentPane.add(lblConsultarActivosEn);
		
		JButton obrasBtn = new JButton("Consultar");
		obrasBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idObra = idObraTxt.getText();
				int obraId = Integer.parseInt(idObra);
				Object[][] datos = cp.EquiposEnObra(obraId);
				table.setModel(new DefaultTableModel(datos,columnasCp));
			}
		});
		obrasBtn.setBounds(320, 79, 89, 23);
		contentPane.add(obrasBtn);
		
		table = new JTable();
		table.setBounds(22, 369, 621, 199);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("nombrar activo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigosGUI c = new codigosGUI();
				c.setVisible(true);
			}
		});
		btnNewButton.setBounds(320, 186, 151, 23);
		contentPane.add(btnNewButton);
	}
}
