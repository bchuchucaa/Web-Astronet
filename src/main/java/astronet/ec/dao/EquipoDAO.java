package astronet.ec.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Equipo;

@Stateless
public class EquipoDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(Equipo equipo) {
		if (this.read(equipo.getId())!=null) {
			this.update(equipo);
		}else 
			this.create(equipo);
		
	}
	
	public void update(Equipo equipo) {
		//System.out.println("registro "+cli.getRegistro().get(0).toString());
		em.merge(equipo);
		
	}

	public void delete(int id) {
		Equipo equ = read(id);
		em.remove(equ);
	}
	
	public Equipo read(int id) {
		return em.find(Equipo.class, id);
	}
	
	public void create(Equipo equipo) {
		em.persist(equipo);
		
	}
	public List<Equipo> find(){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Equipo> criteriaQuery = criteriaBuilder.createQuery(Equipo.class);
		// Se establece la clausula FROM
		criteriaQuery.select(criteriaQuery.from(Equipo.class));
		System.out.println("Sech");
		return em.createQuery(criteriaQuery).getResultList();
	}
	
	public Equipo seleccionar(String nombre) {
		String jpql="SELECT equipo FROM Equipo equipo WHERE equipo.equi_marca LIKE?1";
		Query q= em.createQuery(jpql, Equipo.class);
		q.setParameter(1, nombre);
		Equipo equi=(Equipo) q.getSingleResult();
		return equi;
	
	}	
	
/*
 * 
		String jpql="SELECT emp FROM Empleado emp WHERE emp.email LIKE?1 AND emp.password LIKE?2";
		Query q= em.createQuery(jpql, Empleado.class);
		q.setParameter(1, email);
		q.setParameter(2, password);
		Empleado empl=(Empleado) q.getSingleResult();
		return empl;
 */


}
