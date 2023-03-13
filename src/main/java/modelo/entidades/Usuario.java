package modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Clase de la entidad usuario que contiene el identificador de cada usuario,
 * nombre, y clave
 */
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Identificador numerico del usuario
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer id;
	
	/**
	 * Nombre el usuario
	 */
	@Column(name="nombre")
	private String nombre;
	
	/**
	 * Clave del usuario
	 */
	@Column(name="clave")
	private String clave;
	
	/**
	 * Constructor vacio de la clase
	 */
	public Usuario() {
		
	}

	/**
	 * Constructor con parametros de la clase
	 * @param nombre Nombre del usuario
	 * @param clave Clave del usuario
	 */
	public Usuario(String nombre, String clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
	}

	/**
	 * @return Identificador numerico del usuario
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id Identificador numerico del usuario
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return Nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return Clave del usuario
	 */
	public String getClave() {
		return clave;
	}

	/** 
	 * @param clave Clave del usuario
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", clave=" + clave + "]";
	}
	
	
}


