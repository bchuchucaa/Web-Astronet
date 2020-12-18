package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.AgendamientoDAO;
import astronet.ec.modelo.Agendamiento;


@Stateless
public class AgendamientoON {
	
	@Inject
	private AgendamientoDAO agdao;
	
	public void guardar(Agendamiento ag) {
		agdao.save(ag);
	}

	public List<Agendamiento> getAgendamiento(String nombre) {
			return agdao.getActividades(nombre);
	}
	
	public void actualizar(Agendamiento ag) {
		agdao.update(ag);
	}

	
	
	
}
