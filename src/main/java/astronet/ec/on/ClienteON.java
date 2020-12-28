package astronet.ec.on;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import astronet.ec.dao.ClienteDAO;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;
import astronet.ec.modelo.Telefono;

@Stateless
public class ClienteON {

	@Inject
	private ClienteDAO clidao;
	@Inject
	private Registro registro;
	
	

	public void guardar(Cliente cli) {

		clidao.save(cli);
	}
	
	public void guardarCliente(Cliente cli) {
		clidao.create(cli);
	}
	
	public void actualizar (Cliente cli) {
		clidao.update(cli);
	}
	
	
	public List<Cliente> getListadoCliente() {
		return clidao.getCliente();
	}

	public Cliente getCliente(int cedula) {
		Cliente aux = clidao.read3(cedula);
		System.out.println("Prueba: " + " " + clidao.read3(cedula));
		return aux;
	}

	public Cliente getClienteCedula(String cedula) {
		Cliente aux = clidao.buscarCedula(cedula);
		registro.setIdClienteTemp(aux.getId());
		return aux;
	}

	public Cliente getClienteNombre(String nombre) {
		Cliente aux = clidao.buscarNombre(nombre);
		return aux;
	}
	
	
	public void dato() {
		
		System.out.println("hola datos");
	}
	/***
	 * metodo para la carga retardia y para obtener paginacion
	 */
	public List<Cliente> getResultList(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        List<Cliente> all = new ArrayList<Cliente>();
        all.addAll(this.clidao.getAll(first,pageSize,sortField,sortOrder,filters));
        return all;
    }
 
    public int count(String sortField, SortOrder sortOrder, Map<String, String> filters) {
        return this.clidao.getAll(-1,-1,null,null,filters).size();
    }
	

}
