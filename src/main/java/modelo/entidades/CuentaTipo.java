package modelo.entidades;
/**
 * Clase enum que contiene los tipos de Cuentas que pueden existir:
 * INGRESO, GASTO, INGRESOGASTO
 */
public enum CuentaTipo {
	INGRESO ("INGRESO", 1),
	GASTO ("GASTO", 2),
	INGRESOGASTO ("INGRESOGASTO",3);
	/**
	 * Nombre del tipo de cuenta
	 */
	private String nombreTipo;
	/**
	 * Identificador numerico del tipo de cuenta
	 */
	private int idTipo;
	/**
	 * Constructor con parametros
	 * @param nombreTipo Nombre del tipo la cuenta
	 * @param id Identificador del tipo de cuenta
	 */
	CuentaTipo(String nombreTipo, int id) {
		this.idTipo = id;
		this.nombreTipo = nombreTipo; 
	}
	/**
	 * @return Nombre del tipo de cuenta
	 */
	public String getNombreTipo() {
		return nombreTipo;
	}
	
	/**
	 * @param nombreTipo Nombre del tipo de cuenta
	 */
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	/**
	 * @return Identificador dedl tipo de cuenta
	 */
	public int getIdTipo() {
		return idTipo;
	}
	
	/**
	 * @param idTipo Identificador del tipo de cuenta
	 */
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	
}
