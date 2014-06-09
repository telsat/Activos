package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="activo")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=1)
public class Activo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private String serial_telsat;
	private String serial;
	private String modelo;
	private String descripcion;
	private String proveedor;
	private String factura;
	private String foto;
	private String estado;
	private int precio;
	private String tipo_activo;
	
	
	public String getSerial_telsat() {
		return serial_telsat;
	}
	public void setSerial_telsat(String serial_telsat) {
		this.serial_telsat = serial_telsat;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getTipo_activo() {
		return tipo_activo;
	}
	public void setTipo_activo(String tipo_activo) {
		this.tipo_activo = tipo_activo;
	}
	
	

}
