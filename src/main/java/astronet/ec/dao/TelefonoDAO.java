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
import astronet.ec.modelo.Telefono;

@Stateless
public class TelefonoDAO {
	
	@Inject
	private EntityManager em;
	
	
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
	

	

	//THIS THE NEW SHIT



}
