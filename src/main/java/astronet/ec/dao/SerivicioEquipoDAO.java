package astronet.ec.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import astronet.ec.modelo.EquipoServicio;

public class SerivicioEquipoDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(EquipoServicio EquipoServicio) {
		if (this.read(EquipoServicio.getId())!=null) {
			this.update(EquipoServicio);
		}else 
			this.create(EquipoServicio);
		
	}
	
	public void update(EquipoServicio EquipoServicio) {
		//System.out.println("registro "+cli.getRegistro().get(0).toString());
		em.merge(EquipoServicio);
		
	}

	public void delete(int id) {
		EquipoServicio equ = read(id);
		em.remove(equ);
	}
	
	public EquipoServicio read(int id) {
		return em.find(EquipoServicio.class, id);
	}
	
	public void create(EquipoServicio EquipoServicio) {
		em.persist(EquipoServicio);
		
	}
	
	public List<EquipoServicio> find(){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<EquipoServicio> criteriaQuery = criteriaBuilder.createQuery(EquipoServicio.class);
		// Se establece la clausula FROM
		criteriaQuery.select(criteriaQuery.from(EquipoServicio.class));
		System.out.println("Sech");
		return em.createQuery(criteriaQuery).getResultList();
		
	}
}
