package modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Clase de la entidad Cuenta, almacena un identificador, nombre
 * y total segun los valores de los montos asociados a ella 
 */
@Entity
public class Cuenta implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador numerico de la cuenta
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Nombre de la cuenta
	 */
	@Column
	private String nombre;
	
	/**
	 * Total de la cuenta según sus movimientos asociados
	 */
	@Column
	private double total;
	
	/**
	 * Tipo de la cuenta
	 */
	@Enumerated
	private CuentaTipo tipo;
	
	/**
	 * Constructor vacio de la clase
	 */
	public Cuenta() {}

	/**
	 * Constructor con parametros de la clase
	 * @param nombre Nombre de la cuenta
	 * @param total Total de la cuenta según sus movimientos asociados
	 */
	public Cuenta(String nombre, double total) {
		super();
		this.nombre = nombre;
		this.total = total;
	}

	/**
	 * @return Identificador numerico de la cuenta
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id Identificador numerico de la cuenta
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Nombre de la cuenta
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Nombre de la cuenta
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return Total de la cuenta
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total Total de la cuenta
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return Instancia de CuentaTipo
	 */
	public CuentaTipo getTipo() {
		return tipo;
	}

	/**
	 * @param tipo Instancia de CuentaTIpo
	 */
	public void setTipo(CuentaTipo tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", nombre=" + nombre + ", total=" + total + "]";
	}
}
