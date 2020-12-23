package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.EquipoDAO;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Equipo;

@Stateless

public class EquipoOn {
	
	@Inject
	private EquipoDAO equipoDao;
	
	private List<Equipo> listadoAntenas;
	
	public void guardar(Equipo equipo) {

		equipoDao.save(equipo);
		
	}
	
	public Equipo buscarAntena(int id) {
		return equipoDao.read(id);
	}
	public void guardarEquipo(Equipo equipo) {
		equipoDao.create(equipo);
	}
	public void actualizar (Equipo equipo) {
		equipoDao.update(equipo);
	}
	/*
	public List<Equipo> getListadoEquipo() {
		return equipoDao.getListadoEquipos();
	}
*/
	

	public List<Equipo> getListadoAntenas() {
		return equipoDao.find();
	}

	public void setListadoAntenas(List<Equipo> listadoAntenas) {
		this.listadoAntenas = equipoDao.find();
	}

}
