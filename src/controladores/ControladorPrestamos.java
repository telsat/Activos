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
			datos[x][2] = prestamos.get(x).getEstado_retorno();
			datos[x][0] = prestamos.get(x).getFecha_prestamo();
			datos[x][1] = prestamos.get(x).getFecha_entrega();
			datos[x][3] = prestamos.get(x).getObra_prestamo();
			datos[x][4] = prestamos.get(x).getSerial_activo();
			datos[x][5] = prestamos.get(x).getAsignado();
			datos[x][6] = prestamos.get(x).getNombrepersona();
			datos[x][7] = prestamos.get(x).getNombreobra();
			
		}	
		
		
		return datos;
	}
	
	@SuppressWarnings("unchecked")
	public Object[][] EquiposEnObra(int obraId){
		String quer = "SELECT * FROM prestamos WHERE obra_prestamo = '"+obraId+"' and fecha_entrega is null;";
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
		
		Date fecha_prestamo = prestamoTO.getFecha_prestamo();		
		String asignado = prestamoTO.getAsignado();			
		int obra_prestamo = prestamoTO.getObra_prestamo();
		String serial_activo = prestamoTO.getSerial_activo();	
		int id = prestamoTO.getId();
		try {
			em.getTransaction().begin();
			prestamos.setAsignado(asignado);
			prestamos.setId(id);			
			prestamos.setFecha_prestamo(fecha_prestamo);			
			prestamos.setObra_prestamo(obra_prestamo);
			prestamos.setSerial_activo(serial_activo);
			em.persist(prestamos);
			em.getTransaction().commit();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void RegistrarDevolucion(PrestamosTO prestamoTO){
		String serial = prestamoTO.getSerial_activo();
		Date fecha_entrega = prestamoTO.getFecha_entrega();
		String estado = prestamoTO.getEstado_retorno();
		String consulta = "SELECT MAX(id) FROM prestamos WHERE serial_activo = '"+serial+"';";
		Query query = em.createNativeQuery(consulta);		
		
		int id = (int) query.getSingleResult();					
		
		Prestamos pres = em.find(Prestamos.class, id);
		if(pres!=null){
			em.getTransaction().begin();
			pres.setEstado_retorno(estado);
			pres.setFecha_entrega(fecha_entrega);
			em.persist(pres);
			em.getTransaction().commit();
		}
		
		
		
	}

}
