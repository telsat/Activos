package controladores;

import javax.persistence.EntityManager;


import entidades.Persona;
import to.PersonaTO;
import util.EntityManagerUtil;

public class ControladorPersonas {
	private EntityManager em = EntityManagerUtil.getEntityManager();
	
	Persona persona = new Persona();
	
	public void GuardarPersona(PersonaTO personaTO){
		String cedula = personaTO.getCedula();
		String nombre = personaTO.getNombre();
		String apellido = personaTO.getApellido();
		
		try {
			em.getTransaction().begin();
			persona.setCedula(cedula);
			persona.setNombre(nombre);
			persona.setApellido(apellido);
			em.persist(persona);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
