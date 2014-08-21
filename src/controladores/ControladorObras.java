package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Obra;
import to.ObraTO;
import util.EntityManagerUtil;

public class ControladorObras {
	private EntityManager em = EntityManagerUtil.getEntityManager();
	Obra obra = new Obra();
	
	public void GuardarObra(ObraTO obraTO){
		int id = obraTO.getId();
		String nombre = obraTO.getNombre();
		
		try {
			em.getTransaction().begin();
			obra.setId(id);
			obra.setNombre(nombre);
			em.persist(obra);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public Object[][] ListarObras(){
		String consulta = "select * from obra";
		Query query = em.createNativeQuery(consulta,Obra.class);
		List<Obra> obras = query.getResultList();
		int size = obras.size();
		Object[][] datos = new Object[size][2];
		for (int i = 0; i < size; i++) {
			datos[i][0] = obras.get(i).getId();
			datos[i][1] = obras.get(i).getNombre();
			
		}
		return datos;
	}

}
