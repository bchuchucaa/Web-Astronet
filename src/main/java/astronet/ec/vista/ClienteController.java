package astronet.ec.vista;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import astronet.ec.dao.TelefonoDAO;
import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Equipo;
import astronet.ec.modelo.Instalacion;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;
import astronet.ec.modelo.Telefono;
import astronet.ec.on.AgendamientoON;
import astronet.ec.on.ClienteON;
import astronet.ec.on.EmpleadoON;
import astronet.ec.on.EquipoOn;
import astronet.ec.on.InstalacionON;
import astronet.ec.on.RegistroON;
import astronet.ec.on.ServicioON;
import astronet.ec.on.TelefonoON;
import astronet.ec.vista.InstalacionController.ServicioFA;

@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {

	// private static final long serialVersionUID = 8799656478674716638L;
	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();
	private List<Cliente> listadoCliente;
	private List<Servicio> servicios;
	private List<Registro> registros;
	private List<Empleado> empleados;
	private List<Instalacion> listaInstalaciones;
	private Registro registro = new Registro();
	private Empleado empleado = new Empleado();
	private Servicio servicio = new Servicio();
	private Instalacion instalacion = new Instalacion();
	private Agendamiento agendamiento = new Agendamiento();
	private Equipo equipo = new Equipo();

	private List<Telefono> telefonos;
	/**
	 * Declaraacion de variables
	 */
	private int id;
	private int idR;
	private String cedula;
	private String nombre;
	private String apellidos;
	private String IP;
	private String Password;
	private String email;
	private String convencional;
	private String celular;
	private String direccionPrincipal;
	private String direccionSecundaria;
	private String direccionReferencia;
	private String latitud;
	private String longitud;
	
	

	private String antenaC;
	public String problemas;
	public String soluciones;
	private String empleados1;
	private String servicioRB;
	private String item;
	private String antenaElegida;
	private String planElegido;
	private List<Equipo> listadoAntenas;
	

	public int idEmpl;

	private int codigoReg;
	
	@PostConstruct
	public void init() {
		cliente = new Cliente();
		registro = new Registro();
		instalacion=new Instalacion();
		servicio = new Servicio();
		agendamiento = new Agendamiento();
		empleados = empon.getListadoEmpleado();
		listadoCliente = clion.getListadoCliente();
		registros = regon.getListadoRegistro();
		listaInstalaciones = inson.getListadoInstalacion();
		telefonos = new ArrayList<Telefono>();
		equipo = new Equipo();
		listadoAntenas = eqOn.getListadoAntenas();
		System.out.println("Si tomoo las antenaas" + listadoAntenas.size());

	}


	/**
	 * Fin de la declaracion
	 */

	@ManagedProperty(value = "#{login}")
	private EmpleadoController empCon;

	/**
	 * Inyeccion de las clases ON
	 */
	@Inject
	private ClienteON clion;
	
	@Inject
	private RegistroON regon;

	@Inject
	private EmpleadoON empon;

	@Inject
	private InstalacionON inson;

	@Inject
	private ServicioON seron;

	@Inject
	private FacesContext fc;

	@Inject
	private AgendamientoON agon;
	
	@Inject 
	private EquipoOn eqOn;
	
	@Inject 
	private TelefonoON telOn;

	/**
	 * Fin de la inyeccion
	 */

	/**
	 * Creacion del Constructor
	 */


	/**
	 * Metodo para la accion de editar los clientes
	 */
	public void loadData() {
		if (id == 0)
			return;
		cliente = clion.getCliente(id);


	}

	/**
	 * Metodo para la accion para realizar las revisiones
	 */
	public void datosRegistro() {

		if (idR == 0)
			return;
		registro = regon.getRegistro(idR);
	}
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getDireccionPrincipal() {
		return direccionPrincipal;
	}

	public void setDireccionPrincipal(String direccionPrincipal) {
		this.direccionPrincipal = direccionPrincipal;
	}

	public String getDireccionSecundaria() {
		return direccionSecundaria;
	}

	public void setDireccionSecundaria(String direccionSecundaria) {
		this.direccionSecundaria = direccionSecundaria;
	}

	public String getDireccionReferencia() {
		return direccionReferencia;
	}

	public void setDireccionReferencia(String direccionReferencia) {
		this.direccionReferencia = direccionReferencia;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getAntenaElegida() {
		return antenaElegida;
	}

	public void setAntenaElegida(String antenaElegida) {
		this.antenaElegida = antenaElegida;
	}

	public List<Equipo> getListadoAntenas() {
		return eqOn.getListadoAntenas();
	}

	public void setListadoAntenas(List<Equipo> listadoAntenas) {
		this.listadoAntenas = listadoAntenas;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConvencional() {
		return convencional;
	}

	public void setConvencional(String convencional) {
		this.convencional = convencional;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	

	

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getProblemas() {
		return problemas;
	}

	public void setProblemas(String problemas) {
		this.problemas = problemas;
	}

	public ClienteON getClion() {
		return clion;
	}

	public void setClion(ClienteON clion) {
		this.clion = clion;
	}

	public RegistroON getRegon() {
		return regon;
	}

	public void setRegon(RegistroON regon) {
		this.regon = regon;
	}

	public EmpleadoON getEmpon() {
		return empon;
	}

	public void setEmpon(EmpleadoON empon) {
		this.empon = empon;
	}

	public InstalacionON getInson() {
		return inson;
	}

	public void setInson(InstalacionON inson) {
		this.inson = inson;
	}

	public ServicioON getSeron() {
		return seron;
	}

	public void setSeron(ServicioON seron) {
		this.seron = seron;
	}

	public FacesContext getFc() {
		return fc;
	}

	public void setFc(FacesContext fc) {
		this.fc = fc;
	}

	public AgendamientoON getAgon() {
		return agon;
	}

	public void setAgon(AgendamientoON agon) {
		this.agon = agon;
	}

	public EquipoOn getEqOn() {
		return eqOn;
	}

	public void setEqOn(EquipoOn eqOn) {
		this.eqOn = eqOn;
	}

	public TelefonoON getTelOn() {
		return telOn;
	}

	public void setTelOn(TelefonoON telOn) {
		this.telOn = telOn;
	}

	public problema[] getListaProblema() {
		return listaProblema;
	}

	public void setListaProblema(problema[] listaProblema) {
		this.listaProblema = listaProblema;
	}

	public solucion[] getListaSolucion() {
		return listaSolucion;
	}

	public void setListaSolucion(solucion[] listaSolucion) {
		this.listaSolucion = listaSolucion;
	}

	public solucion[] getListaAccion() {
		return listaAccion;
	}

	public void setListaAccion(solucion[] listaAccion) {
		this.listaAccion = listaAccion;
	}

	public ServicioFA[] getServicioLista() {
		return servicioLista;
	}

	public void setServicioLista(ServicioFA[] servicioLista) {
		this.servicioLista = servicioLista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/*
	 * Creacion de getters and setters
	 */
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListadoCliente() {
		return listadoCliente;
	}

	public void setListadoCliente(List<Cliente> listadoCliente) {
		this.listadoCliente = listadoCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAntenaC() {
		return antenaC;
	}

	public void setAntenaC(String antenaC) {
		this.antenaC = antenaC;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public String getSoluciones() {
		return soluciones;
	}

	public void setSoluciones(String soluciones) {
		this.soluciones = soluciones;
	}

	public String getEmpleados1() {
		return empleados1;
	}

	public void setEmpleados1(String empleados1) {
		this.empleados1 = empleados1;
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	public int getCodigoReg() {
		return codigoReg;
	}

	public void setCodigoReg(int codigoReg) {
		this.codigoReg = codigoReg;
	}

	public String getServicioRB() {
		return servicioRB;
	}

	public void setServicioRB(String servicioRB) {
		this.servicioRB = servicioRB;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Instalacion> getListaInstalaciones() {
		return listaInstalaciones;
	}

	public void setListaInstalaciones(List<Instalacion> listaInstalaciones) {
		this.listaInstalaciones = listaInstalaciones;
	}

	public int getIdEmpl() {
		return idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Agendamiento getAgendamiento() {
		return agendamiento;
	}

	public void setAgendamiento(Agendamiento agendamiento) {
		this.agendamiento = agendamiento;
	}

	public int getIdR() {
		return idR;
	}

	public void setIdR(int idR) {
		this.idR = idR;
	}

	public EmpleadoController getEmpCon() {
		return empCon;
	}

	public void setEmpCon(EmpleadoController empCon) {
		this.empCon = empCon;
	}
	

	/*
	 * Hasta aqui llega la creacion de los getters and setters
	 */

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	/**
	 * Metodo para dirigirnos a la pagina editarClientes
	 * 
	 * @param codigo
	 * @return
	 */

	public String editar(int codigo) {

		return "editarClientes?faces-redirect=true&id=" + codigo;
	}

	public String editarRegistro(int codigo) {
		return "agendamiento?faces-redirect=true&id=" + codigo;
	}

	/**
	 * Metodo para la creacion de los clientes
	 * 
	 * @return
	 */
	public String guardarCliente() {

		try {
			clion.guardarCliente(cliente);
			// servicio.setIdClienteTemp(cliente.getId());
			// seron.guardar(servicio);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Metodo para la busqueda de clientes para el registro
	 * 
	 * @return
	 */

	
	public String buscarCedula() {
		System.out.println("esta es la cedula hpta "+ this.cedula);
		try {
			if (this.cedula!=null) {
				
				cliente = clion.getClienteCedula(this.cedula);
				System.out.println("cliente cedula --> "+ cliente.getCedula());
				List<Telefono>telefonos2=telOn.getTelefonos(cliente);
				for (Telefono telefono : telefonos2) {
					System.out.println(telefono.getTipoTelefono());
					System.out.println("-----kiko----");
				}
				setTelefonos(telefonos2);
				System.out.println("-----CHAVOOOO----");
				registro.setIdClienteTemp(cliente.getId());
				cliente.setTelefonos(telefonos2);
				fechaHora();
				datoR();
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Correctas"));

			}
		}catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));

		}
				System.out.println("veniii"+ cliente.getCedula());
				return null;

			}
	
	
	

	
	public String buscarCedula1() {
try {
	if (cliente.getCedula()!=null) {
		
		cliente = clion.getClienteCedula(cliente.getCedula());
		registro.setIdClienteTemp(cliente.getId());
		fechaHora();
		datoR();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Correctas"));

	}
}catch (Exception e) {
	// TODO: handle exception
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));

}
		System.out.println("veniii"+ cliente.getCedula());
		return cliente.getCedula();

	}
	
	
	public List<Telefono> getTelefonos1(Cliente cliente){
		
		return telefonos;
	}
	
	
	
	
	
	
	
	

	/**
	 * Metodo para la busqueda del cliente por el nombre
	 */
	public void buscarNombre() {
		cliente = clion.getClienteNombre(cliente.getNombre());
		registro.setIdClienteTemp(cliente.getId());
		fechaHora();
		datoR();
	}

	/**
	 * Metodo para editar los clientes
	 * 
	 * @return
	 */
	public String cargarDatos() {
		try {
			clion.guardar(cliente);
			init();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo para editar los clientes
	 * 
	 * @return
	 */
	public String cargarDatosCallCenter() {
		
		try {
			clion.guardar(cliente);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo para guadar el agendamiento
	 * 
	 * @return
	 */
	public String guardarAgendamiento() {
		try {
			agon.guardar(agendamiento);
			regon.guardar(registro);
			init();
			return "callcenter";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo para la ejecuccion del sistema de simbolo (cmd)
	 */
	/*
	public void cmd() {
		try {
			System.out.println("gol");
			
			 *for (int i = 0; i < registro.getCliente().getServicio().size(); i++) {
				//IP = registro.getCliente().getServicio().get(i).getIp();
				Runtime.getRuntime().exec("cmd.exe /k start ping " + IP + " -t");
				fechaHora();
				System.out.println("IP obtenida: " + IP);
				System.out.println("hola2");
			} 
			 
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	public void winbox() {

		try {
			for (int i = 0; i < registro.getCliente().getServicio().size(); i++) {
				IP = registro.getCliente().getServicio().get(i).getIp();
				Password = registro.getCliente().getServicio().get(i).getPassword();
				Runtime.getRuntime().exec("C:\\Winbox.exe " + IP + " admin connect " + Password);
				System.out.println("IP obtenida: " + IP);
				System.out.println("hola2");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	 */

	/**
	 * Metodo para mostrar el listado de las antenas en el combox
	 * 
	 * @return
	 */

	public String listAntena() {
		antenaC = "" + eqOn.getListadoAntenas();
		return antenaC;
	}

	 
	
	
	
	/**
	 * Metod para guardar los registros
	 * 
	 * @return
	 */
	public String cargarDatosRegistro() {
		try {
			System.out.println("Llegando:::::111");
			cliente.setId(registro.getCliente().getId());
			registro.getCliente().setId(cliente.getId());
			System.out.println("cliente id "+cliente.getId());
			empleado.setId(registro.getEmpleado().getId());
			registro.getEmpleado().setId(empleado.getId());
			regon.guardar(registro);
			init();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// Matriz de objetos
	public static class problema {
		public String carLabel;
		public String carValue;

		public problema(String carLabel, String carValue) {
			this.carLabel = carLabel;
			this.carValue = carValue;
		}

		public String getCarLabel() {
			return carLabel;
		}

		public String getCarValue() {
			return carValue;
		}
	}
	

	public problema[] listaProblema;

	public problema[] getProblemas1() {
		listaProblema = new problema[6];

		listaProblema[0] = new problema("SERVICIO INTERMITENTE", "1");
		listaProblema[1] = new problema("SIN SERVICIO", "2");
		listaProblema[2] = new problema("PROBLEMAS EN CAPACIDAD", "3");
		listaProblema[3] = new problema("ROUTER DESCONFIGURADO", "4");
		listaProblema[4] = new problema("SERVICIO LENTO", "5");
		listaProblema[5] = new problema("CORTE DE SERVICIO", "6");

		return listaProblema;
	}

	// Matriz de Objetos para solucion
	public static class solucion {

		public String carLabel;
		public String carValue;

		public solucion(String carLabel, String carValue) {
			this.carLabel = carLabel;
			this.carValue = carValue;
		}

		public String getCarLabel() {
			return carLabel;
		}

		public String getCarValue() {
			return carValue;
		}

	}

	public solucion[] listaSolucion;

	public solucion[] getSolucion() {
		listaSolucion = new solucion[3];

		listaSolucion[0] = new solucion("SOLUCIONADO", "1");
		listaSolucion[1] = new solucion("NODO CAIDO", "2");
		listaSolucion[2] = new solucion("VISITA TECNICA", "3");

		return listaSolucion;
	}
	
	//matriz para la accion de cada registro del callcenter
	public static class accion {

		public String carLabel;
		public String carValue;

		public accion(String carLabel, String carValue) {
			this.carLabel = carLabel;
			this.carValue = carValue;
		}

		public String getCarLabel() {
			return carLabel;
		}

		public String getCarValue() {
			return carValue;
		}

	}

	public solucion[] listaAccion;

	public solucion[] getAccion() {
		listaSolucion = new solucion[5];
		listaSolucion[0] = new solucion("PENDIENTE", "1");
		listaSolucion[1] = new solucion("SOLUCIONADO", "2");
		listaSolucion[2] = new solucion("LLAMAR A VERIFICAR", "3");
		listaSolucion[3] = new solucion("CLIENTE NO DA NINGUNA RESPUESTA", "4");
		listaSolucion[4] = new solucion("VISITA TECNICA", "5");

		return listaSolucion;
	}

	public String tecnicoCampo() {
		empleados1 = "" + empon.getListadoEmpleado();

		return empleados1;
	}

	public void consultarCliente() {

		Cliente cli;
		try {
			cli = regon.consultarCliente(registro.getIdClienteTemp());
			registro.setCliente(cli);

		} catch (Exception e) {
			//registro.setCliente(null);
			// TODO Auto-generated catch block
			/*
			 * FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			 * e.getMessage(), "Error"); fc.addMessage("txtCliente1", msg);
			 */

			e.printStackTrace();
		}
	}

	public void consultarCliente1() {

		Cliente cli;
		try {

			cli = regon.consultarCliente(servicio.getIdClienteTemp());
			servicio.setCliente(cli);
		} catch (Exception e) {
			//registro.setCliente(null);
			// TODO Auto-generated catch block
			/*
			 * FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			 * e.getMessage(), "Error"); fc.addMessage("txtCliente1", msg);
			 */

			e.printStackTrace();
		}
	}

	public void consultarEmpleado() {

		Empleado emp;
		try {
			emp = regon.consultarEmpleado(registro.getIdEmpleadoTemp());
			registro.setEmpleado(emp);

		} catch (Exception e) {
			//registro.setEmpleado(null);
			// TODO Auto-generated catch block
			/*
			 * FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			 * e.getMessage(), "Error"); fc.addMessage("txtEmpleado1", msg);
			 */

			e.printStackTrace();
		}
	}


	/**
	 * Metodo de conltar Registro para el agendamiento
	 * public void consultarRegistro() {
		Registro reg;
		try {
			reg = regon.consultarRegistro(agendamiento.getCodigoRegistroTemp());
			agendamiento.setRegistro(reg);
		} catch (Exception e) {
			agendamiento.setRegistro(null);
			

			e.printStackTrace();
		}
	}
	 */

	

	



	/**
	 * Metodo para la fecha del sistema
	 */
	public void fechaHora() {
		Calendar fecha = new GregorianCalendar();

		// Obtenemos el valor del año, mes, día,
		// hora, minuto y segundo del sistema
		// usando el método get y el parámetro correspondiente
		int año = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String fec = String.valueOf(año) + "/" + String.valueOf(mes + 1) + "/" + String.valueOf(dia) + " "
				+ String.valueOf(hora) + ":" + String.valueOf(minuto) + ":" + String.valueOf(segundo);
		registro.setFechaHora(fec);
		agendamiento.setFecha(fec);

	}

	public void datoR() {
		System.out.println("datos locos " + empCon.getId());
		registro.setIdEmpleadoTemp(empCon.getId());
	}

	public String datoI() {
		System.out.println("Datos Instalacion " + empCon.getId());
		instalacion.setCodigoEmpTemp(empCon.getId());
		return "instalacion";
	}

	public boolean validadorDeCedula(String cedula) {
		boolean cedulaCorrecta = false;

		try {

			if (cedula.length() == 10) // ConstantesApp.LongitudCedula
			{
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validación cédula
					// El decimo digito se lo considera dígito verificador
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
		}

		if (!cedulaCorrecta) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Cedula Incorrecta"));

		}
		return cedulaCorrecta;
	}
	

	
	

	/**
	 * Metodo para guardar los datos de la instalacion
	 * 
	 * @return
	 */
	public String crearInstalacion() {

		try {
			inson.crearI(instalacion);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public String crearCliente() {
		Telefono tele = new Telefono();
		Telefono teleMovil = new Telefono();
		Cliente cli = new Cliente();
		String hola = "ww";
		System.out.println(hola);
		cli.setCedula(this.cedula);
		cli.setApellidos(this.apellidos);
		cli.setNombre(this.nombre);
		cli.setDireccionPrincipal(this.direccionPrincipal);
		cli.setDireccionSecundaria(this.direccionSecundaria);
		cli.setDireccionReferencia(this.direccionReferencia);
		cli.setEmail(this.email);
		cli.setLatitud(this.latitud);
		cli.setLongitud(this.longitud);
	
		clion.guardar(cli);
		
		tele.setTipoTelefono("Convencional");
		tele.setTelNumero(this.convencional);
		tele.setCliente(cli);

		telOn.guardar(tele);
		
		teleMovil.setTipoTelefono("Movil");
		teleMovil.setTelNumero(this.celular);
		teleMovil.setCliente(cli);
		
		telOn.guardar(teleMovil);
		
		
		return null;
	}
	/**
	 * Metodo de consultar Empleado para la instalacion
	 */
	public void consultarEmpleado1() {

		Empleado emp;
		try {
			emp = regon.consultarEmpleado(instalacion.getCodigoEmpTemp());
			instalacion.setEmpleado(emp);
		} catch (Exception e) {
			//instalacion.setEmpleado(null);
			// TODO Auto-generated catch block
			/*
			 * FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			 * e.getMessage(), "Error"); fc.addMessage("txtEmpleado1", msg);
			 */
			//e.printStackTrace();
		}
	}
	

	
	/*
	 * Metodo para de radioButton del Modo de Servicio
	 */
	public static class ServicioFA {
		public String servicioLabel;
		public String servicioValue;

		public ServicioFA(String servicioLabel, String servicioValue) {
			this.servicioLabel = servicioLabel;
			this.servicioValue = servicioValue;
		}

		public String getServicioLabel() {
			return servicioLabel;
		}

		public void setServicioLabel(String servicioLabel) {
			this.servicioLabel = servicioLabel;
		}

		public String getServicioValue() {
			return servicioValue;
		}

		public void setServicioValue(String servicioValue) {
			this.servicioValue = servicioValue;
		}

	}

	public ServicioFA[] servicioLista;

	public ServicioFA[] getListaServicioRB() {

		servicioLista = new ServicioFA[2];
		servicioLista[0] = new ServicioFA("Fibra Optica", "FO");
		servicioLista[1] = new ServicioFA("Antena", "RE");

		return servicioLista;
	}

	public String getPlanElegido() {
		return planElegido;
	}

	public void setPlanElegido(String planElegido) {
		this.planElegido = planElegido;
	}	
}
