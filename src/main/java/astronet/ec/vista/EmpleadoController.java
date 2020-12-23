package astronet.ec.vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Instalacion;
import astronet.ec.modelo.Registro;
import astronet.ec.on.EmpleadoON;
import astronet.ec.util.SessionUtils;
//este bean sera llamado desde (listadoEmpleado.xhtml)
@ManagedBean(name = "empleadoControllerBean")
@ViewScoped
public class EmpleadoController {

	@Inject
	private EmpleadoON empon;
	private String nombre;
	private int id;
	private int idUser;

	private Empleado empleado;
	private Empleado empUser;
	private Instalacion instalacion;
	private Registro registro;
	private List<Empleado> empleados;

	//@PostConstruct //importante que esto este comentado caso contrario genera errores
	public void init() {
		try {
			empUser=empon.read(idUser);
			empleado = new Empleado();
			instalacion = new Instalacion();
			registro = new Registro();
			empleados = empon.getEmpleado();
		} catch (Exception e) {
			System.out.println("CONTROL DE ERRORES EN EMPLEADOCONTROLLER");
		}
	}
	
	public void loadData() {
		System.out.println("codigo editar " + id);
		if (id == 0)
			return;
		
		empleado = empon.getEmpleado(id);			
	}

	//ZONA GET/SET
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Registro getRegistro() {
		return registro;
	}
	public void setRegistro(Registro registro) {
		this.registro = registro;
	}
	public String getNombre() {
		nombre = empleado.getNombre();
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Empleado getEmpUser() {
		return empUser;
	}
	public void setEmpUser(Empleado empUser) {
		this.empUser = empUser;
	}
	//FIN ZONA GET/SET
	
	
	



	public String editar(int codigo) {

		return "registrarEmpleado?faces-redirect=true&id=" + codigo;
	}
	
	public String eliminar(int codigo) {

		return "registrarEmpleado?faces-redirect=true&id=" + codigo;
	}
	
	/*
	 * Metodo para guardar o actualizar empleado
	 * 
	 */
	
	public String guardarEmpleado() {
		try {
			empon.guardar(empleado);
			init();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Metodo de inciar sesion
	 */
	public String login() {
		String direccion=null;
		String departamento1 = "Radio";
		String departamento2 = "FibraAdm";
		String departamento3 = "Tecnico Radio";
		String departamento4 = "Tecnico Fibra";
		String departamento5 = "Contabilidad";
		try {
			empleado = empon.login(empleado.getEmail(), empleado.getPassword());
			if (empleado != null) {
				
				
				String department=empleado.getDepartamento();
				HttpSession session = SessionUtils.getSession();
				switch (department) {
				case "Radio":  					
					session.setAttribute("username", empleado);
					registro = new Registro();
					instalacion = new Instalacion();
					System.out.println("login exitoso" + " " + empleado.getId() + " " + empleado.getNombre());
					id = empleado.getId();
					System.out.println("Login saliendo datos " + id);
					registro.setIdEmpleadoTemp(id);
					instalacion.setCodigoEmpTemp(id);	
					//return "agendamiento?faces-redirect=true&id=" + codigo;
					direccion="radio";
					break;
				case "Administrador":  					
					session.setAttribute("username", empleado);				
					System.out.println("login exitoso" + " " + empleado.getId() + " " + empleado.getNombre());
					direccion="viewAdmin?faces-redirect=true&id="+empleado.getId();
					//direccion="viewAdmin";
					break;
				case "Tecnico Radio":  
					direccion="viewTechRadio";
					break;
				case "Tecnico Fibra":  
					direccion="viewTechFibra";
					break;
				case "Contabilidad":  
					direccion="viewUserContabilidad";
					break;
				case "Secretaria":  
					direccion="callcenter";
					break;
				default:
					break;
				}
				
/*
				if (empleado.getDepartamento().equals(departamento1) || empleado.getDepartamento().equals(departamento2)) {
					HttpSession session = SessionUtils.getSession();
					session.setAttribute("username", empleado);
					registro = new Registro();
					instalacion = new Instalacion();
					System.out.println("login exitoso" + " " + empleado.getId() + " " + empleado.getNombre());
					id = empleado.getId();
					System.out.println("Login saliendo datos " + id);
					registro.setIdEmpleadoTemp(id);
					instalacion.setCodigoEmpTemp(id);
					System.out.println("Tiene permisos de todo");

					direccion= "callcenter";
				} if (empleado.getDepartamento().equals(departamento3)
						|| empleado.getDepartamento().equals(departamento4)
						|| empleado.getDepartamento().equals(departamento5)) {
					HttpSession session = SessionUtils.getSession();
					session.setAttribute("username", empleado);
					registro = new Registro();
					instalacion = new Instalacion();
					System.out.println("login exitoso" + " " + empleado.getId() + " " + empleado.getNombre());
					id = empleado.getId();
					System.out.println("Login saliendo datos " + id);
					registro.setIdEmpleadoTemp(id);
					instalacion.setCodigoEmpTemp(id);
					System.out.println("permisos solo de tecnico");
					

					direccion= "callcenter";
				}
*/				
			} 

		}catch (Exception e) {
			// TODO: handle exception
			FacesContext.
			getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
		}
		
		
		return direccion;
	}
	


	public String logout() {

		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index.xhtml";

	}

}
