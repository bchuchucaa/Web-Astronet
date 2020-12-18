package astronet.ec.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Servicio;

@Stateless
public class ServicioDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(Servicio ser) {
		if (this.read(ser.getId()) != null) 
			
			this.update(ser);
		else 
			System.out.println("hola datos "+ser);
			this.create(ser);
		
	}
	
	public void create(Servicio ser) {
		em.persist(ser);
		
	}
	
	public Servicio read(int id) {
		return em.find(Servicio.class, id);
	}
	
	public void update(Servicio ser) {
		em.merge(ser);
	}
	
	public void delete(int id) {
		Servicio ser = read(id);
		em.remove(ser);
	}

}
