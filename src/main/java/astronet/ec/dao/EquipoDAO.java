package astronet.ec.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import astronet.ec.modelo.Cliente;
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
	

}
