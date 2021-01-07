package astronet.ec.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EquipoServicio")

public class EquipoServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "equipoServi_id")
	@GeneratedValue(generator = "secuenciaEquiServ")
	@SequenceGenerator(name = "secuenciaEquiServ", initialValue = 14)
	private int id;
	
	@Column(name = "equipoServi_serial")
	private String cedula;
	
	@Column(name = "equipoServi_passwd")
	private String nombre;

	@Column(name = "equipoServi_ip")
	private String ip;
	
	
	/*
	 * Relacion EquipoServicio con Equipo
	 */
	@OneToOne
	@JoinColumn(name="equipoServicioEquipo_fk")
	@JsonIgnore
	private Equipo equipo;
	
	/*
	 * Relacion EquipoServicio con Servicio
	 */
	@OneToOne
	@JoinColumn(name="equipoServicioServicio_fk")
	@JsonIgnore
	private Servicio servicio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "EquipoServicio [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", ip=" + ip + ", equipo="
				+ equipo + ", servicio=" + servicio + "]";
	}
	
	

}
