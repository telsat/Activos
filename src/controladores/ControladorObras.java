package controladores;

import javax.persistence.EntityManager;

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

}
