package controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Prestamos;
import to.PrestamosTO;
import util.EntityManagerUtil;

public class ControladorPrestamos {
	private EntityManager em = EntityManagerUtil.getEntityManager();
	Prestamos prestamos = new Prestamos();
	
	@SuppressWarnings("unchecked")
	public Object[][] ActivosAsignados(PrestamosTO prestamosTO){
		String serial_activo = prestamosTO.getSerial_activo();
		String cedula = prestamosTO.getAsignado();
		
		String activosAsignados = "SELECT * FROM prestamos WHERE asignado = '"+cedula+"' or serial_activo = '"+serial_activo+"';";
		Query query = em.createNativeQuery(activosAsignados,Prestamos.class);
		List<Prestamos> prestamos = query.getResultList();
		int size = prestamos.size();
		Object [][] datos = new Object[size][7];
		
		for(int x = 0;x<size;x++){
			datos[x][0] = prestamos.get(x).getEstado_retorno();
			datos[x][1] = prestamos.get(x).getFecha_prestamo();
			datos[x][2] = prestamos.get(x).getFecha_entrega();
			datos[x][3] = prestamos.get(x).getObra_prestamo();
			datos[x][4] = prestamos.get(x).getSerial_activo();
			datos[x][5] = prestamos.get(x).getAsignado();
			
		}	
		
		
		return datos;
	}
	
	@SuppressWarnings("unchecked")
	public Object[][] EquiposEnObra(int obraId){
		String quer = "SELECT * FROM prestamos WHERE obra_prestamo = '"+obraId+"';";
		Query query = em.createNativeQuery(quer,Prestamos.class);
		List<Prestamos> activos = query.getResultList();
		int size = activos.size();
		Object [][] datos = new Object[size][7];
		for(int x = 0;x<size;x++){
			datos[x][0] = activos.get(x).getEstado_retorno();
			datos[x][1] = activos.get(x).getFecha_prestamo();
			datos[x][2] = activos.get(x).getFecha_entrega();
			datos[x][3] = activos.get(x).getObra_prestamo();
			datos[x][4] = activos.get(x).getSerial_activo();
			datos[x][5] = activos.get(x).getAsignado();
			
		}
		return datos;
	}
	
	
	public void GuardarPrestamo(PrestamosTO prestamoTO){
		String id = prestamoTO.getId();
		Date fecha_prestamo = prestamoTO.getFecha_prestamo();
		Date fecha_entrega = prestamoTO.getFecha_entrega();
		String asignado = prestamoTO.getAsignado();
		String estado_retorno = prestamoTO.getEstado_retorno();		
		int obra_prestamo = prestamoTO.getObra_prestamo();
		String serial_activo = prestamoTO.getSerial_activo();	
		
		try {
			em.getTransaction().begin();
			prestamos.setAsignado(asignado);
			prestamos.setEstado_retorno(estado_retorno);
			prestamos.setFecha_entrega(fecha_entrega);
			prestamos.setFecha_prestamo(fecha_prestamo);
			prestamos.setId(id);
			prestamos.setObra_prestamo(obra_prestamo);
			prestamos.setSerial_activo(serial_activo);
			em.persist(prestamos);
			em.getTransaction().commit();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
