package astronet.ec.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import astronet.ec.modelo.Empleado;
import astronet.ec.on.EmpleadoON;
import astronet.ec.util.SessionUtils;



@ManagedBean(name = "adminBean")
@ViewScoped
public class AdminBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Empleado> empleados;//listar todos los empleados
	private Empleado empleado;//objeto para editar	
	private Empleado empleadoAdmin;//EmpleadoAdministrador	
	private int idAdmin;
	
	//@ManagedProperty(value ="#{login}" )//"#{login}" <- 
	//private EmpleadoController empCon;
	@Inject
	private EmpleadoON empon;
	//@PostConstruct
	public void init() {
		System.out.println("Param pedri: "+this.idAdmin);
		this.empleados=empon.getListadoEmpleado();
		this.empleadoAdmin=empon.read(this.idAdmin);
	}
	
	
//	ZONA GET/SET
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}	
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public Empleado getEmpleadoAdmin() {
		return empleadoAdmin;
	}
	public void setEmpleadoAdmin(Empleado empleadoAdmin) {
		this.empleadoAdmin = empleadoAdmin;
	}
	/*
	public EmpleadoController getEmpCon() {
		return empCon;
	}
	public void setEmpCon(EmpleadoController empCon) {
		this.empCon = empCon;
	}*/
	
	
	
	
//	FIN ZONA GET/SET

//	ZONA METODOS
	



	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index.xhtml";
	}
	
	
	
//	FIN ZONA METODOS
	
}
