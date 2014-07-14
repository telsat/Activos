package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Prestamos;
import to.PrestamosTO;
import util.EntityManagerUtil;

public class ControladorPrestamos {
	private EntityManager em = EntityManagerUtil.getEntityManager();
	
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

}
