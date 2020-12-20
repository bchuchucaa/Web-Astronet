package astronet.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Equipo;
import astronet.ec.modelo.Telefono;

@Stateless
public class TelefonoDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(Telefono tel) {
		if (this.read(tel.getId())!=null) {
			this.update(tel);
		}else 
			this.create(tel);
		
	}
	
	public Telefono read(int id) {
		return em.find(Telefono.class, id);
	}
	
	public void update(Telefono tel) {
		//System.out.println("registro "+cli.getRegistro().get(0).toString());
		em.merge(tel);
		
	}
	
	public void create(Telefono tel) {
		em.persist(tel);
		
	}
	
	
	public List<Telefono> getTelefonos(Cliente cliente) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Telefono> criteriaQuery = criteriaBuilder.createQuery(Telefono.class);
		// Se establece la clausula FROM
		Root<Telefono> root = criteriaQuery.from(Telefono.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("cliente"), cliente)); // criteriaQuery.multiselect(root.get(atr))
		// // Se configuran los predicados,
		// combinados por AND
		System.out.println("************8");
		
		return em.createQuery(criteriaQuery).getResultList();
		
	}
	

	

	



}
