package ec.edu.ups.ppw63.demo63.dao;

import java.util.List;

import ec.edu.ups.ppw63.demo63.model.Universidad;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UniversidadDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void insert(Universidad universidad) {
		em.persist(universidad);
	}
		
	public void update(Universidad universidad) {
		em.merge(universidad);	
	}

	public void remove(int codigo) {
		Universidad universidad = em.find(Universidad.class, codigo);
		em.refresh(universidad);
	}
	
	public Universidad read(int codigo) {
		Universidad universidad = em.find(Universidad.class, codigo);
		return universidad;
	}
	
	public List<Universidad> getAll(){
		String jpql = "SELECT u FROM Universidad u"; //JPQL es sensible a mayusculas --- para realizar una consulta es similar pero hay q ue tener en cuenta que se tiene una variabe en lugar del alterisco y hay que referenciar a la entidad  no a la tabla
												 // Es decir se debe consultar en la entidad mas no directamente a una tabla de la base de datos 
												 // En lugar del * se coloca una variable, esa variable hace referencia al alias de la entidad
		Query q = em.createQuery(jpql, Universidad.class);
		return q.getResultList();
	}
}
