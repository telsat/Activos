package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Activo;
import util.EntityManagerUtil;

public class ControladorActivos {
	private EntityManager em = EntityManagerUtil.getEntityManager();
	
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

}
