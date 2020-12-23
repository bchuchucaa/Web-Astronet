package astronet.ec.vista;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import astronet.ec.modelo.Empleado;
import astronet.ec.on.EmpleadoON;
import astronet.ec.util.SessionUtils;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
	
	@Inject
	private EmpleadoON empon;	
	private Empleado empleado;//declaracion de objeto para evitar declarar mail y password
	@PostConstruct
	public void init() {
		empleado=new Empleado();
	}
		
//	ZONA GET /SET
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
//	ZONA GET /SET
	
//	ZONA METODOS 
	public String login() {
		String direccion=null;
		try {
			empleado = empon.login(empleado.getEmail(), empleado.getPassword());
			if (empleado != null) {
				
				
				String department=empleado.getDepartamento();
				HttpSession session = SessionUtils.getSession();
				switch (department) {
				case "Radio":  					
					session.setAttribute("username", empleado);
					System.out.println("login exitoso" + " " + empleado.getId() + " " + empleado.getNombre());
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
	
//	FIN ZONA METODOS 

}
