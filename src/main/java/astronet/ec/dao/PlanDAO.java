package astronet.ec.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import astronet.ec.modelo.Plan;

public class PlanDAO {
	@Inject
	private EntityManager em;
	
	public void save(Plan Plan) {
		if (this.read(Plan.getId())!=null) {
			this.update(Plan);
		}else 
			this.create(Plan);
		
	}
	
	public void update(Plan Plan) {
		//System.out.println("registro "+cli.getRegistro().get(0).toString());
		em.merge(Plan);
		
	}

	public void delete(int id) {
		Plan equ = read(id);
		em.remove(equ);
	}
	
	public Plan read(int id) {
		return em.find(Plan.class, id);
	}
	
	public void create(Plan Plan) {
		em.persist(Plan);
		
	}
	
	public List<Plan> find(){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Plan> criteriaQuery = criteriaBuilder.createQuery(Plan.class);
		// Se establece la clausula FROM
		criteriaQuery.select(criteriaQuery.from(Plan.class));
		System.out.println("Sech");
		return em.createQuery(criteriaQuery).getResultList();
		
	}
}
