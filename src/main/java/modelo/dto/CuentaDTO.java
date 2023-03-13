package modelo.dto;
/**
 * Clase que contiene el identificador, nombre y monto total
 * del consolidado de una Cuenta.
 */
public class CuentaDTO {

	/**
	 * Identificador de la cuenta
	 */
	private int id;
	
	/**
	 * Nombre de la cuenta
	 */
	private String nombre;
	
	/**
	 * Total del consolidado de una cuenta
	 */
	private double totalcalculado;
	
	/**
	 * Constructor vacio de la clase
	 */
	public CuentaDTO() {}

	/**
	 * Constructor con parametros de la clase
	 * @param id Identificador numerico de la Cuenta
	 * @param nombre Nombre de la Cuenta
	 * @param totalcalculado Valor total del consolidado de la cuenta
	 */
	public CuentaDTO(int id, String nombre, double totalcalculado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.totalcalculado = totalcalculado;
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
	 * @return Total del consolidado de la cuenta
	 */
	public double getTotalcalculado() {
		return totalcalculado;
	}

	/**
	 * 
	 * @param totalcalculado Total del consolidado de la cuenta
	 */
	public void setTotalcalculado(double totalcalculado) {
		this.totalcalculado = totalcalculado;
	}
	
	
}
