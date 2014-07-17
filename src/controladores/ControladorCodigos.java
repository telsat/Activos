package controladores;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Codigos;
import to.CodigosTO;
import util.EntityManagerUtil;

public class ControladorCodigos {
	private EntityManager em = EntityManagerUtil.getEntityManager();
	Codigos codigos = new Codigos();
	CodigosTO codigosTO = new CodigosTO();
	@SuppressWarnings("unchecked")
	
	
	public String[] ListaCodigos(){
		String select = "select * from codigos";
		
		Query query = em.createNativeQuery(select,Codigos.class);
		List<Codigos> lista = query.getResultList();
		int size = lista.size();
		String[][] codigos = new String[size][2];
		String[] codes = {""};
		String nombre;
		for(int x = 0; x < size; x++){
			String cod = codigos[x][0] = lista.get(x).getCodigo();
			String name = codigos[x][1] = lista.get(x).getNombre();
			nombre = cod +" - "+ name;
			codes[x] = nombre;
		}	
		
		return codes;
	}
	
	
	public static synchronized String generateUniqueID() {
		final char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','a','b','c','d','e','f'};
		StringBuilder uniqueId = new StringBuilder("");
		Random rn = new Random(System.nanoTime());
		
		for (int i = 0; i < 3; ++i) {
			int random = rn.nextInt();
			uniqueId.append(digits[(random & 0xf0) >> 4]);
			uniqueId.append(digits[random & 0x0f]);
			}
		
		return uniqueId.toString();
	}
	
	
	
	public void GuardarCodigos(CodigosTO codigosTO){
		String codigo = codigosTO.getCodigo();
		String nombre = codigosTO.getNombre();
		String descripcion = codigosTO.getDescripcion();
		String estado = codigosTO.getEstado();
		
		try {
			em.getTransaction().begin();
			codigos.setCodigo(codigo);
			codigos.setDescripcion(descripcion);
			codigos.setEstado(estado);
			codigos.setNombre(nombre);
			em.persist(codigos);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
