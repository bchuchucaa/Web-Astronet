package astronet.ec.on;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.SerivicioEquipoDAO;
import astronet.ec.modelo.EquipoServicio;

@Stateless
public class EquipoServicioON {

	@Inject
	private SerivicioEquipoDAO serveqdao;

	public void crearI(EquipoServicio ins) {
		serveqdao.create(ins);
	}

	public void actualizar(EquipoServicio ins) {
		serveqdao.update(ins);
	}
}
