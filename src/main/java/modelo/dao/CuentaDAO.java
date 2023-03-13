package modelo.dao;

import java.util.List;

import modelo.dto.CuentaDTO;
import modelo.entidades.Cuenta;
import modelo.entidades.CuentaTipo;
/**
 * Intefaz que contiene las firmas de los métodos para obtener el 
 * consolidado de cada tipo de cuenta y obtener las cuentas según su
 * tipo. Hereda de la interfaz GenericDAO.
 */
public interface CuentaDAO extends GenericDAO<Cuenta, Integer> {

	/**
	 * Firma del método que obtiene el consolidado de las cuentas de Ingreso
	 * según un mes especifico.
	 * @param mes Número del mes que se desea el consolidado
	 * @return Lista de objetos tipo CuentaDTO
	 */
	public List<CuentaDTO> getConsolidadoCuentasIngreso(int mes);
	
	/**
	 * Firma del método que obtiene el consolidado de las cuentas de Egreso
	 * según un mes especifico.
	 * @param mes Número del mes que se desea el consolidado
	 * @return Lista de objetos tipo CuentaDTO
	 */
	public List<CuentaDTO> getConsolidadoCuentsEgreso(int mes);
	
	/**
	 * Firma del método que obtiene el consolidado de las cuentas de Ingreso-Egreso
	 * @return Lista de objetos tipo Cuenta
	 */
	public List<Cuenta> getConsolidadoCuentasIngresoEgreso();
	
	/**
	 * Firma del método que obtiene una lista de Cuentas según el tipo de cuenta
	 * @param tipo Tipo de cuenta 
	 * @return Lista de objetos tipo Cuenta
	 */
	public List<Cuenta> getByType(CuentaTipo tipo);
}
