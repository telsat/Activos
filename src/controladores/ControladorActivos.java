package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Activo;
import to.ActivoTO;
import util.EntityManagerUtil;

public class ControladorActivos {
	
	
	private EntityManager em = EntityManagerUtil.getEntityManager();
	Activo activo = new Activo();
	
	@SuppressWarnings("unchecked")
	public Object[][] EstadoActivos(String estado){
		String estados = "SELECT * FROM activo WHERE estado = '"+estado+"' ;";
		Query query = em.createNativeQuery(estados, Activo.class);
		List<Activo> activos = query.getResultList();
		int size = activos.size();
		Object [][] datos = new Object[size][10];
		for(int x = 0; x < size; x++){
			datos[x][0] = activos.get(x).getSerial();
			datos[x][1] = activos.get(x).getTipo_activo();
			datos[x][2] = activos.get(x).getModelo();			
			
		}		
		return datos;
		
	}
	
	public void GuardarActivo(ActivoTO activoTO){
		String serialTelsat = activoTO.getSerial_telsat();
		String serial = activoTO.getSerial();
		String modelo = activoTO.getModelo();
		String descripcion = activoTO.getDescripcion();
		String proveedor = activoTO.getProveedor();
		String factura = activoTO.getFactura();
		String foto = activoTO.getFoto();
		String estado = activoTO.getEstado();
		int precio = activoTO.getPrecio();
		String tipoActivo = activoTO.getTipo_activo();
		
		try {
			em.getTransaction().begin();
			activo.setSerial(serial);
			activo.setSerial_telsat(serialTelsat);
			activo.setModelo(modelo);
			activo.setDescripcion(descripcion);
			activo.setProveedor(proveedor);
			activo.setFactura(factura);
			activo.setFoto(foto);
			activo.setEstado(estado);
			activo.setPrecio(precio);
			activo.setTipo_activo(tipoActivo);
			em.persist(activo);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void RegistrarPrestamo(ActivoTO activoTO){
		String serialT = activoTO.getSerial_telsat();
		String estado = activoTO.getEstado();
		
		Activo act = em.find(Activo.class,serialT);
		if(act!=null){
			em.getTransaction().begin();
			act.setEstado(estado);
			em.persist(act);
			em.getTransaction().commit();
			
		}
		
	}

}
