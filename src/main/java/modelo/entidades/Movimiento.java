package modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Clase de la entidad movimiento que contiene el identificador de cada movimiento,
 * el concepto del movimiento, el valor del movimiento, la fecha en que se realizo el
 * movimiento y las cuenta de origen y destino
 */
@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador numerico de cada movimiento
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	/**
	 * Concepto por el que se realizo el movimiento
	 */
	@Column(name = "concepto")
	private String concepto;
	
	/**
	 * Valor por el se realizo el movimiento
	 */
	@Column(name = "valor")
	private double valor;
	
	/**
	 * Fecha en la que se realizo el movimiento
	 */
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	/**
	 * Cuenta de origen, desde donde viene el valor del
	 * movimiento
	 */
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cuenta_origen")
	private Cuenta origen;
	
	/**
	 * Cuenta de destino, cuenta a la que se acredita el valor
	 * del movimiento
	 */
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cuenta_destino")
	private Cuenta destino;
	
	/**
	 * Constructor vacio de la clase
	 */
	public Movimiento() {
	}

	/**
	 * Constructor con parametros de la clase
	 * @param concepto Concepto por el que se realizo el movimiento
	 * @param valor Valor por el se realizo el movimiento
	 * @param fecha Fecha en la que se realizo el movimiento
	 * @param origen Cuenta de origen del valor
	 * @param destino Cuenta a la que se le acredita el valor 
	 */
	public Movimiento(String concepto, double valor, Date fecha, Cuenta origen, Cuenta destino) {
		super();
		this.concepto = concepto;
		this.valor = valor;
		this.fecha = fecha;
		this.origen = origen;
		this.destino = destino;
	}

	/**
	 * @return Identificador del movimiento
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id Identificador del movimiento
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return Concepto del movimiento
	 */
	public String getConcepto() {
		return concepto;
	}

	/**
	 * @param concepto Concepto del movimiento
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	/**
	 * @return Valor del movimiento
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor Valor del movimiento
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return Fecha del movimiento
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha Fecha del movimiento
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return Objeto Cuenta, cuenta de origen del movimiento
	 */
	public Cuenta getOrigen() {
		return origen;
	}

	/**
	 * @param origen  Objeto Cuenta, cuenta de origen del movimiento
	 */
	public void setOrigen(Cuenta origen) {
		this.origen = origen;
	}

	/**
	 * @return Objeto cuenta, cuenta a la que se acerdita el movimiento
	 */
	public Cuenta getDestino() {
		return destino;
	}

	/**
	 * @param destino Objeto cuenta, cuenta a la que se acerdita el movimiento
	 */
	public void setDestino(Cuenta destino) {
		this.destino = destino;
	}



	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", concepto=" + concepto + ", valor=" + valor + ", fecha=" + fecha + ", origen="
				+ origen + ", destino=" + destino + "]";
	}
	
	
	
}
