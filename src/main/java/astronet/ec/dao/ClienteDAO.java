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
import astronet.ec.modelo.Servicio;
import astronet.ec.modelo.Telefono;

@Stateless
public class ClienteDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(Cliente cli) {
		if (this.read(cli.getId())!=null) {
			this.update(cli);
		}else 
			this.create(cli);
		
	}
	
	public void create(Cliente cli) {
		em.persist(cli);
		
	}
	
	public Cliente read(int id) {
		return em.find(Cliente.class, id);
	}
	
	public Cliente read3(int id) {
		String jpql = "SELECT cli FROM Cliente cli   WHERE cli.id = :a";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("a", id);
		Cliente cli = (Cliente) q.getSingleResult();
				
		return cli;

	}
	
	public void update(Cliente cli) {
		//System.out.println("registro "+cli.getRegistro().get(0).toString());
		em.merge(cli);
		
	}
	
	public void update1(int cli) {
		String jpql = "UPDATE public.cliente\r\n" + 
				"	SET cli_cedula=?, cli_celular=?, cli_convencional=?, cli_dirprincipal=?, cli_dirreferencia=?, cli_dirsecundaria=?, cli_email=?, cli_latitud=?, cli_longitud=?, cli_nombre=?, antcliente_fk=?\r\n" + 
				"	WHERE cli_id= :id;";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("id", cli);
	}
	
	public void delete(int id) {
		Cliente cli = read(id);
		em.remove(cli);
	}
	public List<Cliente> getCliente() {
		String jpql = "SELECT cliente FROM Cliente cliente ";
		Query q = em.createQuery(jpql, Cliente.class);
		List<Cliente> clientes = q.getResultList();
		return clientes;
	}
	
	public List<Telefono> getTelefonos(String cedula) {
		System.out.println("CLIENTE BUSCADO -----> "+ cedula);
		Cliente cli= new Cliente();
		cli=buscarCedula(cedula);
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Telefono> criteriaQuery = criteriaBuilder.createQuery(Telefono.class);
		// Se establece la clausula FROM
		Root<Telefono> root = criteriaQuery.from(Telefono.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("cliente"), cli)); // criteriaQuery.multiselect(root.get(atr))
		// // Se configuran los predicados,
		// combinados por AND
		System.out.println(em.createQuery(criteriaQuery).getResultList());
		
		return em.createQuery(criteriaQuery).getResultList();
		
	}
	

	

	
	public Cliente buscarCedula(String cedula) {
		String jpql = "SELECT cli FROM Cliente cli WHERE cli.cedula = :cedula";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("cedula", cedula);
		Cliente clien = (Cliente) q.getSingleResult();
		clien.getCedula();
		clien.getNombre();
		return clien;
	}
	
	public Cliente buscarNombre(String nombre) {
		String jpql = "SELECT cli FROM Cliente cli WHERE cli.nombre = :nombre";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("nombre", nombre);
		Cliente clien = (Cliente) q.getSingleResult();
		return clien;
	}


}
