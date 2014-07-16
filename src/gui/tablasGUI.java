package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import to.ActivoTO;
import to.FacturaTO;
import to.ObraTO;
import to.PersonaTO;
import to.PrestamosTO;
import to.ProveedorTO;

public class tablasGUI extends JFrame {
	
	ActivoTO ato = new ActivoTO();
	FacturaTO fto = new FacturaTO();
	ObraTO oto = new ObraTO();
	PersonaTO perto = new PersonaTO();
	PrestamosTO presto = new PrestamosTO();
	ProveedorTO proveto = new ProveedorTO();
	
	

	private JPanel contentPane;
	private JTextField telsatSerialTxt;
	private JTextField activoSerialTxt;
	private JTextField modeloTxt;
	private JTextField descripcionTxt;
	private JTextField proveeNitTxt;
	private JTextField ActFacturaTxt;
	private JTextField fotoTxt;
	private JTextField EstadoTxt;
	private JTextField precioTxt;
	private JTextField tipoActivoTxt;
	private JTextField NitTxt;
	private JTextField proveedorNombreTxt;
	private JTextField direccionTxt;
	private JTextField telefonoTxt;
	private JTextField contactoTxt;
	private JTextField mailTxt;
	private JTextField filtroTxt;
	private JTextField facturaNumeroTxt;
	private JTextField facturaNitTxt;
	private JTextField fechaCompraTxt;
	private JTextField idObraTxt;
	private JTextField obraNombreTxt;
	private JTextField cedulaTxt;
	private JTextField personaNombreTxt;
	private JTextField apellidoTxt;
	private JTextField fechaPrestamoTxt;
	private JTextField fechaEntregaTxt;
	private JTextField asignadoTxt;
	private JTextField estadoRetornoTxt;
	private JTextField obraPrestadoTxt;
	private JTextField serialPrestamoTxt;
	private JTextField codigoTxt;
	private JTextField codigoNombreTxt;
	private JTextField codigoDescripcionTxt;
	private JTextField codigoEstadoTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tablasGUI frame = new tablasGUI();
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
	public tablasGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 567, 307);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Activo", null, panel, null);
		panel.setLayout(null);
		
		telsatSerialTxt = new JTextField();
		telsatSerialTxt.setBounds(113, 8, 121, 20);
		panel.add(telsatSerialTxt);
		telsatSerialTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Serial telsat");
		lblNewLabel.setBounds(10, 14, 86, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Serial");
		lblNewLabel_1.setBounds(10, 61, 86, 14);
		panel.add(lblNewLabel_1);
		
		activoSerialTxt = new JTextField();
		activoSerialTxt.setBounds(113, 55, 121, 20);
		panel.add(activoSerialTxt);
		activoSerialTxt.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 101, 86, 14);
		panel.add(lblModelo);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(10, 147, 86, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Proveedor(nit)");
		lblNewLabel_3.setBounds(10, 192, 86, 14);
		panel.add(lblNewLabel_3);
		
		modeloTxt = new JTextField();
		modeloTxt.setBounds(113, 98, 121, 20);
		panel.add(modeloTxt);
		modeloTxt.setColumns(10);
		
		descripcionTxt = new JTextField();
		descripcionTxt.setBounds(113, 144, 121, 20);
		panel.add(descripcionTxt);
		descripcionTxt.setColumns(10);
		
		proveeNitTxt = new JTextField();
		proveeNitTxt.setBounds(113, 189, 121, 20);
		panel.add(proveeNitTxt);
		proveeNitTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Factura");
		lblNewLabel_4.setBounds(297, 14, 86, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ruta Foto");
		lblNewLabel_5.setBounds(297, 61, 86, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setBounds(297, 104, 86, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Precio");
		lblNewLabel_7.setBounds(297, 150, 86, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tipo de Activo");
		lblNewLabel_8.setBounds(297, 195, 86, 14);
		panel.add(lblNewLabel_8);
		
		ActFacturaTxt = new JTextField();
		ActFacturaTxt.setBounds(416, 8, 116, 20);
		panel.add(ActFacturaTxt);
		ActFacturaTxt.setColumns(10);
		
		fotoTxt = new JTextField();
		fotoTxt.setBounds(416, 58, 116, 20);
		panel.add(fotoTxt);
		fotoTxt.setColumns(10);
		
		EstadoTxt = new JTextField();
		EstadoTxt.setBounds(416, 98, 116, 20);
		panel.add(EstadoTxt);
		EstadoTxt.setColumns(10);
		
		precioTxt = new JTextField();
		precioTxt.setBounds(416, 144, 116, 20);
		panel.add(precioTxt);
		precioTxt.setColumns(10);
		
		tipoActivoTxt = new JTextField();
		tipoActivoTxt.setBounds(416, 189, 116, 20);
		panel.add(tipoActivoTxt);
		tipoActivoTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(10, 245, 116, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_7 = new JButton("Limpiar");
		btnNewButton_7.setBounds(159, 245, 127, 23);
		panel.add(btnNewButton_7);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Proveedor", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("NIT");
		lblNewLabel_9.setBounds(10, 11, 70, 14);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Nombre");
		lblNewLabel_10.setBounds(10, 53, 70, 14);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Direccion");
		lblNewLabel_11.setBounds(10, 100, 70, 14);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Telefono");
		lblNewLabel_12.setBounds(10, 153, 70, 14);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Contacto");
		lblNewLabel_13.setBounds(260, 11, 70, 14);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("E Mail");
		lblNewLabel_14.setBounds(260, 53, 70, 14);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Filtro");
		lblNewLabel_15.setBounds(260, 100, 70, 14);
		panel_1.add(lblNewLabel_15);
		
		NitTxt = new JTextField();
		NitTxt.setBounds(90, 8, 86, 20);
		panel_1.add(NitTxt);
		NitTxt.setColumns(10);
		
		proveedorNombreTxt = new JTextField();
		proveedorNombreTxt.setBounds(90, 50, 86, 20);
		panel_1.add(proveedorNombreTxt);
		proveedorNombreTxt.setColumns(10);
		
		direccionTxt = new JTextField();
		direccionTxt.setBounds(90, 97, 86, 20);
		panel_1.add(direccionTxt);
		direccionTxt.setColumns(10);
		
		telefonoTxt = new JTextField();
		telefonoTxt.setBounds(90, 150, 86, 20);
		panel_1.add(telefonoTxt);
		telefonoTxt.setColumns(10);
		
		contactoTxt = new JTextField();
		contactoTxt.setBounds(340, 8, 86, 20);
		panel_1.add(contactoTxt);
		contactoTxt.setColumns(10);
		
		mailTxt = new JTextField();
		mailTxt.setBounds(340, 50, 86, 20);
		panel_1.add(mailTxt);
		mailTxt.setColumns(10);
		
		filtroTxt = new JTextField();
		filtroTxt.setBounds(340, 97, 86, 20);
		panel_1.add(filtroTxt);
		filtroTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.setBounds(10, 206, 124, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(171, 206, 106, 23);
		panel_1.add(btnLimpiar);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Factura", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_16 = new JLabel("Numero");
		lblNewLabel_16.setBounds(10, 11, 104, 14);
		panel_2.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("NIT Proveedor");
		lblNewLabel_17.setBounds(10, 59, 104, 14);
		panel_2.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Fecha Compra");
		lblNewLabel_18.setBounds(10, 109, 104, 14);
		panel_2.add(lblNewLabel_18);
		
		facturaNumeroTxt = new JTextField();
		facturaNumeroTxt.setBounds(171, 11, 86, 20);
		panel_2.add(facturaNumeroTxt);
		facturaNumeroTxt.setColumns(10);
		
		facturaNitTxt = new JTextField();
		facturaNitTxt.setBounds(171, 59, 86, 20);
		panel_2.add(facturaNitTxt);
		facturaNitTxt.setColumns(10);
		
		fechaCompraTxt = new JTextField();
		fechaCompraTxt.setBounds(171, 106, 86, 20);
		panel_2.add(fechaCompraTxt);
		fechaCompraTxt.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.setBounds(10, 160, 122, 23);
		panel_2.add(btnNewButton_2);
		
		JButton btnLimpiar_1 = new JButton("Limpiar");
		btnLimpiar_1.setBounds(171, 160, 89, 23);
		panel_2.add(btnLimpiar_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Obra", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_19 = new JLabel("Id Obra");
		lblNewLabel_19.setBounds(10, 24, 85, 14);
		panel_3.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Nombre");
		lblNewLabel_20.setBounds(10, 70, 85, 14);
		panel_3.add(lblNewLabel_20);
		
		idObraTxt = new JTextField();
		idObraTxt.setBounds(105, 21, 86, 20);
		panel_3.add(idObraTxt);
		idObraTxt.setColumns(10);
		
		obraNombreTxt = new JTextField();
		obraNombreTxt.setBounds(105, 67, 86, 20);
		panel_3.add(obraNombreTxt);
		obraNombreTxt.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Guardar");
		btnNewButton_3.setBounds(10, 131, 121, 23);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_8 = new JButton("Limpiar");
		btnNewButton_8.setBounds(176, 131, 106, 23);
		panel_3.add(btnNewButton_8);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Persona", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_21 = new JLabel("Cedula");
		lblNewLabel_21.setBounds(10, 11, 80, 14);
		panel_4.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Nombre");
		lblNewLabel_22.setBounds(10, 58, 80, 14);
		panel_4.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Apellido");
		lblNewLabel_23.setBounds(10, 110, 80, 14);
		panel_4.add(lblNewLabel_23);
		
		cedulaTxt = new JTextField();
		cedulaTxt.setBounds(100, 8, 86, 20);
		panel_4.add(cedulaTxt);
		cedulaTxt.setColumns(10);
		
		personaNombreTxt = new JTextField();
		personaNombreTxt.setBounds(100, 55, 86, 20);
		panel_4.add(personaNombreTxt);
		personaNombreTxt.setColumns(10);
		
		apellidoTxt = new JTextField();
		apellidoTxt.setBounds(100, 107, 86, 20);
		panel_4.add(apellidoTxt);
		apellidoTxt.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Guardar");
		btnNewButton_4.setBounds(10, 189, 146, 23);
		panel_4.add(btnNewButton_4);
		
		JButton btnNewButton_9 = new JButton("Limpiar");
		btnNewButton_9.setBounds(195, 189, 123, 23);
		panel_4.add(btnNewButton_9);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Prestamos", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_24 = new JLabel("Fecha Prestamo");
		lblNewLabel_24.setBounds(10, 11, 119, 14);
		panel_5.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Fecha Entrega");
		lblNewLabel_25.setBounds(10, 57, 119, 14);
		panel_5.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Asignado a ");
		lblNewLabel_26.setBounds(10, 106, 119, 14);
		panel_5.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Estado de Retorno");
		lblNewLabel_27.setBounds(10, 160, 119, 14);
		panel_5.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Obra Prestado");
		lblNewLabel_28.setBounds(311, 8, 89, 14);
		panel_5.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Serial Activo");
		lblNewLabel_29.setBounds(311, 54, 89, 14);
		panel_5.add(lblNewLabel_29);
		
		fechaPrestamoTxt = new JTextField();
		fechaPrestamoTxt.setBounds(155, 5, 86, 20);
		panel_5.add(fechaPrestamoTxt);
		fechaPrestamoTxt.setColumns(10);
		
		fechaEntregaTxt = new JTextField();
		fechaEntregaTxt.setBounds(155, 51, 86, 20);
		panel_5.add(fechaEntregaTxt);
		fechaEntregaTxt.setColumns(10);
		
		asignadoTxt = new JTextField();
		asignadoTxt.setBounds(155, 100, 86, 20);
		panel_5.add(asignadoTxt);
		asignadoTxt.setColumns(10);
		
		estadoRetornoTxt = new JTextField();
		estadoRetornoTxt.setBounds(155, 154, 86, 20);
		panel_5.add(estadoRetornoTxt);
		estadoRetornoTxt.setColumns(10);
		
		obraPrestadoTxt = new JTextField();
		obraPrestadoTxt.setBounds(410, 5, 86, 20);
		panel_5.add(obraPrestadoTxt);
		obraPrestadoTxt.setColumns(10);
		
		serialPrestamoTxt = new JTextField();
		serialPrestamoTxt.setBounds(410, 51, 86, 20);
		panel_5.add(serialPrestamoTxt);
		serialPrestamoTxt.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Guardar");
		btnNewButton_5.setBounds(10, 226, 119, 23);
		panel_5.add(btnNewButton_5);
		
		JButton btnNewButton_10 = new JButton("Limpiar");
		btnNewButton_10.setBounds(175, 226, 133, 23);
		panel_5.add(btnNewButton_10);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Codigos", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_31 = new JLabel("Codigo");
		lblNewLabel_31.setBounds(10, 11, 76, 14);
		panel_6.add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("Nombre");
		lblNewLabel_32.setBounds(10, 51, 76, 14);
		panel_6.add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("Descripcion");
		lblNewLabel_33.setBounds(10, 93, 76, 14);
		panel_6.add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("Estado");
		lblNewLabel_34.setBounds(10, 136, 76, 14);
		panel_6.add(lblNewLabel_34);
		
		codigoTxt = new JTextField();
		codigoTxt.setBounds(147, 5, 86, 20);
		panel_6.add(codigoTxt);
		codigoTxt.setColumns(10);
		
		codigoNombreTxt = new JTextField();
		codigoNombreTxt.setBounds(147, 45, 86, 20);
		panel_6.add(codigoNombreTxt);
		codigoNombreTxt.setColumns(10);
		
		codigoDescripcionTxt = new JTextField();
		codigoDescripcionTxt.setBounds(147, 87, 86, 20);
		panel_6.add(codigoDescripcionTxt);
		codigoDescripcionTxt.setColumns(10);
		
		codigoEstadoTxt = new JTextField();
		codigoEstadoTxt.setBounds(147, 130, 86, 20);
		panel_6.add(codigoEstadoTxt);
		codigoEstadoTxt.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Guardar");
		btnNewButton_6.setBounds(10, 196, 115, 23);
		panel_6.add(btnNewButton_6);
		
		JButton btnLimpiar_2 = new JButton("Limpiar");
		btnLimpiar_2.setBounds(157, 196, 123, 23);
		panel_6.add(btnLimpiar_2);
	}
}
