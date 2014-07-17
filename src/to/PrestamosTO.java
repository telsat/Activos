package to;

import java.util.Date;

public class PrestamosTO {
	private String id;
	private Date fecha_prestamo;
	private Date fecha_entrega;
	private String asignado;
	private String estado_retorno;
	private int obra_prestamo;
	private String serial_activo;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	public Date getFecha_entrega() {
		return fecha_entrega;
	}
	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	public String getAsignado() {
		return asignado;
	}
	public void setAsignado(String asignado) {
		this.asignado = asignado;
	}
	public String getEstado_retorno() {
		return estado_retorno;
	}
	public void setEstado_retorno(String estado_retorno) {
		this.estado_retorno = estado_retorno;
	}
	public int getObra_prestamo() {
		return obra_prestamo;
	}
	public void setObra_prestamo(int obra_prestamo) {
		this.obra_prestamo = obra_prestamo;
	}
	public String getSerial_activo() {
		return serial_activo;
	}
	public void setSerial_activo(String serial_activo) {
		this.serial_activo = serial_activo;
	}
	
	

}
