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
import controladores.ControladorObras;
import controladores.ControladorPersonas;
import controladores.ControladorPrestamos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import java.awt.Color;


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
		
		setBounds(100, 100, 953, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
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
		final String[] columnasCa = {"serial telsat","Modelo","serial","Descripcion","Factura Nro"};
		final ControladorPrestamos cp = new ControladorPrestamos();
		final String[] columnasCp = {"fecha prestamo","fecha entrega","estado retorno","obra prestamo","serial activo","asignado","nombre empleado","nombre de obra"};
		final PrestamosTO prestamosTO = new PrestamosTO();
		final String[] columnasPers = {"cedula","nombre","apellido"};
		final String[] columnasObra = {"id de obra","nombre de obra"};
		final ControladorPersonas controlPers = new ControladorPersonas();
		final ControladorObras controlObra = new ControladorObras();
		JButton EstadoBtn = new JButton("consultar");
		EstadoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String estado = estadoActivoTxt.getText();
				Object[][]datos = ca.EstadoActivos(estado);
				
				table.setModel(new DefaultTableModel(datos,columnasCp));
								
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
		
		JButton btnNewButton = new JButton("nombrar activo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigosGUI c = new codigosGUI();
				c.setVisible(true);
			}
		});
		btnNewButton.setBounds(320, 186, 151, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Llenar Tablas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablasGUI tg = new tablasGUI();
				tg.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(320, 245, 151, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 339, 905, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Listar Personas");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[][] Datos = controlPers.ListaPersonas();
				table.setModel(new DefaultTableModel(Datos,columnasPers));
			}
		});
		btnNewButton_2.setBounds(535, 186, 142, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Listar Obras");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[][] Datos = controlObra.ListarObras();
				table.setModel(new DefaultTableModel(Datos,columnasObra));
			}
		});
		btnNewButton_3.setBounds(535, 228, 142, 23);
		contentPane.add(btnNewButton_3);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = table.getSelectedRow();
				String serial = (String) table.getValueAt(fila, 4);
				serialTxt.setText(serial);
			}
		});
	}
}
