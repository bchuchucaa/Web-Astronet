package astronet.ec.dao;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Registro;

@Stateless
public class AgendamientoDAO {
	
	@Inject
	private EntityManager em;
	
	//.L.
	
	public void save(Agendamiento ag) {
		if (this.read(ag.getId())!=null) {
			this.update(ag);
		}else 
			this.create(ag);
	}
	
	public void create(Agendamiento ag) {
		em.persist(ag);
	}
	
	public Agendamiento read(int id) {
		return em.find(Agendamiento.class, id);
	}
	
	public void update(Agendamiento ag) {
		em.merge(ag);
		
	}
	
	public List<Agendamiento> getActividades(String nombre) {
		String jpql = "SELECT ag FROM Agendamiento ag  where ag.tecnicoResponsable = :busqueda";
		Query q = em.createQuery(jpql, Agendamiento.class);
		q.setParameter("busqueda", nombre);
		List<Agendamiento> agendamientos =  q.getResultList();
		return agendamientos;
	}
	
	

	


}
	
	