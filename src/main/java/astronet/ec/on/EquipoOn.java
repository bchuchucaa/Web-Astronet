package astronet.ec.on;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.EquipoDAO;
import astronet.ec.modelo.Equipo;

@Stateless

public class EquipoOn {
	
	@Inject
	private EquipoDAO equipoDao;
	
	public void guardar(Equipo equipo) {

		equipoDao.save(equipo);
		
	}
	
	public void guardarEquipo(Equipo equipo) {
		equipoDao.create(equipo);
	}
	
	public void actualizar (Equipo equipo) {
		equipoDao.update(equipo);
	}

}
