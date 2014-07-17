package controladores;

import java.util.Date;

import javax.persistence.EntityManager;

import entidades.Factura;
import to.FacturaTO;
import util.EntityManagerUtil;

public class ControladorFactura {
	private EntityManager em = EntityManagerUtil.getEntityManager();
	Factura factura = new Factura();
	
	
	public void GuardarFactura(FacturaTO facturaTO){
		String numero = facturaTO.getNumero();
		String nit_proveedor = facturaTO.getNit_proveedor();
		Date fecha_compra = facturaTO.getFecha_compra();
		
		try {
			em.getTransaction().begin();
			factura.setNumero(numero);
			factura.setNit_proveedor(nit_proveedor);
			factura.setFecha_compra(fecha_compra);
			em.persist(factura);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	

}
