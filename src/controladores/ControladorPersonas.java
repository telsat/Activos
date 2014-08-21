package controladores;

import java.util.List;

import javax.persistence.EntityManager;


import javax.persistence.Query;

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
	
	
	@SuppressWarnings("unchecked")
	public Object[][] ListaPersonas(){
		String consulta = "select * from persona";
		Query query = em.createNativeQuery(consulta,Persona.class);
		List<Persona> personas = query.getResultList();
		int size = personas.size();
		Object datos[][] = new Object[size][3];
		for(int i = 0; i < size; i++){
			datos[i][0] =  personas.get(i).getCedula();
			datos[i][1] =  personas.get(i).getNombre();
			datos[i][2] =  personas.get(i).getApellido();
			
		}
		return datos;
	}

}
