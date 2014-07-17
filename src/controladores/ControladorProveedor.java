package controladores;

import javax.persistence.EntityManager;

import entidades.Proveedor;
import to.ProveedorTO;
import util.EntityManagerUtil;

public class ControladorProveedor {
	private EntityManager em = EntityManagerUtil.getEntityManager();
	Proveedor proveedor = new Proveedor();
	
	public void GuardarProveedor(ProveedorTO proveedorTO){
		String nit = proveedorTO.getNit();
		String nombre = proveedorTO.getNombre();
		String direccion = proveedorTO.getDireccion();
		String telefono = proveedorTO.getTelefono();
		String contacto  = proveedorTO.getContacto();
		String email = proveedorTO.getEmail();
		String filtro = proveedorTO.getFiltro() ;
		
		try {
			em.getTransaction().begin();
			proveedor.setContacto(contacto);
			proveedor.setDireccion(direccion);
			proveedor.setEmail(email);
			proveedor.setFiltro(filtro);
			proveedor.setNit(nit);
			proveedor.setNombre(nombre);
			proveedor.setTelefono(telefono);
			em.persist(proveedor);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
