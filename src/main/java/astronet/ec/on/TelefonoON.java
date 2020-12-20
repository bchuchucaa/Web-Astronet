package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.ClienteDAO;
import astronet.ec.dao.TelefonoDAO;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;
import astronet.ec.modelo.Telefono;

@Stateless
public class TelefonoON {

	@Inject
	private TelefonoDAO teldao;
	
	public void guardar(Telefono tel) {

		teldao.save(tel);
	}
	
	public List<Telefono> getTelefonos(Cliente cliente){
		List<Telefono> aux = teldao.getTelefonos(cliente);
		return aux;
	}
	
	
	

}
