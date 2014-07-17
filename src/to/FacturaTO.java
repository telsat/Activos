package to;

import java.util.Date;

public class FacturaTO {
	private String numero;
	private String nit_proveedor;
	private Date fecha_compra;
	
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNit_proveedor() {
		return nit_proveedor;
	}
	public void setNit_proveedor(String nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}
	public Date getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	
	

}
